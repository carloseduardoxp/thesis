import requests
import json
import mysql.connector
from github import Github, RateLimitExceededException

class Database():

    def __init__(self, host,database,user,password):
        self._host = host
        self._database = database
        self._user = user
        self._password = password

    def getConnection(self):
        db = mysql.connector.connect(
            host=self._host,
            user=self._user,
            password=self._password,
            database=self._database
        )    

        return db

    def getPullRequests(self):
        query = """ select distinct owner_repo,pr_number f
                    from pullRequests 
                    where (owner_repo,pr_number) not in (select owner_repo,pr_number from reviews)
                      and changedFiles > 0                                             
                """

        db = self.getConnection()
    
        cursor = db.cursor()

        cursor.execute(query)

        pullRequests = []

        for (owner_repo,pr_number) in cursor: 
            pullRequests.append((owner_repo,pr_number))

        return pullRequests        

    def save(self,data):
        sql = "INSERT IGNORE INTO reviews (owner_repo, pr_number,user_id, login, type, body, site_admin, state, author_association) VALUES (%s, %s, %s, %s, %s, %s, %s, %s, %s)"

        db = self.getConnection()

        cursor = db.cursor()    

        cursor.execute(sql,data)
        db.commit()   


class ReadReviews():

    def __init__(self, repo,pullNumber,page):
        self._repo = repo
        self._pullNumber = pullNumber
        self._page = page

    def requisicao_api(self):
        resposta = requests.get(
            f'https://api.github.com/repos/{self._repo}/pulls/{self._pullNumber}/reviews?per_page=100&page={self._page}', headers=headers)
        if resposta.status_code == 200:
            return resposta.json()
        else:
            return resposta.status_code

    def getReviews(self):
        reviews = []
        dados_api = self.requisicao_api()
        if type(dados_api) is not int:
            for i in range(len(dados_api)):
                id = -1
                login = "None"
                userType = "None"
                site_admin = False

                if (dados_api[i]['user'] is not None):
                    id = dados_api[i]['user']['id']
                    login = dados_api[i]['user']['login']
                    userType = dados_api[i]['user']['type']
                    site_admin = dados_api[i]['user']['site_admin']

                reviews.append((self._repo,
                                self._pullNumber,
                                id,
                                login,
                                userType,
                                dados_api[i]['body'],
                                site_admin,
                                dados_api[i]['state'],
                                dados_api[i]['author_association']
                              ))
        else:
            print(dados_api)
        return reviews   

  
# GRAPHQL API v4
#   using an access token   
#################
access_token = 'YOUR_GITHUB_TOKEN'
headers = {'Authorization': 'Bearer '+ access_token}             

database = Database("localhost","dataset_thesis_2025","root","root")
pullRequests = database.getPullRequests()

count = 0     

print("Pull Requests to process "+str(len(pullRequests)))

for (pullRequest) in pullRequests:
    ownerRepo = pullRequest[0]
    prNumber = pullRequest[1]

    page = 1     
    contributorsSize = 100 
    while (contributorsSize == 100): 
        readReviews = ReadReviews(ownerRepo,prNumber,page)  
        reviews = readReviews.getReviews()
        contributorsSize = len(reviews)
        for (review) in reviews:
            database.save(review)
        page += 1       
    
    count += 1
    if (count % 100 == 0):
        print("Count "+str(count))
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

    def getRepositoriesWithPullRequests(self):
        query = """ select distinct owner_repo 
                    from repositories 
                    where (owner_repo) not in (select owner_repo from collaborators)
                      and stars >= 10 and isFork = 0;
                """

        db = self.getConnection()
    
        cursor = db.cursor()

        cursor.execute(query)

        pullRequests = []

        for (owner_repo) in cursor: 
            pullRequests.append((owner_repo))

        return pullRequests        

    def save(self,data):
        sql = "INSERT IGNORE INTO collaborators (owner_repo, id, login, type, site_admin, contributions) VALUES (%s, %s, %s, %s, %s, %s)"

        db = self.getConnection()

        cursor = db.cursor()    

        cursor.execute(sql,data)
        db.commit()   

    def update():
        sql = """
                update repositories r
                set collaborators = (select count(*) from collaborators c where c.owner_repo = r.owner_repo and type = 'User');
              """  

        db = self.getConnection()

        cursor = db.cursor()    

        cursor.execute(sql)
        db.commit()       


class ReadChangedFiles():

    def __init__(self, repo,page):
        self._repo = repo
        self._page = page

    def requisicao_api(self):
        resposta = requests.get(
            f'https://api.github.com/repos/{self._repo}/contributors?per_page=100&anon=true&page={self._page}', headers=headers)
        if resposta.status_code == 200:
            return resposta.json()
        else:
            return resposta.status_code

    def getContributors(self):
        contributors = []
        dados_api = self.requisicao_api()
        if type(dados_api) is not int:
            for i in range(len(dados_api)):
                id = -1
                if ("id" in dados_api[i]):
                    id = dados_api[i]['id']
                login = ""
                if ("login" in dados_api[i]):
                    login = dados_api[i]['login']                    
                site_admin = False
                if ("site_admin" in dados_api[i]):
                    site_admin = dados_api[i]['site_admin']                    

                contributors.append((self._repo,
                                     id,
                                     login,
                                     dados_api[i]['type'],
                                     site_admin,
                                     dados_api[i]['contributions']))
        else:
            print(dados_api)
            return None
        return contributors   
  
# GRAPHQL API v4
#   using an access token   
#################
access_token = 'YOUR_GITHUB_TOKEN'
headers = {'Authorization': 'Bearer '+ access_token}

database = Database("localhost","dataset_thesis_2025","root","root")
repositoriesWithPullRequests = database.getRepositoriesWithPullRequests()

count = 0     

for (repository) in repositoriesWithPullRequests:
     ownerRepo = repository[0]

     page = 1     
     contributorsSize = 100 
     while (contributorsSize == 100):        
        readChangedFiles = ReadChangedFiles(ownerRepo,page)  
        contributors = readChangedFiles.getContributors()   
        contributorsSize = len(contributors)
        for (contributor) in contributors:
            database.save(contributor)
        page += 1        

    
database.update()

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
        query = """ select owner_repo,pr_number 
                    from pullRequests 
                    where (owner_repo,pr_number) not in (select owner_repo,pr_number from changedFiles)
                      and owner_repo in (select owner_repo from repositories where stars >= 10 and isFork = 0);
                """

        db = self.getConnection()
    
        cursor = db.cursor()

        cursor.execute(query)

        pullRequests = []

        for (owner_repo,pr_number) in cursor: 
            pullRequests.append((owner_repo,pr_number))

        return pullRequests        

    def save(self,ownerRepo,pullRequestNumber,fileName,typeChange):
        sql = "INSERT IGNORE INTO changedFiles (owner_repo, pr_number, fileName, typeChange) VALUES (%s, %s, %s, %s)"

        db = self.getConnection()

        cursor = db.cursor()    

        cursor.execute(sql,(ownerRepo,pullRequestNumber,fileName,typeChange))
        db.commit()  
        

    def update(self, language, file_extension):
        sql = f"""
            UPDATE pullRequests pr
            JOIN (
                SELECT owner_repo, pr_number, COUNT(*) AS file_count
                FROM changedFiles
                WHERE fileName LIKE %s
                GROUP BY owner_repo, pr_number
            ) cf ON pr.owner_repo = cf.owner_repo AND pr.pr_number = cf.pr_number
            JOIN repositories r ON pr.owner_repo = r.owner_repo
            SET pr.changedFiles = cf.file_count
            WHERE r.language = %s;
            """

        db = self.getConnection()
        cursor = db.cursor()
        like_pattern = f"%.{file_extension.lstrip('.')}" 
        cursor.execute(sql, (like_pattern, language))
        db.commit()

class ReadChangedFiles():

    def __init__(self, repo,pullNumber,page):
        self._repo = repo
        self._pullNumber = pullNumber
        self._page = page

    def requisicao_api(self):
        resposta = requests.get(
            f'https://api.github.com/repos/{self._repo}/pulls/{self._pullNumber}/files?per_page=100&page={self._page}', headers=headers)
        if resposta.status_code == 200:
            return resposta.json()
        else:
            return resposta.status_code

    def getFilesChanged(self):
        changedFiles = []
        dados_api = self.requisicao_api()
        if type(dados_api) is not int:
            for i in range(len(dados_api)):
                changedFiles.append((dados_api[i]['filename'],dados_api[i]['status']))
        else:
            print(dados_api)
        return changedFiles   
    
# GRAPHQL API v4
#   using an access token   
#################
access_token = 'YOUR_GITHUB_TOKEN'
headers = {'Authorization': 'Bearer '+ access_token}          

database = Database("localhost","dataset_thesis_2025","root","root")
pullRequests = database.getPullRequests()

count = 0     

for (pullRequest) in pullRequests:
     ownerRepo = pullRequest[0]
     pullRequestNumber = pullRequest[1]

     page = 1     
     contributorsSize = 100 
     while (contributorsSize == 100): 
        readChangedFiles = ReadChangedFiles(ownerRepo,pullRequestNumber,page)     
        changedFiles = readChangedFiles.getFilesChanged()

        contributorsSize = len(changedFiles)

        for (changedFile) in changedFiles:        
            fileName = changedFile[0]
            typeChange = changedFile[1]
            database.save(ownerRepo,pullRequestNumber,fileName,typeChange)

        page += 1     

     count += 1
     if (count % 100 == 0):
        print("Count "+str(count))

database.update(language="Java", file_extension=".java")
database.update(language="Python", file_extension=".py")

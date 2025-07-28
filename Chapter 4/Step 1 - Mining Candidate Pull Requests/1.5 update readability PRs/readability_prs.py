from os import name
from github import Github, RateLimitExceededException
import csv, json, os.path, pandas as pd, requests, time
from datetime import datetime
import mysql.connector
import re

def run_query(query): 
    request = requests.post('https://api.github.com/graphql', json={'query': query}, headers=headers)
    if request.status_code == 200:
        return request.json()
    else:
        raise ValueError("Query failed to run by returning code of {}. {}".format(request.status_code, query))       

def query_composer(owner,repo,pr_number):
    query = """query {
                repositoryOwner (login:\"""" + owner + """\") {
                    repository(name:\"""" + repo + """\") {
                        pullRequest(number:"""+ str(pr_number) + """) {
                            title 
                            body 
                            mergedAt
                            mergedBy {
                                login
                            }
                            author {
                                login
                            }
                        }
                    }
                }
            }
        """

    return query   

def get_connection():
    db = mysql.connector.connect(
        host="localhost",
        user="root",
        password="root",
        database="dataset_thesis_2025"
    )    

    return db     

def get_repositories():

    query = """ select owner_repo,pr_number 
                from pullRequests where owner_repo in (select owner_repo from repositories where stars >= 10 and isFork = 0)
                and changedFiles > 0 and title is null;
            """

    db = get_connection()
    
    cursor = db.cursor()

    cursor.execute(query)

    repositories = []

    for (repo_info) in cursor: 
        repositories.append((repo_info[0],repo_info[1]))

    global total 
    total = len(repositories)    

    return repositories    

def print_with_timestamp(message):
    now = datetime.now()
    timestamp = now.strftime("%Y-%m-%d %H:%M:%S")
    print(f"{timestamp} - {count} of {total} - {message}")    


def update_repositories():  

    global count 

    count = 0     
    
    repositories = get_repositories()

    for (repository) in repositories:    
        count += 1
        process_repository(repository)        

    
def process_repository(repository): 
    owner = repository[0].split("/")[0]
    repo = repository[0].split("/")[1]
    pr_number = repository[1]

    result = run_query(query_composer(owner,repo,pr_number))

    if 'errors' in result:
        print_with_timestamp(f"Error in response for {repository}: {result['errors']}")
        return

    try:

        title = result["data"]["repositoryOwner"]["repository"]["pullRequest"]["title"]
        title = remove_unicode_nao_bmp(title)
        body = result["data"]["repositoryOwner"]["repository"]["pullRequest"]["body"]
        body = remove_unicode_nao_bmp(body)
        body = body[:16000] 
        pr = result["data"]["repositoryOwner"]["repository"]["pullRequest"]
        merged_by_field = pr.get("mergedBy")
        merged_by = None
        if merged_by_field is not None:
            merged_by = merged_by_field.get("login")

        author_by_field = pr.get("author")       
        author = None
        if author_by_field is not None:
            author = author_by_field.get("login")     
            
        merged_at = datetime.strptime( result["data"]["repositoryOwner"]["repository"]["pullRequest"]["mergedAt"], '%Y-%m-%dT%H:%M:%SZ')

        sql = """ UPDATE pullRequests 
                    set title = %s,
                        body = %s,
                        mergedBy = %s,
                        author = %s,
                        mergedAt = %s
                    where owner_repo = %s   
                      and pr_number = %s             
        """
        
        db = get_connection()
        cursor = db.cursor()    

        cursor.execute(sql,(title,body,merged_by,author,merged_at,repository[0],pr_number))
        db.commit()   

    except Exception as e:
        error_detail = result.get('errors', 'No additional error details available.')
        print_with_timestamp(f"Failed to import {repository}: {e}. Additional details: {error_detail}")


def remove_unicode_nao_bmp(texto):
    return re.sub(r'[\U00010000-\U0010FFFF]', '', texto)    
  
# GRAPHQL API v4
#   using an access token   
#################
access_token = 'YOUR_GITHUB_TOKEN'
headers = {'Authorization': 'Bearer '+ access_token}

update_repositories()

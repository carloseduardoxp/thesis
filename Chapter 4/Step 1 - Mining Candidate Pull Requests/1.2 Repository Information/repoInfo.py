from os import name
from github import Github, RateLimitExceededException
import csv, json, os.path, pandas as pd, requests, time
from datetime import datetime
import mysql.connector

def run_query(query): 
    request = requests.post('https://api.github.com/graphql', json={'query': query}, headers=headers)
    if request.status_code == 200:
        return request.json()
    else:
        raise ValueError("Query failed to run by returning code of {}. {}".format(request.status_code, query))       

def query_composer(owner,repo):
    query = """query {
                repositoryOwner (login:\"""" + owner + """\") {
                    repository(name:\"""" + repo + """\") {
                        isFork
                        forkCount
                        stargazerCount
                        pullRequests {
                            totalCount
                        }         
                        updatedAt
                        issues {
                            totalCount
                        }
                        watchers {
                            totalCount
                        }
                        primaryLanguage {
                           name
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

    query = """ select owner_repo 
                from repositories where stars is null
            """

    db = get_connection()
    
    cursor = db.cursor()

    cursor.execute(query)

    repositories = []

    for (repo_info) in cursor: 
        repositories.append(repo_info[0])

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
    owner = repository.split("/")[0]
    repo = repository.split("/")[1]

    result = run_query(query_composer(owner,repo))

    if 'errors' in result:
        print_with_timestamp(f"Error in response for {repository}: {result['errors']}")
        return
    
    if result.get('data', {}).get('repositoryOwner') is None:
        print_with_timestamp(f"No repository owner data found for {repository}.")
        return

    try:

        is_fork = result["data"]["repositoryOwner"]["repository"]["isFork"]
        fork_count = result["data"]["repositoryOwner"]["repository"]["forkCount"]
        stargazer_count = result["data"]["repositoryOwner"]["repository"]["stargazerCount"]
        pull_requests = result["data"]["repositoryOwner"]["repository"]["pullRequests"]["totalCount"]
        updated_at = datetime.strptime( result["data"]["repositoryOwner"]["repository"]["updatedAt"], '%Y-%m-%dT%H:%M:%SZ')
        issues = result["data"]["repositoryOwner"]["repository"]["issues"]["totalCount"]
        watchers = result["data"]["repositoryOwner"]["repository"]["watchers"]["totalCount"]
        language = result["data"]["repositoryOwner"]["repository"]["primaryLanguage"]["name"]

        sql = """ UPDATE repositories 
                    set stars = %s,
                        isFork = %s,
                        pullRequests = %s,
                        forks = %s,
                        lastUpdate = %s,
                        numberIssues = %s,
                        watchers = %s,
                        language = %s               
                    where owner_repo = %s                
        """
        
        db = get_connection()
        cursor = db.cursor()    

        cursor.execute(sql,(stargazer_count,is_fork,pull_requests,fork_count,updated_at,issues,watchers,language,repository))
        db.commit()   

    except Exception as e:
        error_detail = result.get('errors', 'No additional error details available.')
        print_with_timestamp(f"Failed to import {repository}: {e}. Additional details: {error_detail}")
    
  
# GRAPHQL API v4
#   using an access token   
#################
access_token = 'YOUR_GITHUB_TOKEN'
headers = {'Authorization': 'Bearer '+ access_token}

update_repositories()

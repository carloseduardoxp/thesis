from os import name
from github import Github, RateLimitExceededException
import csv, json, os.path, pandas as pd, requests, time
import mysql.connector
from datetime import datetime
import time
import re

def get_connection():
    db = mysql.connector.connect(
        host="localhost",
        user="root",
        password="root",
        database="dataset_thesis_2025"
    )   
    return db

def run_query(query): 
    request = requests.post('https://api.github.com/graphql', json={'query': query}, headers=headers)
    if request.status_code == 200:
        return request.json()
    elif request.status_code == 403:
        print("Rate limit exceeded. Waiting for 60 seconds...")
        time.sleep(60)
        return run_query(query)
    else:
        raise ValueError("Query failed to run by returning code of {}. {}".format(request.status_code, query))       

#could be also be used as a parameter
#created:<=2024-01-01 
#owner:apache
#in:title
#in:body
#language:Python
def query_composer(keyword, cursor=None):
    cursor_part = f', after: "{cursor}"' if cursor else ""
    query = f"""query {{
                  search(query: "{keyword} is:pr is:merged review:approved in:title language:Java", 
                    type: ISSUE, 
                        first: 100{cursor_part}) {{
                            pageInfo {{
                                endCursor
                                hasNextPage
                            }}
                            issueCount 
                            edges {{ 
                                node {{  
                                    ... on PullRequest {{  
                                        url                                      
                                    }} 
                                }}          
                            }} 
                        }}
                     }}"""
    return query    

def print_with_timestamp(message):
    now = datetime.now()
    timestamp = now.strftime("%Y-%m-%d %H:%M:%S")
    print(f"{timestamp} - {message}")              

def get_readability_pull_requests(keyword): 
    result = None    
    cursor = None
    has_next_page = True 
    page = 1

    try:
        while has_next_page:      
            result = run_query(query_composer(keyword, cursor))
            if "data" not in result:
                print_with_timestamp("No data returned. Check the query or authentication.")
                break
            
            issue_count = result["data"]["search"]["issueCount"]
            end_cursor = result["data"]["search"]["pageInfo"]["endCursor"]
            has_next_page = result["data"]["search"]["pageInfo"]["hasNextPage"]

            print_with_timestamp(f"Total Occurrences: {issue_count}. Page: {page}")
            page += 1

            for pr in result["data"]["search"]["edges"]:   
                pr_url = pr["node"]["url"]

                match = re.search(r"github\.com/([^/]+/[^/]+)/pull/(\d+)", pr_url)
                if match:
                    repository = match.group(1)
                    pr_number = match.group(2)                    

                    data_pr = (repository,
                            pr_number,
                            pr_url,
                            keyword)                
                
                    sql_repo = "INSERT IGNORE INTO repositories (owner_repo) VALUES (%s)"
                    sql_pr = "INSERT IGNORE INTO pullRequests (owner_repo, pr_number, url, keyword) VALUES (%s, %s, %s, %s)"

                    db = get_connection()
                    cursor_db = db.cursor()    
                    cursor_db.execute(sql_repo, (repository,))
                    cursor_db.execute(sql_pr, data_pr)
                    db.commit()
                else:
                    print_with_timestamp(f"URL does not match: {pr_url}")

            cursor = end_cursor  

            print_with_timestamp(f"Cursor: {cursor}")
    except Exception as e:
        error_detail = result.get('errors', 'No additional error details available.') if result else 'No response received'
        print_with_timestamp(f"Error: {e}. Additional details: {error_detail}")            

# GRAPHQL API v4
access_token = 'YOUR_GITHUB_TOKEN'
headers = {'Authorization': f'Bearer {access_token}'}

data = get_readability_pull_requests('readability')
data = get_readability_pull_requests('understandability')
data = get_readability_pull_requests('legibility')

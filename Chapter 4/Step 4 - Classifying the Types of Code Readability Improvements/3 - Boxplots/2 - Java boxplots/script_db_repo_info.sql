-- number of repositories
select distinct owner_repo
from pullRequests 
where aceita = 1 
  and owner_repo in (select owner_repo from repositories where language = 'Java');
  
-- boxplot data
select stars, pullRequests, collaborators
from repositories
where owner_repo in (select owner_repo from pullRequests where language = 'Java' and aceita = 1);
  
  
-- opened PRs
select distinct author 
from pullRequests 
where aceita = 1 
  and owner_repo in (select owner_repo from repositories where language = 'Java');
  
-- total accounts
select distinct author 
from pullRequests 
where aceita = 1 
  and owner_repo in (select owner_repo from repositories where language = 'Java')
  
union 

select distinct mergedby
from pullRequests 
where aceita = 1 
  and owner_repo in (select owner_repo from repositories where language = 'Java')
  
union

select distinct login 
from reviews
where (owner_repo,pr_number) in (select owner_repo,pr_number from pullRequests where aceita = 1 and owner_repo in (select owner_repo from repositories where language = 'Java'));

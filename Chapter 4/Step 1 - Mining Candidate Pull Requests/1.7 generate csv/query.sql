/* directory to save the csv */
SELECT @@GLOBAL.secure_file_priv;

/* verify if there is any PR with less than 2 revisors */
select count(distinct prs.login),prs.owner_repo,prs.pr_number
from 
(
select distinct login,owner_repo,pr_number
from `dataset_thesis_2025`.`reviews`
where (owner_repo,pr_number) in (select owner_repo,pr_number from `dataset_thesis_2025`.`pullRequests` where changedFiles > 0 and (title like '%readability%' or title like '%legibility%' or title like '%understandability%') )
union
select distinct mergedby,owner_repo,pr_number
from `dataset_thesis_2025`.`pullRequests` where changedFiles > 0 and (title like '%readability%' or title like '%legibility%' or title like '%understandability%')
union
select distinct author,owner_repo,pr_number
from `dataset_thesis_2025`.`pullRequests` where changedFiles > 0 and (title like '%readability%' or title like '%legibility%' or title like '%understandability%')
) prs
group by prs.owner_repo,prs.pr_number
having count(distinct prs.login) < 2;

/* generate the csv with candidate Python PRs */
SELECT 'url', 'number_python_files', 'keyword', 'merged at', 'pr_title','pr_body'
UNION ALL
select url,
	   changedFiles,
       keyword,
	   mergedAt,
	   REPLACE(REPLACE(REGEXP_REPLACE(title,'[^\\x20-\\x7E]', ' '),'\n',' '),'\r',' ') AS title,
       REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REGEXP_REPLACE(body,'[^\\x20-\\x7E]', ' '),'\n',' '),'\r',' '),'<',' '),'-->',' '),'!--',' ') AS body
from `dataset_thesis_2025`.`pullRequests` pr
where IFNULL(changedFiles,0) >= 1
  and (title like '%readability%' or title like '%legibility%' or title like '%understandability%')
  and pr.owner_repo in (select owner_repo from repositories where year(lastUpdate) >= 2024 and isfork = 0 and stars >= 10  and language = 'Python')
  order by keyword
INTO OUTFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\candidateMergedReadabilityPRs_python_title.csv';

/* generate the csv with candidate Java PRs */
SELECT 'url', 'number_java_files', 'keyword', 'merged at', 'pr_title','pr_body'
UNION ALL
select url,
	   changedFiles,
       keyword,
	   mergedAt,
	   REPLACE(REPLACE(REGEXP_REPLACE(title,'[^\\x20-\\x7E]', ' '),'\n',' '),'\r',' ') AS title,
       REPLACE(REPLACE(REPLACE(REPLACE(REPLACE(REGEXP_REPLACE(body,'[^\\x20-\\x7E]', ' '),'\n',' '),'\r',' '),'<',' '),'-->',' '),'!--',' ') AS body
from `dataset_thesis_2025`.`pullRequests` pr
where IFNULL(changedFiles,0) >= 1
  -- and (title like '%readability%' or title like '%legibility%' or title like '%understandability%')
  and pr.owner_repo in (select owner_repo from repositories where year(lastUpdate) >= 2024 and isfork = 0 and stars >= 10  and language = 'Java')
  order by keyword
INTO OUTFILE 'C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\candidateMergedReadabilityPRs_java_title.csv';

/* verify how many pull requests does not change Python files*/
select count(*) from `dataset_thesis_2025`.`pullRequests` pr
where pr.owner_repo in (select owner_repo from repositories where stars >= 10 and isFork = 0)
and 
(select count(*) 
 from `dataset_thesis_2025`.`changedFiles` c 
 where LOWER(SUBSTRING_INDEX(fileName,'.',-1)) = 'py' and c.owner_repo = pr.owner_repo and c.pr_number = pr.pr_number) = 0;

select count(*),LOWER(SUBSTRING_INDEX(fileName,'.',-1))
from changedfiles
group by LOWER(SUBSTRING_INDEX(fileName,'.',-1))
order by count(*) desc;

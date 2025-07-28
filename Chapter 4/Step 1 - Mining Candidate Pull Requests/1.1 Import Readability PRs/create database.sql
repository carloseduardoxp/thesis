drop database if exists dataset_thesis_2025;

create database dataset_thesis_2025;

use dataset_thesis_2025;

CREATE TABLE IF NOT EXISTS `dataset_thesis_2025`.`repositories` (
  `owner_repo` VARCHAR(255) NOT NULL ,
  `language` VARCHAR(255),
  `stars` INT(11) ,  
  `isFork` TINYINT(1),
  `pullRequests` INT(11),
  `forks` INT(11),
  `numberIssues` INT(11),
  `watchers` INT(11),
  `collaborators` INT(11),
  `lastUpdate` TIMESTAMP,
  PRIMARY KEY (`owner_repo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dataset_thesis_2025`.`pullRequests` (
  `owner_repo` VARCHAR(255) NOT NULL ,
  `pr_number` INT NOT NULL , 
  `url` VARCHAR(255) NOT NULL ,
  `title` VARCHAR(255),
  `body` TEXT ,
  `changedFiles` INT ,
  `mergedAt` TIMESTAMP  ,  
  `mergedBy` VARCHAR(255) ,  
  `author` VARCHAR(255) ,      
  `keyword` VARCHAR(255) , 
  PRIMARY KEY (`owner_repo`,`pr_number`),
  FOREIGN KEY(owner_repo) REFERENCES repositories(owner_repo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dataset_thesis_2025`.`collaborators` (
  `owner_repo` VARCHAR(255) NOT NULL ,
  `id`  INT(11) NOT NULL , 
  `login` VARCHAR(255) NOT NULL ,
  `type` VARCHAR(255) NOT NULL ,
  `site_admin`  TINYINT(1) NOT NULL ,  
  `contributions` INT(11) NOT NULL , 
  PRIMARY KEY (`owner_repo`,`id`),
  FOREIGN KEY(owner_repo) REFERENCES repositories(owner_repo))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dataset_thesis_2025`.`changedFiles` (
  `owner_repo` VARCHAR(255) NOT NULL ,
  `pr_number` INT(11) NOT NULL , 
  `fileName` VARCHAR(500) NOT NULL ,  
  `typeChange` VARCHAR(255) NOT NULL ,    
  PRIMARY KEY (`owner_repo`,`pr_number`,`fileName`),
  FOREIGN KEY(owner_repo,pr_number) REFERENCES pullRequests(owner_repo,pr_number))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `dataset_thesis_2025`.`reviews` (
  `id` int NOT NULL AUTO_INCREMENT,
  `owner_repo` VARCHAR(255) NOT NULL ,
  `pr_number` INT(11) NOT NULL , 
  `user_id`  INT(11) NOT NULL , 
  `login` VARCHAR(255) NOT NULL ,
  `type` VARCHAR(255) NOT NULL ,
  `body` TEXT NOT NULL ,
  `site_admin`  TINYINT(1) NOT NULL ,  
  `state` VARCHAR(255) NOT NULL ,
  `author_association` VARCHAR(255) NOT NULL ,
  PRIMARY KEY (`id`),
  FOREIGN KEY(owner_repo,pr_number) REFERENCES pullRequests(owner_repo,pr_number))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

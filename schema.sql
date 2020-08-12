
/* This is the schema for the application */

/* Database Users Credentials
	Username: rapid
	Password: rapid123
*/


DROP DATABASE IF EXISTS logparser;
CREATE DATABASE logparser;

use logparser;

DROP TABLE IF EXISTS `logparser`.`log`;

CREATE TABLE `logparser`.`log` ( `id` INT NOT NULL AUTO_INCREMENT , `log_date` DATETIME NOT NULL , `ip` VARCHAR(50) NOT NULL , `request` VARCHAR(50) NOT NULL , `status` VARCHAR(10) NOT NULL , `user_agent` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`) ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `logparser`.`hourly_comment`;

CREATE TABLE `logparser`.`hourly_comment` ( `id` INT NOT NULL AUTO_INCREMENT , `log_date` DATETIME NOT NULL , `ip` VARCHAR(50) NOT NULL , `request` VARCHAR(50) NOT NULL , `status` VARCHAR(10) NOT NULL , `user_agent` VARCHAR(255) NOT NULL , `comment` TEXT NOT NULL , PRIMARY KEY (`id`) ) ENGINE = InnoDB;

DROP TABLE IF EXISTS `logparser`.`daily_comment`;

CREATE TABLE `logparser`.`daily_comment` ( `id` INT NOT NULL AUTO_INCREMENT , `log_date` DATETIME NOT NULL , `ip` VARCHAR(50) NOT NULL , `request` VARCHAR(50) NOT NULL , `status` VARCHAR(10) NOT NULL , `user_agent` VARCHAR(255) NOT NULL , `comment` TEXT NOT NULL , PRIMARY KEY (`id`) ) ENGINE = InnoDB;
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;
CREATE USER IF NOT EXISTS 'dev'@'%' IDENTIFIED BY ':u0=0TI^3@lI';
GRANT ALL PRIVILEGES ON testdb.* TO 'dev'@'%';
FLUSH PRIVILEGES;
SET time_zone = '+00:00';

CREATE TABLE tbluser (
		id INT(19) NOT NULL AUTO_INCREMENT COMMENT 'userId',
		name varchar(100) NOT NULL,
		genre SMALLINT(2) UNSIGNED NOT NULL,
		age SMALLINT(3) UNSIGNED NOT NULL,
		address VARCHAR(200) NOT NULL,
		auditCreationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
        phone varchar(20) DEFAULT NULL,
		primary key(id)
    ) engine = InnoDB default charset = utf8mb4;
    
CREATE TABLE tblcustomer (
		id INT(19) NOT NULL AUTO_INCREMENT COMMENT 'customerId',
		userId INT(19) NOT NULL,
		password varchar(50) NULL,
		status tinyint(1) NOT NULL DEFAULT 0,
		primary key(id),
        constraint FK_USER_CUSTOMER foreign key (userId) references tbluser(id)
    ) engine = InnoDB default charset = utf8mb4;
CREATE DATABASE IF NOT EXISTS testdb;
USE testdb;
CREATE USER IF NOT EXISTS 'dev'@'%' IDENTIFIED BY ':u0=0TI^3@lI';
GRANT ALL PRIVILEGES ON testdb.* TO 'dev'@'%';
FLUSH PRIVILEGES;
SET time_zone = '+00:00';

CREATE TABLE IF NOT EXISTS client (
		id INT(19) NOT NULL AUTO_INCREMENT,
        address VARCHAR(200) NOT NULL,
        age INT UNSIGNED,
        genre INT UNSIGNED,
		name varchar(50) NOT NULL,
        phone varchar(20),
        password varchar(100) NOT NULL,
        status tinyint(1) NOT NULL DEFAULT FALSE,
		creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		lastModifiedDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		primary key(id)
    ) engine = InnoDB default charset = utf8mb4;
    
CREATE TABLE IF NOT EXISTS account (
	id INT(19) NOT NULL AUTO_INCREMENT,
	balance DOUBLE,
	number varchar(20),
    type int(2),
	client_id int(19) NOT NULL,
	status tinyint(1) NOT NULL DEFAULT 0,
	creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	lastModifiedDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	primary key(id)
) engine = InnoDB default charset = utf8mb4;
    
CREATE TABLE IF NOT EXISTS movement (
		id INT(19) NOT NULL AUTO_INCREMENT COMMENT 'customerId',
	    balance DOUBLE,
        type int(2),
	    value DOUBLE,        
		status tinyint(1) NOT NULL DEFAULT 0,
		account_id int(19) NOT NULL,
		creationDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		lastModifiedDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
		primary key(id),
        constraint FK_ACCOUNT_MOVEMENT foreign key (account_id) references account(id)
    ) engine = InnoDB default charset = utf8mb4;
    
desc movement;
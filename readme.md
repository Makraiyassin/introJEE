## DB for project:

CREATE DATABASE shopjee;
Use shopjee;
CREATE TABLE product(
id int NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(255) NOT NULL,
brand VARCHAR(255) NOT NULL,
category VARCHAR(255) NOT NULL,
price DECIMAL(7,2) NOT NULL
)

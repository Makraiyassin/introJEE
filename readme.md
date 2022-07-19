### Courses OCA (1Z0819):

https://app.pluralsight.com/paths/certificate/java-se-11-developer-certification-1z0-819

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
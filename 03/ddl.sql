
create database jdbcsample;

use jdbcsample;

CREATE TABLE employee(
 employee_number VARCHAR(8) PRIMARY KEY,
 name VARCHAR(32) NOT NULL ,
 age int
);

CREATE USER updateUser@localhost IDENTIFIED BY 'morijyobi';
GRANT SELECT,INSERT,UPDATE,DELETE ON jdbcsample.* TO updateUser@localhost;

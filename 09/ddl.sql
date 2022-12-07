
create database school_management;

use school_management;

CREATE TABLE students(
 id INTEGER AUTO_INCREMENT,
 name VARCHAR(16),
 grade INTEGER NOT NULL,
 email VARCHAR(256) NOT NULL UNIQUE,
 gender VARCHAR(1) NOT NULL,
 PRIMARY KEY(id)
);

CREATE USER AppUser@localhost IDENTIFIED BY 'morijyobi';
GRANT SELECT,INSERT,UPDATE,DELETE ON school_management.* TO AppUser@localhost;

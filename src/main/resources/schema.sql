CREATE TABLE songs
(
 songName varchar(100) NOT NULL,
 id varchar(11) NOT NULL ,
 votes int DEFAULT 0,
 PRIMARY KEY (id)
);

CREATE TABLE users
(
 phoneNumber varchar(10) NOT NULL,
 id varchar(11) NOT NULL ,
 PRIMARY KEY (id)
);
drop table links;
drop table users;



CREATE TABLE users (
	User_ID int NOT NULL AUTO_INCREMENT,
	fname varchar(255) NOT NULL,
	lname varchar(255) NOT NULL,
	userName varchar(255) NOT NULL,
	password varchar(255) NOT NULL,
	game varchar(255) NOT NULL,
	email varchar(45) NOT NULL,
	profile_pic varchar(45) DEFAULT NULL,
    
 PRIMARY KEY (User_ID)
 );
 
 CREATE TABLE links(
	Link_ID int NOT NULL AUTO_INCREMENT,
	link varchar(255) NOT NULL,
	game varchar(255) NOT NULL,
	voteCount int DEFAULT NULL,
	User_ID int,
	PRIMARY KEY (Link_ID),
	FOREIGN KEY (User_ID) REFERENCES users(User_ID)
	);
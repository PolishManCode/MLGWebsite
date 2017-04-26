CREATE TABLE users (
	User_ID int NOT NULL AUTO_INCREMENT,
	fname varchar(255) NOT NULL,
	lname varchar(255) NOT NULL,
	userName varchar(255) DEFAULT NULL,
	password varchar(255) DEFAULT NULL,
 PRIMARY KEY (User_ID)
 );
 
 CREATE TABLE links(
	Link_ID int NOT NULL,
	link varchar(255) NOT NULL,
	User_ID int,
	PRIMARY KEY (Link_ID),
	FOREIGN KEY (User_ID) REFERENCES users(User_ID)
	);



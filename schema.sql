CREATE TABLE `users` (
 `ID` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(255) NOT NULL,
 `userName` varchar(255) DEFAULT NULL,
 `password` varchar(255) DEFAULT NULL,
 PRIMARY KEY (`ID`)) 
 ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
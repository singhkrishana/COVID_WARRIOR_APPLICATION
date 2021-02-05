CREATE DATABASE  IF NOT EXISTS `capp_db`;
USE `capp_db`;

DROP TABLE IF EXISTS `contact`;

CREATE TABLE `contact` (
  `contactId` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `remark` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`contactId`),
  KEY `user_fk_idx` (`userId`),
  CONSTRAINT `user_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) 
  ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=latin1;




LOCK TABLES `contact` WRITE;

INSERT INTO `contact` VALUES (101,11,'Contact101','88888888','contact101@KK.com','Pune, India','College Friend'),
(102,11,'Contact102','88888888','contact101@KK.com','Mumbai, India','College Friend'),
(103,11,'Contact103','88888888','contact101@KK.com','Delhi, India','College Friend'),
(104,11,'Contact104','88888888','contact101@KK.com','Bhopal, India','College Friend'),
(105,11,'Contact105','88888888','contact101@KK.com','Hyd, India','College Friend'),
(106,11,'Contact106','88888888','contact101@KK.com','Bengaluru, India','College Friend'),
(107,11,'Contact107','88888888','contact101@KK.com','Nagpur, India','College Friend'),
(108,11,'Contact108','88888888','contact101@KK.com','Pune, India','College Friend'),
(109,11,'Contact109','88888888','contact101@KK.com','Indore, India','College Friend'),
(110,11,'Contact110','88888888','contact101@KK.com','Pune, India','School Friend'),
(111,11,'Contact111','88888888','contact101@KK.com','Pune, India','College Friend'),
(112,11,'Contact112','88888888','contact101@KK.com','Pune, India',''),
(113,11,'Contact113','88888888','contact101@KK.com','Pune, India',''),
(114,12,'Contact114','88888888','contact101@KK.com','Pune, India',''),
(115,12,'Contact115','88888888','contact101@KK.com','Pune, India','College Friend');

UNLOCK TABLES;



DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(150) DEFAULT NULL,
  `loginName` varchar(45) NOT NULL,
  `password` varchar(50) DEFAULT NULL,
  `role` int(1) NOT NULL DEFAULT '2',
  `loginStatus` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`userId`),
  UNIQUE KEY `loginName_UNIQUE` (`loginName`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;


LOCK TABLES `user` WRITE;
;
INSERT INTO `user` VALUES (1,'Vikram','9303580884','vikram@kk.net','Bhopal','v','v123',2,1),
(3,'Amit','8955555555','amit@gmail.com','Pune','amit','amit123',1,1),
(4,'Raj','5622222222','raj@kk.com','Delhi','raj','raj',1,1),
(6,'Nitin','55555555','nitin@kk.net','Mumbai','nitin','nitin123',1,1),
(7,'Varun Sinha','8569856985','varun@kk.com','Mumbai, MS','varun','varun123',2,1),
(10,'Vivek','88888888','vivek@kk.com','Pune','vivek','vivek123',2,1),
(11,'User11','111111111','user11@kk.net','Pune','user11','user11',2,1),
(12,'User12','111111111','user12@kk.net','Mumbai','user12','user12',2,1);

UNLOCK TABLES;

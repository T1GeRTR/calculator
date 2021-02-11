DROP DATABASE IF EXISTS calculator;

CREATE DATABASE `calculator`;

USE `calculator`;

CREATE TABLE `user` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`login` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY login (login),
KEY password (password)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `session` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`sessionId` varchar(50) NOT NULL,
`userId` int(11) NOT NULL,
PRIMARY KEY (id),
UNIQUE KEY sessionId (sessionId),
FOREIGN KEY (userId) REFERENCES `user` (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

CREATE TABLE `expression` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`type` ENUM('ADDITION', 'SUBTRACTION', 'DIVISION', 'MULTIPLICATION', 'EXPONENTIATION', 'SINUS', 'COMPLEX') NOT NULL,
`string` varchar (50) NOT NULL,
`result` float(11) NOT NULL,
`status` ENUM('OK', 'ERROR') NOT NULL,
`datetime` datetime NOT NULL,
`userId` int(11),
PRIMARY KEY (id),
KEY string (string),
KEY result (result),
KEY datetime (datetime),
FOREIGN KEY (userId) REFERENCES `user` (id) ON DELETE CASCADE
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `user` (login, password) VALUES ('unknow', ' ');

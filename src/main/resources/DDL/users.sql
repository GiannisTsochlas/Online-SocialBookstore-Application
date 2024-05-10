CREATE DATABASE  IF NOT EXISTS `secure_users_directory`;
USE `secure_users_directory`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `profile`;
DROP TABLE IF EXISTS `BookOffers`;



CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  `user_name` VARCHAR(100) UNIQUE,
  `password` text DEFAULT NULL,
  `role` text DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `profile` (
    `p_id` int AUTO_INCREMENT PRIMARY KEY ,
    `full_name` VARCHAR(100),
    `address` VARCHAR(255),
    `age` TEXT,
    `phone_number` VARCHAR(20),
    `book_categories` VARCHAR(255),
    `favorite_authors` TEXT,
    `user_id` int unique,
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `BookOffers` (
    `offer_id` INT AUTO_INCREMENT PRIMARY KEY,
    `user_id` INT unique,
    `book_title` VARCHAR(255) NOT NULL,
    `authors` VARCHAR(255) NOT NULL,
    `category` TEXT NOT NULL,
    `summary` TEXT NOT NULL,
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


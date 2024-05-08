CREATE DATABASE  IF NOT EXISTS `secure_users_directory`;
USE `secure_users_directory`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `Profile`;


CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_name` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `role` text DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE Profile (
    `p_id` int AUTO_INCREMENT,
    `user_id` int UNIQUE,
    `full_name` VARCHAR(100),
    `address` VARCHAR(255),
    `age` TEXT,
    `phone_number` VARCHAR(20),
    `book_categories` VARCHAR(255),
    `favorite_authors` TEXT,
    PRIMARY KEY(`p_id`),
    FOREIGN KEY (`user_id`) REFERENCES `users`(`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

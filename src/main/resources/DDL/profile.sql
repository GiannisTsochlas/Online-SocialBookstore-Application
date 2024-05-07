CREATE DATABASE  IF NOT EXISTS `profile_directory`;
USE `profile_directory`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `Profile`;


CREATE TABLE Profile (
    profile_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(100) NOT NULL,
    address VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    phone_number VARCHAR(20) NOT NULL,
    book_categories VARCHAR(255) NOT NULL,
    favorite_authors TEXT NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
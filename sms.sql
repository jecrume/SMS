-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.6.5-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for sms
CREATE DATABASE IF NOT EXISTS `sms` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sms`;

-- Dumping structure for table sms.course
CREATE TABLE IF NOT EXISTS `course` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL DEFAULT '',
  `instructor` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sms.course: ~10 rows (approximately)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`id`, `name`, `instructor`) VALUES
	(1, 'English', 'Anderea Scamaden'),
	(2, 'Mathematics', 'Eustace Niemetz'),
	(3, 'Anatomy', 'Reynolds Pastor'),
	(4, 'Organic Chemistry', 'Odessa Belcher'),
	(5, 'Physics', 'Dani Swallow'),
	(6, 'Digital Logic', 'Glenden Reilingen'),
	(7, 'Object Oriented Programming', 'Giselle Ardy'),
	(8, 'Data Structures', 'Carolan Stoller'),
	(9, 'Politics', 'Carmita De Maine'),
	(10, 'Art', 'Kingsly Doxsey');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for table sms.student
CREATE TABLE IF NOT EXISTS `student` (
  `email` varchar(50) NOT NULL,
  `name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sms.student: ~10 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`email`, `name`, `password`) VALUES
	('aiannitti7@is.gd', 'Alexandra Iannitti', 'TWP4hf5j'),
	('cjaulme9@bing.com', 'Cahra Jaulme', 'FnVklVgC6r6'),
	('cstartin3@flickr.com', 'Clem Startin', 'XYHzJ1S'),
	('hguerre5@deviantart.com', 'Harcourt Guerre', 'OzcxzD1PGs'),
	('hluckham0@google.ru', 'Hazel Luckham', 'X1uZcoIh0dj'),
	('htaffley6@columbia.edu', 'Holmes Taffley', 'xowtOQ'),
	('ljiroudek8@sitemeter.com', 'Laryssa Jiroudek', 'bXRoLUP'),
	('qllorens2@howstuffworks.com', 'Quillan Llorens', 'W6rJuxd'),
	('sbowden1@yellowbook.com', 'Sonnnie Bowden', 'SJc4aWSU'),
	('tattwool4@biglobe.ne.jp', 'Thornie Attwool', 'Hjt0SoVmuBz');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for table sms.student_course
CREATE TABLE IF NOT EXISTS `student_course` (
  `sEmail` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  KEY `FK67781ppuwsfo6gqqtm9oglho6` (`id`),
  KEY `FKetco6ps07ll87nbqyx3r9uw0s` (`sEmail`),
  CONSTRAINT `FK67781ppuwsfo6gqqtm9oglho6` FOREIGN KEY (`id`) REFERENCES `course` (`id`),
  CONSTRAINT `FKetco6ps07ll87nbqyx3r9uw0s` FOREIGN KEY (`sEmail`) REFERENCES `student` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table sms.student_course: ~5 rows (approximately)
/*!40000 ALTER TABLE `student_course` DISABLE KEYS */;
INSERT INTO `student_course` (`sEmail`, `id`) VALUES
	('hluckham0@google.ru', 1),
	('hluckham0@google.ru', 10),
	('hluckham0@google.ru', 7),
	('hluckham0@google.ru', 4),
	('sbowden1@yellowbook.com', 7);
/*!40000 ALTER TABLE `student_course` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

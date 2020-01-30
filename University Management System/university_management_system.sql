-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Jan 30, 2020 at 01:35 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `university_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE IF NOT EXISTS `lecturer` (
  `username` varchar(20) NOT NULL,
  `name` varchar(40) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `course1_code` char(10) DEFAULT NULL,
  `course1_name` char(30) DEFAULT NULL,
  `course2_code` char(10) DEFAULT NULL,
  `course2_name` char(30) DEFAULT NULL,
  `course3_code` char(10) DEFAULT NULL,
  `course3_name` char(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `username` varchar(20) NOT NULL,
  `name` char(40) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `password` char(15) NOT NULL,
  `course1_code` char(10) DEFAULT NULL,
  `course1_name` char(30) DEFAULT NULL,
  `course2_code` char(10) DEFAULT NULL,
  `course2_name` char(30) DEFAULT NULL,
  `course3_code` char(10) DEFAULT NULL,
  `course3_name` char(30) DEFAULT NULL,
  PRIMARY KEY (`username`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

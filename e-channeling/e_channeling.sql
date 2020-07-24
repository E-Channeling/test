-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3325
-- Generation Time: May 15, 2020 at 12:56 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `e_channeling`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` bigint(20) NOT NULL,
  `user_id` varchar(8) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `user_id`, `password`) VALUES
(1, 'MENUKA', 'c8ffe9a587b126f152ed3d89a146b445'),
(3, 'MAHINSHA', '202cb962ac59075b964b07152d234b70');

-- --------------------------------------------------------

--
-- Table structure for table `appoiment`
--

CREATE TABLE `appoiment` (
  `id` bigint(20) NOT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  `schedule_id` bigint(20) DEFAULT NULL,
  `appoiment_date` timestamp NULL DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `cancel_date` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `appoiment`
--

INSERT INTO `appoiment` (`id`, `patient_id`, `schedule_id`, `appoiment_date`, `status`, `cancel_date`) VALUES
(93, 1, 42240, '2020-05-03 03:50:21', 'CANCEL', '2020-05-04 16:55:01'),
(94, 1, 42239, '2020-05-03 03:50:36', 'CANCEL', '2020-05-03 03:50:41'),
(95, 1, 42241, '2020-05-03 03:50:59', 'REJECT', NULL),
(96, 1, 42242, '2020-05-03 15:15:00', 'APPROVE', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `doctor`
--

CREATE TABLE `doctor` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(12) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `hospital_id` bigint(20) NOT NULL,
  `user_id` varchar(8) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor`
--

INSERT INTO `doctor` (`id`, `first_name`, `last_name`, `address`, `contact`, `gender`, `email`, `hospital_id`, `user_id`, `password`) VALUES
(1, 'Menuka', 'Jayasinghem', 'Bibile', '0774142608', 'MALE', 'menu@gmail.com', 1, 'menu', '123'),
(3, 'Menuka', 'Madhusanka', 'Yalkumbura, Kotagama', '0774142608', 'MALE', 'menukamadhusanka@gmail.com', 1, 'MENUKA', '202cb962ac59075b964b07152d234b70'),
(4, 'Mahinsha', 'Ramyathilake', '9/2,Meegahawatte,Delgoda', '0763261717', 'MALE', 'mahiramyathilake@gmail.com', 2, 'MAHI_DOC', '08c4c9b32230ea186ff625be92f853fe'),
(5, 'Mahinsha', 'Ramyathilake', '9/2,Meegahawatte,Delgoda', '0763261717', 'MALE', 'mahiramyathilake@gmail.com', 2, 'MAHINSHA', '202cb962ac59075b964b07152d234b70'),
(6, 'a', 'b', 'hgdbsdgs', '4753875', 'MALE', 'sfdhs@gmail.com', 2, 'test', 'a01610228fe998f515a72dd730294d87'),
(7, 'df', 'jkhf', 'odifgo', '65465', 'MALE', 'ldfjig@gmail.com', 2, 'jkda', 'a01610228fe998f515a72dd730294d87');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_speclization`
--

CREATE TABLE `doctor_speclization` (
  `id` bigint(20) NOT NULL,
  `doctor_id` bigint(20) NOT NULL,
  `specilization_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `doctor_speclization`
--

INSERT INTO `doctor_speclization` (`id`, `doctor_id`, `specilization_id`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL,
  `patient_id` bigint(20) NOT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `description` varchar(300) DEFAULT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`id`, `patient_id`, `doctor_id`, `description`, `date`) VALUES
(1, 1, 1, 'good work', '2020-04-22 16:19:56'),
(2, 1, 2, 'good', '2020-04-22 16:20:23'),
(3, 2, 1, 'fjfj', '2020-04-22 16:23:54'),
(4, 1, 1, 'ggo\r\n', '2020-04-25 16:26:53'),
(5, 1, 3, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', '2020-04-26 15:46:57'),
(6, 1, 3, 'dggggggggggggggggggggggggggggggggggggggggggggg', '2020-04-26 15:47:04'),
(7, 1, 3, 'dbhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh', '2020-04-26 15:47:12'),
(8, 1, 3, 'fhnfhgjtgk', '2020-04-26 15:47:22'),
(9, 1, 3, 'fgggggggggggggggggggggggg', '2020-04-26 15:59:16'),
(10, 1, 3, 'aaaaaa', '2020-05-03 03:51:13');

-- --------------------------------------------------------

--
-- Table structure for table `hospital`
--

CREATE TABLE `hospital` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hospital`
--

INSERT INTO `hospital` (`id`, `name`, `address`, `contact`) VALUES
(2, 'BIBILE', 'ABC', '011023123'),
(3, 'Badulla', 'bbbbbbbbbbb', '0555412');

-- --------------------------------------------------------

--
-- Table structure for table `patient`
--

CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contact` varchar(12) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `email` varchar(100) NOT NULL,
  `photo` mediumblob DEFAULT NULL,
  `user_id` varchar(8) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `patient`
--

INSERT INTO `patient` (`id`, `first_name`, `last_name`, `dob`, `address`, `contact`, `gender`, `email`, `photo`, `user_id`, `password`) VALUES
(1, 'Menuka', 'Jayasingha', '2020-04-06', 'Yalkumbura', '077414260', 'MALE', 'menukamadhusanka@gmail', '', 'MENUKA', '202cb962ac59075b964b07152d234b70'),
(2, 'Menuka', 'Madhusanka', '2020-04-22', 'Yalkumbura, Kotagama', '0774142608', 'MALE', 'menukamadhusanka@gmail.com', '', 'MENU', '900150983cd24fb0d6963f7d28e17f72'),
(3, 'Menuka', 'Madhusanka', '2020-04-08', 'Yalkumbura, Kotagama', '0774142608', 'MALE', 'menukamadhusanka@gmail.com', '', 'A', '7815696ecbf1c96e6894b779456d330e'),
(4, 'Menuka', 'Madhusanka', '2020-04-27', 'Yalkumbura, Kotagama', '0774142608', 'MALE', 'menukamadhusanka@gmail.com', '', 'mmmh', '202cb962ac59075b964b07152d234b70'),
(7, 'Menuka', 'Madhusanka', '2020-05-11', 'Yalkumbura, Kotagama', '0774142608', 'MALE', 'menukamadhusanka@gmail.com', '', 'f', '8fa14cdd754f91cc6554c9e71929cce7'),
(8, 'Menuka', 'Madhusanka', '2020-05-05', 'Yalkumbura, Kotagama', '0774142608', 'MALE', 'menukamadhusanka@gmail.com', '', 'j', '363b122c528f54df4a0446b6bab05515');

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `id` bigint(20) NOT NULL,
  `hospital_id` bigint(20) DEFAULT NULL,
  `doctor_id` bigint(20) DEFAULT NULL,
  `specilization_id` bigint(20) NOT NULL,
  `from_time` time DEFAULT NULL,
  `to_time` time DEFAULT NULL,
  `date` date DEFAULT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`id`, `hospital_id`, `doctor_id`, `specilization_id`, `from_time`, `to_time`, `date`, `status`) VALUES
(42238, 2, 3, 1, '18:30:00', '19:00:00', '2020-05-20', 'AVAILABLE'),
(42239, 1, 3, 1, '08:10:00', '08:30:00', '2020-05-05', 'AVAILABLE'),
(42240, 1, 3, 1, '08:30:00', '09:00:00', '2020-05-05', 'AVAILABLE'),
(42241, 1, 3, 1, '09:00:00', '09:30:00', '2020-05-05', 'BOOKED'),
(42242, 1, 3, 1, '09:30:00', '10:00:00', '2020-05-05', 'BOOKED'),
(42243, 1, 3, 1, '13:10:00', '13:30:00', '2020-05-21', 'AVAILABLE'),
(42245, 1, 3, 1, '08:00:00', '08:30:00', '2020-05-08', 'BOOKED'),
(42246, 1, 3, 1, '08:30:00', '09:00:00', '2020-05-08', 'AVAILABLE'),
(42247, 1, 3, 1, '09:00:00', '09:30:00', '2020-05-08', 'AVAILABLE'),
(42248, 1, 3, 1, '09:30:00', '10:00:00', '2020-05-08', 'AVAILABLE'),
(42249, 1, 3, 1, '13:00:00', '13:15:00', '2020-05-08', 'AVAILABLE'),
(42250, 1, 3, 1, '13:15:00', '13:30:00', '2020-05-08', 'AVAILABLE'),
(42251, 1, 3, 1, '13:30:00', '13:45:00', '2020-05-08', 'AVAILABLE'),
(42252, 1, 3, 1, '13:45:00', '14:00:00', '2020-05-08', 'AVAILABLE');

-- --------------------------------------------------------

--
-- Table structure for table `specilization`
--

CREATE TABLE `specilization` (
  `id` bigint(20) NOT NULL,
  `spec_name` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `specilization`
--

INSERT INTO `specilization` (`id`, `spec_name`) VALUES
(1, 'test'),
(2, 'test2');

-- --------------------------------------------------------

--
-- Table structure for table `treatment`
--

CREATE TABLE `treatment` (
  `id` bigint(20) NOT NULL,
  `patient_id` bigint(20) NOT NULL,
  `doctor_id` bigint(20) NOT NULL,
  `description` varchar(300) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `appoiment`
--
ALTER TABLE `appoiment`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `doctor_speclization`
--
ALTER TABLE `doctor_speclization`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patient`
--
ALTER TABLE `patient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `specilization`
--
ALTER TABLE `specilization`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `treatment`
--
ALTER TABLE `treatment`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `appoiment`
--
ALTER TABLE `appoiment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=98;

--
-- AUTO_INCREMENT for table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `doctor_speclization`
--
ALTER TABLE `doctor_speclization`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `patient`
--
ALTER TABLE `patient`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42253;

--
-- AUTO_INCREMENT for table `specilization`
--
ALTER TABLE `specilization`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `treatment`
--
ALTER TABLE `treatment`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

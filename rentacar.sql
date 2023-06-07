-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 07, 2023 at 12:53 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rentacar`
--

-- --------------------------------------------------------

--
-- Table structure for table `Auto`
--

CREATE TABLE `Auto` (
  `auto_id` int(11) NOT NULL,
  `marka` varchar(50) NOT NULL,
  `model` varchar(50) NOT NULL,
  `godiste` int(11) NOT NULL,
  `is_iznajmljen` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Auto`
--

INSERT INTO `Auto` (`auto_id`, `marka`, `model`, `godiste`, `is_iznajmljen`) VALUES
(1, 'Bugatti', 'Chiron', 2023, 0),
(2, 'BMW', 'M3', 2021, 0),
(3, 'Audi', 'TT', 2019, 0),
(4, 'Mercedes Benz', 'S-Class', 2015, 0),
(5, 'Ford', 'Focus', 2018, 0),
(6, 'Skoda', 'SuperB', 2020, 0),
(7, 'Bravado', 'Bison', 2013, 0);

-- --------------------------------------------------------

--
-- Table structure for table `Klijent`
--

CREATE TABLE `Klijent` (
  `klijent_id` int(11) NOT NULL,
  `ime` varchar(50) NOT NULL,
  `prezime` varchar(50) NOT NULL,
  `broj_telefona` varchar(45) NOT NULL,
  `broj_vozacke` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Klijent`
--

INSERT INTO `Klijent` (`klijent_id`, `ime`, `prezime`, `broj_telefona`, `broj_vozacke`) VALUES
(1, 'Cedomir', 'Ljepojevic', '4533462', '12345'),
(2, 'Andjela', 'Trifunovic', '42355634', '226654'),
(3, 'Petar', 'Petrovic', '64288733', '203455632'),
(4, 'Petar', 'Petrovic', '555333', '12345'),
(5, 'Marko', 'markovic', '222333', '1237654'),
(6, 'Mika', 'Mikic', '242563', '383762'),
(7, 'Zika', 'Zikic', '34456564', '3734783'),
(8, 'Ivan', 'Ivanovic', '546373', '363782'),
(9, 'Jovan', 'Jovanovic', '46572', '5839523'),
(10, 'Jovan', 'Jovanovic', '457583', '42835'),
(11, 'Teodora', 'Teodorovic', '567483', '3984575'),
(12, 'Jovanka', 'Jovanovic', '456372', '2987465'),
(13, 'Joksim', 'Joksimovic', '4563728', '98765'),
(14, 'Mitar', 'Miric', '643728', '4278192'),
(15, 'Mirka', 'Mirkovic', '56473829', '67238945'),
(16, 'Zika', 'Zikic', '54627381', '212312'),
(17, 'Zika', 'Zikic', '54627381', '212312'),
(18, 'ime', 'prezime', '55555', '55555'),
(19, 'ime', 'prezime', '55555', '55555'),
(20, 'Jovanka', 'Broz', '4356728', '6537482'),
(21, 'Jovanka', 'Broz', '4356728', '6537482'),
(22, 'Misko', 'Misic', '4626316', '42344'),
(23, 'Misko', 'Misic', '4626316', '42344'),
(24, 'Djordje', 'Mordjevic', '4536172', '45264'),
(25, 'Djordje', 'Mordjevic', '4536172', '45264');

-- --------------------------------------------------------

--
-- Table structure for table `Rezervacija`
--

CREATE TABLE `Rezervacija` (
  `rezervacija_id` int(11) NOT NULL,
  `klijent_id` int(11) NOT NULL,
  `auto_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Rezervacija`
--

INSERT INTO `Rezervacija` (`rezervacija_id`, `klijent_id`, `auto_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 7),
(6, 1, 3),
(7, 1, 3),
(10, 19, 7),
(11, 21, 7),
(12, 23, 7),
(13, 25, 6);

-- --------------------------------------------------------

--
-- Table structure for table `User`
--

CREATE TABLE `User` (
  `user_id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `User`
--

INSERT INTO `User` (`user_id`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, 'abc', '123'),
(3, 'sis1234', 'sis1234'),
(4, 'andjela2', '2andjela'),
(5, 'peca30', 'javaphp'),
(6, 'test', 'test'),
(7, 'test', 'test');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Auto`
--
ALTER TABLE `Auto`
  ADD PRIMARY KEY (`auto_id`);

--
-- Indexes for table `Klijent`
--
ALTER TABLE `Klijent`
  ADD PRIMARY KEY (`klijent_id`);

--
-- Indexes for table `Rezervacija`
--
ALTER TABLE `Rezervacija`
  ADD PRIMARY KEY (`rezervacija_id`),
  ADD KEY `auto_id` (`auto_id`),
  ADD KEY `klijent_id` (`klijent_id`);

--
-- Indexes for table `User`
--
ALTER TABLE `User`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Auto`
--
ALTER TABLE `Auto`
  MODIFY `auto_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `Klijent`
--
ALTER TABLE `Klijent`
  MODIFY `klijent_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `Rezervacija`
--
ALTER TABLE `Rezervacija`
  MODIFY `rezervacija_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `User`
--
ALTER TABLE `User`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Rezervacija`
--
ALTER TABLE `Rezervacija`
  ADD CONSTRAINT `rezervacija_ibfk_1` FOREIGN KEY (`auto_id`) REFERENCES `Auto` (`auto_id`),
  ADD CONSTRAINT `rezervacija_ibfk_2` FOREIGN KEY (`klijent_id`) REFERENCES `Klijent` (`klijent_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

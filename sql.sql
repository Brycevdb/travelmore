-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: travelmore
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `accomodation`
--

DROP TABLE IF EXISTS `accomodation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `accomodation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) default null,
  `location_id` int(11) DEFAULT NULL,
  `periodId` int(11) DEFAULT NULL,
  `freeplaces` int(11) DEFAULT NULL,
  `priceaperson` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `accomodation`
--

LOCK TABLES `accomodation` WRITE;
/*!40000 ALTER TABLE `accomodation` DISABLE KEYS */;
/*!40000 ALTER TABLE `accomodation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `coords` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

/*DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/* SET character_set_client = utf8mb4 ;
CREATE TABLE `payment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `methodId` int(11) DEFAULT NULL,
  `transaction` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
/*UNLOCK TABLES;*/

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `paymentmethod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
/*!40000 ALTER TABLE `paymentmethod` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `period`
--

DROP TABLE IF EXISTS `period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `period` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `start` date DEFAULT NULL,
  `end` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `period`
--

LOCK TABLES `period` WRITE;
/*!40000 ALTER TABLE `period` DISABLE KEYS */;
/*!40000 ALTER TABLE `period` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `transport` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `priceaperson` double DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `transport`
--

LOCK TABLES `transport` WRITE;
/*!40000 ALTER TABLE `transport` DISABLE KEYS */;
/*!40000 ALTER TABLE `transport` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `trip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `departure` int(11) DEFAULT NULL,
  `accomodationId` int(11) DEFAULT NULL,
  `transportId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `trip`
--

LOCK TABLES `trip` WRITE;
/*!40000 ALTER TABLE `trip` DISABLE KEYS */;
/*!40000 ALTER TABLE `trip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tripofuser`
--

DROP TABLE IF EXISTS `tripofuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tripofuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `tripId` int(11) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `totalpeeps` int(11) DEFAULT NULL,
  `methodId` int(11) DEFAULT NULL,
  `transaction` date DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `tripofuser`
--

LOCK TABLES `tripofuser` WRITE;
/*!40000 ALTER TABLE `tripofuser` DISABLE KEYS */;
/*!40000 ALTER TABLE `tripofuser` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `famname` varchar(45) DEFAULT NULL,
  `role` varchar(45) DEFAULT NULL,
  `pass` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `landId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userpaymentmethod`
--

/*DROP TABLE IF EXISTS `userpaymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/* SET character_set_client = utf8mb4 ;
CREATE TABLE `userpaymentmethod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `paymentmethodId` int(11) DEFAULT NULL,
  `extra` varchar(45) DEFAULT NULL,
  `active` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `userpaymentmethod`
--

LOCK TABLES `userpaymentmethod` WRITE;
/*!40000 ALTER TABLE `userpaymentmethod` DISABLE KEYS */;
/*/*!40000 ALTER TABLE `userpaymentmethod` ENABLE KEYS */;
/*UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-12 10:53:46
INSERT INTO `travelmore`.`location` (`name`, `coords`) VALUES ('Brussel', '0.0');
INSERT INTO `travelmore`.`location` (`name`, `coords`) VALUES ('Antwerpen', '1.1');

INSERT INTO `travelmore`.`accomodation` (`name`, `location_id`, `periodId`, `freeplaces`, `priceaperson`) VALUES ('Hotel', '1', '1', '50', '50');
INSERT INTO `travelmore`.`accomodation` (`name`, `location_id`, `periodId`, `freeplaces`, `priceaperson`) VALUES ('Camping Kitsch', '2', '2', '200', '15');

INSERT INTO `travelmore`.`user` (`name`, `famname`, `role`, `pass`, `mail`, `landId`) VALUES ('User', 'user', '1', 'iets', 'iets', '1');
INSERT INTO `travelmore`.`user` (`name`, `famname`, `role`, `pass`, `mail`, `landId`) VALUES ('User2', 'user', '0', 'iets2', 'iets2', '2');

INSERT INTO `travelmore`.`paymentmethod` (`name`) VALUES ('Paypal');
INSERT INTO `travelmore`.`paymentmethod` (`name`) VALUES ('Bancontact');

INSERT INTO `travelmore`.`period` (`start`, `end`) VALUES ('2018-01-01', '2018-01-02');
INSERT INTO `travelmore`.`period` (`start`, `end`) VALUES ('1970-01-01', '1970-01-02');

INSERT INTO `travelmore`.`tripofuser` (`userId`, `tripId`, `totalprice`, `totalpeeps`, `methodId`, `transaction`) VALUES ('2', '2', '500', '5', '2', '2018-01-01');
INSERT INTO `travelmore`.`tripofuser` (`userId`, `tripId`, `totalprice`, `totalpeeps`, `methodId`, `transaction`) VALUES ('1', '1', '500', '3', '1', '2018-01-02');


INSERT INTO `travelmore`.`transport` (`name`, `priceaperson`) VALUES ('auto', '10');
INSERT INTO `travelmore`.`transport` (`name`, `priceaperson`) VALUES ('vliegtuig', '200');

INSERT INTO `travelmore`.`trip` (`departure`, `accomodationId`, `transportId`) VALUES ('1', '2', '1');
INSERT INTO `travelmore`.`trip` (`departure`, `accomodationId`, `transportId`) VALUES ('2', '1', '2');
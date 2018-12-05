SET NAMES utf8 ;

--
-- Table structure for table `accomodation`
--

DROP TABLE IF EXISTS `accomodation`;
CREATE TABLE `accomodation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) default null,
  `location_id` int(11) DEFAULT NULL,
  `periodId` int(11) DEFAULT NULL,
  `freeplaces` int(11) DEFAULT NULL,
  `priceaperson` double DEFAULT NULL,
  `photourl` varchar(45) default null,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `accomodation`
--

LOCK TABLES `accomodation` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `location`
--

DROP TABLE IF EXISTS `location`;
CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `coords` varchar(45) DEFAULT NULL,
  `photourl` varchar(45) default null,
  PRIMARY KEY (`id`)
);


--
-- Dumping data for table `location`
--

LOCK TABLES `location` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
CREATE TABLE `paymentmethod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
UNLOCK TABLES;

--
-- Table structure for table `period`
--

DROP TABLE IF EXISTS `period`;
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
UNLOCK TABLES;

--
-- Table structure for table `transport`
--

DROP TABLE IF EXISTS `transport`;
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
UNLOCK TABLES;

--
-- Table structure for table `trip`
--

DROP TABLE IF EXISTS `trip`;
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
UNLOCK TABLES;

--
-- Table structure for table `tripofuser`
--

DROP TABLE IF EXISTS `tripofuser`;
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
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
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
UNLOCK TABLES;

--
-- Table structure for table `userpaymentmethod`
--

INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Brussel', '0.0', 'https://cdn.pixabay.com/photo/2015/09/25/23/10/brussel-958408_960_720.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Antwerpen', '1.1', 'https://cdn.pixabay.com/photo/2016/02/05/15/20/antwerp-1181141_960_720.jpg');

INSERT INTO `travelmore`.`accomodation` (`name`, `location_id`, `periodId`, `freeplaces`, `priceaperson`, `photourl`) VALUES ('Hotel', '1', '1', '50', '50', 'https://images.freeimages.com/images/large-previews/12a/hotel-1220563.jpg');
INSERT INTO `travelmore`.`accomodation` (`name`, `location_id`, `periodId`, `freeplaces`, `priceaperson`, `photourl`) VALUES ('Camping Kitsch', '2', '2', '200', '15', 'https://cdn.pixabay.com/photo/2016/11/29/04/17/bonfire-1867275_960_720.jpg');

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
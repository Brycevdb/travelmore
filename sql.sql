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
  `photourl` varchar(200) default null,
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
  `photourl` varchar(200) default null,
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

INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Antwerpen', '1.1', 'https://static.b-europe.com/-/media/MediaRepository/Images_LowRes/Destinations/BE/700x432_antwerp_2.ashx?h=432&la=en&w=700&hash=2A71B7E1DCCDE00F425029D959C9A8894C155996');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Brussel', '0.0', 'https://www.dinnerinthesky.be/dist/assets/images/slider/pic_001.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Aalst', '0.0', 'https://www.persregiodender.be/wp-content/uploads/2016/01/Uitzicht-op-Aalst-NAC-De-Werf-Persregio-Dender-300x167.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Aarschot', '0.0', 'https://www.hetgasthuis.be/upload/1/page_block/medium/voorblad_landschap.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Andenne', '0.0', 'http://www.province-namur.be/wp-content/uploads/2017/03/vues-aeriennes.jpeg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Beringen', '0.0', 'https://igorphiltjens.be/wp-content/uploads/2016/10/B_mijnsite-Stad-Beringen.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Bilzen', '0.0', 'https://dsocdn.akamaized.net/Assets/Images_Upload/2018/09/14/bilzen.jpg?maxheight=416&maxwidth=568');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Binche', '0.0', 'http://www.carnavaldebinche.be/images/slideshows/slidetop/slideshow_12.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Blankenberge', '0.0', 'https://www.visit-blankenberge.be/imageresizer/49117AF680A536F300B777283119A161/1633.jpg?h=800');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Brugge', '0.0', 'https://www.beerwalk.be/media/1257/brugge-fb.png');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Leuven', '0.0', 'https://www.arenbergleuven.be/imager/files/Stad/2533/Stadhuis_horizontaal_Marco-Mertens_LR_605e8e1ce848eb8ed47a1b5d0338acaa.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Namen', '0.0', 'https://www.ahstatic.com/photos/3151_de_00_p_2048x1536.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Dinant', '0.0', 'https://static1.squarespace.com/static/570142dc1d07c0902335c2e3/57021e50b09f95bfee6d2f22/5883b41c1b10e356f52f9177/1518202042768/IMG_4986.JPG?format=2500w');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Hasselt', '0.0', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRp-qftoDu7rd2PrAcHchSnZr08MgmSwVpIHgB9MVJ-I6v3xVKsbQ');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Turnhout', '0.0', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRU02kXIEyWtiiiiGAZTRtug04mpyEVGta2cdMGm4VQ4owG8VV4');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('De Panne', '0.0', 'https://www.ahstatic.com/photos/8131_de_00_p_2048x1536.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Oostende', '0.0', 'https://www.hotel-dieprince.be/wordpress/wp-content/uploads/2016/11/hotel-oostende-die-prince-omgeving-08-1920x1000.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Maaseik', '0.0', 'http://www.cittaslow-nederland.nl/wp-content/uploads/2017/11/Vlooienkoning-Maaseik-1024x683.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Geel', '0.0', 'https://static.independent.co.uk/s3fs-public/thumbnails/image/2015/10/03/12/Geel-Mike-Jay.jpg?w968h681');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Ravels', '0.0', 'https://www.wzc-ravels.be/images/cache/2dba50871d00c4977bd9cdbada6a3f08.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Weelde', '0.0', 'https://www.wzc-ravels.be/images/cache/2dba50871d00c4977bd9cdbada6a3f08.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Arendonk', '0.0', 'http://nieuwsblad.typepad.com/arendonk/images/2008/04/28/toremansmolen_3.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Poppel', '0.0', 'https://www.wzc-ravels.be/images/cache/2dba50871d00c4977bd9cdbada6a3f08.jpg');
INSERT INTO `travelmore`.`location` (`name`, `coords`, `photourl`) VALUES ('Tilburg', '0.0', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSm5JPZtZPtw-c3ErnzIySLNJcYo4u3d7cIBP0LKlQOYdkAXNv');

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
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: university
-- ------------------------------------------------------
-- Server version	5.7.20-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `departmens`
--

DROP TABLE IF EXISTS `departmens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `departmens` (
  `DepartmenID` int(11) NOT NULL AUTO_INCREMENT,
  `DepartmenName` varchar(45) NOT NULL,
  `id_head` int(11) NOT NULL,
  PRIMARY KEY (`DepartmenID`),
  KEY `fk_head_idx` (`id_head`),
  CONSTRAINT `fk_head` FOREIGN KEY (`id_head`) REFERENCES `lectors` (`lectorsID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departmens`
--

LOCK TABLES `departmens` WRITE;
/*!40000 ALTER TABLE `departmens` DISABLE KEYS */;
INSERT INTO `departmens` VALUES (1,'Gryffindor',2),(2,'Ravenclaw',1),(3,'Slytherin',4);
/*!40000 ALTER TABLE `departmens` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lect_and_dep`
--

DROP TABLE IF EXISTS `lect_and_dep`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lect_and_dep` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_lector` int(11) NOT NULL,
  `id_departmen` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_id_lec_idx` (`id_lector`),
  KEY `fk_id_dep_idx` (`id_departmen`),
  CONSTRAINT `fk_id_dep` FOREIGN KEY (`id_departmen`) REFERENCES `departmens` (`DepartmenID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_id_lec` FOREIGN KEY (`id_lector`) REFERENCES `lectors` (`lectorsID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lect_and_dep`
--

LOCK TABLES `lect_and_dep` WRITE;
/*!40000 ALTER TABLE `lect_and_dep` DISABLE KEYS */;
INSERT INTO `lect_and_dep` VALUES (1,4,3),(2,2,1),(3,1,1),(4,5,1),(5,3,2);
/*!40000 ALTER TABLE `lect_and_dep` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lectors`
--

DROP TABLE IF EXISTS `lectors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lectors` (
  `lectorsID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `degree` varchar(45) NOT NULL,
  `phone` decimal(10,0) NOT NULL,
  `salary` int(11) NOT NULL,
  PRIMARY KEY (`lectorsID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lectors`
--

LOCK TABLES `lectors` WRITE;
/*!40000 ALTER TABLE `lectors` DISABLE KEYS */;
INSERT INTO `lectors` VALUES (1,'Albus','Dumbledore','professor',634794539,5000),(2,'Minerva','McGonagall','professor',635663207,4500),(3,'Filius','Flitwick','professor',976559688,4500),(4,'Severus','Snape','professor',937885241,4500),(5,'Rubeus','Hagrid','assistant',934458630,1000);
/*!40000 ALTER TABLE `lectors` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-13  1:44:38

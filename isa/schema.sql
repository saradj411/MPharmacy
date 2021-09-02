-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: pharmacy_db
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `action_and_promotion`
--

DROP TABLE IF EXISTS `action_and_promotion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `action_and_promotion` (
  `id_action` int NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  PRIMARY KEY (`id_action`),
  KEY `FKqef7qn1i9poed97cenmypm6ga` (`pharmacy_id`),
  CONSTRAINT `FKqef7qn1i9poed97cenmypm6ga` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_and_promotion`
--

LOCK TABLES `action_and_promotion` WRITE;
/*!40000 ALTER TABLE `action_and_promotion` DISABLE KEYS */;
/*!40000 ALTER TABLE `action_and_promotion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `action_patient_pharmacy`
--

DROP TABLE IF EXISTS `action_patient_pharmacy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `action_patient_pharmacy` (
  `patient_id` int NOT NULL,
  `pharmacy_id` int NOT NULL,
  PRIMARY KEY (`patient_id`,`pharmacy_id`),
  KEY `FKnanayh84q037t09iq5fii4e2n` (`pharmacy_id`),
  CONSTRAINT `FK2nwgyk8mfri0bm5pei2rmhds9` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FKnanayh84q037t09iq5fii4e2n` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `action_patient_pharmacy`
--

LOCK TABLES `action_patient_pharmacy` WRITE;
/*!40000 ALTER TABLE `action_patient_pharmacy` DISABLE KEYS */;
INSERT INTO `action_patient_pharmacy` VALUES (507,501),(508,501),(510,501),(510,502),(507,503),(507,504),(508,504);
/*!40000 ALTER TABLE `action_patient_pharmacy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `allergies`
--

DROP TABLE IF EXISTS `allergies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allergies` (
  `patient_id` int NOT NULL,
  `drug_id` int NOT NULL,
  PRIMARY KEY (`patient_id`,`drug_id`),
  KEY `FKeg8cxkil8c0nv0ex6omcvov8d` (`drug_id`),
  CONSTRAINT `FKeg8cxkil8c0nv0ex6omcvov8d` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id_drug`),
  CONSTRAINT `FKmiky0mjiuiup8ed6dmf8xjny2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allergies`
--

LOCK TABLES `allergies` WRITE;
/*!40000 ALTER TABLE `allergies` DISABLE KEYS */;
INSERT INTO `allergies` VALUES (507,501),(507,502),(508,502),(510,502),(510,503),(508,504);
/*!40000 ALTER TABLE `allergies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alternative_drug`
--

DROP TABLE IF EXISTS `alternative_drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alternative_drug` (
  `id_drug` int NOT NULL,
  `id_alternative_drug` int NOT NULL,
  PRIMARY KEY (`id_drug`,`id_alternative_drug`),
  KEY `FK8d0vgykabhq639twfedcmtod4` (`id_alternative_drug`),
  CONSTRAINT `FK8d0vgykabhq639twfedcmtod4` FOREIGN KEY (`id_alternative_drug`) REFERENCES `drug` (`id_drug`),
  CONSTRAINT `FK9f4ynuf20566lnhcql5kcvy88` FOREIGN KEY (`id_drug`) REFERENCES `drug` (`id_drug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alternative_drug`
--

LOCK TABLES `alternative_drug` WRITE;
/*!40000 ALTER TABLE `alternative_drug` DISABLE KEYS */;
INSERT INTO `alternative_drug` VALUES (503,501),(505,501),(506,501),(503,502),(501,504),(506,504),(501,507),(503,507);
/*!40000 ALTER TABLE `alternative_drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authority` (
  `id` int NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_PHARMACY_ADMIN'),(3,'ROLE_PHARMACIST'),(4,'ROLE_DERMATOLOGIST'),(5,'ROLE_PATIENT'),(6,'ROLE_SUPPLIER');
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint`
--

DROP TABLE IF EXISTS `complaint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint` (
  `dtype` varchar(31) NOT NULL,
  `id_complaint` int NOT NULL,
  `is_answered` bit(1) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  PRIMARY KEY (`id_complaint`),
  KEY `FKktah4qns7wu1m4ifl8ud4j9em` (`patient_id`),
  KEY `FK6ehntnrxpb9vso3k5xpf07a7c` (`pharmacy_id`),
  KEY `FK8ry7xaxssdp9vdk6dtr46rull` (`staff_id`),
  CONSTRAINT `FK6ehntnrxpb9vso3k5xpf07a7c` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`),
  CONSTRAINT `FK8ry7xaxssdp9vdk6dtr46rull` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKktah4qns7wu1m4ifl8ud4j9em` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint`
--

LOCK TABLES `complaint` WRITE;
/*!40000 ALTER TABLE `complaint` DISABLE KEYS */;
INSERT INTO `complaint` VALUES ('StaffComplaint',32,NULL,'Niiiisi nisi ',508,NULL,504),('PharmacyComplaint',33,NULL,'Op op op',508,504,NULL);
/*!40000 ALTER TABLE `complaint` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `complaint_answer`
--

DROP TABLE IF EXISTS `complaint_answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `complaint_answer` (
  `id_answer` bigint NOT NULL,
  `text_answer` varchar(255) DEFAULT NULL,
  `complaint_id` int DEFAULT NULL,
  PRIMARY KEY (`id_answer`),
  KEY `FK7wl51jbx3v9wjyyt357kjpajp` (`complaint_id`),
  CONSTRAINT `FK7wl51jbx3v9wjyyt357kjpajp` FOREIGN KEY (`complaint_id`) REFERENCES `complaint` (`id_complaint`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `complaint_answer`
--

LOCK TABLES `complaint_answer` WRITE;
/*!40000 ALTER TABLE `complaint_answer` DISABLE KEYS */;
/*!40000 ALTER TABLE `complaint_answer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dermatolgoist_grade`
--

DROP TABLE IF EXISTS `dermatolgoist_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dermatolgoist_grade` (
  `id_markd` int NOT NULL,
  `grade` int DEFAULT NULL,
  `id_dermatologist` int DEFAULT NULL,
  `id_patient` int DEFAULT NULL,
  PRIMARY KEY (`id_markd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dermatolgoist_grade`
--

LOCK TABLES `dermatolgoist_grade` WRITE;
/*!40000 ALTER TABLE `dermatolgoist_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `dermatolgoist_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dermatologist`
--

DROP TABLE IF EXISTS `dermatologist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dermatologist` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKasoc5qtxi28gowti1yfuqn917` FOREIGN KEY (`id`) REFERENCES `staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dermatologist`
--

LOCK TABLES `dermatologist` WRITE;
/*!40000 ALTER TABLE `dermatologist` DISABLE KEYS */;
INSERT INTO `dermatologist` VALUES (501),(504),(509),(533);
/*!40000 ALTER TABLE `dermatologist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dermatologists_in_pharmacies`
--

DROP TABLE IF EXISTS `dermatologists_in_pharmacies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dermatologists_in_pharmacies` (
  `dermatologist_id` int NOT NULL,
  `pharmacy_id` int NOT NULL,
  PRIMARY KEY (`dermatologist_id`,`pharmacy_id`),
  KEY `FKgmypkmckuo83gvxia1lrkboc7` (`pharmacy_id`),
  CONSTRAINT `FK9pfxhl0xund9bc97is33olnkl` FOREIGN KEY (`dermatologist_id`) REFERENCES `dermatologist` (`id`),
  CONSTRAINT `FKgmypkmckuo83gvxia1lrkboc7` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dermatologists_in_pharmacies`
--

LOCK TABLES `dermatologists_in_pharmacies` WRITE;
/*!40000 ALTER TABLE `dermatologists_in_pharmacies` DISABLE KEYS */;
INSERT INTO `dermatologists_in_pharmacies` VALUES (501,501),(504,501),(533,501),(501,502),(509,503);
/*!40000 ALTER TABLE `dermatologists_in_pharmacies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug`
--

DROP TABLE IF EXISTS `drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug` (
  `id_drug` int NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `drug_type` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  `grade` double DEFAULT NULL,
  `manufacturer` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `napomene` varchar(255) DEFAULT NULL,
  `points` int DEFAULT NULL,
  `recipe_need` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id_drug`),
  UNIQUE KEY `UK_gp2v51p5n48ip1i7dl9ejujhh` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug`
--

LOCK TABLES `drug` WRITE;
/*!40000 ALTER TABLE `drug` DISABLE KEYS */;
INSERT INTO `drug` VALUES (501,'sifra 1','tableta','TABLET',8,'proizvodjac 1','probiotik','nap1',10,_binary ''),(502,'sifra 2','kapsula','CAPSULE',6,'proizvodjac 2','paracetamol','nap2',20,_binary ''),(503,'sifra 3','tableta','TABLET',7,'proizvodjac 3','andol','nap1',10,_binary '\0'),(504,'sifra 4','kapsula','CAPSULE',5,'proizvodjac 4','ampril','nap13',15,_binary ''),(505,'sifra 5','prasak','INJECTION',8,'proizvodjac 5','aspirin','nap3',12,_binary ''),(506,'sifra 6','tableta','TABLET',10,'proizvodjac 6','brufen','naa',22,_binary '\0'),(507,'sifra 7','sprej','GEL',7,'proizvodjac 7','mometazonfuorat','nap1',10,_binary ''),(508,'sifra 8','kapsula','CAPSULE',3,'proizvodjac 8','gentamicin','nap34',5,_binary ''),(509,'sifra 9','kapsula','CAPSULE',3,'DOO Komerc','flonidan','aaam',8,_binary ''),(510,'sifra 10','tableta','TABLET',6,'DOO Komerc','pressing','amaa',10,_binary '');
/*!40000 ALTER TABLE `drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug_grade`
--

DROP TABLE IF EXISTS `drug_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug_grade` (
  `id_mark_dr` int NOT NULL,
  `grade` int DEFAULT NULL,
  `id_drug` int DEFAULT NULL,
  `id_patient` int DEFAULT NULL,
  PRIMARY KEY (`id_mark_dr`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug_grade`
--

LOCK TABLES `drug_grade` WRITE;
/*!40000 ALTER TABLE `drug_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `drug_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug_order`
--

DROP TABLE IF EXISTS `drug_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug_order` (
  `id_order` int NOT NULL,
  `processed` bit(1) DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `time_limit` date DEFAULT NULL,
  `admin` int DEFAULT NULL,
  PRIMARY KEY (`id_order`),
  KEY `FKjci1ntkbripsqf4mi4prd9mn5` (`admin`),
  CONSTRAINT `FKjci1ntkbripsqf4mi4prd9mn5` FOREIGN KEY (`admin`) REFERENCES `pharmacy_admin` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug_order`
--

LOCK TABLES `drug_order` WRITE;
/*!40000 ALTER TABLE `drug_order` DISABLE KEYS */;
INSERT INTO `drug_order` VALUES (500,_binary '',5,'2021-08-12',503),(501,_binary '\0',4,'2021-09-20',503),(502,_binary '\0',8,'2021-11-20',503),(503,_binary '',2,'2021-12-20',503),(504,_binary '',4,'2021-10-20',503),(505,_binary '',20,'2021-05-20',503);
/*!40000 ALTER TABLE `drug_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug_pricelist`
--

DROP TABLE IF EXISTS `drug_pricelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug_pricelist` (
  `id_pricelist` int NOT NULL,
  `end` date DEFAULT NULL,
  `price` double DEFAULT NULL,
  `start` date DEFAULT NULL,
  `drug_id` int DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  PRIMARY KEY (`id_pricelist`),
  KEY `FKqo4dvkphrybmvxenv4pnw9aa0` (`drug_id`),
  KEY `FKmah9src0v0k1oyqejdgk19sh6` (`pharmacy_id`),
  CONSTRAINT `FKmah9src0v0k1oyqejdgk19sh6` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`),
  CONSTRAINT `FKqo4dvkphrybmvxenv4pnw9aa0` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id_drug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug_pricelist`
--

LOCK TABLES `drug_pricelist` WRITE;
/*!40000 ALTER TABLE `drug_pricelist` DISABLE KEYS */;
INSERT INTO `drug_pricelist` VALUES (501,'2021-08-12',100,'2021-02-27',503,503),(502,'2021-10-12',250,'2021-01-01',504,501),(503,'2021-06-11',300,'2020-06-11',505,503),(504,'2021-07-12',180,'2020-02-02',506,504),(505,'2021-12-01',300,'2020-04-07',507,502),(506,'2021-09-09',280,'2020-04-01',503,501),(507,'2021-11-01',300,'2020-07-07',504,502),(509,'2021-11-01',300,'2020-07-07',507,501),(510,'2021-11-01',286,'2020-07-07',506,501),(511,'2021-11-01',300,'2020-08-11',508,504),(512,'2021-11-01',260,'2020-08-20',507,504),(513,'2021-09-01',650,'2020-07-07',501,501),(514,'2021-12-01',301,'2020-08-03',501,503),(515,'2021-08-12',240,'2020-06-01',502,503),(516,'2021-11-10',100,'2020-08-17',502,504),(517,'2021-12-12',256,'2020-08-22',503,504),(518,'2021-12-12',500,'2020-09-01',505,501),(519,'2021-12-13',300,'2020-08-31',505,502),(520,'2021-12-10',260,'2020-08-31',505,504),(521,'2021-10-12',600,'2020-08-30',505,505),(522,'2021-10-12',179,'2020-08-30',509,501),(523,'2021-10-21',366,'2020-09-02',509,503),(524,'2021-10-05',200,'2020-09-01',509,502),(525,'2021-10-10',574,'2020-08-23',509,504),(526,'2021-11-15',566,'2020-08-31',509,505),(527,'2021-09-30',544,'2020-08-31',510,505),(528,'2021-09-19',73,'2020-08-31',510,504),(529,'2021-10-12',199,'2020-09-01',510,503),(530,'2021-11-30',344,'2020-08-20',510,502),(531,'2021-12-12',266,'2020-08-26',510,501),(532,'2021-11-01',500,'2020-08-01',508,502),(533,'2021-12-12',256,'2020-08-10',507,503);
/*!40000 ALTER TABLE `drug_pricelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `drug_reservation`
--

DROP TABLE IF EXISTS `drug_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `drug_reservation` (
  `id_reservation` int NOT NULL,
  `cancelled` bit(1) DEFAULT NULL,
  `date_of_reservation` date DEFAULT NULL,
  `expired` bit(1) DEFAULT NULL,
  `is_picked_up` bit(1) DEFAULT NULL,
  `pick_up_date` date DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `drug_id` int DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  PRIMARY KEY (`id_reservation`),
  KEY `FKsly54vwc3hhgeg3xq22aksbtv` (`drug_id`),
  KEY `FK1rhnptsvh592psojejey6rjrv` (`patient_id`),
  KEY `FKi285obsfp6r9vbc1y1nustkyk` (`pharmacy_id`),
  CONSTRAINT `FK1rhnptsvh592psojejey6rjrv` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FKi285obsfp6r9vbc1y1nustkyk` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`),
  CONSTRAINT `FKsly54vwc3hhgeg3xq22aksbtv` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id_drug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `drug_reservation`
--

LOCK TABLES `drug_reservation` WRITE;
/*!40000 ALTER TABLE `drug_reservation` DISABLE KEYS */;
INSERT INTO `drug_reservation` VALUES (500,_binary '\0','2021-04-20',_binary '\0',_binary '\0','2021-06-20',3,503,510,503),(501,_binary '','2021-05-25',_binary '\0',_binary '\0','2021-06-15',3,504,510,501),(502,_binary '\0','2021-04-20',_binary '\0',_binary '','2021-07-20',3,505,508,503),(503,_binary '\0','2021-05-18',_binary '',_binary '\0','2021-07-20',3,506,510,504),(504,_binary '','2021-04-20',_binary '\0',_binary '','2021-09-20',3,507,507,502),(505,_binary '\0','2021-04-20',_binary '\0',_binary '\0','2021-09-20',3,503,510,503),(506,_binary '','2021-05-25',_binary '\0',_binary '','2021-06-15',3,504,508,501),(507,_binary '\0','2021-04-20',_binary '',_binary '\0','2021-08-20',3,505,507,503),(508,_binary '\0','2021-05-18',_binary '',_binary '','2021-07-20',3,506,508,504),(509,_binary '\0','2021-04-20',_binary '\0',_binary '\0','2021-05-24',3,507,507,502),(510,_binary '\0','2021-04-20',_binary '\0',_binary '','2021-05-24',3,507,508,502),(511,_binary '','2021-01-25',_binary '\0',_binary '\0','2021-01-15',3,504,510,501),(512,_binary '','2021-02-25',_binary '\0',_binary '','2021-02-16',3,504,510,501),(513,_binary '','2021-03-25',_binary '\0',_binary '','2021-03-17',3,504,510,501),(514,_binary '','2021-04-25',_binary '\0',_binary '\0','2021-04-18',3,504,510,501);
/*!40000 ALTER TABLE `drug_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erecipe`
--

DROP TABLE IF EXISTS `erecipe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `erecipe` (
  `id_recipe` int NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `date_of_issue` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `patient_id` int DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id_recipe`),
  KEY `FKs2qy12k7vvux68rmkdll5uy5f` (`patient_id`),
  KEY `FKkf9vckww0po7hfmhnvtmv57bl` (`pharmacy_id`),
  KEY `FKafii8btlvjvjinevhhttt25kb` (`userid`),
  CONSTRAINT `FKafii8btlvjvjinevhhttt25kb` FOREIGN KEY (`userid`) REFERENCES `users` (`id`),
  CONSTRAINT `FKkf9vckww0po7hfmhnvtmv57bl` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`),
  CONSTRAINT `FKs2qy12k7vvux68rmkdll5uy5f` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erecipe`
--

LOCK TABLES `erecipe` WRITE;
/*!40000 ALTER TABLE `erecipe` DISABLE KEYS */;
INSERT INTO `erecipe` VALUES (2,'Hard kodirano','2021-09-02','Ivana ','NEW','Ivic',1,NULL,501),(5,'Hard kodirano','2021-09-02','Mika','NEW','Mikic',507,NULL,501),(9,'Hard kodirano','2021-09-02','Mika','NEW','Mikic',507,NULL,501),(11,'Hard kodirano','2021-09-02','Ana','NEW','Mikic',508,NULL,501),(15,'Hard kodirano','2021-09-02','Ana','NEW','Mikic',508,NULL,501),(18,'Hard kodirano','2021-09-02','Mika','NEW','Mikic',507,NULL,511),(20,'Hard kodirano','2021-09-02','Ana','NEW','Mikic',508,NULL,511),(24,'Hard kodirano','2021-09-02','Ivana ','NEW','Ivic',1,NULL,511),(27,'Hard kodirano','2021-09-02','Ivana ','NEW','Ivic',1,NULL,511),(30,'Hard kodirano','2021-09-02','Ivana ','NEW','Ivic',1,NULL,511),(40,'Hard kodirano','2021-09-02','Ana','PROCESSED','Mikic',508,503,501),(42,'Hard kodirano','2021-09-02','Mika','NEW','Mikic',507,NULL,501),(500,'12345','2021-05-24','Ana','NEW','Mikic',508,501,511),(501,'12346','2021-05-22','Ana','NEW','Mikic',508,501,511);
/*!40000 ALTER TABLE `erecipe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erecipe_drug`
--

DROP TABLE IF EXISTS `erecipe_drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `erecipe_drug` (
  `id` int NOT NULL,
  `code` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `quantity` int NOT NULL,
  `erecipe_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5tgc0vji7l5pvdjf51ir2eamh` (`erecipe_id`),
  CONSTRAINT `FK5tgc0vji7l5pvdjf51ir2eamh` FOREIGN KEY (`erecipe_id`) REFERENCES `erecipe` (`id_recipe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erecipe_drug`
--

LOCK TABLES `erecipe_drug` WRITE;
/*!40000 ALTER TABLE `erecipe_drug` DISABLE KEYS */;
INSERT INTO `erecipe_drug` VALUES (3,'sifra 10','pressing',2,2),(4,'sifra 5','aspirin',10,2),(6,'sifra 10','pressing',1,5),(7,'sifra 8','gentamicin',10,5),(8,'sifra 4','ampril',3,5),(10,'sifra 7','mometazonfuorat',10,9),(12,'sifra 8','gentamicin',1,11),(13,'sifra 5','aspirin',13,11),(14,'sifra 1','probiotik',10,11),(16,'sifra 8','gentamicin',10,15),(17,'sifra 10','pressing',3,15),(19,'sifra 8','gentamicin',2,18),(21,'sifra 5','aspirin',2,20),(22,'sifra 8','gentamicin',10,20),(23,'sifra 9','flonidan',1,20),(25,'sifra 2','paracetamol',3,24),(26,'sifra 10','pressing',1,24),(28,'sifra 8','gentamicin',1,27),(29,'sifra 2','paracetamol',2,27),(31,'sifra 1','probiotik',10,30),(41,'sifra 7','mometazonfuorat',1,40),(43,'sifra 7','mometazonfuorat',1,42),(500,'sifra 1','probiotik',7,501),(501,'sifra 2','paracetamol',8,501),(502,'sifra 1','probiotik',9,501),(503,'sifra 2','paracetamol',11,501);
/*!40000 ALTER TABLE `erecipe_drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `erecipe_e_recipe_drug`
--

DROP TABLE IF EXISTS `erecipe_e_recipe_drug`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `erecipe_e_recipe_drug` (
  `erecipe_id_recipe` int NOT NULL,
  `e_recipe_drug_id` int NOT NULL,
  PRIMARY KEY (`erecipe_id_recipe`,`e_recipe_drug_id`),
  UNIQUE KEY `UK_2s4f193vwkatv0eprn51ptax8` (`e_recipe_drug_id`),
  CONSTRAINT `FK4gsayj1jjvv78kwo1b9fmgowu` FOREIGN KEY (`erecipe_id_recipe`) REFERENCES `erecipe` (`id_recipe`),
  CONSTRAINT `FKt1i4nrpae4bo283homnkrw4mb` FOREIGN KEY (`e_recipe_drug_id`) REFERENCES `erecipe_drug` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `erecipe_e_recipe_drug`
--

LOCK TABLES `erecipe_e_recipe_drug` WRITE;
/*!40000 ALTER TABLE `erecipe_e_recipe_drug` DISABLE KEYS */;
INSERT INTO `erecipe_e_recipe_drug` VALUES (2,3),(2,4),(5,6),(5,7),(5,8),(9,10),(11,12),(11,13),(11,14),(15,16),(15,17),(18,19),(20,21),(20,22),(20,23),(24,25),(24,26),(27,28),(27,29),(30,31),(40,41),(42,43),(500,500),(500,501),(501,502),(501,503);
/*!40000 ALTER TABLE `erecipe_e_recipe_drug` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examination` (
  `id_examination` int NOT NULL,
  `canceled` bit(1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `is_scheduled` bit(1) DEFAULT NULL,
  `points_for_examination` int DEFAULT NULL,
  `price` double DEFAULT NULL,
  `report` varchar(255) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `patient` int DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  `staff_id` int DEFAULT NULL,
  `therapy_id` int DEFAULT NULL,
  PRIMARY KEY (`id_examination`),
  KEY `FKa3udxysjwrvhg0pqmbvf0m91v` (`patient`),
  KEY `FKbgmdt0v4389k7xcglifp7mddt` (`pharmacy_id`),
  KEY `FKdosuxmxbt8wp48ejfuqf3obrw` (`staff_id`),
  KEY `FKmtm9jt4vhn0064qv2llm4e59b` (`therapy_id`),
  CONSTRAINT `FKa3udxysjwrvhg0pqmbvf0m91v` FOREIGN KEY (`patient`) REFERENCES `patient` (`id`),
  CONSTRAINT `FKbgmdt0v4389k7xcglifp7mddt` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`),
  CONSTRAINT `FKdosuxmxbt8wp48ejfuqf3obrw` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKmtm9jt4vhn0064qv2llm4e59b` FOREIGN KEY (`therapy_id`) REFERENCES `therapy` (`id_therapy`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination`
--

LOCK TABLES `examination` WRITE;
/*!40000 ALTER TABLE `examination` DISABLE KEYS */;
INSERT INTO `examination` VALUES (1,_binary '\0','2021-07-22','11:00:00',_binary '\0',NULL,880,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',NULL,504,506,NULL),(500,_binary '\0','2021-07-23','09:00:00',_binary '\0',NULL,600,'info1','08:00:00','CREATED','DERMATOLOGIST_EXAMINATION',NULL,501,501,NULL),(501,_binary '\0','2021-07-22','11:00:00',_binary '\0',NULL,880,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',NULL,501,504,NULL),(503,_binary '\0','2021-07-22','11:00:00',_binary '\0',NULL,880,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',NULL,503,502,NULL),(505,_binary '\0','2021-07-22','11:00:00',_binary '\0',NULL,880,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',NULL,501,501,NULL),(506,_binary '\0','2021-07-22','11:00:00',_binary '\0',NULL,1000,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',NULL,501,511,NULL),(508,_binary '\0','2021-07-23','11:00:00',_binary '\0',NULL,1000,'info2','09:30:00','CREATED','PHARMACIST_EXAMINATION',NULL,501,511,NULL),(509,_binary '\0','2021-08-27','12:00:00',_binary '\0',NULL,1050,'info2','10:30:00','CREATED','PHARMACIST_EXAMINATION',NULL,501,511,NULL),(510,_binary '\0','2021-07-29','11:00:00',_binary '\0',NULL,1030,'info2','09:30:00','CREATED','DERMATOLOGIST_EXAMINATION',NULL,501,501,NULL),(511,_binary '\0','2021-07-27','12:00:00',_binary '\0',NULL,1050,'info2','10:30:00','CREATED','DERMATOLOGIST_EXAMINATION',NULL,501,504,NULL),(542,_binary '\0','2021-08-28','12:00:00',_binary '\0',NULL,1050,'info2','10:30:00','CREATED','PHARMACIST_EXAMINATION',NULL,501,511,NULL),(550,_binary '\0','2020-05-20','09:00:00',_binary '',10,600,'info1','08:00:00','FINISHED','DERMATOLOGIST_EXAMINATION',508,501,501,NULL),(551,_binary '\0','2020-05-23','11:00:00',_binary '',NULL,880,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',508,501,504,501),(553,_binary '\0','2020-01-20','09:00:00',_binary '',NULL,600,'info1','08:00:00','FINISHED','DERMATOLOGIST_EXAMINATION',507,501,501,NULL),(554,_binary '\0','2020-02-23','11:00:00',_binary '',NULL,880,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',507,501,504,502),(555,_binary '\0','2020-03-27','12:00:00',_binary '',NULL,1050,'info2','10:30:00','FINISHED','PHARMACIST_EXAMINATION',508,501,511,NULL),(556,_binary '\0','2020-08-29','11:00:00',_binary '',NULL,1030,'info2','09:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',510,501,501,NULL),(557,_binary '\0','2020-08-27','12:00:00',_binary '',NULL,1050,'info2','10:30:00','FINISHED','DERMATOLOGIST_EXAMINATION',510,501,504,504),(559,_binary '\0','2020-03-26','12:00:00',_binary '',NULL,1050,'info2','10:30:00','FINISHED','PHARMACIST_EXAMINATION',507,501,511,503);
/*!40000 ALTER TABLE `examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (44);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingredient`
--

DROP TABLE IF EXISTS `ingredient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingredient` (
  `id` bigint NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `spec_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsvgqxge85nh0olgolktt8wl22` (`spec_id`),
  CONSTRAINT `FKsvgqxge85nh0olgolktt8wl22` FOREIGN KEY (`spec_id`) REFERENCES `specification` (`id_spec`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingredient`
--

LOCK TABLES `ingredient` WRITE;
/*!40000 ALTER TABLE `ingredient` DISABLE KEYS */;
INSERT INTO `ingredient` VALUES (500,'sastojak 1',504),(501,'sastojak 1',500),(502,'sastojak 1',503),(503,'sastojak 1',502),(504,'sastojak 1',501);
/*!40000 ALTER TABLE `ingredient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loyality_program`
--

DROP TABLE IF EXISTS `loyality_program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loyality_program` (
  `id_program` int NOT NULL,
  `created_date` date DEFAULT NULL,
  `is_active` bit(1) DEFAULT NULL,
  `percent_bronse` int DEFAULT NULL,
  `percent_gold` int DEFAULT NULL,
  `percent_silver` int DEFAULT NULL,
  `points_to_gold` int DEFAULT NULL,
  `points_to_regular` int DEFAULT NULL,
  `points_to_silver` int DEFAULT NULL,
  PRIMARY KEY (`id_program`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loyality_program`
--

LOCK TABLES `loyality_program` WRITE;
/*!40000 ALTER TABLE `loyality_program` DISABLE KEYS */;
INSERT INTO `loyality_program` VALUES (1,'2021-09-01',_binary '',10,15,20,10,20,30);
/*!40000 ALTER TABLE `loyality_program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offer`
--

DROP TABLE IF EXISTS `offer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `offer` (
  `id_offer` int NOT NULL,
  `delivery_date` date DEFAULT NULL,
  `offer_status` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  `supplier` int DEFAULT NULL,
  PRIMARY KEY (`id_offer`),
  KEY `FKh72fbxk95il288bkwa1a7qtyg` (`order_id`),
  KEY `FK3kytrr80wev2mllt0mgesp0w` (`supplier`),
  CONSTRAINT `FK3kytrr80wev2mllt0mgesp0w` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`id`),
  CONSTRAINT `FKh72fbxk95il288bkwa1a7qtyg` FOREIGN KEY (`order_id`) REFERENCES `drug_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offer`
--

LOCK TABLES `offer` WRITE;
/*!40000 ALTER TABLE `offer` DISABLE KEYS */;
INSERT INTO `offer` VALUES (500,'2021-07-22','ON_HOLD',550,500,123),(501,'2021-08-22','ON_HOLD',860,501,123),(502,'2021-09-22','CONFIRMED',502,502,123),(504,'2021-08-22','ON_HOLD',250,503,123),(505,'2021-09-22','CONFIRMED',252,504,123),(506,'2021-09-22','CONFIRMED',252,505,123),(509,'2021-07-22','ON_HOLD',123,500,123),(511,'2021-08-22','ON_HOLD',569,501,123),(512,'2021-09-22','ON_HOLD',256,502,123),(514,'2021-08-22','ON_HOLD',250,503,123),(515,'2021-09-22','ON_HOLD',356,504,123),(516,'2021-09-22','ON_HOLD',252,505,123);
/*!40000 ALTER TABLE `offer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_item`
--

DROP TABLE IF EXISTS `order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_item` (
  `id_item` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `drug_id` int DEFAULT NULL,
  `order_id` int DEFAULT NULL,
  PRIMARY KEY (`id_item`),
  KEY `FKgpnp57wwbs8g5ins7ct0lomct` (`drug_id`),
  KEY `FKljkhiiofkrht7899fsketcwtn` (`order_id`),
  CONSTRAINT `FKgpnp57wwbs8g5ins7ct0lomct` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id_drug`),
  CONSTRAINT `FKljkhiiofkrht7899fsketcwtn` FOREIGN KEY (`order_id`) REFERENCES `drug_order` (`id_order`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_item`
--

LOCK TABLES `order_item` WRITE;
/*!40000 ALTER TABLE `order_item` DISABLE KEYS */;
INSERT INTO `order_item` VALUES (1,10,502,500),(2,10,503,500),(3,5,506,502),(5,100,504,503),(6,20,504,505),(7,10,501,505),(500,5,501,500),(501,3,502,500),(503,6,503,502),(504,7,503,503),(505,5,505,504),(506,5,506,505),(507,5,506,503),(509,5,501,501),(510,5,505,501),(511,5,504,501);
/*!40000 ALTER TABLE `order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `patient`
--

DROP TABLE IF EXISTS `patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `patient` (
  `loyalty_category` varchar(255) DEFAULT NULL,
  `penalty` int DEFAULT NULL,
  `points` int DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKf0or75ex3abs31ottuqg8s301` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `patient`
--

LOCK TABLES `patient` WRITE;
/*!40000 ALTER TABLE `patient` DISABLE KEYS */;
INSERT INTO `patient` VALUES ('NONE',0,0,1),('GOLD',2,10,507),('GOLD',1,39,508),('BRONZE',0,7,510);
/*!40000 ALTER TABLE `patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacist`
--

DROP TABLE IF EXISTS `pharmacist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacist` (
  `id` int NOT NULL,
  `pharmacist_pharmacy` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsgqepiiqv4w61yu5u92gxlekk` (`pharmacist_pharmacy`),
  CONSTRAINT `FKc3pfeui1y673x654uprmvcbcf` FOREIGN KEY (`id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKsgqepiiqv4w61yu5u92gxlekk` FOREIGN KEY (`pharmacist_pharmacy`) REFERENCES `pharmacy` (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacist`
--

LOCK TABLES `pharmacist` WRITE;
/*!40000 ALTER TABLE `pharmacist` DISABLE KEYS */;
INSERT INTO `pharmacist` VALUES (333,501),(511,501),(559,501),(502,503),(506,504);
/*!40000 ALTER TABLE `pharmacist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacist_grade`
--

DROP TABLE IF EXISTS `pharmacist_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacist_grade` (
  `id_markp` int NOT NULL,
  `grade` int DEFAULT NULL,
  `id_patient` int DEFAULT NULL,
  `id_pharmacist` int DEFAULT NULL,
  PRIMARY KEY (`id_markp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacist_grade`
--

LOCK TABLES `pharmacist_grade` WRITE;
/*!40000 ALTER TABLE `pharmacist_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacist_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy`
--

DROP TABLE IF EXISTS `pharmacy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy` (
  `id_pharm` int NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `avg_grade` double DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `consultation_price` double DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` int DEFAULT NULL,
  `postal_code` int DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `town` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy`
--

LOCK TABLES `pharmacy` WRITE;
/*!40000 ALTER TABLE `pharmacy` DISABLE KEYS */;
INSERT INTO `pharmacy` VALUES (501,'Novosadska 3',7,'Novi Sad',550,'Srbija','opis5','Jankovic',2,21000,'Street 2','Novi Sad'),(502,'Gagarinova 10',8,'Novi Sad',600,'Srbija','opis5','Benu',2,21000,'Street 2','Novi Sad'),(503,'Bore Stankovica 2',6,'Novi Sad',800,'Srbija','opis5','Zegin',2,21000,'Street 2','Novi Sad'),(504,'Knez Mihajlova 23',9,'Novi Sad',1050,'Srbija','opis5','Srbotrade',2,21000,'Street 2','Novi Sad'),(505,'Bore Petrovica 1',10,'Novi Sad',1500,'Srbija','opis5','DedaPharm',2,21000,'Street 2','Novi Sad');
/*!40000 ALTER TABLE `pharmacy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy_admin`
--

DROP TABLE IF EXISTS `pharmacy_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy_admin` (
  `id` int NOT NULL,
  `admin_pharmacy` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKis0516kkflgbjvmbqrg5jvnn2` (`admin_pharmacy`),
  CONSTRAINT `FKis0516kkflgbjvmbqrg5jvnn2` FOREIGN KEY (`admin_pharmacy`) REFERENCES `pharmacy` (`id_pharm`),
  CONSTRAINT `FKrl8tfwoab6vjfb75rs1ckitr1` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_admin`
--

LOCK TABLES `pharmacy_admin` WRITE;
/*!40000 ALTER TABLE `pharmacy_admin` DISABLE KEYS */;
INSERT INTO `pharmacy_admin` VALUES (503,501);
/*!40000 ALTER TABLE `pharmacy_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy_drugs`
--

DROP TABLE IF EXISTS `pharmacy_drugs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy_drugs` (
  `id` int NOT NULL,
  `quantity` int DEFAULT NULL,
  `drug_id` int DEFAULT NULL,
  `pharmacy_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh53exsctey2scaeexa9jcnqk7` (`drug_id`),
  KEY `FKb53hu8ayc4qarqq4yyili4bxm` (`pharmacy_id`),
  CONSTRAINT `FKb53hu8ayc4qarqq4yyili4bxm` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`),
  CONSTRAINT `FKh53exsctey2scaeexa9jcnqk7` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id_drug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_drugs`
--

LOCK TABLES `pharmacy_drugs` WRITE;
/*!40000 ALTER TABLE `pharmacy_drugs` DISABLE KEYS */;
INSERT INTO `pharmacy_drugs` VALUES (1,0,507,503),(501,50,503,503),(502,8,504,501),(503,6,505,503),(504,90,506,504),(505,3,507,502),(506,5,503,501),(507,8,504,502),(508,8,507,501),(511,30,508,502),(512,15,508,504),(514,12,507,504),(515,40,501,501),(516,3,501,503),(517,30,502,503),(518,22,502,504),(519,21,503,504),(520,6,506,501),(521,14,505,501),(522,54,505,502),(523,25,505,505),(524,10,509,501),(525,10,510,505),(526,16,510,504),(527,190,510,503),(528,34,510,502),(529,7,510,501),(530,11,509,502),(531,13,509,503),(532,45,509,504),(533,34,509,505),(534,60,505,504);
/*!40000 ALTER TABLE `pharmacy_drugs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pharmacy_grade`
--

DROP TABLE IF EXISTS `pharmacy_grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pharmacy_grade` (
  `id_mark_ph` int NOT NULL,
  `grade` int DEFAULT NULL,
  `id_patient` int DEFAULT NULL,
  `id_pharmacy` int DEFAULT NULL,
  PRIMARY KEY (`id_mark_ph`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pharmacy_grade`
--

LOCK TABLES `pharmacy_grade` WRITE;
/*!40000 ALTER TABLE `pharmacy_grade` DISABLE KEYS */;
/*!40000 ALTER TABLE `pharmacy_grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `request_for_vacation`
--

DROP TABLE IF EXISTS `request_for_vacation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `request_for_vacation` (
  `id` int NOT NULL,
  `accepted` bit(1) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `end` date DEFAULT NULL,
  `request_processed` bit(1) DEFAULT NULL,
  `start` date DEFAULT NULL,
  `pharmacy_id` int NOT NULL,
  `staff_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtc07ld2hn0kfb2cnnw2t7hn15` (`pharmacy_id`),
  KEY `FKeh7wt0kfs1plccqkop673uk8a` (`staff_id`),
  CONSTRAINT `FKeh7wt0kfs1plccqkop673uk8a` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKtc07ld2hn0kfb2cnnw2t7hn15` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `request_for_vacation`
--

LOCK TABLES `request_for_vacation` WRITE;
/*!40000 ALTER TABLE `request_for_vacation` DISABLE KEYS */;
INSERT INTO `request_for_vacation` VALUES (600,_binary '\0','opiz','2021-06-20',_binary '','2020-06-20',501,502),(601,_binary '\0','opiz','2021-06-20',_binary '','2020-06-20',501,502),(602,_binary '\0','opiz','2021-06-20',_binary '','2020-06-20',501,502),(604,_binary '\0','opiz','2021-06-20',_binary '\0','2020-06-20',502,501),(605,_binary '\0','opiz','2021-06-20',_binary '\0','2020-06-20',502,504),(606,_binary '\0','opiz','2021-06-20',_binary '','2020-06-20',502,533);
/*!40000 ALTER TABLE `request_for_vacation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `specification`
--

DROP TABLE IF EXISTS `specification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `specification` (
  `id_spec` int NOT NULL,
  `contraindications` varchar(255) DEFAULT NULL,
  `ingredients` varchar(255) DEFAULT NULL,
  `recommended_dose` int DEFAULT NULL,
  `structure` varchar(255) DEFAULT NULL,
  `drug_code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_spec`),
  KEY `FK8cy0hsex7dgx7c7kw8apa4v4p` (`drug_code`),
  CONSTRAINT `FK8cy0hsex7dgx7c7kw8apa4v4p` FOREIGN KEY (`drug_code`) REFERENCES `drug` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `specification`
--

LOCK TABLES `specification` WRITE;
/*!40000 ALTER TABLE `specification` DISABLE KEYS */;
INSERT INTO `specification` VALUES (500,'iritacija sinusa','sastojak 1, sastojak 2',4,'sastav 1','sifra 1'),(501,'iritacija oka','sastojak 1',6,'sastav 2','sifra 2'),(502,'nema','sastojak 3, sastojak 2',7,'sastav 3','sifra 3'),(503,'iritacija sinusa','sastojak 13',2,'sastav 4','sifra 4'),(504,'nema','sastojak 4',9,'sastav 5','sifra 5'),(505,'Lose po dijabeticare.','sastojak 4',9,'sastav 1','sifra 6'),(506,'nema','sastojak 4',9,'sastav 2','sifra 7'),(507,'Ne znamo.','sastojak 4',9,'sastav 32','sifra 8'),(508,'Moguce povracanje','sastojak 4',9,'sastav 43','sifra 9'),(509,'Prekomerno spavanje.','sastojak 4',1,'sastav 25','sifra 10');
/*!40000 ALTER TABLE `specification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `avg_grade` double DEFAULT NULL,
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK5aes4ihkx95t5h3fvhayg940u` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (7.2,333),(8,501),(6.4,502),(6.3,504),(7.2,506),(7,509),(7.2,511),(6.2,533),(7.2,559);
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FKiseinqnkpn2w6ow7l0ynr93pd` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES (123);
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sys_admin`
--

DROP TABLE IF EXISTS `sys_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sys_admin` (
  `id` int NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK36xbhlypy086th1512ry1m5cf` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sys_admin`
--

LOCK TABLES `sys_admin` WRITE;
/*!40000 ALTER TABLE `sys_admin` DISABLE KEYS */;
INSERT INTO `sys_admin` VALUES (512);
/*!40000 ALTER TABLE `sys_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `therapy`
--

DROP TABLE IF EXISTS `therapy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `therapy` (
  `id_therapy` int NOT NULL,
  `number_of_day` int DEFAULT NULL,
  `drug_id` int DEFAULT NULL,
  PRIMARY KEY (`id_therapy`),
  KEY `FKcd21b9hkdo7b464k1dkid6x6b` (`drug_id`),
  CONSTRAINT `FKcd21b9hkdo7b464k1dkid6x6b` FOREIGN KEY (`drug_id`) REFERENCES `drug` (`id_drug`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `therapy`
--

LOCK TABLES `therapy` WRITE;
/*!40000 ALTER TABLE `therapy` DISABLE KEYS */;
INSERT INTO `therapy` VALUES (500,3,504),(501,5,501),(502,8,502),(503,9,503),(504,4,505),(505,7,506);
/*!40000 ALTER TABLE `therapy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_authority`
--

DROP TABLE IF EXISTS `user_authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_authority` (
  `user_id` int NOT NULL,
  `authority_id` int NOT NULL,
  KEY `FKgvxjs381k6f48d5d2yi11uh89` (`authority_id`),
  KEY `FKhi46vu7680y1hwvmnnuh4cybx` (`user_id`),
  CONSTRAINT `FKgvxjs381k6f48d5d2yi11uh89` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `FKhi46vu7680y1hwvmnnuh4cybx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_authority`
--

LOCK TABLES `user_authority` WRITE;
/*!40000 ALTER TABLE `user_authority` DISABLE KEYS */;
INSERT INTO `user_authority` VALUES (501,4),(502,3),(503,2),(123,6),(504,4),(505,2),(506,3),(507,5),(508,5),(509,4),(510,5),(511,3),(512,1),(333,3),(559,3),(533,4),(1,5),(35,1);
/*!40000 ALTER TABLE `user_authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL,
  `account_enabled` bit(1) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,_binary '\0','Trg Dositeja 1','Novi Sad','Srbija','ivi@gmail.com','Ivana ','$2a$10$udytwqtL302DTEJX.v66ZOlFTH22//GyFw.TFN0Y0LikFfl2JOxuq','065-89-89-988','Ivic'),(35,_binary '','Novo 1','Novi Sad','Srbija','bubaa@gmail.com','Lana','$2a$10$pKXZSF/hvEvCWM2pylwFwuPDEezqP9ryKCLMdMDvlQJ60Oga0y31S','065/78-98-65','Bubic'),(123,_binary '','Deletinara','Novi Sad','Srbija','supplierpharmacy33@gmail.com','Ivana','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589145','Mucibabic'),(333,_binary '','Bulevar kneza Milosa','Novi Sad','Srbija','pharmacistpharmacy33@gmail.com ','Sara','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','Djuric'),(501,_binary '','Deletinara','Novi Sad','Srbija','dermatologistpharmacy@gmail.com','Kristina','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589145','Mucibabic'),(502,_binary '','Bulevar kneza Milosa','Novi Sad','Srbija','sara@gmail.com','Sara','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','Djuric'),(503,_binary '','Bulevar oslobodjenja','Novi Sad','Srbija','vekim@gmail.com','Verica','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Mucibabic'),(504,_binary '','Cara Urosa','Novi Sad','Srbija','majam@gmail.com','Maja','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Milenkovic'),(505,_binary '','Bulevar cara Lazara','Novi Sad','Srbija','marija@gmail.com','Marija','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589935','Maric'),(506,_binary '','Aleksa Santic','Novi Sad','Srbija','luka@gmail.com','Luka','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589011','Lukic'),(507,_binary '','Apatinska','Novi Sad','Srbija','mika@gmail.com','Mika','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589331','Mikic'),(508,_binary '','Backa','Novi Sad','Srbija','patient0874@gmail.com','Ana','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589371','Mikic'),(509,_binary '','Cara Milosa','Novi Sad','Srbija','urosm@gmail.com','Uros','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Milenkovic'),(510,_binary '','Bulevar cara Lazara','Novi Sad','Srbija','luna@gmail.com','Luna','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589371','Mikic'),(511,_binary '','Bulevar kneza Milosa','Novi Sad','Srbija','maki@gmail.com','Maki','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','Djuric'),(512,_binary '','Gagarinova 3','Novi Sad','Srbija','majamilenkovic98@gmail.com','Dejan','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589371','Dekic'),(533,_binary '','Cara Milosa','Novi Sad','Srbija','ivanm@gmail.com','Ivan','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589335','Milenkovic'),(559,_binary '','Bulevar kneza Milosa','Novi Sad','Srbija','veki@gmail.com','Veki','$2a$10$sqes3IpPL4mBgAAmimisyOWj5DlqPRndrJFNFw9zWiJjyNa5ozKS6','066589111','V');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacation`
--

DROP TABLE IF EXISTS `vacation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacation` (
  `id` int NOT NULL,
  `end` datetime(6) DEFAULT NULL,
  `start` datetime(6) DEFAULT NULL,
  `pharmacy_id` int NOT NULL,
  `staff_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqryhiebd79gns254vt43hw8a6` (`pharmacy_id`),
  KEY `FK6v2kghildpn8lepkx7a51gc3x` (`staff_id`),
  CONSTRAINT `FK6v2kghildpn8lepkx7a51gc3x` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FKqryhiebd79gns254vt43hw8a6` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacation`
--

LOCK TABLES `vacation` WRITE;
/*!40000 ALTER TABLE `vacation` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work_time`
--

DROP TABLE IF EXISTS `work_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `work_time` (
  `id` int NOT NULL,
  `date` date DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `pharmacy_id` int NOT NULL,
  `staff_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8kpcjnsnmxiiasxv8toyf4pgr` (`pharmacy_id`),
  KEY `FK86tblnddtvonw25p15pap03l3` (`staff_id`),
  CONSTRAINT `FK86tblnddtvonw25p15pap03l3` FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`),
  CONSTRAINT `FK8kpcjnsnmxiiasxv8toyf4pgr` FOREIGN KEY (`pharmacy_id`) REFERENCES `pharmacy` (`id_pharm`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work_time`
--

LOCK TABLES `work_time` WRITE;
/*!40000 ALTER TABLE `work_time` DISABLE KEYS */;
INSERT INTO `work_time` VALUES (501,'2021-07-22','15:00:00','06:30:00',501,501),(502,'2021-07-23','15:00:00','06:30:00',501,501),(503,'2021-07-22','20:00:00','15:30:00',502,501),(504,'2021-07-24','15:00:00','06:30:00',501,501),(505,'2021-07-23','20:00:00','15:30:00',502,501),(506,'2021-07-22','19:00:00','06:30:00',501,504),(507,'2021-07-23','19:00:00','06:30:00',501,504),(508,'2021-07-24','19:00:00','06:30:00',501,504),(509,'2021-07-25','19:00:00','06:30:00',501,504),(540,'2021-07-22','19:00:00','06:30:00',503,502),(541,'2021-07-23','19:00:00','06:30:00',503,502),(542,'2021-07-24','19:00:00','06:30:00',503,502),(543,'2021-07-25','19:00:00','06:30:00',503,502),(544,'2021-07-26','19:00:00','06:30:00',503,502),(545,'2021-07-28','19:00:00','06:30:00',503,502),(546,'2021-07-28','19:00:00','06:30:00',503,502),(547,'2021-07-29','19:00:00','06:30:00',503,502),(551,'2021-07-25','19:00:00','06:30:00',501,501),(552,'2021-07-26','19:00:00','06:30:00',501,501),(553,'2021-07-30','19:00:00','06:30:00',501,501),(554,'2021-07-27','19:00:00','06:30:00',501,501),(555,'2021-07-28','19:00:00','06:30:00',501,501),(556,'2021-07-29','19:00:00','06:30:00',501,501),(566,'2021-07-26','19:00:00','06:30:00',501,504),(567,'2021-07-27','19:00:00','06:30:00',501,504),(568,'2021-07-28','19:00:00','06:30:00',501,504),(569,'2021-07-29','19:00:00','06:30:00',501,504),(570,'2021-07-22','19:00:00','06:30:00',504,506),(571,'2021-07-23','19:00:00','06:30:00',504,506),(572,'2021-07-24','19:00:00','06:30:00',504,506),(573,'2021-07-25','19:00:00','06:30:00',504,506),(574,'2021-07-26','19:00:00','06:30:00',504,506),(575,'2021-07-28','19:00:00','06:30:00',504,506),(576,'2021-07-28','19:00:00','06:30:00',504,506),(577,'2021-07-29','19:00:00','06:30:00',504,506),(598,'2021-07-24','20:00:00','15:30:00',502,501);
/*!40000 ALTER TABLE `work_time` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-02 23:57:38

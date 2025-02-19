/*M!999999\- enable the sandbox mode */ 
-- MariaDB dump 10.19-11.5.2-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: elearning
-- ------------------------------------------------------
-- Server version	11.5.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*M!100616 SET @OLD_NOTE_VERBOSITY=@@NOTE_VERBOSITY, NOTE_VERBOSITY=0 */;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `categoryid` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`categoryid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES
(8,'Development',1,'2024-10-27 05:08:43','2024-10-27 05:08:43'),
(9,'Marketing',1,'2024-10-27 05:08:43','2024-10-27 05:08:43'),
(10,'Fitness',1,'2024-10-27 05:08:43','2024-10-27 05:08:43'),
(11,'Design',1,'2024-10-27 05:08:43','2024-10-27 05:08:43'),
(12,'Social Media',1,'2024-10-27 05:08:43','2024-10-27 05:08:43'),
(13,'Social Service',1,'2024-10-27 05:08:43','2024-10-27 05:08:43');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concept`
--

DROP TABLE IF EXISTS `concept`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `concept` (
  `conceptid` int(11) NOT NULL AUTO_INCREMENT,
  `topic` int(11) DEFAULT NULL,
  `title` varchar(200) DEFAULT NULL,
  `descriptionmarkup` mediumtext DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`conceptid`),
  KEY `topic` (`topic`),
  CONSTRAINT `concept_ibfk_1` FOREIGN KEY (`topic`) REFERENCES `topic` (`topicid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=82 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concept`
--

LOCK TABLES `concept` WRITE;
/*!40000 ALTER TABLE `concept` DISABLE KEYS */;
INSERT INTO `concept` VALUES
(45,22,'Vaiable and Data types','https://www.youtube.com/embed/ajdRvxDWH4w?si=UDj2s5x-Clyk-aqB',1,'2024-10-29 10:40:51','2024-11-02 05:50:01'),
(46,22,'Operators and Conditional Statements','https://www.youtube.com/embed/Zg4-uSjxosE?si=yOuo9rYeErXTW_21',1,'2024-10-29 10:40:51','2024-11-02 08:37:02'),
(47,23,'Loops and Strings','https://www.youtube.com/embed/UmRtFFSDSFo?si=RhVMBfT6CnUoLAsO',1,'2024-10-29 10:40:51','2024-11-02 08:37:09'),
(48,23,'Arrays','https://www.youtube.com/embed/gFWhbjzowrM?si=Cqn-3jWXTQJq7QXl',1,'2024-10-29 10:40:51','2024-11-02 08:37:12'),
(49,24,'Functions & Methods','https://www.youtube.com/embed/P0XMXqDGttU?si=VtGaZLKLfczGknBS',1,'2024-10-29 10:40:51','2024-11-02 08:37:23'),
(50,25,'DOM - Document Object Model','https://www.youtube.com/embed/7zcXPCt8Ck0?si=0R0EJc2LnpeiRAzS',1,'2024-10-29 11:09:01','2024-11-02 08:37:34'),
(51,25,'DOM - Document Object Model part 2 complete','https://www.youtube.com/embed/fXAGTOZ25H8?si=9LHEl9KK1xXVssHv',1,'2024-10-29 11:09:01','2024-11-02 08:37:37'),
(52,26,'Events in JavaScript ','https://www.youtube.com/embed/_i-uLJAh79U?si=ty8mdgVIVriOqSKe',1,'2024-10-29 11:09:01','2024-11-02 08:37:45'),
(53,27,'Tic Tac Toe Game in JavaScript','https://www.youtube.com/embed/SqrppLEljkY?si=WfOraVy__ak99Xxe',1,'2024-10-29 11:09:01','2024-11-02 08:38:19'),
(54,27,'API Calls','https://www.youtube.com/embed/CyGodpqcid4?si=_VnyZ7NEwa_WO_8-',1,'2024-10-29 11:09:01','2024-11-02 08:38:12'),
(65,42,'Web Designing','https://www.youtube.com/embed/HcOc7P5BMi4?si=seV_lRDB1QSR2mLI',1,'2024-11-18 17:25:25','2024-11-18 17:25:29'),
(67,44,'one shot','https://www.youtube.com/embed/hlGoQC332VM?si=fQfwozzOoz7J_V_J',1,'2024-11-18 17:25:34','2024-11-18 17:25:38'),
(68,45,'One shot','https://www.youtube.com/embed/fUmSkEvet08?si=CjMKTiU-8-YFFR-i',1,'2024-11-18 17:25:40','2024-11-18 17:25:43'),
(69,46,'Setup and exploring','https://www.youtube.com/embed/kvE8RJu8Vts?si=ECWs3aK77abJfnyJ',1,'2024-11-18 17:25:45','2024-11-18 17:25:48'),
(70,46,'Advance level exploring','https://www.youtube.com/embed/PVAR-hONRFQ?si=V5ZQUC-J1AJ4hbp2',1,'2024-11-18 17:25:51','2024-11-18 17:25:53'),
(71,46,'Intermidate level','https://www.youtube.com/embed/06d-h6LpBo8?si=w2oRtNJQPRHuVvwc',1,'2024-11-18 17:25:56','2024-11-18 17:25:58'),
(72,46,'final module','https://www.youtube.com/embed/RzCWNFKkb1Q?si=4MIzPEs2K3o0bRd_',1,'2024-11-18 17:26:02','2024-11-18 17:26:05'),
(74,48,' git commands','https://www.youtube.com/embed/gwWKnnCMQ5c?si=j97X-aA-cf_ULlU6',1,'2024-11-19 11:48:37','2024-11-19 11:48:37'),
(75,49,' git commands','https://www.youtube.com/embed/gwWKnnCMQ5c?si=j97X-aA-cf_ULlU6',1,'2024-11-19 11:49:08','2024-11-19 11:49:08'),
(76,51,'20 Minute Yoga to tone the arms','https://www.youtube.com/embed/S9-00Cs7cuI?si=HmOSPLo2R2CV1YTs',1,NULL,NULL),
(77,51,' build strength','https://www.youtube.com/embed/S9-00Cs7cuI?si=HmOSPLo2R2CV1YTs',1,NULL,NULL),
(78,52,'30 Minute Easy','https://www.youtube.com/embed/FdyhENXyIQ4?si=8oAzQN9CEwaaM8q-',1,NULL,NULL),
(79,50,'Beginner Camp','https://www.youtube.com/embed/-u0s-hkW6us?si=hYcm5r9L7oSX5WIS',1,NULL,NULL),
(80,52,'Relaxation flow','https://www.youtube.com/embed/FdyhENXyIQ4?si=OfW_h4xRD7K_PTnS',1,NULL,NULL),
(81,50,'Beginner Camp 2','https://www.youtube.com/embed/-u0s-hkW6us?si=hYcm5r9L7oSX5WIS',1,NULL,NULL);
/*!40000 ALTER TABLE `concept` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `category` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `descriptionmarkup` mediumtext DEFAULT NULL,
  `isfree` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `difficulty` enum('Beginner','Intermediate','Advanced') DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`courseid`),
  KEY `category` (`category`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`category`) REFERENCES `category` (`categoryid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES
(4,8,'All Fundamentals of JavaScript | Backend Development','This course covers the essential fundamentals of JavaScript with a focus on backend development. It includes topics such as variables, functions, control flow, loops, arrays, objects, error handling, and an introduction to backend with Node.js and Express.',1,100,'Beginner',1,'2024-10-29 10:30:29','2024-10-29 10:30:29'),
(17,8,'Complete HTML with Project','HTML Tutorial for Beginners | Complete HTML with Notes & Code',1,100,'Intermediate',1,'2024-11-05 16:34:27','2024-11-06 03:03:42'),
(19,8,'Complete SQL  with MySQL and mariaDB ','Learn from scrach go from beginner to Advance',1,100,'Intermediate',1,'2024-11-09 03:55:16','2024-11-09 03:59:10'),
(20,8,'Profitable Web Developer RoadMapFreelancing, Jobs & AI in Web','Freelancing, Jobs & AI in Web',1,100,'Advanced',1,'2024-11-10 04:25:12','2024-11-10 04:25:12'),
(21,9,'Digital Marketing','Digital Marketing Complete Course',1,80,'Advanced',1,'2024-11-11 13:13:22','2024-11-11 13:13:22'),
(23,8,'Git & GitHub Tutorial For Beginners','Go from beginner to advance learn teamwork create repository',1,100,'Beginner',1,'2024-11-19 11:48:36','2024-11-19 11:48:36'),
(24,8,'Git & GitHub Tutorial For Beginners','Go from beginner to advance learn teamwork create repository',1,100,'Beginner',1,'2024-11-19 11:49:08','2024-11-19 11:49:08'),
(25,10,'Yoga Exercise ','Yoga Exercise for beiginners',1,100,'Intermediate',1,'2025-02-15 06:45:36','2025-02-15 06:45:36');
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faquestions`
--

DROP TABLE IF EXISTS `faquestions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faquestions` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) NOT NULL,
  `question` varchar(30) DEFAULT NULL,
  `answer` varchar(30) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`questionid`),
  KEY `user` (`user`),
  CONSTRAINT `FAQuestions_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faquestions`
--

LOCK TABLES `faquestions` WRITE;
/*!40000 ALTER TABLE `faquestions` DISABLE KEYS */;
INSERT INTO `faquestions` VALUES
(5,59,'All courses are free ? ','yes','2024-11-09 17:00:42','2024-11-10 04:34:41'),
(6,59,'Block chain course ?','Today','2024-11-09 17:10:41','2024-11-10 04:35:51'),
(7,59,'AI and Ml course date','Today','2024-11-09 17:11:42','2024-11-10 04:36:01'),
(8,60,'When offers start','next month','2024-11-10 04:37:37','2024-11-11 13:01:40'),
(9,59,'recent course ?','Roadmap to web development','2024-11-10 14:27:54','2024-11-11 13:02:06');
/*!40000 ALTER TABLE `faquestions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `questionid` int(11) NOT NULL AUTO_INCREMENT,
  `concept` int(11) DEFAULT NULL,
  `questionmarkup` mediumtext DEFAULT NULL,
  `correctoption` int(11) DEFAULT NULL,
  `answermarkup` mediumtext DEFAULT NULL,
  `difficulty` enum('Low','Medium','Hard','Master') DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`questionid`),
  KEY `concept` (`concept`),
  CONSTRAINT `question_ibfk_1` FOREIGN KEY (`concept`) REFERENCES `concept` (`conceptid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES
(6,45,'Which of the following is not a data type in JavaScript?',4,'String,Number,Boolean,Object','Medium',1,'2024-11-05 15:06:27','2024-11-05 15:06:27'),
(7,45,'Which keyword is used to declare a variable in JavaScript?',1,'var,let,const,function','Low',1,'2024-11-05 15:06:27','2024-11-05 15:06:27'),
(8,45,'What is the output of typeof null in JavaScript?',3,'object,null,undefined,error','Medium',1,'2024-11-05 15:06:27','2024-11-05 15:06:27'),
(9,45,'Which of the following data types is mutable in JavaScript?',2,'Number,Array,String,Boolean','Hard',1,'2024-11-05 15:06:27','2024-11-05 15:06:27'),
(10,45,'How do you define a constant in JavaScript?',3,'let,var,const,function','Low',1,'2024-11-05 15:06:27','2024-11-05 15:06:27'),
(13,76,'The downward-facing dog pose is known as:',1,'Adho Mukha Svanasana,Urdhva Mukha Svanasana,Tadasana,Paschimottanasana','Master',1,'2025-02-15 06:29:35','2025-02-15 11:15:44'),
(14,77,'\"Anulom Vilom\" is a type of:',2,'Meditation,Pranayama,Asana,Mantra chanting','Hard',1,'2025-02-15 06:29:35','2025-02-15 11:15:48'),
(15,78,'What is the meaning of the word \"Yoga\"?',2,'Exercise,Union,Meditation,Relaxation','Medium',1,'2025-02-15 06:29:35','2025-02-15 11:15:52'),
(16,76,'Which of the following is a balancing yoga pose?',3,'Bhujangasana,Trikonasana,Vrikshasana,Dhanurasana','Medium',1,'2025-02-15 06:29:35','2025-02-15 11:15:56'),
(17,80,'Which ancient text is considered the foundation of yoga philosophy?',2,' Bhagavad Gita,Yoga Sutras of Patanjali,Vedas,Upanishads','Medium',1,'2025-02-15 06:29:35','2025-02-15 11:15:59'),
(18,80,'How many limbs of yoga are mentioned in Patanjali’s Yoga Sutras?',3,'4,6,8,10','Medium',1,'2025-02-15 06:29:35','2025-02-15 11:16:03');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reviews`
--

DROP TABLE IF EXISTS `reviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reviews` (
  `reviewid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `descriptionmarkup` varchar(50) DEFAULT NULL,
  `createat` date DEFAULT NULL,
  PRIMARY KEY (`reviewid`),
  KEY `user` (`user`),
  KEY `course` (`course`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`course`) REFERENCES `course` (`courseid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reviews`
--

LOCK TABLES `reviews` WRITE;
/*!40000 ALTER TABLE `reviews` DISABLE KEYS */;
INSERT INTO `reviews` VALUES
(5,60,4,'Wonderful course','2024-11-07'),
(6,60,19,'Best Course','2024-11-20'),
(7,59,17,'great Course','2024-11-20'),
(8,59,4,'greate course helps lot',NULL);
/*!40000 ALTER TABLE `reviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `test`
--

DROP TABLE IF EXISTS `test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `test` (
  `testid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `topic` int(11) DEFAULT NULL,
  `datetime` datetime DEFAULT NULL,
  `noofquestions` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`testid`),
  KEY `user` (`user`),
  KEY `course` (`course`),
  KEY `topic` (`topic`),
  CONSTRAINT `test_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_2` FOREIGN KEY (`course`) REFERENCES `course` (`courseid`) ON UPDATE CASCADE,
  CONSTRAINT `test_ibfk_3` FOREIGN KEY (`topic`) REFERENCES `topic` (`topicid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test`
--

LOCK TABLES `test` WRITE;
/*!40000 ALTER TABLE `test` DISABLE KEYS */;
INSERT INTO `test` VALUES
(1,60,4,22,'2024-11-07 13:54:04',NULL,'2024-11-07 08:24:04',NULL),
(2,60,4,22,'2024-11-07 16:44:33',5,'2024-11-07 11:14:33',NULL),
(3,60,4,22,'2024-11-07 16:49:02',5,'2024-11-07 11:19:02',NULL),
(4,60,4,22,'2024-11-07 16:50:49',5,'2024-11-07 11:20:49',NULL),
(5,60,4,22,'2024-11-07 16:53:42',5,'2024-11-07 11:23:42',NULL),
(6,60,4,22,'2024-11-07 21:16:33',5,'2024-11-07 15:46:33',NULL),
(7,59,4,22,'2024-11-08 13:02:54',5,'2024-11-08 07:32:54',NULL),
(8,60,4,22,'2024-11-08 13:11:55',5,'2024-11-08 07:41:55',NULL),
(9,60,4,22,'2024-11-08 18:49:06',5,'2024-11-08 13:19:06',NULL),
(10,60,4,22,'2024-11-08 21:28:41',5,'2024-11-08 15:58:41',NULL),
(11,60,4,22,'2024-11-09 12:01:14',5,'2024-11-09 06:31:14',NULL),
(12,60,4,22,'2024-11-09 12:25:15',5,'2024-11-09 06:55:15',NULL),
(13,59,4,22,'2024-11-10 19:51:11',5,'2024-11-10 14:21:11',NULL),
(14,60,4,22,'2024-11-11 21:04:08',5,'2024-11-11 15:34:08',NULL),
(15,59,4,22,'2024-12-07 19:45:33',5,'2024-12-07 14:15:33',NULL);
/*!40000 ALTER TABLE `test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `testquestion`
--

DROP TABLE IF EXISTS `testquestion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `testquestion` (
  `testquestionid` int(11) NOT NULL AUTO_INCREMENT,
  `test` int(11) DEFAULT NULL,
  `question` int(11) DEFAULT NULL,
  `givenanswer` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`testquestionid`),
  KEY `test` (`test`),
  KEY `question` (`question`),
  CONSTRAINT `testquestion_ibfk_1` FOREIGN KEY (`test`) REFERENCES `test` (`testid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `testquestion_ibfk_2` FOREIGN KEY (`question`) REFERENCES `question` (`questionid`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `testquestion`
--

LOCK TABLES `testquestion` WRITE;
/*!40000 ALTER TABLE `testquestion` DISABLE KEYS */;
/*!40000 ALTER TABLE `testquestion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `topicid` int(11) NOT NULL AUTO_INCREMENT,
  `course` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`topicid`),
  KEY `course` (`course`),
  CONSTRAINT `topic_ibfk_1` FOREIGN KEY (`course`) REFERENCES `course` (`courseid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES
(22,4,'Introduction to JavaScript and Environment Setup',1,'2024-10-29 10:36:15','2024-10-29 10:36:15'),
(23,4,'Loops and Array',1,'2024-10-29 10:36:15','2024-11-02 08:39:17'),
(24,4,'Functions and Scope in JavaScript',1,'2024-10-29 10:36:15','2024-10-29 10:36:15'),
(25,4,'DOM',1,'2024-10-29 10:36:15','2024-11-02 08:41:07'),
(26,4,'Event Handling',1,'2024-10-29 10:36:15','2024-11-02 08:42:02'),
(27,4,'Arrays and Array Methods in JavaScript',1,'2024-10-29 10:36:15','2024-10-29 10:36:15'),
(42,17,'Basic to Advance HTML',1,'2024-11-05 16:28:41','2024-11-05 16:28:41'),
(44,19,'Set up , Query designing  ',1,'2024-11-09 03:47:35','2024-11-09 03:47:35'),
(45,20,'Freelancing, Jobs & AI in Web',1,'2024-11-10 04:20:35','2024-11-10 04:20:35'),
(46,21,'Beginning levelIn',1,'2024-11-11 13:04:24','2024-11-11 13:04:24'),
(48,23,'start to end',1,'2024-11-19 11:38:54','2024-11-19 11:38:54'),
(49,24,'start to end',1,'2024-11-19 11:38:54','2024-11-19 11:38:54'),
(50,25,' Day 2',1,'2025-02-15 06:45:36','2025-02-15 06:45:36'),
(51,25,'Day 3',1,'2025-02-15 06:45:36','2025-02-15 06:45:36'),
(52,25,'Day 1',1,'2025-02-15 06:45:36','2025-02-15 06:45:36');
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(200) DEFAULT NULL,
  `passwordhashsalted` varchar(130) DEFAULT NULL,
  `role` enum('Admin','User') DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `name` varchar(200) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES
(35,'vaishnavimalge1403@gmail.com','$2a$10$c7RJeBiLk2wYKo8edY.q0OlibQozGce5BwzIbTVa5rbxayCqPXE0u','User',1,'2024-11-05 11:59:46','2024-11-07 14:08:11','vaishu','vaishnavimalge1403@gmail.com'),
(45,'vandanamalge@gmail.com','$2a$10$PGGbaLKsO6AxpkbCBCnntu05enBXlviLHYjiRdqUq5B50Yo0IbCdG','User',1,'2024-11-05 14:32:17','2024-11-06 08:22:47','vandanamalge','vandanamalge@gmail.com'),
(59,'vaishnavimalge@gmail.com','$2a$10$c7RJeBiLk2wYKo8edY.q0OlibQozGce5BwzIbTVa5rbxayCqPXE0u','User',1,'2024-11-06 06:57:13','2024-11-19 13:27:16','Vaishnavi ','vaishnavimalge@gmail.com'),
(60,'jayrajmalge@gmail.com','$2a$10$kT65eidYFQjUClRniymJpeQT44STBrXgupTsO517WUN6ii/4X79hG','Admin',1,'2025-02-14 08:58:40','2025-02-17 11:35:58','jay','jayrajmalge@gmail.com'),
(61,'vaishnavimalge@1403gmail.com','$2a$10$Zq2xvQ9xKKuglv4ZxAncI.zV.uAclZyRCtUOdnxagboEmRzkiLTuq','User',1,'2024-11-08 13:45:27','2024-11-08 13:45:27','vaishnavimalge','vaishnavimalge@1403gmail.com'),
(64,'vaishnvaimalge@gmail.com','$2a$10$b3H3gKV3zXN2FQaUyq4TF.FXGRAbRBk.Iq1tbIz7SJz05txSquYfS','User',1,'2024-11-17 12:14:10','2024-11-17 12:14:10','vaishnvaimalge','vaishnvaimalge@gmail.com'),
(66,'vandanmalge31@gmail.com','$2a$10$LJRG90pT3iiUDhPoX2hRNO5bvKKqs2oS0o0jNJZBxXSDeRFLwE1gC','User',1,'2025-02-13 14:26:33','2025-02-13 14:26:33','vandanmalge31','vandanmalge31@gmail.com'),
(67,'abc@gmail.com','$2a$10$.u/lYPwMidEc7zedN6FSMecMGQAXcEOucYBq0NCgGDetDCwkk/z46','User',1,'2025-02-14 09:24:28','2025-02-14 09:24:28','abc','abc@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usercourse`
--

DROP TABLE IF EXISTS `usercourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usercourse` (
  `usercourseid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `subscriptionstart` date DEFAULT current_timestamp(),
  `subscriptionend` date DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`usercourseid`),
  KEY `user` (`user`),
  KEY `course` (`course`),
  CONSTRAINT `usercourse_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `usercourse_ibfk_2` FOREIGN KEY (`course`) REFERENCES `course` (`courseid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usercourse`
--

LOCK TABLES `usercourse` WRITE;
/*!40000 ALTER TABLE `usercourse` DISABLE KEYS */;
INSERT INTO `usercourse` VALUES
(32,35,4,'2024-12-06','2024-12-06','2024-12-06 10:07:20','2024-12-06 10:07:20'),
(36,60,4,'2024-11-06','2024-12-06','2024-11-06 14:19:13','2024-11-06 14:19:13'),
(47,60,17,'2024-11-13','2024-12-13','2024-11-13 04:18:46','2024-11-13 04:18:46'),
(48,59,4,'2024-11-18','2024-12-18','2024-11-18 12:51:48','2024-11-18 12:51:48'),
(49,66,4,'2025-02-13','2025-03-15','2025-02-13 16:08:04','2025-02-13 16:08:04'),
(50,60,25,'2025-02-15','2025-03-17','2025-02-15 06:49:23','2025-02-15 06:49:23');
/*!40000 ALTER TABLE `usercourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `wishcourse`
--

DROP TABLE IF EXISTS `wishcourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `wishcourse` (
  `wishcourseid` int(11) NOT NULL AUTO_INCREMENT,
  `user` int(11) DEFAULT NULL,
  `course` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `descriptionmarkup` mediumtext DEFAULT NULL,
  `isfree` int(11) DEFAULT NULL,
  `points` int(11) DEFAULT NULL,
  `difficulty` enum('Beginner','Intermediate','Advanced') DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `createat` timestamp NULL DEFAULT current_timestamp(),
  `updatedat` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`wishcourseid`),
  KEY `user` (`user`),
  KEY `course` (`course`),
  CONSTRAINT `wishcourse_ibfk_1` FOREIGN KEY (`user`) REFERENCES `user` (`userid`) ON UPDATE CASCADE,
  CONSTRAINT `wishcourse_ibfk_2` FOREIGN KEY (`course`) REFERENCES `course` (`courseid`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wishcourse`
--

LOCK TABLES `wishcourse` WRITE;
/*!40000 ALTER TABLE `wishcourse` DISABLE KEYS */;
INSERT INTO `wishcourse` VALUES
(128,60,20,'Profitable Web Developer RoadMapFreelancing, Jobs & AI in Web','Freelancing, Jobs & AI in Web',1,100,'Advanced',1,'2024-11-10 04:25:12','2024-11-10 04:25:12'),
(129,59,19,'Complete SQL  with MySQL and mariaDB ','Learn from scrach go from beginner to Advance',1,100,'Intermediate',1,'2024-11-09 03:55:16','2024-11-09 03:59:10'),
(131,66,17,'Complete HTML','HTML Tutorial for Beginners | Complete HTML with Notes & Code',1,100,'Intermediate',1,'2024-11-05 16:34:27','2024-11-06 03:03:42');
/*!40000 ALTER TABLE `wishcourse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*M!100616 SET NOTE_VERBOSITY=@OLD_NOTE_VERBOSITY */;

-- Dump completed on 2025-02-19 13:35:11

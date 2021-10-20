-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: software_match
-- ------------------------------------------------------
-- Server version	8.0.25

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
-- Table structure for table `activity_content`
--

DROP TABLE IF EXISTS `activity_content`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_content` (
  `id` int DEFAULT NULL,
  `student_count` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_content`
--

LOCK TABLES `activity_content` WRITE;
/*!40000 ALTER TABLE `activity_content` DISABLE KEYS */;
INSERT INTO `activity_content` VALUES (2,201543220),(2,201543219);
/*!40000 ALTER TABLE `activity_content` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_organization`
--

DROP TABLE IF EXISTS `activity_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_organization` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  `adress` varchar(45) NOT NULL,
  `organizer` varchar(45) NOT NULL,
  `joinway` varchar(45) NOT NULL,
  `level` int DEFAULT NULL,
  PRIMARY KEY (`id`,`name`,`organizer`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_organization`
--

LOCK TABLES `activity_organization` WRITE;
/*!40000 ALTER TABLE `activity_organization` DISABLE KEYS */;
INSERT INTO `activity_organization` VALUES (1,'打架大赛','2021-11-11 00:00:00','中州','中州打架社团','线下',1);
/*!40000 ALTER TABLE `activity_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `activity_user`
--

DROP TABLE IF EXISTS `activity_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `organizer` int NOT NULL,
  `time` datetime NOT NULL,
  `adress` varchar(45) NOT NULL,
  `joinWay` varchar(45) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`id`,`organizer`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_user`
--

LOCK TABLES `activity_user` WRITE;
/*!40000 ALTER TABLE `activity_user` DISABLE KEYS */;
INSERT INTO `activity_user` VALUES (2,'拜拜了',201543220,'2021-10-21 07:12:34','北教','微信参加',2),(3,'芜湖',201543219,'2021-10-07 00:00:00','宿舍','现场报名',2),(5,'拔牙',201543219,'2021-10-10 00:00:00','医务室','现场报名',2);
/*!40000 ALTER TABLE `activity_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `info_activity`
--

DROP TABLE IF EXISTS `info_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info_activity` (
  `id` int NOT NULL,
  `info` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_activity`
--

LOCK TABLES `info_activity` WRITE;
/*!40000 ALTER TABLE `info_activity` DISABLE KEYS */;
INSERT INTO `info_activity` VALUES (2,'不知不觉，又是一个新的学年开始。不少拿着Zu的小萌新们要踏上一段新的旅程了，不知道是不是对新的生活满怀憧憬与期待呢？为了帮助初来乍到的新生能够更快地适应在德国的学习和生活，也便于所有身处异国他乡的留德华人们能够了解到更多有用实在的信息，德累斯顿学联准备在本周六10月2日下午15:00-17:00，召开2021/2022冬季学期德累斯顿学联新生大会。'),(3,' 为提升员工的团队意识，增强团队凝聚力，加强部门、同事之间的交流与协作，营造奋发向上的组织氛围，2013年8月24至25日、8月31日至9月1日，苏宁环球江南公司宜兴、北塘项目部分两批成功举行拓展训练。 两天的训练分别完成了团队破冰、团队迷宫、无线电合作、达芬奇密码、罗马炮车、赤壁之战、擂站CS、十面埋伏、通天塔等十余个项目。通过本次培训，参训员工展现出良好的个人素质和高昂的激情，体现出良好的团队协作精神和目标意识，在时间紧、任务重的情况下，高质量地完成了所有的培训科目。'),(5,'2021.06.15 更新苹果12最终优惠券信息，最高降价1400元。\n2021.06.15 更新iPhone11降价1000元（仅限64G版本）\n2021.06.13 更新小米11 Ultra最终优惠，叠加优惠券后，降价1100元！\n2021.06.12 快到618了，很多手机全程价保，准备换机的可以入手了。\n2021.06.05 很多朋友私信问消费券怎么领，我更新专题文章放底部，感兴趣的可以看看。\n2021.06.04 消费券第2轮开始发放，记得先领取再下单\n2021.06.01 苹果最新优惠1000+400元，更新专题文章\n2021.05.29 官方5.24-6.20全程价保！确保价格最低。更新OPPO、真我、IQOO手机的最终优惠。\n2021.05.29 更新苹果手机最新优惠。\n2021.05.28 官方5.24-6.20全程价保！确保价格最低。更新小米11Pro/小米11等最终优惠\n2021.05.28 官方5.24-6.20全程价保！确保价格最低。更新一加手机最终优惠。\n2021.05.27 添加OPPO Reno6 Pro优惠信息，更新其他手机优惠信息\n2021.05.27 添加红米 Note 10系列优惠信息\n2021.05.26 更新小米11Pro优惠信息，至少降价300元\n2021.05.25 添加京东红包，每天可领取3次，可叠加使用更优惠！\n2021.05.25 更新iPhone 12、12mini、12 Pro Max 优惠券，最高直降1000元\n2021.05.24 更新iPhone11优惠券50元\n2021.05.24 更新一加8/IQOO Neo5/Neo5活力版优惠券\n2021.05.24 更新预售优惠券，小米11/小米10S/红米Note9/红米K40\n2021.05.23 补充评论区咨询较多的魅族手机优惠\n2021.05.23 更新iPhone11/小米11/红米8/OPPO Reno 4等优惠\n2021.05.22 发布各品牌手机优惠汇总，更新最新优惠，去除失效活动');
/*!40000 ALTER TABLE `info_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `picture_activity`
--

DROP TABLE IF EXISTS `picture_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `picture_activity` (
  `id` int DEFAULT NULL,
  `picture` longtext
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `picture_activity`
--

LOCK TABLES `picture_activity` WRITE;
/*!40000 ALTER TABLE `picture_activity` DISABLE KEYS */;
INSERT INTO `picture_activity` VALUES (1,'sdaasd456456'),(2,'shjasgdhjgd'),(2,'dhjfgkhjgsdafhjkgasdhf'),(2,'hgdsfhkjgsdakhjfgsdhjfgsdaghsdfhjgsdhfjgs'),(3,'hjksdfjhkgsdafhjk');
/*!40000 ALTER TABLE `picture_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_organization`
--

DROP TABLE IF EXISTS `user_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_organization` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `level` char(2) NOT NULL,
  `managercount` int NOT NULL,
  `normalcount` int DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `pic_org` longtext,
  `collage` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`,`name`,`phone`,`managercount`),
  UNIQUE KEY `phone_UNIQUE` (`phone`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `manger_infromation_key_idx` (`managercount`),
  CONSTRAINT `manger_information_key` FOREIGN KEY (`managercount`) REFERENCES `user_student` (`count`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_organization`
--

LOCK TABLES `user_organization` WRITE;
/*!40000 ALTER TABLE `user_organization` DISABLE KEYS */;
INSERT INTO `user_organization` VALUES (2,'AA','1',201543220,NULL,'1008611','123','454564sf56asd4f52sd41f564sdf564sd56f4asdf1asd56f45asd6f45sd24f8sd744s5rt4856s4g75ds4ag85sd74g8564sd56g4sd857sd8tr7456sd4fg1235sad1f5sdfsda4f56as0df74sdf47s56e4f','BB');
/*!40000 ALTER TABLE `user_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_petname`
--

DROP TABLE IF EXISTS `user_petname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_petname` (
  `id` int NOT NULL,
  `pet_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`pet_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_petname`
--

LOCK TABLES `user_petname` WRITE;
/*!40000 ALTER TABLE `user_petname` DISABLE KEYS */;
INSERT INTO `user_petname` VALUES (1,'sakdjkl'),(2,'汪汪'),(7,'小狗汪汪'),(8,'蓝子');
/*!40000 ALTER TABLE `user_petname` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_student`
--

DROP TABLE IF EXISTS `user_student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `count` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `collage` varchar(45) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `gender` varchar(8) DEFAULT '男',
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pet_name` varchar(255) NOT NULL,
  `pic_user` longtext,
  PRIMARY KEY (`id`,`count`,`phone`,`pet_name`),
  UNIQUE KEY `count_UNIQUE` (`count`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_student`
--

LOCK TABLES `user_student` WRITE;
/*!40000 ALTER TABLE `user_student` DISABLE KEYS */;
INSERT INTO `user_student` VALUES (1,201543220,'大黄','1008611','互联网金融与信息工程学院','计算机科学与技术','男','123456','dahuang@qq.com','','ghdhghdgjhgdgyu45456asdf1f456d421z4fd564f52sa1f5sd456f4sd4545sdx12xc15es4f5sd422zx154a231d23a421z2315a4d5412341gh23jkh4kl1l3j45i4u5321dg231fdg456j454i56456y445u54d87sd89fg5xf6d4g56df4hg564g547fsg47sr4ty74uy45fdg4hj21fgd1h214shzdf1g454g78dfs74y544d211524x54x5464s856f745s64ts'),(2,201543219,'大白','1008612',NULL,NULL,'男','abc123',NULL,'','hgadfhydsgfjhsdaghgdsafhgasdyufyue578dsf857sda56f4sd352f4186sd5a74fasd41f56asd4f86asd74f54asdf56s7ad89f732w85e4r87e897485ag74856sdfghasd4g5674gh89asdf4g5641asdg85674asdg41asdg5674asd89g4we25r4g856wser74g4as1g6534azsd563g4as35dg857asd7g85sda74g56s41g56s7d4g564sdg56sdagsd'),(7,201543204,'小白','1008604',NULL,NULL,'男','a1160124552',NULL,'',NULL),(8,201543201,'小蓝','1008610',NULL,'大数据与信息分析',NULL,'a1160124552',NULL,'',NULL);
/*!40000 ALTER TABLE `user_student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'software_match'
--

--
-- Dumping routines for database 'software_match'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-20 17:48:53

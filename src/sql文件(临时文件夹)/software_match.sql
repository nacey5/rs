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
  `organizer` int NOT NULL,
  `joinway` varchar(45) NOT NULL,
  `level` int DEFAULT NULL,
  PRIMARY KEY (`id`,`name`,`organizer`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_organization`
--

LOCK TABLES `activity_organization` WRITE;
/*!40000 ALTER TABLE `activity_organization` DISABLE KEYS */;
INSERT INTO `activity_organization` VALUES (7,'歌唱祖国大赛','2021-11-11 00:00:00','中州',201543220,'线下',1),(8,'花式滑轮比赛','2021-11-11 00:00:00','操场',201543220,'线下',1),(9,'垃圾分类大赛','2021-11-11 00:00:00','操场',201543220,'线下',1),(10,'最美夕阳大赛','2021-11-11 00:00:00','线上提交',201543220,'线上',1),(11,'笑傲江湖','2021-11-11 00:00:00','阶梯教室',201543220,'线下',1),(12,'绝代风华-猜谜大赛','2021-11-11 00:00:00','阶梯教室',201543220,'线下',1),(13,'扣篮之王','2021-11-11 00:00:00','操场',201543220,'线下',1),(14,'金融知识竞赛','2021-11-11 00:00:00','线上',201543220,'线上',1);
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
INSERT INTO `activity_user` VALUES (2,'拜拜了',201543220,'2021-10-21 07:12:34','北教','微信参加',2),(3,'芜湖',201543221,'2021-10-07 00:00:00','宿舍','现场报名',2),(5,'拔牙',201543222,'2021-10-10 00:00:00','医务室','现场报名',2);
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
-- Table structure for table `info_organization`
--

DROP TABLE IF EXISTS `info_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `info_organization` (
  `id` int NOT NULL,
  `info` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `info_organization`
--

LOCK TABLES `info_organization` WRITE;
/*!40000 ALTER TABLE `info_organization` DISABLE KEYS */;
INSERT INTO `info_organization` VALUES (7,'广东金融学院音乐协会诞生于 1992 年，于2014 年 3 月 21 日正式更名为「 出雲音乐协会 」，致力于打造广金音乐文化传播第一平台，成为卓越的大学活动策划者和出色的舞台执行团队。\n\n我们对「 出雲 」的理解是希望这个组织，出色，出众，出人头地。浮雲蔽日，前路迷茫是我们做音乐事业者的必经之路，我们只是执着地坚信，光芒，希望一直都在，只要沉淀，思考，奋进，终会有拨开雾霾，出雲见日的时候。\n\n作为广金唯一的音乐社团，所有流派的音乐爱好者我们都尽收怀中。只要你够热情，就一起来传承我们的够姜精神。'),(8,'广东金融学院轮滑协会\n\n是学校课余轮滑爱好者组成的运动协会。\n\n协会致力于普及高校轮滑运动，\n\n促进高校间的轮滑交流，\n\n发展轮滑事业。\n\n本协会立足校内，\n\n以服务会员为根本，\n\n组织轮滑培训，\n\n开展轮滑集体活动，\n\n积极与校外进行轮滑交流，\n\n增强同学的体质，\n\n通过轮滑运动进行体育比赛和社会实践，\n\n为广大轮滑爱好者提供一个\n\n塑造和张扬个性、展现青春和激情的舞台，\n\n以提高轮滑爱好者的体育竞技水平，\n\n培养团队精神，\n\n丰富大学生的校园文化生活，\n\n提高我校学生的综合素质，\n\n促进全民健身运动，\n\n促进我校社团文化的繁荣发展，\n\n提高我校学生的课余生活质量。'),(9,'广东金融学院绿时环保协会\n\n成立于2009年3月份\n\n是由一群具有环保意识\n\n的学生组建的大学社团\n\n倡导“以绿色为梦想，以环保为己任”\n\n我们的宗旨是\n\n做实事，用自己的一举一动\n\n去影响身边的人加入到环保队伍当中\n\n我们的口号是：Join us, join Green Time!\n\n协会于2009年12月11日\n\n加入绿点青年环境教育中心\n\n此后与40多所联盟环保社团取得交流\n\n为自身的发展注入了新活力\n\n    自协会成立以来\n\n协会不断成长\n\n先后开展过捐书换书、圣诞水果贺卡\n\n飞羽观鸟高校联合推广、“走巡车陂涌”\n\n世界地球日、火炉山秋游等一系列活动\n\n协会立足校园，面向社会\n\n自成立后得到学院领导、社会环保部门\n\n的大力支持\n\n并与龙洞街道办事处取得友好联系\n\n协会曾两度被评为\n\n年度优秀社团\n\n得到全校师生的肯定\n\n       现今协会的日常经营事务\n\n是“捐书换书，以物换物”\n\n同学们的闲置物品到了新学期或者毕业季\n\n大多都会丢弃到楼下\n\n这给环境造成了很大的压力\n\n同时也给宿管阿姨造成了很大的困扰\n\n况且这些闲置物品还有回收利用的价值\n\n就此变成垃圾岂不可惜\n\n让我们行动起来，变废为宝\n\n将闲置物品的价值流通利用起来吧\n\n为我们生存依赖的环境\n\n贡献自己的一点微薄之力吧！'),(10,'寻至心坎，影得动人；\n\n青春易逝，光影长存。\n\n大家好，我们是广东金融学院寻影协会，是一个专注于微电影叙事类短片创造的学生组织，这里的每一个人都是纯粹的电影爱好者，我们因为共同的兴趣走到一起，我们协会的活动主题是微电影拍摄。微电影爱好者们，无论你有没有作品，无论你是否精于拍摄，这里都能帮助你提升自己的摄影能力与微电影知识。\n\n寻影今年3岁啦，是一个充满活力、具有无限发展前景的团队。\n\n寻影协会的故事从一群爱电影、爱表达的人相遇的那天开始，到此刻还在继续。我们寻寻觅觅，在等一个你，不需要多么精通电影，不需要掌握所有技术，只要你热爱电影，渴望交流，那么便欢迎你加入寻影大家庭，与我们一起探寻微电影的奥秘，一同享受拍摄微电影的充实与快乐，共同创作出自己的微电影、短视频！\n\n我们可以一起提高摄影能力，我们可以一起从诗词歌赋聊到人生哲理。在这里，你可以是导演，可以是演员，可以是编剧，我们在一起，就拥有创造一切的可能性。\n\n寻影协会设有五大部门，分别是宣传部、秘书部、人资部、外联部、财务部。宣传部主要负责协会的推文海报制作和宣传物资设计等工作；秘书部主要负责开会总结、文件整理、统计数据等工作；人资部负责活动策划以及人员安排；外联部的主要工作是谈赞助，做赞助策划书以及和其他学校的社团组织联谊；财务部主要负责记录协会的财务状况和购买物资设备等。\n\n我们本次招新既招会员，也招部员哟！\n\n始于喜欢，源于兴趣，终于热爱，寻影寻影，寻一个你。'),(11,'广金笛箫协会诞生于2009年7月，我们秉承着“弘扬民族音乐”&“繁荣校园文化”的宗旨，高扬“会笛箫客，传民族情”的口号。独具特色的民族乐器是中华传统文化的一大瑰宝，为了让同学们在学习之余能够受到传统民乐文化的熏陶，陶冶情操，培养雅兴，广东金融学院笛箫协会作为一个具有一定资历的社团，承担起这一任务，并已成功举办过八届“金苑杯”民族乐器大赛，为民乐爱好者们提供一个交流和竞技的平台，让良好的传统民乐文化氛围充满校园。在这个广金学子喜爱的家庭里，你可以和一群热爱乐器的朋友相互学习，共同成长。'),(12,'金风灯谜协会成立于2011年4月22日。协会共设有秘书部、学术部、组织部、网宣部、外联部五大部门。从成立之初到现在已成功举办了大大小小的全校性谜会，如周年庆谜会、迎新谜会、中秋谜会等；并响应省社联号召成功举办了几场区域性谜会，如粤高校杯，粤新生杯，得到了学校领导和广大师生的赞许。'),(13,'广东金融学院篮球协会\n\n是校政教处、共青团委批准成立的协会\n\n作为新成立的协会，\n\n我们本着\n\n“在篮球中快乐，\n\n在快乐中篮球”\n\n的宗旨；\n\n坚持以推动我校篮球发展、\n\n创造浓厚的校园文化氛围为目标。\n\n坚决执行学校的发展要求、\n\n积极的为每位同学服务。 \n\n篮球协会设置的部门有：\n\n技术部、秘书部、\n\n宣传部、外联部四大部门\n\n外加裁判组和花式篮球'),(14,'广金金蜜蜂社团\n\n是在中国建设银行广东省分行\n\n指导下开展工作的学生组织\n\n致力于普及金融知识\n\n全面提高同学们综合金融素质\n\n搭建世界500强企业与校方合作的平台\n\n为同学们提供\n\n一个自我展示自我创造\n\n的梦想舞台'),(18,'我爱你像风吹走了千万里从不问归期');
/*!40000 ALTER TABLE `info_organization` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_organization`
--

LOCK TABLES `user_organization` WRITE;
/*!40000 ALTER TABLE `user_organization` DISABLE KEYS */;
INSERT INTO `user_organization` VALUES (2,'AA','1',201543220,NULL,'1008611','123','454564sf56asd4f52sd41f564sdf564sd56f4asdf1asd56f45asd6f45sd24f8sd744s5rt4856s4g75ds4ag85sd74g8564sd56g4sd857sd8tr7456sd4fg1235sad1f5sdfsda4f56as0df74sdf47s56e4f','BB'),(7,'出雲音乐协会','1',201543220,NULL,'1008612','123',NULL,NULL),(8,'轮滑协会','1',201543220,NULL,'1008613','123',NULL,NULL),(9,'广东金融学院绿时环保协会 ','1',201543220,NULL,'1008614','123',NULL,NULL),(10,'巡影协会','1',201543220,NULL,'1008615','123',NULL,NULL),(11,'笛箫协会','1',201543220,NULL,'1008616','123',NULL,NULL),(12,'金风灯谜协会','1',201543220,NULL,'1008617','123',NULL,NULL),(13,'篮球协会','1',201543220,NULL,'1008618','123',NULL,NULL),(14,'广金金蜜蜂社团','1',201543220,NULL,'1008619','123',NULL,NULL);
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

-- Dump completed on 2021-10-25 19:31:16

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
-- Table structure for table `activity_count`
--

DROP TABLE IF EXISTS `activity_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `activity_count` (
  `id` int NOT NULL,
  `point_count` bigint DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='活动点击次数，热度';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_count`
--

LOCK TABLES `activity_count` WRITE;
/*!40000 ALTER TABLE `activity_count` DISABLE KEYS */;
INSERT INTO `activity_count` VALUES (7,1),(8,0),(9,0),(10,0),(11,0),(12,0),(13,0);
/*!40000 ALTER TABLE `activity_count` ENABLE KEYS */;
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
  `time` varchar(255) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `organizer` int NOT NULL,
  `joinway` varchar(45) NOT NULL,
  `level` int DEFAULT NULL,
  `status` varchar(45) DEFAULT 'true',
  PRIMARY KEY (`id`,`name`,`organizer`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_organization`
--

LOCK TABLES `activity_organization` WRITE;
/*!40000 ALTER TABLE `activity_organization` DISABLE KEYS */;
INSERT INTO `activity_organization` VALUES (7,'歌唱祖国大赛','2021-11-11 00:00:00','中州',201543220,'线下',1,'false'),(8,'花式滑轮比赛','2021-11-11 00:00:00','',201543220,'线下',1,'true'),(9,'垃圾分类大赛','2021-11-11 00:00:00','操场',201543220,'线下',1,'true'),(10,'最美夕阳大赛','2021-11-11 00:00:00','线上提交',201543220,'线上',1,'true'),(11,'笑傲江湖','2021-11-11 00:00:00','阶梯教室',201543220,'线下',1,'true'),(12,'绝代风华-猜谜大赛','2021-11-11 00:00:00','阶梯教室',201543220,'线下',1,'true'),(13,'扣篮之王','2021-11-11 00:00:00','操场',201543220,'线下',1,'true'),(14,'金融知识竞赛','2021-11-11 00:00:00','线上',201543220,'线上',1,'true'),(15,'计算机比赛','2021-11-11 00:00:00','线上',201543220,'线上',1,'true'),(16,'金融货币识别大赛','2021-11-11 00:00:00','阶梯教室',201543220,'线下',1,'true'),(17,'记忆大赛','2021-11-11 00:00:00','线上提交',201543220,'线下',1,'true'),(18,'我是诗人你是谁大赛','2021-11-11 00:00:00','操场',201543220,'线下',1,'true'),(19,'军事技能大赛','2021-11-11 00:00:00','线上',201543220,'线上',1,'true'),(20,'操盘亿万资金','2021-11-11 00:00:00','操场',201543220,'线下',1,'true'),(21,'韩语吐槽','2021-11-11 00:00:00','操场',201543220,'线下',1,'true'),(22,'速算比赛','2021-11-11 00:00:00','操场',201543220,'线下',1,'true'),(23,'心理健康活动','2021-11-11 00:00:00','操场',201543220,'线下',1,'true'),(24,'希望杯冠军赛（男篮）','2021-11-03 16:50:00','南苑篮球场',201543220,'线下',1,'true'),(25,'萌芽杯','2021-10-30 18:30:00','北苑排球场3号场',201543220,'线下',1,'true'),(26,'软件设计大赛','2021-11-07 14:00:00','北阶101',201543220,'线下',1,'true'),(27,'金融学院第十三届党团知识竞赛','2018-11-10 18:30:00','远楼607',201543220,'线下',1,'true'),(28,'大学生志愿服务西部计划','2021','西部(山区)',201566677,'线下报名',2,'true'),(29,'献血活动','2021.10.05','北苑饭堂前',201577788,'现场报名',2,'true');
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
  `time` varchar(255) NOT NULL,
  `adress` varchar(45) NOT NULL,
  `joinWay` varchar(45) NOT NULL,
  `level` int NOT NULL,
  `status` varchar(45) DEFAULT 'true',
  PRIMARY KEY (`id`,`organizer`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `activity_user`
--

LOCK TABLES `activity_user` WRITE;
/*!40000 ALTER TABLE `activity_user` DISABLE KEYS */;
INSERT INTO `activity_user` VALUES (2,'振兴杯',201543220,'2021-10-21 07:12:34','北教','微信参加',2,'true'),(3,'学生会招新',201543221,'2021-10-07 00:00:00','宿舍','现场报名',2,'true'),(9,'sdfag',4744,'2021-11-07 07:55:50','gsasa','gfasf',2,'true'),(10,'sadgasdg',4744,'2021-11-07 08:23:57','gsaas','agsdgsa',2,'true'),(11,'vnf',4744,'2021-11-07 12:46:31','ghjd','dfjdt',1,'true'),(12,'t sthe',4744,'2021-11-07 02:03:41','re ','er g',0,'true');
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
INSERT INTO `info_activity` VALUES (2,'不知不觉，又是一个新的学年开始。不少拿着Zu的小萌新们要踏上一段新的旅程了，不知道是不是对新的生活满怀憧憬与期待呢？为了帮助初来乍到的新生能够更快地适应在德国的学习和生活，也便于所有身处异国他乡的留德华人们能够了解到更多有用实在的信息，德累斯顿学联准备在本周六10月2日下午15:00-17:00，召开2021/2022冬季学期德累斯顿学联新生大会。'),(3,' 为提升员工的团队意识，增强团队凝聚力，加强部门、同事之间的交流与协作，营造奋发向上的组织氛围，2013年8月24至25日、8月31日至9月1日，苏宁环球江南公司宜兴、北塘项目部分两批成功举行拓展训练。 两天的训练分别完成了团队破冰、团队迷宫、无线电合作、达芬奇密码、罗马炮车、赤壁之战、擂站CS、十面埋伏、通天塔等十余个项目。通过本次培训，参训员工展现出良好的个人素质和高昂的激情，体现出良好的团队协作精神和目标意识，在时间紧、任务重的情况下，高质量地完成了所有的培训科目。'),(5,'2021.06.15 更新苹果12最终优惠券信息，最高降价1400元。\n2021.06.15 更新iPhone11降价1000元（仅限64G版本）\n2021.06.13 更新小米11 Ultra最终优惠，叠加优惠券后，降价1100元！\n2021.06.12 快到618了，很多手机全程价保，准备换机的可以入手了。\n2021.06.05 很多朋友私信问消费券怎么领，我更新专题文章放底部，感兴趣的可以看看。\n2021.06.04 消费券第2轮开始发放，记得先领取再下单\n2021.06.01 苹果最新优惠1000+400元，更新专题文章\n2021.05.29 官方5.24-6.20全程价保！确保价格最低。更新OPPO、真我、IQOO手机的最终优惠。\n2021.05.29 更新苹果手机最新优惠。\n2021.05.28 官方5.24-6.20全程价保！确保价格最低。更新小米11Pro/小米11等最终优惠\n2021.05.28 官方5.24-6.20全程价保！确保价格最低。更新一加手机最终优惠。\n2021.05.27 添加OPPO Reno6 Pro优惠信息，更新其他手机优惠信息\n2021.05.27 添加红米 Note 10系列优惠信息\n2021.05.26 更新小米11Pro优惠信息，至少降价300元\n2021.05.25 添加京东红包，每天可领取3次，可叠加使用更优惠！\n2021.05.25 更新iPhone 12、12mini、12 Pro Max 优惠券，最高直降1000元\n2021.05.24 更新iPhone11优惠券50元\n2021.05.24 更新一加8/IQOO Neo5/Neo5活力版优惠券\n2021.05.24 更新预售优惠券，小米11/小米10S/红米Note9/红米K40\n2021.05.23 补充评论区咨询较多的魅族手机优惠\n2021.05.23 更新iPhone11/小米11/红米8/OPPO Reno 4等优惠\n2021.05.22 发布各品牌手机优惠汇总，更新最新优惠，去除失效活动'),(24,'这次比赛大家都讲自己的能力毫无保留的展现了出来。这两场比赛都是硬仗，我们在比赛中都遇到了困难，但是大家都没放弃。坚持的结果就是我们最后都取得了胜利，这是好事，但我们也会在从中发现不足，争取下一场比赛打得更好。恭喜互联网院男篮杀进决赛'),(25,'互联网院7号开场发球连续得分，帮助互联网院女排建立了完美的开局，也点燃了队员和观众的激情。互联网院14号一记扣球完美得分，这边经贸院队依旧顽强凭着平稳的垫球与互联网女排展开拉锯战，最终经贸院4号一记扣杀压线得分，经贸29号二传一个隐蔽的吊球得分。但互联网院的高质量发球，让经贸院女排措手不及，频频下网，略显着急导致失误增多。此时经贸院队叫了第一次暂停，但第一局的局势已经被互联网女排牢牢掌握在手中，暂停结束，互联网院队以25:10轻取第一局。'),(26,'软件设计大赛是由爪哇部落主办的全校性的大学生团队软件设计大赛,旨在提高广金学子的计算机编程能力和团队协作能力，时至今年已经举办到第10届。大赛将历时两个月，分为初赛和决赛。奖品丰厚,综测任你拿!'),(27,'为加深学生对党的认知，进一步增强学生对党的认同感和归属感，2018年11月10日18时30分，由团委组织部承办的金融学院第十三届党团知识竞赛在之远楼607成功举行。'),(28,'今年，广东面向全省各高校开展大学生志愿服务西部（山区）计划招募工作已全面启动。据统计，去年共有147所高校3907人报名西部计划，最终349名志愿者脱颖而出。高校要立足志愿服务常态化工作，扎实推进2021年广东大学生志愿服务西部（山区）计划实施，积极引导毕业生投身扶贫开发，鼓励更多青年在西部基层火热的实践中建功立业，挥斥方遒。同学们！要用脚步丈量大地，用心灵感悟人生方向，用青春告白伟大祖国。\r\n人生的道路有许多方向,有人向东海岸的对岸驶去,\r\n师夷长技以制夷,有人跨越南北半球,到非洲去维护世界和平,\r\n路就在脚下,此刻你选择向西而行,是点亮他人前进的灯塔,实现自己的人生价值，到西部(山区)奋斗，让青春出彩。');
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
INSERT INTO `info_organization` VALUES (7,'广东金融学院音乐协会诞生于 1992 年，于2014 年 3 月 21 日正式更名为「 出雲音乐协会 」，致力于打造广金音乐文化传播第一平台，成为卓越的大学活动策划者和出色的舞台执行团队。\n\n我们对「 出雲 」的理解是希望这个组织，出色，出众，出人头地。浮雲蔽日，前路迷茫是我们做音乐事业者的必经之路，我们只是执着地坚信，光芒，希望一直都在，只要沉淀，思考，奋进，终会有拨开雾霾，出雲见日的时候。\n\n作为广金唯一的音乐社团，所有流派的音乐爱好者我们都尽收怀中。只要你够热情，就一起来传承我们的够姜精神。'),(8,'广东金融学院轮滑协会\n\n是学校课余轮滑爱好者组成的运动协会。\n\n协会致力于普及高校轮滑运动，\n\n促进高校间的轮滑交流，\n\n发展轮滑事业。\n\n本协会立足校内，\n\n以服务会员为根本，\n\n组织轮滑培训，\n\n开展轮滑集体活动，\n\n积极与校外进行轮滑交流，\n\n增强同学的体质，\n\n通过轮滑运动进行体育比赛和社会实践，\n\n为广大轮滑爱好者提供一个\n\n塑造和张扬个性、展现青春和激情的舞台，\n\n以提高轮滑爱好者的体育竞技水平，\n\n培养团队精神，\n\n丰富大学生的校园文化生活，\n\n提高我校学生的综合素质，\n\n促进全民健身运动，\n\n促进我校社团文化的繁荣发展，\n\n提高我校学生的课余生活质量。'),(9,'记忆协会是广金唯一一个\n致力于记忆力培训和思维导图绘制\n的脑力开发社团\n协会设\n秘书部、组织部、特训部和外宣部四大部门\n外宣部：制作推文、活动摄影\n组织部：策划活动、组织团建\n秘书部：上传下达、文案撰写\n特训部：会员教学、竞技交流\n我们有：\n大咖坐阵\n全球二十多年仅有700名世界记忆大师\n我们协会就有2名\n记忆高超\n5分钟记320个数字\n35秒记忆一副扑克牌\n的师兄师姐负责教学\n一起暴富\n首届会员艾琳同学\n参加“记忆九段”全球总决赛\n获得奖金近一万元'),(10,'保险实践协会\n是以广东金融学院保险系师生为主的、\n面向全校师生的\n保险实践交流、促进组织\n其前身是依托国家级实验教学示范中心\n保险实验室的学生教学辅助团队\n它是一个提供保险竞赛资讯\n以及保险实践学习机会给各位同学的窗口\n主要工作就是\n作为学生联系老师、校外组织等的桥梁\n来帮助同学们了解和学习更多\n与保险相关的知识\n同时也会组织一些相关的竞赛活动\n来让大家展现自我、焕发光彩！\n主要项目：\n保险产品创新创意大赛\n《保险学苑》书刊、“现金流”财富实践游戏\n校友分享交流会、保险公司分享交流会等'),(11,'广东金融学院计算机与技术协会\n是电脑爱好者的绿洲\n人才济济，实力雄厚\n\n计协分为五个部门\n电竞部、技术部\n网宣部、外联部、财务部\n部门间各司其职\n也亲密无比\n计协小伙伴们发光发热'),(12,'英语俱乐部\n是全校唯一一个英语学术型社团\n至今已陪伴广金莘莘学子\n走过28个春秋冬夏\n我们英俱每个星期都会\n举办口语角等常规活动\n和定期举行风采之星英语等\n品牌活动\n并且社团团建\n和节日庆祝也少不了我们\n我们现设有四大部门\n分别是口语部，外联部\n网宣部以及人事部\n在这里我们是一个大家庭\n好学英语的大家庭\n如果你也感兴趣，快来加入我们吧！'),(13,'会计学会\n是一个以会计学习与交流为主的\n学术性、专业型社团组织\n社团内会定期发布最新资讯\n组织专业培训和大型专业比赛\n我们与高顿财经、中华会计网校\n正保远程教育、广东财经大学等\n各大公司与学校有长期交流与合作\n有中华网校杯校园财会大赛\n财会杯科研论文大赛\n以及模拟初级会计师等各种比赛'),(14,'ERP沙盘学习团队\n从成立之初就\n以自主性学习为团队的核心思想\n我们团队已经拥有了浓厚的自主性学习氛围\nERP沙盘模拟作为我们团队的\n一项基本但很重要的活动\n是每一位成员都需要亲身去体验与学习的\n在这里\n你会发现大家\n都全身心投入到学习\n因为在这里，你会发现\n你的知识储备永远是不够的\n它针对物资资源管理（物流）\n人力资源管理（人流）\n财务资源管理（财流）\n信息资源管理（信息流）\n集成一体化的企业管理软件\n涉及企业的人、财、物、供、产、销\n全面结合、全面受控\n实时反馈、动态协调\n以销定产、以产求供\n降低成本等各个方面\n有学不完的知识\n是一个值得你投入时间\n与经历去参与的活动'),(18,'我爱你像风吹走了千万里从不问归期'),(29,'广东金融学院绿时环保协会\n\n成立于2009年3月份\n\n是由一群具有环保意识\n\n的学生组建的大学社团\n\n倡导“以绿色为梦想，以环保为己任”\n\n我们的宗旨是\n\n做实事，用自己的一举一动\n\n去影响身边的人加入到环保队伍当中\n\n我们的口号是：Join us, join Green Time!\n\n协会于2009年12月11日\n\n加入绿点青年环境教育中心\n\n此后与40多所联盟环保社团取得交流\n\n为自身的发展注入了新活力\n\n    自协会成立以来\n\n协会不断成长\n\n先后开展过捐书换书、圣诞水果贺卡\n\n飞羽观鸟高校联合推广、“走巡车陂涌”\n\n世界地球日、火炉山秋游等一系列活动\n\n协会立足校园，面向社会\n\n自成立后得到学院领导、社会环保部门\n\n的大力支持\n\n并与龙洞街道办事处取得友好联系\n\n协会曾两度被评为\n\n年度优秀社团\n\n得到全校师生的肯定\n\n       现今协会的日常经营事务\n\n是“捐书换书，以物换物”\n\n同学们的闲置物品到了新学期或者毕业季\n\n大多都会丢弃到楼下\n\n这给环境造成了很大的压力\n\n同时也给宿管阿姨造成了很大的困扰\n\n况且这些闲置物品还有回收利用的价值\n\n就此变成垃圾岂不可惜\n\n让我们行动起来，变废为宝\n\n将闲置物品的价值流通利用起来吧\n\n为我们生存依赖的环境\n\n贡献自己的一点微薄之力吧！'),(30,'寻至心坎，影得动人；\n\n青春易逝，光影长存。\n\n大家好，我们是广东金融学院寻影协会，是一个专注于微电影叙事类短片创造的学生组织，这里的每一个人都是纯粹的电影爱好者，我们因为共同的兴趣走到一起，我们协会的活动主题是微电影拍摄。微电影爱好者们，无论你有没有作品，无论你是否精于拍摄，这里都能帮助你提升自己的摄影能力与微电影知识。\n\n寻影今年3岁啦，是一个充满活力、具有无限发展前景的团队。\n\n寻影协会的故事从一群爱电影、爱表达的人相遇的那天开始，到此刻还在继续。我们寻寻觅觅，在等一个你，不需要多么精通电影，不需要掌握所有技术，只要你热爱电影，渴望交流，那么便欢迎你加入寻影大家庭，与我们一起探寻微电影的奥秘，一同享受拍摄微电影的充实与快乐，共同创作出自己的微电影、短视频！\n\n我们可以一起提高摄影能力，我们可以一起从诗词歌赋聊到人生哲理。在这里，你可以是导演，可以是演员，可以是编剧，我们在一起，就拥有创造一切的可能性。\n\n寻影协会设有五大部门，分别是宣传部、秘书部、人资部、外联部、财务部。宣传部主要负责协会的推文海报制作和宣传物资设计等工作；秘书部主要负责开会总结、文件整理、统计数据等工作；人资部负责活动策划以及人员安排；外联部的主要工作是谈赞助，做赞助策划书以及和其他学校的社团组织联谊；财务部主要负责记录协会的财务状况和购买物资设备等。\n\n我们本次招新既招会员，也招部员哟！\n\n始于喜欢，源于兴趣，终于热爱，寻影寻影，寻一个你。'),(31,'我们是一群热爱数据分析\n和量化投资的有志青年\n致力于将广东省内高校学术研究\n与实际市场投资结为一体\n我们希望德才兼备的你加入我们！\n在这里\n我们可以一起讨论金融热点\n一起交流最近的模拟交易的心得\n一起探索算法、编程等一些技术难题\n一起组队参加各种活动\n金融建模大赛、美国大学生数学建模大赛\n中国大学生数学建模大赛\n大创项目、攀登计划等······\n收获各种国际级、国家级大奖\n \n“我们希望你具备”\n \n学习能力强\n对数据分析、量化投资感兴趣\n有责任心，做事认真负责\n如果有编程和数据处理能力更佳\n'),(32,'燎原文学社\n成立于2003年\n是一个广金文学爱好者\n的自由而飞扬地展现自我的社区\n下设五个部门\n分别为贯通社团里外的秘书部\n技能满点的宣传部\n致力创作的写作部\n人员调配安排的人力资源部\n与校内外组织对接工作的外联部'),(33,'广金货币金融协会\n以广州货币金融博物馆为阵地\n致力于\n传播货币金融文化知识\n让更多人了解货币文化\n和感受其背后的璀璨历史\n货协联手博物馆开展了各种科普活动\n如货币文化节、人民币防伪活动\n会员日等精品活动\n多次被评为\n校级十大优秀社团\n \n我们协会有三个部门\n分别是文宣部、秘书部和资源部\n提升技能拓展人脉丰富知识\n更多精彩期待你的到来～'),(34,'广金笛箫协会诞生于2009年7月，我们秉承着“弘扬民族音乐”&“繁荣校园文化”的宗旨，高扬“会笛箫客，传民族情”的口号。独具特色的民族乐器是中华传统文化的一大瑰宝，为了让同学们在学习之余能够受到传统民乐文化的熏陶，陶冶情操，培养雅兴，广东金融学院笛箫协会作为一个具有一定资历的社团，承担起这一任务，并已成功举办过八届“金苑杯”民族乐器大赛，为民乐爱好者们提供一个交流和竞技的平台，让良好的传统民乐文化氛围充满校园。在这个广金学子喜爱的家庭里，你可以和一群热爱乐器的朋友相互学习，共同成长。'),(35,'军事协会\n是一个以军事户外活动为主的协会\n在这里\n你将体验到精彩的战地生活\n你将见识到世界各地的枪械武器\n并懂得如何\n去使用它们远程狙击、近战突袭\n与队友组成战术小队\n以真人CS的形式\n在不同的环境下搜查、消灭敌人\n在这里\n你将感受到野外露营\n野战烧烤的乐趣\n亲手准备美味食材\n和战友们在青草地上\n一起撸串、喝快乐水\n感受不一样的军旅生活！'),(36,'广东金融学院数学爱好者协会\n成立于2005年\n其旨在提高会员的数学水平\n及对数学模型的应用能力\n培养会员的数学思维习惯\n对实际问题的洞察能力\n以及数学与计算机的综合应用能力\n数协的宗旨是\n立足基础、学以致用\n携手共进、力攀高峰\n协会秉承“相亲相爱一家人”理念\n内部团结和谐，共同进退\n这里是给热爱数学的同学\n一个相互交流和学习的平台'),(37,'金风灯谜协会成立于2011年4月22日。协会共设有秘书部、学术部、组织部、网宣部、外联部五大部门。从成立之初到现在已成功举办了大大小小的全校性谜会，如周年庆谜会、迎新谜会、中秋谜会等；并响应省社联号召成功举办了几场区域性谜会，如粤高校杯，粤新生杯，得到了学校领导和广大师生的赞许。'),(39,'校心协\n即广东金融学院\n心理健康与个人发展协会\n是以服务学生、帮助学生排解心里困惑\n提高大学生的心理素质\n促进大学生健康成长\n和全面发展为宗旨的组织\n加入我们\n你可以有许多机会策划活动\n认识更多的老师和朋友\n学习各种新技能..'),(40,'我们是一群热爱Kpop的广金人\n韩语学社每学期都会举办韩语角\n泡菜节等常规活动\n并为会员提供免费韩语课程\n我们现设有六大部门\n分别是财务部、表演部、外宣部\n培训部、秘书部、策划部\n学韩语、赏韩景\n品韩味、听韩歌\n让我们一起邂逅韩国文化！ '),(41,'广东金融学院金融学会\n成立于2000年12月1日\n是校社联管理下的一个学术类学生社团\n2012年金融学会与华农金协等\n高校社团一起创建了\n广东大学生金融联盟\n目前金融学会广东大学生金融联盟的\n五大常任理事之一\n \n自成立以来\n金融学会始终致力于传播金融知识\n和帮助同样对金融感兴趣的同学们\n搭建一个个学习交流的良好平台\n在围绕金融知识开展的\n各类型多样化的活动中\n逐渐让同学们认识金融\n喜欢金融，学习金融，受益于金融'),(42,'广金金蜜蜂社团\n\n是在中国建设银行广东省分行\n\n指导下开展工作的学生组织\n\n致力于普及金融知识\n\n全面提高同学们综合金融素质\n\n搭建世界500强企业与校方合作的平台\n\n为同学们提供\n\n一个自我展示自我创造\n\n的梦想舞台'),(133,'广东金融学院篮球协会\n\n是校政教处、共青团委批准成立的协会\n\n作为新成立的协会，\n\n我们本着\n\n“在篮球中快乐，\n\n在快乐中篮球”\n\n的宗旨；\n\n坚持以推动我校篮球发展、\n\n创造浓厚的校园文化氛围为目标。\n\n坚决执行学校的发展要求、\n\n积极的为每位同学服务。 \n\n篮球协会设置的部门有：\n\n技术部、秘书部、\n\n宣传部、外联部四大部门\n\n外加裁判组和花式篮球');
/*!40000 ALTER TABLE `info_organization` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pcituremain_activity`
--

DROP TABLE IF EXISTS `pcituremain_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pcituremain_activity` (
  `id` int NOT NULL,
  `picture` longtext,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pcituremain_activity`
--

LOCK TABLES `pcituremain_activity` WRITE;
/*!40000 ALTER TABLE `pcituremain_activity` DISABLE KEYS */;
INSERT INTO `pcituremain_activity` VALUES (20,'http://localhost:8080/FindMore/shapan/pic_1.jpg'),(21,'http://localhost:8080/FindMore/hanyu/pic_1.jpg'),(22,'http://localhost:8080/FindMore/susuan/pic_1.jpg'),(23,'http://localhost:8080/FindMore/xinli/pic_1.png'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_1.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_1.jpg'),(26,'http://localhost:8080/FindMore/image/ruanjiansheji/pic_1.gif'),(27,'http://localhost:8080/FindMore/image/dangtuan/pic_1.jpg'),(28,'http://localhost:8080/FindMore/image/xibu.jpg');
/*!40000 ALTER TABLE `pcituremain_activity` ENABLE KEYS */;
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
INSERT INTO `picture_activity` VALUES (2,'http://localhost:8080/FindMore/image/zxb.jpg'),(3,'http://localhost:8080/FindMore/image/xshzx_0.jpg'),(0,'http://localhost:8080/FindMore/image/zxb.jpg'),(0,'http://localhost:8080/FindMore/image/xshzx_0.jpg'),(0,'http://localhost:8080/FindMore/image/shetuanzhaoxin_0.jpg'),(0,'http://localhost:8080/FindMore/image/zuzishetuan.jpg'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_1.jpg'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_2.gif'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_3.gif'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_4.gif'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_5.gif'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_6.jpg'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_7.jpg'),(24,'http://localhost:8080/FindMore/image/xiwangbei/pic_8.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_1.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_2.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_3.gif'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_4.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_5.gif'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_6.gif'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_7.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_8.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_9.jpg'),(25,'http://localhost:8080/FindMore/image/mengyabei/pic_10.jpg'),(26,'http://localhost:8080/FindMore/image/ruanjiansheji/pic_1.gif'),(26,'http://localhost:8080/FindMore/image/ruanjiansheji/pic_2.jpg'),(26,'http://localhost:8080/FindMore/image/ruanjiansheji/pic_3.jpg'),(27,'http://localhost:8080/FindMore/image/dangtuan/pic_1.jpg'),(27,'http://localhost:8080/FindMore/image/dangtuan/pic_2.jpg'),(27,'http://localhost:8080/FindMore/image/dangtuan/pic_3.jpg'),(27,'http://localhost:8080/FindMore/image/dangtuan/pic_4.jpg'),(27,'http://localhost:8080/FindMore/image/dangtuan/pic_5.jpg'),(27,'http://localhost:8080/FindMore/image/dangtuan/pic_6.jpg'),(21,'http://localhost:8080/FindMore/hanyu/pic_1.jpg'),(20,'http://localhost:8080/FindMore/shapan/pic_1.jpg');
/*!40000 ALTER TABLE `picture_activity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `time_activity`
--

DROP TABLE IF EXISTS `time_activity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `time_activity` (
  `id` int NOT NULL,
  `sign_up_end_time` varchar(45) DEFAULT NULL,
  `first_match_time` varchar(45) DEFAULT NULL,
  `final_match_time` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `time_activity`
--

LOCK TABLES `time_activity` WRITE;
/*!40000 ALTER TABLE `time_activity` DISABLE KEYS */;
INSERT INTO `time_activity` VALUES (1,'2021.11.01','2021.11.04','2021.12.30');
/*!40000 ALTER TABLE `time_activity` ENABLE KEYS */;
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
  KEY `manger_infromation_key_idx` (`managercount`)
) ENGINE=InnoDB AUTO_INCREMENT=425 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_organization`
--

LOCK TABLES `user_organization` WRITE;
/*!40000 ALTER TABLE `user_organization` DISABLE KEYS */;
INSERT INTO `user_organization` VALUES (7,'出雲音乐协会','1',201543220,NULL,'1301000000','123','http://localhost:8080/FindMore/image/chuyun/pic_1.jpg',NULL),(8,'轮滑协会','1',201543220,NULL,'13020000000','123','http://localhost:8080/FindMore/image/lunhua/pic_1.jpg',NULL),(9,'记忆协会','1',201543220,NULL,'13090000000','123','http://localhost:8080/FindMore/image/Head/jiyi.jpg',NULL),(10,'保险实践协会','1',201543220,NULL,'13011000000','123','http://localhost:8080/FindMore/image/baoxian/pic_1.jpg',NULL),(11,'计算机协会','1',201543220,NULL,'13015000000','123','http://localhost:8080/FindMore/image/Head/jisuanji.jpg',NULL),(12,'英语俱乐部','1',201543220,NULL,'13018000000','123','http://localhost:8080/FindMore/image/Head/yingyu.jpg',NULL),(13,'会计学会','1',201543220,NULL,'13019000000','123','http://localhost:8080/FindMore/image/Head/kuaiji.jpg',NULL),(14,'ERP沙盘学习团队','1',201543220,NULL,'13024000000','123','http://localhost:8080/FindMore/image/shapan/pic_1.jpg',NULL),(31,'量化投资研究协会','1',201543220,NULL,'13012000000','123','http://localhost:8080/FindMore/image/Head/lianghuatouzi.jpg',NULL),(32,'燎原文学社 ','1',201543220,NULL,'13013000000','123','http://localhost:8080/FindMore/image/Head/liaoyuan.jpg',NULL),(35,'军事协会','1',201543220,NULL,'13016000000','123','http://localhost:8080/FindMore/image/Head/junshi.jpg',NULL),(36,'数学爱好者协会','1',201543220,NULL,'13017000000','123','http://localhost:8080/FindMore/image/Head/shuxue.jpg',NULL),(39,'心理健康与个人发展协会','1',201543220,NULL,'13021000000','123','http://localhost:8080/FindMore/image/Head/xinli.jpg',NULL),(40,'韩语学社','1',201543220,NULL,'13022000000','123','http://localhost:8080/FindMore/image/Head/hanyu.jpg',NULL),(41,'金融学会','1',201543220,NULL,'13023000000','123','http://localhost:8080/FindMore/image/Head/jinrong.jpg',NULL);
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
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `collage` varchar(45) DEFAULT NULL,
  `major` varchar(45) DEFAULT NULL,
  `gender` varchar(8) DEFAULT '男',
  `password` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `pet_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pic_user` longtext,
  PRIMARY KEY (`id`,`count`,`phone`),
  UNIQUE KEY `count_UNIQUE` (`count`),
  UNIQUE KEY `phone_UNIQUE` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_student`
--

LOCK TABLES `user_student` WRITE;
/*!40000 ALTER TABLE `user_student` DISABLE KEYS */;
INSERT INTO `user_student` VALUES (1,201543220,'大黄','13012344321','互联网金融与信息工程学院','计算机科学与技术','男','123456','dahuang@qq.com','大黄','ghdhghdgjhgdgyu45456asdf1f456d421z4fd564f52sa1f5sd456f4sd4545sdx12xc15es4f5sd422zx154a231d23a421z2315a4d5412341gh23jkh4kl1l3j45i4u5321dg231fdg456j454i56456y445u54d87sd89fg5xf6d4g56df4hg564g547fsg47sr4ty74uy45fdg4hj21fgd1h214shzdf1g454g78dfs74y544d211524x54x5464s856f745s64ts'),(2,201543219,'大白','1008612','互联网金融与信息工程学院','计算机科学与技术','男','abc123',NULL,'大白','hgadfhydsgfjhsdaghgdsafhgasdyufyue578dsf857sda56f4sd352f4186sd5a74fasd41f56asd4f86asd74f54asdf56s7ad89f732w85e4r87e897485ag74856sdfghasd4g5674gh89asdf4g5641asdg85674asdg41asdg5674asd89g4we25r4g856wser74g4as1g6534azsd563g4as35dg857asd7g85sda74g56s41g56s7d4g564sdg56sdagsd'),(11,201543200,'findmore2','13010061007','互联网金融与信息工程学院','计算机科学与技术',NULL,'711be3iidqb6lrsln0avp0v21u',NULL,'findMore',NULL),(19,201543000,'findmore3','13126021980','互联网金融与信息工程学院','计算机科学与技术',NULL,'o5gmeniduksgasjg04sl15h3o',NULL,'findMore',NULL),(20,201567832,'findmore4','123456','互联网金融与信息工程学院','计算机科学与技术',NULL,'13010081009',NULL,'findMore',NULL),(21,201543001,'findmore5','13126021981','互联网金融与信息工程学院','计算机科学与技术',NULL,'o5gmeniduksgasjg04sl15h3o',NULL,'findMore',NULL),(25,123123,'findmore7','123',NULL,NULL,NULL,'13010071007',NULL,NULL,NULL),(26,201543239,'findmore8','13010081008',NULL,NULL,NULL,'123',NULL,NULL,NULL),(27,211643239,'findmore9','13010091009',NULL,NULL,NULL,'105ism5b2p0tdpcio72kmi6irg',NULL,NULL,NULL),(28,201543296,'findmore10','13001233210',NULL,NULL,NULL,'105ism5b2p0tdpcio72kmi6irg',NULL,NULL,NULL);
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

-- Dump completed on 2021-11-21 12:10:03

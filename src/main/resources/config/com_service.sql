-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: www.dbdbd.cn    Database: com_service
-- ------------------------------------------------------
-- Server version	5.1.73

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
-- Table structure for table `active_code`
--

DROP TABLE IF EXISTS `active_code`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `active_code` (
  `user_id` bigint(20) NOT NULL,
  `code` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `active_code`
--

LOCK TABLES `active_code` WRITE;
/*!40000 ALTER TABLE `active_code` DISABLE KEYS */;
/*!40000 ALTER TABLE `active_code` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `admin_user`
--

DROP TABLE IF EXISTS `admin_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_user` (
  `id` bigint(20) NOT NULL,
  `account` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `nick` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_user`
--

LOCK TABLES `admin_user` WRITE;
/*!40000 ALTER TABLE `admin_user` DISABLE KEYS */;
INSERT INTO `admin_user` VALUES (1,'admin','admin','admin');
/*!40000 ALTER TABLE `admin_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `appeal`
--

DROP TABLE IF EXISTS `appeal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appeal` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `linkman` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `appeal`
--

LOCK TABLES `appeal` WRITE;
/*!40000 ALTER TABLE `appeal` DISABLE KEYS */;
INSERT INTO `appeal` VALUES (14425036903732,'我的简历','q8bk4vfk','528400','nnnnnb',14384506219094,'mmmmmm','hfghgfh','2015-09-17 23:28:10','2015-09-17 23:29:53');
/*!40000 ALTER TABLE `appeal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `busiess_service`
--

DROP TABLE IF EXISTS `busiess_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `busiess_service` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type_b` varchar(255) DEFAULT NULL,
  `type_s` varchar(255) DEFAULT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `linkman` varchar(45) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `busiess_service`
--

LOCK TABLES `busiess_service` WRITE;
/*!40000 ALTER TABLE `busiess_service` DISABLE KEYS */;
INSERT INTO `busiess_service` VALUES (14422444486241,'ios开发fuxk','q8bkb7vw','q8bkb7vwah52,q8bkb7vw54k3,q8bkb7vwevl5,q8bkb7vwiwww,q8bkb7vwgzhq','528400','sdgdfgfdg','hhhhh',14384506219094,'nnnnn','2015-09-14 23:27:28','2015-09-15 00:00:33');
/*!40000 ALTER TABLE `busiess_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `business_type`
--

DROP TABLE IF EXISTS `business_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `business_type` (
  `id` varchar(255) NOT NULL,
  `parent_id` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `name_py` varchar(255) DEFAULT NULL,
  `name_pj` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `business_type`
--

LOCK TABLES `business_type` WRITE;
/*!40000 ALTER TABLE `business_type` DISABLE KEYS */;
INSERT INTO `business_type` VALUES ('q8bk','0','商务服务',NULL,NULL),('q8bk4vfk','q8bk','投资担保',NULL,NULL),('q8bk4vfksizo','q8bk4vfk','投资',NULL,NULL),('q8bk4vfk7x00','q8bk4vfk','担保',NULL,NULL),('q8bk4vfkrh42','q8bk4vfk','典当行',NULL,NULL),('q8bk4vfkh6n2','q8bk4vfk','贷款',NULL,NULL),('q8bk4vfkc7pz','q8bk4vfk','银行直投',NULL,NULL),('q8bkch9e','q8bk','工商注册',NULL,NULL),('q8bkch9elr1q','q8bkch9e','内资公司注册',NULL,NULL),('q8bkch9el9nf','q8bkch9e','工商年检',NULL,NULL),('q8bkch9ecy3u','q8bkch9e','专项审批',NULL,NULL),('q8bkch9eo3tf','q8bkch9e','海外公司注册',NULL,NULL),('q8bkch9eo8sg','q8bkch9e','外资公司注册',NULL,NULL),('q8bkch9e4v81','q8bkch9e','香港公司注册',NULL,NULL),('q8bkch9ec3ip','q8bkch9e','验资开户',NULL,NULL),('q8bkch9e14gb','q8bkch9e','公司变更',NULL,NULL),('q8bkch9en569','q8bkch9e','公司注销',NULL,NULL),('q8bkch9ey2qg','q8bkch9e','一般纳税人申请',NULL,NULL),('q8bkch9ehye1','q8bkch9e','资质认证',NULL,NULL),('q8bkb7vw','q8bk','保险',NULL,NULL),('q8bk4vn3','q8bk','法律咨询',NULL,NULL),('q8bkqgl0','q8bk','商标专利',NULL,NULL),('q8bk02ie','q8bk','印刷包装',NULL,NULL),('q8bk3l1p','q8bk','起名/风水/算命',NULL,NULL),('q8bkn0qm','q8bk','喷绘招牌',NULL,NULL),('q8bkitv8','q8bk','咨询',NULL,NULL),('q8bksxm7','q8bk','网站建设/推广',NULL,NULL),('q8bkg4zk','q8bk','翻译/速记',NULL,NULL),('q8bk1x55','q8bk','网络布线/维护',NULL,NULL),('q8bky6xf','q8bk','快递',NULL,NULL),('q8bk6lqw','q8bk','代办签证/签注',NULL,NULL),('q8bkxoxa','q8bk','财务会计/评估',NULL,NULL),('q8bklvix','q8bk','货运专线',NULL,NULL),('q8bkvau9','q8bk','设计策划',NULL,NULL),('q8bk66yt','q8bk','货运物流',NULL,NULL),('q8bkra39','q8bk','广告传媒',NULL,NULL),('q8bklu8v','q8bk','租赁',NULL,NULL),('q8bkbhw3','q8bk','制卡',NULL,NULL),('q8bkgp4p','q8bk','办公设备维修',NULL,NULL),('q8bkvmmz','q8bk','展会服务',NULL,NULL),('q8bkizlg','q8bk','礼品定制',NULL,NULL),('q8bkzr7q','q8bk','建筑维修',NULL,NULL),('q8bkh38k','q8bk','机械设备维修',NULL,NULL),('q8bkb7vwah52','q8bkb7vw','意外险',NULL,NULL),('q8bkb7vw54k3','q8bkb7vw','旅游保险',NULL,NULL),('q8bkb7vwevl5','q8bkb7vw','签证保险',NULL,NULL),('q8bkb7vwboa6','q8bkb7vw','健康险',NULL,NULL),('q8bkb7vwiwww','q8bkb7vw','人寿险',NULL,NULL),('q8bkb7vwaz4g','q8bkb7vw','少儿保险',NULL,NULL),('q8bkb7vwngle','q8bkb7vw','商业养老险',NULL,NULL),('q8bkb7vwgzhq','q8bkb7vw','投资型保险',NULL,NULL),('q8bkb7vwy022','q8bkb7vw','家财险',NULL,NULL),('q8bkb7vw8n8k','q8bkb7vw','汽车保险',NULL,NULL),('q8bkb7vwgexd','q8bkb7vw','企业财产险',NULL,NULL),('q8bkqgl04au0','q8bkqgl0','商标服务',NULL,NULL),('q8bkqgl0bsw2','q8bkqgl0','版权服务',NULL,NULL),('q8bkqgl0be9p','q8bkqgl0','专利服务',NULL,NULL),('q8bk4vn39ic0','q8bk4vn3','合同纠纷',NULL,NULL),('q8bk4vn3nguk','q8bk4vn3','知识产权',NULL,NULL),('q8bk4vn3d4we','q8bk4vn3','法律援助',NULL,NULL),('q8bk4vn3fsvt','q8bk4vn3','劳动争议',NULL,NULL),('q8bk4vn3iucx','q8bk4vn3','商业纠纷',NULL,NULL),('q8bk4vn3simz','q8bk4vn3','房产纠纷',NULL,NULL),('q8bk4vn32606','q8bk4vn3','刑事辩护',NULL,NULL),('q8bk4vn35kd1','q8bk4vn3','婚姻家庭',NULL,NULL),('q8bk4vn3h3n2','q8bk4vn3','医疗事故',NULL,NULL),('q8bk4vn3bl4l','q8bk4vn3','交通事故',NULL,NULL),('q8bk4vn3n36e','q8bk4vn3','征地补偿',NULL,NULL),('q8bk4vn3xsxo','q8bk4vn3','公司法务',NULL,NULL),('q8bk4vn3m8fn','q8bk4vn3','债务纠纷',NULL,NULL),('q8bk4vn3am69','q8bk4vn3','建筑工程',NULL,NULL),('q8bk4vn364fh','q8bk4vn3','涉外法律',NULL,NULL),('q8bk02ie4bvw','q8bk02ie','不干胶印刷',NULL,NULL),('q8bk02ie2mzh','q8bk02ie','纸类印刷',NULL,NULL),('q8bk02iest4m','q8bk02ie','防伪印刷',NULL,NULL),('q8bk02iemgoe','q8bk02ie','包装',NULL,NULL),('q8bk02ieq3qb','q8bk02ie','名片印刷',NULL,NULL),('q8bk02ie0f8n','q8bk02ie','书刊印刷',NULL,NULL),('q8bk02ieugne','q8bk02ie','仪器面板印刷',NULL,NULL),('q8bk02ieikmy','q8bk02ie','服装印花',NULL,NULL),('q8bk02ieg6fb','q8bk02ie','办公礼品印刷',NULL,NULL),('q8bk02ie5w4b','q8bk02ie','宣传资料印刷',NULL,NULL),('q8bk3l1prts7','q8bk3l1p','起名',NULL,NULL),('q8bk3l1pd8o6','q8bk3l1p','风水',NULL,NULL),('q8bk3l1p4ck6','q8bk3l1p','算命',NULL,NULL),('q8bk3l1pt8rp','q8bk3l1p','星座',NULL,NULL),('q8bk3l1pmq1c','q8bk3l1p','择吉日',NULL,NULL),('q8bk3l1px3l6','q8bk3l1p','解梦 ',NULL,NULL),('q8bkn0qmzcix','q8bkn0qm','灯箱',NULL,NULL),('q8bkn0qmnw5g','q8bkn0qm','招牌',NULL,NULL),('q8bkn0qms2hb','q8bkn0qm','LED显示屏',NULL,NULL),('q8bkn0qmoizg','q8bkn0qm','亮化工程',NULL,NULL),('q8bkn0qmzppg','q8bkn0qm','背景',NULL,NULL),('q8bkn0qmodhh','q8bkn0qm','形象墙',NULL,NULL),('q8bkn0qmbdq4','q8bkn0qm','展架制作',NULL,NULL),('q8bkn0qmotts','q8bkn0qm','户外广告',NULL,NULL),('q8bkn0qmv3ak','q8bkn0qm','标牌',NULL,NULL),('q8bkn0qm7twx','q8bkn0qm','条幅',NULL,NULL),('q8bkn0qmah4p','q8bkn0qm','锦旗',NULL,NULL),('q8bkn0qmmdwy','q8bkn0qm','奖牌',NULL,NULL),('q8bkitv8gpg1','q8bkitv8','企业公关',NULL,NULL),('q8bkitv8x20g','q8bkitv8','人才/职介',NULL,NULL),('q8bkitv8c3r8','q8bkitv8','户口咨询',NULL,NULL),('q8bkitv84umh','q8bkitv8','心理咨询',NULL,NULL),('q8bkitv8z5qg','q8bkitv8','市场调查',NULL,NULL),('q8bkitv8i1fw','q8bkitv8','代缴社保/公积金',NULL,NULL),('q8bksxm7rbog','q8bksxm7','网站建设/设计',NULL,NULL),('q8bksxm7qn34','q8bksxm7','域名注册',NULL,NULL),('q8bksxm72kg1','q8bksxm7','网络营销/推广',NULL,NULL),('q8bksxm76gtm','q8bksxm7','服务器| 软件开发',NULL,NULL),('q8bksxm7u33w','q8bksxm7','app开发',NULL,NULL),('q8bksxm7v4eg','q8bksxm7','企业邮箱',NULL,NULL),('q8bksxm7cizy','q8bksxm7','网站维护',NULL,NULL),('q8bkg4zkzals','q8bkg4zk','速记',NULL,NULL),('q8bkg4zkqn7m','q8bkg4zk','笔译',NULL,NULL),('q8bkg4zk2adm','q8bkg4zk','口译',NULL,NULL),('q8bkg4zkyb4u','q8bkg4zk','同声传译',NULL,NULL),('q8bkg4zkh0c8','q8bkg4zk','本地化',NULL,NULL),('q8bk1x55b0sg','q8bk1x55','综合布线',NULL,NULL),('q8bk1x556a9s','q8bk1x55','系统集成',NULL,NULL),('q8bk1x55giu8','q8bk1x55','安防监控',NULL,NULL),('q8bk1x558b98','q8bk1x55','网络维护',NULL,NULL),('q8bk1x55eoig','q8bk1x55','电脑组装',NULL,NULL),('q8bk1x55wlub','q8bk1x55','IT外包',NULL,NULL),('q8bk1x55pi4m','q8bk1x55','光纤宽带',NULL,NULL),('q8bk1x55iwrh','q8bk1x55','弱电工程',NULL,NULL),('q8bky6xftdd7','q8bky6xf','同城快递',NULL,NULL),('q8bky6xflgka','q8bky6xf','国内快递',NULL,NULL),('q8bky6xfvk2o','q8bky6xf','国际快递',NULL,NULL),('q8bk6lqwzrsg','q8bk6lqw','旅游签证',NULL,NULL),('q8bk6lqwcd5h','q8bk6lqw','工作签证',NULL,NULL),('q8bk6lqw87gz','q8bk6lqw','商务签证',NULL,NULL),('q8bk6lqwxaag','q8bk6lqw','探亲访友签证',NULL,NULL),('q8bk6lqw5b4c','q8bk6lqw','留学签证',NULL,NULL),('q8bk6lqwlfo6','q8bk6lqw','港澳通行证/签注',NULL,NULL),('q8bk6lqwod8i','q8bk6lqw','移民签证',NULL,NULL),('q8bk6lqwnzd7','q8bk6lqw','入台证/台湾通行证',NULL,NULL),('q8bk6lqw6sto','q8bk6lqw','护照',NULL,NULL),('q8bkxoxaylyd','q8bkxoxa','代理记帐',NULL,NULL),('q8bkxoxamptx','q8bkxoxa','验资',NULL,NULL),('q8bkxoxavevn','q8bkxoxa','财务审计',NULL,NULL),('q8bkxoxanbet','q8bkxoxa','资产评估',NULL,NULL),('q8bkxoxa9cx1','q8bkxoxa','税务咨询',NULL,NULL),('q8bkxoxa3g7i','q8bkxoxa','工程造价',NULL,NULL),('q8bkxoxammbz','q8bkxoxa','财税疑难',NULL,NULL),('q8bkxoxa4pms','q8bkxoxa','纳税申报',NULL,NULL),('q8bklvix5qrl','q8bklvix','国内货运专线',NULL,NULL),('q8bklvixvlg3','q8bklvix','国际货运专线',NULL,NULL),('q8bkvau9bgwt','q8bkvau9','名片设计',NULL,NULL),('q8bkvau9dkea','q8bkvau9','平面设计',NULL,NULL),('q8bkvau9wcl3','q8bkvau9','视频制作',NULL,NULL),('q8bkvau9u1hm','q8bkvau9','广告设计',NULL,NULL),('q8bkvau9i7wb','q8bkvau9','工业设计',NULL,NULL),('q8bkvau9wtdl','q8bkvau9','SI店面设计',NULL,NULL),('q8bkvau9hsg5','q8bkvau9','装潢设计',NULL,NULL),('q8bkvau998i0','q8bkvau9','LOGO设计/VI设计',NULL,NULL),('q8bkvau99m27','q8bkvau9','服装设计',NULL,NULL),('q8bkvau9vg59','q8bkvau9','建筑设计',NULL,NULL),('q8bkvau9i3no','q8bkvau9','景观设计',NULL,NULL),('q8bkvau9lxcy','q8bkvau9','动漫设计',NULL,NULL),('q8bkvau93137','q8bkvau9','签名设计',NULL,NULL),('q8bk66ytlwgu','q8bk66yt','仓储',NULL,NULL),('q8bk66ytxets','q8bk66yt','全国零担',NULL,NULL),('q8bk66yty14h','q8bk66yt','航空运输',NULL,NULL),('q8bk66yt4pq7','q8bk66yt','货运代理',NULL,NULL),('q8bk66ytaa2p','q8bk66yt','托运',NULL,NULL),('q8bk66ytzpe9','q8bk66yt','进出口报关',NULL,NULL),('q8bk66yt153u','q8bk66yt','空车配货',NULL,NULL),('q8bkra39h128','q8bkra39','广告位招租',NULL,NULL),('q8bkra399b1s','q8bkra39','导视系统设计',NULL,NULL),('q8bkra39r8o5','q8bkra39','多媒体互动',NULL,NULL),('q8bklu8vucob','q8bklu8v','机械设备租赁',NULL,NULL),('q8bklu8vzoka','q8bklu8v','办公设备租赁',NULL,NULL),('q8bklu8vl76s','q8bklu8v','庆典会展租赁',NULL,NULL),('q8bklu8vgkt8','q8bklu8v','服装租赁',NULL,NULL),('q8bklu8vgo5g','q8bklu8v','家具租赁',NULL,NULL),('q8bklu8vuatb','q8bklu8v','空调租赁',NULL,NULL),('q8bklu8vogiz','q8bklu8v','户外装备租赁',NULL,NULL),('q8bklu8v7ikd','q8bklu8v','移动厕所租赁',NULL,NULL),('q8bkbhw3k2oc','q8bkbhw3','PVC卡',NULL,NULL),('q8bkbhw3zixq','q8bkbhw3','智能卡',NULL,NULL),('q8bkbhw3pxxt','q8bkbhw3','电子标签',NULL,NULL),('q8bkbhw3svs9','q8bkbhw3','纸卡',NULL,NULL),('q8bkbhw3z3iv','q8bkbhw3','金属卡',NULL,NULL),('q8bkbhw3w3cv','q8bkbhw3','磁条卡',NULL,NULL),('q8bkbhw37mky','q8bkbhw3','滴胶卡',NULL,NULL),('q8bkgp4po16r','q8bkgp4p','打印机维修',NULL,NULL),('q8bkgp4pauza','q8bkgp4p','复印机维修',NULL,NULL),('q8bkgp4plc1s','q8bkgp4p','传真机维修',NULL,NULL),('q8bkgp4p15h8','q8bkgp4p','印刷机维修',NULL,NULL),('q8bkgp4pddws','q8bkgp4p','绘图仪维修',NULL,NULL),('q8bkgp4p52ro','q8bkgp4p','喷码机维修',NULL,NULL),('q8bkgp4pcl6n','q8bkgp4p','集团电话',NULL,NULL),('q8bkgp4ppp4f','q8bkgp4p','投影机维修',NULL,NULL),('q8bkgp4p1sos','q8bkgp4p','LED显示屏/触摸屏',NULL,NULL),('q8bkgp4p2wa6','q8bkgp4p','广播系统监控/门禁',NULL,NULL),('q8bkgp4p8gz3','q8bkgp4p','视频/音频',NULL,NULL),('q8bkgp4pfpl6','q8bkgp4p','安防系统',NULL,NULL),('q8bkgp4p6qnk','q8bkgp4p','扫描仪',NULL,NULL),('q8bkgp4pi6xb','q8bkgp4p','考勤机',NULL,NULL),('q8bkgp4pnldr','q8bkgp4p','一体机',NULL,NULL),('q8bkvmmzxwxf','q8bkvmmz','展会庆典策划',NULL,NULL),('q8bkvmmzg9ip','q8bkvmmz','展位设计',NULL,NULL),('q8bkvmmz07s8','q8bkvmmz','展会布置/搭建',NULL,NULL),('q8bkvmmzvi43','q8bkvmmz','展会用品制作',NULL,NULL),('q8bkvmmznd8z','q8bkvmmz','摄影摄像',NULL,NULL),('q8bkizlgz91d','q8bkizlg','数码电子',NULL,NULL),('q8bkizlg28d7','q8bkizlg','杯子茶具',NULL,NULL),('q8bkizlg3q3s','q8bkizlg','文具本册',NULL,NULL),('q8bkizlg1xvw','q8bkizlg','箱包皮具',NULL,NULL),('q8bkizlg2qnn','q8bkizlg','服装',NULL,NULL),('q8bkizlg901k','q8bkizlg','家居家纺',NULL,NULL),('q8bkizlgndos','q8bkizlg','汽车/户外',NULL,NULL),('q8bkizlggt88','q8bkizlg','运动健康',NULL,NULL),('q8bkizlgyxff','q8bkizlg','小家电',NULL,NULL),('q8bkizlggi2y','q8bkizlg','工艺品',NULL,NULL),('q8bkizlguizp','q8bkizlg','奖杯证书',NULL,NULL),('q8bkzr7qh5a5','q8bkzr7q','打井',NULL,NULL),('q8bkzr7q6hg4','q8bkzr7q','高空防腐',NULL,NULL),('q8bkzr7qbkwi','q8bkzr7q','专业破碎',NULL,NULL),('q8bkzr7q56g3','q8bkzr7q','抗震加固',NULL,NULL),('q8bkzr7qm62b','q8bkzr7q','基础灌浆',NULL,NULL),('q8bkzr7qgdgc','q8bkzr7q','化学锚栓',NULL,NULL),('q8bkzr7q0pkz','q8bkzr7q','植筋加固',NULL,NULL),('q8bkzr7ql1o1','q8bkzr7q','桥梁加固',NULL,NULL),('q8bkzr7qy798','q8bkzr7q','专业拆除',NULL,NULL),('q8bkzr7q1kfw','q8bkzr7q','碳纤维加固',NULL,NULL);
/*!40000 ALTER TABLE `business_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `certificate`
--

DROP TABLE IF EXISTS `certificate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `certificate` (
  `id` bigint(20) NOT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `certificate`
--

LOCK TABLES `certificate` WRITE;
/*!40000 ALTER TABLE `certificate` DISABLE KEYS */;
INSERT INTO `certificate` VALUES (14405972390321,14398261056801,'2015-08-03','人证n',NULL);
/*!40000 ALTER TABLE `certificate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `city`
--

DROP TABLE IF EXISTS `city`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `city` (
  `id` varchar(255) NOT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `name_py` varchar(255) DEFAULT NULL,
  `name_pj` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES ('86010','0','北京',NULL,NULL,'123456'),('86021','0','上海',NULL,NULL,'123456'),('86022','0','天津',NULL,NULL,'123456'),('86023','0','重庆',NULL,NULL,'123456'),('860201','0','广东',NULL,NULL,'123456'),('860281','0','四川',NULL,NULL,'123456'),('8605710','0','浙江',NULL,NULL,'123456'),('8608510','0','贵州',NULL,NULL,'123456'),('860240','0','辽宁',NULL,NULL,'123456'),('860250','0','江苏',NULL,NULL,'123456'),('8605910','0','福建',NULL,NULL,'123456'),('8603110','0','河北',NULL,NULL,'123456'),('8603700','0','河南',NULL,NULL,'123456'),('8604310','0','吉林',NULL,NULL,'123456'),('8604510','0','黑龙江',NULL,NULL,'123456'),('8605320','0','山东',NULL,NULL,'123456'),('2300000','0','安徽',NULL,NULL,'123456'),('5300000','0','广西',NULL,NULL,'123456'),('8608980','0','海南',NULL,NULL,'123456'),('860471','0','内蒙古',NULL,NULL,'123456'),('860349','0','山西',NULL,NULL,'123456'),('8609510','0','宁夏',NULL,NULL,'123456'),('860931','0','甘肃',NULL,NULL,'123456'),('860290','0','陕西',NULL,NULL,'123456'),('860977','0','青海',NULL,NULL,'123456'),('860270','0','湖北',NULL,NULL,'123456'),('860731','0','湖南',NULL,NULL,'123456'),('860791','0','江西',NULL,NULL,'123456'),('8608710','0','云南',NULL,NULL,'123456'),('860991','0','新疆',NULL,NULL,'123456'),('860891','0','西藏',NULL,NULL,'123456'),('8600852','0','香港',NULL,NULL,'123456'),('8600853','0','澳门',NULL,NULL,'123456'),('518000','860201','深圳',NULL,NULL,'123456'),('510000','860201','广州',NULL,NULL,'123456'),('523000','860201','东莞',NULL,NULL,'123456'),('528000','860201','佛山',NULL,NULL,'123456'),('528400','860201','中山',NULL,NULL,'123456'),('519000','860201','珠海',NULL,NULL,'123456'),('516000','860201','惠州',NULL,NULL,'123456'),('529000','860201','江门',NULL,NULL,'123456'),('515000','860201','汕头',NULL,NULL,'123456'),('524000','860201','湛江',NULL,NULL,'123456'),('526000','860201','肇庆',NULL,NULL,'123456'),('525000','860201','茂名',NULL,NULL,'123456'),('522000','860201','揭阳',NULL,NULL,'123456'),('514000','860201','梅州',NULL,NULL,'123456'),('511500','860201','清远',NULL,NULL,'123456'),('529500','860201','阳江',NULL,NULL,'123456'),('512000','860201','韶关',NULL,NULL,'123456'),('517000','860201','河源',NULL,NULL,'123456'),('527300','860201','云浮',NULL,NULL,'123456'),('516600','860201','汕尾',NULL,NULL,'123456'),('521000','860201','潮州',NULL,NULL,'123456'),('529200','860201','台山',NULL,NULL,'123456'),('529600','860201','阳春',NULL,NULL,'123456'),('528300','860201','顺德',NULL,NULL,'123456'),('610000','860281','成都',NULL,NULL,'123456'),('621000','860281','绵阳',NULL,NULL,'123456'),('618000','860281','德阳',NULL,NULL,'123456'),('637000','860281','南充',NULL,NULL,'123456'),('644000','860281','宜宾',NULL,NULL,'123456'),('643000','860281','自贡',NULL,NULL,'123456'),('614000','860281','乐山',NULL,NULL,'123456'),('646000','860281','泸州',NULL,NULL,'123456'),('635000','860281','达州',NULL,NULL,'123456'),('641000','860281','内江',NULL,NULL,'123456'),('629000','860281','遂宁',NULL,NULL,'123456'),('617000','860281','攀枝花',NULL,NULL,'123456'),('620000','860281','眉山',NULL,NULL,'123456'),('638500','860281','广安',NULL,NULL,'123456'),('641300','860281','资阳',NULL,NULL,'123456'),('615000','860281','凉山',NULL,NULL,'123456'),('628000','860281','广元',NULL,NULL,'123456'),('625000','860281','雅安',NULL,NULL,'123456'),('636600','860281','巴中',NULL,NULL,'123456'),('624000','860281','阿坝',NULL,NULL,'123456'),('626000','860281','甘孜',NULL,NULL,'123456'),('310000','8605710','杭州',NULL,NULL,'123456'),('315000','8605710','宁波',NULL,NULL,'123456'),('325000','8605710','温州',NULL,NULL,'123456'),('321000','8605710','金华',NULL,NULL,'123456'),('314000','8605710','嘉兴',NULL,NULL,'123456'),('318000','8605710','台州',NULL,NULL,'123456'),('312000','8605710','绍兴',NULL,NULL,'123456'),('313000','8605710','湖州',NULL,NULL,'123456'),('323000','8605710','丽水',NULL,NULL,'123456'),('324000','8605710','衢州',NULL,NULL,'123456'),('316000','8605710','舟山',NULL,NULL,'123456'),('325600','8605710','乐清',NULL,NULL,'123456'),('325200','8605710','瑞安',NULL,NULL,'123456'),('322000','8605710','义乌',NULL,NULL,'123456'),('550000','8608510','贵阳',NULL,NULL,'123456'),('563000','8608510','遵义',NULL,NULL,'123456'),('556000','8608510','黔东南',NULL,NULL,'123456'),('558000','8608510','黔南',NULL,NULL,'123456'),('553000','8608510','六盘水',NULL,NULL,'123456'),('551700','8608510','毕节',NULL,NULL,'123456'),('554300','8608510','铜仁',NULL,NULL,'123456'),('561000','8608510','安顺',NULL,NULL,'123456'),('562400','8608510','黔西南',NULL,NULL,'123456'),('110000','860240','沈阳',NULL,NULL,'123456'),('116000','860240','大连',NULL,NULL,'123456'),('114000','860240','鞍山',NULL,NULL,'123456'),('121000','860240','锦州',NULL,NULL,'123456'),('113000','860240','抚顺',NULL,NULL,'123456'),('115000','860240','营口',NULL,NULL,'123456'),('124000','860240','盘锦',NULL,NULL,'123456'),('122000','860240','朝阳',NULL,NULL,'123456'),('118000','860240','丹东',NULL,NULL,'123456'),('111000','860240','辽阳',NULL,NULL,'123456'),('117000','860240','本溪',NULL,NULL,'123456'),('125000','860240','葫芦岛',NULL,NULL,'123456'),('112000','860240','铁岭',NULL,NULL,'123456'),('123000','860240','阜新',NULL,NULL,'123456'),('116400','860240','庄河',NULL,NULL,'123456'),('116300','860240','瓦房店',NULL,NULL,'123456'),('215000','860250','苏州',NULL,NULL,'123456'),('210000','860250','南京',NULL,NULL,'123456'),('214000','860250','无锡',NULL,NULL,'123456'),('213000','860250','常州',NULL,NULL,'123456'),('221000','860250','徐州',NULL,NULL,'123456'),('226000','860250','南通',NULL,NULL,'123456'),('225000','860250','扬州',NULL,NULL,'123456'),('224000','860250','盐城',NULL,NULL,'123456'),('223001','860250','淮安',NULL,NULL,'123456'),('222000','860250','连云港',NULL,NULL,'123456'),('225300','860250','泰州',NULL,NULL,'123456'),('223800','860250','宿迁',NULL,NULL,'123456'),('212000','860250','镇江',NULL,NULL,'123456'),('223600','860250','沭阳',NULL,NULL,'123456'),('224100','860250','大丰',NULL,NULL,'123456'),('350000','8605910','福州',NULL,NULL,'123456'),('361000','8605910','厦门',NULL,NULL,'123456'),('362000','8605910','泉州',NULL,NULL,'123456'),('351100','8605910','莆田',NULL,NULL,'123456'),('363000','8605910','漳州',NULL,NULL,'123456'),('352000','8605910','宁德',NULL,NULL,'123456'),('365000','8605910','三明',NULL,NULL,'123456'),('353000','8605910','南平',NULL,NULL,'123456'),('364000','8605910','龙岩',NULL,NULL,'123456'),('354300','8605910','武夷山',NULL,NULL,'123456'),('50000','8603110','石家庄',NULL,NULL,'123456'),('71000','8603110','保定',NULL,NULL,'123456'),('63000','8603110','唐山',NULL,NULL,'123456'),('65000','8603110','廊坊',NULL,NULL,'123456'),('56000','8603110','邯郸',NULL,NULL,'123456'),('66000','8603110','秦皇岛',NULL,NULL,'123456'),('61000','8603110','沧州',NULL,NULL,'123456'),('54000','8603110','邢台',NULL,NULL,'123456'),('53000','8603110','衡水',NULL,NULL,'123456'),('75000','8603110','张家口',NULL,NULL,'123456'),('67000','8603110','承德',NULL,NULL,'123456'),('73000','8603110','定州',NULL,NULL,'123456'),('57750','8603110','馆陶',NULL,NULL,'123456'),('76450','8603110','张北',NULL,NULL,'123456'),('51530','8603110','赵县',NULL,NULL,'123456'),('50800','8603110','正定',NULL,NULL,'123456'),('450000','8603700','郑州',NULL,NULL,'123456'),('471000','8603700','洛阳',NULL,NULL,'123456'),('453000','8603700','新乡',NULL,NULL,'123456'),('473000','8603700','南阳',NULL,NULL,'123456'),('461000','8603700','许昌',NULL,NULL,'123456'),('467000','8603700','平顶山',NULL,NULL,'123456'),('455000','8603700','安阳',NULL,NULL,'123456'),('454150','8603700','焦作',NULL,NULL,'123456'),('476000','8603700','商丘',NULL,NULL,'123456'),('475000','8603700','开封',NULL,NULL,'123456'),('457000','8603700','濮阳',NULL,NULL,'123456'),('466000','8603700','周口',NULL,NULL,'123456'),('464000','8603700','信阳',NULL,NULL,'123456'),('463000','8603700','驻马店',NULL,NULL,'123456'),('462000','8603700','漯河',NULL,NULL,'123456'),('472000','8603700','三门峡',NULL,NULL,'123456'),('458000','8603700','鹤壁',NULL,NULL,'123456'),('454650','8603700','济源',NULL,NULL,'123456'),('464094','8603700','明港',NULL,NULL,'123456'),('461200','8603700','鄢陵',NULL,NULL,'123456'),('461670','8603700','禹州',NULL,NULL,'123456'),('461500','8603700','长葛',NULL,NULL,'123456'),('130000','8604310','长春',NULL,NULL,'123456'),('132000','8604310','吉林',NULL,NULL,'123456'),('136000','8604310','四平',NULL,NULL,'123456'),('133000','8604310','延边',NULL,NULL,'123456'),('138000','8604310','松原',NULL,NULL,'123456'),('137000','8604310','白城',NULL,NULL,'123456'),('134000','8604310','通化',NULL,NULL,'123456'),('134300','8604310','白山',NULL,NULL,'123456'),('136200','8604310','辽源',NULL,NULL,'123456'),('150000','8604510','哈尔滨',NULL,NULL,'123456'),('163000','8604510','大庆',NULL,NULL,'123456'),('161000','8604510','齐齐哈尔',NULL,NULL,'123456'),('157000','8604510','牡丹江',NULL,NULL,'123456'),('152000','8604510','绥化',NULL,NULL,'123456'),('154000','8604510','佳木斯',NULL,NULL,'123456'),('158100','8604510','鸡西',NULL,NULL,'123456'),('155100','8604510','双鸭山',NULL,NULL,'123456'),('154100','8604510','鹤岗',NULL,NULL,'123456'),('164300','8604510','黑河',NULL,NULL,'123456'),('153000','8604510','伊春',NULL,NULL,'123456'),('154600','8604510','七台河',NULL,NULL,'123456'),('165000','8604510','大兴安岭',NULL,NULL,'123456'),('266000','8605320','青岛',NULL,NULL,'123456'),('250000','8605320','济南',NULL,NULL,'123456'),('264000','8605320','烟台',NULL,NULL,'123456'),('261000','8605320','潍坊',NULL,NULL,'123456'),('276000','8605320','临沂',NULL,NULL,'123456'),('255000','8605320','淄博',NULL,NULL,'123456'),('272000','8605320','济宁',NULL,NULL,'123456'),('271000','8605320','泰安',NULL,NULL,'123456'),('252000','8605320','聊城',NULL,NULL,'123456'),('264200','8605320','威海',NULL,NULL,'123456'),('277000','8605320','枣庄',NULL,NULL,'123456'),('253000','8605320','德州',NULL,NULL,'123456'),('276800','8605320','日照',NULL,NULL,'123456'),('257000','8605320','东营',NULL,NULL,'123456'),('274000','8605320','菏泽',NULL,NULL,'123456'),('256600','8605320','滨州',NULL,NULL,'123456'),('271100','8605320','莱芜',NULL,NULL,'123456'),('250200','8605320','章丘',NULL,NULL,'123456'),('257500','8605320','垦利',NULL,NULL,'123456'),('262200','8605320','诸城',NULL,NULL,'123456'),('230000','2300000','合肥',NULL,NULL,'123456'),('241000','2300000','芜湖',NULL,NULL,'123456'),('233000','2300000','蚌埠',NULL,NULL,'123456'),('236000','2300000','阜阳',NULL,NULL,'123456'),('232000','2300000','淮南',NULL,NULL,'123456'),('246000','2300000','安庆',NULL,NULL,'123456'),('234000','2300000','宿州',NULL,NULL,'123456'),('237000','2300000','六安',NULL,NULL,'123456'),('235000','2300000','淮北',NULL,NULL,'123456'),('239000','2300000','滁州',NULL,NULL,'123456'),('243000','2300000','马鞍山',NULL,NULL,'123456'),('244000','2300000','铜陵',NULL,NULL,'123456'),('242000','2300000','宣城',NULL,NULL,'123456'),('236800','2300000','亳州',NULL,NULL,'123456'),('242700','2300000','黄山',NULL,NULL,'123456'),('247100','2300000','池州',NULL,NULL,'123456'),('238000','2300000','巢湖',NULL,NULL,'123456'),('238200','2300000','和县',NULL,NULL,'123456'),('237400','2300000','霍邱',NULL,NULL,'123456'),('231400','2300000','桐城',NULL,NULL,'123456'),('530000','5300000','南宁',NULL,NULL,'123456'),('545000','5300000','柳州',NULL,NULL,'123456'),('541000','5300000','桂林',NULL,NULL,'123456'),('537000','5300000','玉林',NULL,NULL,'123456'),('543000','5300000','梧州',NULL,NULL,'123456'),('536000','5300000','北海',NULL,NULL,'123456'),('537100','5300000','贵港',NULL,NULL,'123456'),('535000','5300000','钦州',NULL,NULL,'123456'),('533000','5300000','百色',NULL,NULL,'123456'),('547000','5300000','河池',NULL,NULL,'123456'),('546100','5300000','来宾',NULL,NULL,'123456'),('542800','5300000','贺州',NULL,NULL,'123456'),('538000','5300000','防城港',NULL,NULL,'123456'),('532200','5300000','崇左',NULL,NULL,'123456'),('570100','8608980','海口',NULL,NULL,'123456'),('572000','8608980','三亚',NULL,NULL,'123456'),('572200','8608980','五指山',NULL,NULL,'123456'),('573100','8608980','三沙',NULL,NULL,'123456'),('571400','8608980','琼海',NULL,NULL,'123456'),('10000','860471','呼和浩特',NULL,NULL,'123456'),('14000','860471','包头',NULL,NULL,'123456'),('24000','860471','赤峰',NULL,NULL,'123456'),('17000','860471','鄂尔多斯',NULL,NULL,'123456'),('28000','860471','通辽',NULL,NULL,'123456'),('21000','860471','呼伦贝尔',NULL,NULL,'123456'),('15000','860471','巴彦淖尔市',NULL,NULL,'123456'),('12000','860471','乌兰察布',NULL,NULL,'123456'),('26000','860471','锡林郭勒盟',NULL,NULL,'123456'),('137400','860471','兴安盟',NULL,NULL,'123456'),('16000','860471','乌海',NULL,NULL,'123456'),('750300','860471','阿拉善盟',NULL,NULL,'123456'),('21008','860471','海拉尔',NULL,NULL,'123456'),('30000','860349','太原',NULL,NULL,'123456'),('41000','860349','临汾',NULL,NULL,'123456'),('37000','860349','大同',NULL,NULL,'123456'),('44000','860349','运城',NULL,NULL,'123456'),('30600','860349','晋中',NULL,NULL,'123456'),('46000','860349','长治',NULL,NULL,'123456'),('48000','860349','晋城',NULL,NULL,'123456'),('45000','860349','阳泉',NULL,NULL,'123456'),('33000','860349','吕梁',NULL,NULL,'123456'),('34000','860349','忻州',NULL,NULL,'123456'),('36000','860349','朔州',NULL,NULL,'123456'),('44100','860349','临猗',NULL,NULL,'123456'),('30400','860349','清徐',NULL,NULL,'123456'),('750000','8609510','银川',NULL,NULL,'123456'),('751100','8609510','吴忠',NULL,NULL,'123456'),('753000','8609510','石嘴山',NULL,NULL,'123456'),('755000','8609510','中卫',NULL,NULL,'123456'),('756000','8609510','固原',NULL,NULL,'123456'),('730000','860931','兰州',NULL,NULL,'123456'),('741000','860931','天水',NULL,NULL,'123456'),('730900','860931','白银',NULL,NULL,'123456'),('745000','860931','庆阳',NULL,NULL,'123456'),('744000','860931','平凉',NULL,NULL,'123456'),('735000','860931','酒泉',NULL,NULL,'123456'),('734000','860931','张掖',NULL,NULL,'123456'),('733000','860931','武威',NULL,NULL,'123456'),('743000','860931','定西',NULL,NULL,'123456'),('737100','860931','金昌',NULL,NULL,'123456'),('742500','860931','陇南',NULL,NULL,'123456'),('731100','860931','临夏',NULL,NULL,'123456'),('735100','860931','嘉峪关',NULL,NULL,'123456'),('747000','860931','甘南',NULL,NULL,'123456'),('710000','860290','西安',NULL,NULL,'123456'),('712000','860290','咸阳',NULL,NULL,'123456'),('721000','860290','宝鸡',NULL,NULL,'123456'),('714000','860290','渭南',NULL,NULL,'123456'),('723000','860290','汉中',NULL,NULL,'123456'),('719000','860290','榆林',NULL,NULL,'123456'),('716000','860290','延安',NULL,NULL,'123456'),('725000','860290','安康',NULL,NULL,'123456'),('726000','860290','商洛',NULL,NULL,'123456'),('727000','860290','铜川',NULL,NULL,'123456'),('810000','860977','西宁',NULL,NULL,'123456'),('817000','860977','海西',NULL,NULL,'123456'),('812200','860977','海北',NULL,NULL,'123456'),('814000','860977','果洛',NULL,NULL,'123456'),('810600','860977','海东',NULL,NULL,'123456'),('811300','860977','黄南',NULL,NULL,'123456'),('815000','860977','玉树',NULL,NULL,'123456'),('813000','860977','海南',NULL,NULL,'123456'),('430000','860270','武汉',NULL,NULL,'123456'),('443000','860270','宜昌',NULL,NULL,'123456'),('441000','860270','襄阳',NULL,NULL,'123456'),('434000','860270','荆州',NULL,NULL,'123456'),('442000','860270','十堰',NULL,NULL,'123456'),('435000','860270','黄石',NULL,NULL,'123456'),('432000','860270','孝感',NULL,NULL,'123456'),('438000','860270','黄冈',NULL,NULL,'123456'),('445000','860270','恩施',NULL,NULL,'123456'),('448000','860270','荆门',NULL,NULL,'123456'),('437000','860270','咸宁',NULL,NULL,'123456'),('436000','860270','鄂州',NULL,NULL,'123456'),('441300','860270','随州',NULL,NULL,'123456'),('433100','860270','潜江',NULL,NULL,'123456'),('431700','860270','天门',NULL,NULL,'123456'),('433000','860270','仙桃',NULL,NULL,'123456'),('442400','860270','神农架',NULL,NULL,'123456'),('410000','860731','长沙',NULL,NULL,'123456'),('412000','860731','株洲',NULL,NULL,'123456'),('413000','860731','益阳',NULL,NULL,'123456'),('415000','860731','常德',NULL,NULL,'123456'),('421000','860731','衡阳',NULL,NULL,'123456'),('411100','860731','湘潭',NULL,NULL,'123456'),('414000','860731','岳阳',NULL,NULL,'123456'),('423000','860731','郴州',NULL,NULL,'123456'),('422000','860731','邵阳',NULL,NULL,'123456'),('418000','860731','怀化',NULL,NULL,'123456'),('425000','860731','永州',NULL,NULL,'123456'),('417000','860731','娄底',NULL,NULL,'123456'),('416000','860731','湘西',NULL,NULL,'123456'),('427000','860731','张家界',NULL,NULL,'123456'),('330000','860791','南昌',NULL,NULL,'123456'),('341000','860791','赣州',NULL,NULL,'123456'),('332000','860791','九江',NULL,NULL,'123456'),('336000','860791','宜春',NULL,NULL,'123456'),('343000','860791','吉安',NULL,NULL,'123456'),('334000','860791','上饶',NULL,NULL,'123456'),('337000','860791','萍乡',NULL,NULL,'123456'),('344000','860791','抚州',NULL,NULL,'123456'),('333000','860791','景德镇',NULL,NULL,'123456'),('338000','860791','新余',NULL,NULL,'123456'),('335000','860791','鹰潭',NULL,NULL,'123456'),('343400','860791','永新',NULL,NULL,'123456'),('650000','8608710','昆明',NULL,NULL,'123456'),('655000','8608710','曲靖',NULL,NULL,'123456'),('671000','8608710','大理',NULL,NULL,'123456'),('661400','8608710','红河',NULL,NULL,'123456'),('653100','8608710','玉溪',NULL,NULL,'123456'),('674100','8608710','丽江',NULL,NULL,'123456'),('663000','8608710','文山',NULL,NULL,'123456'),('675000','8608710','楚雄',NULL,NULL,'123456'),('666100','8608710','西双版纳',NULL,NULL,'123456'),('657000','8608710','昭通',NULL,NULL,'123456'),('678400','8608710','德宏',NULL,NULL,'123456'),('665000','8608710','普洱',NULL,NULL,'123456'),('678000','8608710','保山',NULL,NULL,'123456'),('677000','8608710','临沧',NULL,NULL,'123456'),('674400','8608710','迪庆',NULL,NULL,'123456'),('673100','8608710','怒江',NULL,NULL,'123456'),('830000','860991','乌鲁木齐',NULL,NULL,'123456'),('831100','860991','昌吉',NULL,NULL,'123456'),('841000','860991','巴音郭楞',NULL,NULL,'123456'),('835000','860991','伊犁',NULL,NULL,'123456'),('843000','860991','阿克苏',NULL,NULL,'123456'),('844000','860991','喀什',NULL,NULL,'123456'),('839000','860991','哈密',NULL,NULL,'123456'),('834000','860991','克拉玛依',NULL,NULL,'123456'),('833400','860991','博尔塔拉',NULL,NULL,'123456'),('838000','860991','吐鲁番',NULL,NULL,'123456'),('848000','860991','和田',NULL,NULL,'123456'),('832000','860991','石河子',NULL,NULL,'123456'),('844305','860991','克孜勒苏',NULL,NULL,'123456'),('843300','860991','阿拉尔',NULL,NULL,'123456'),('831300','860991','五家渠',NULL,NULL,'123456'),('843900','860991','图木舒克',NULL,NULL,'123456'),('841005','860991','库尔勒',NULL,NULL,'123456'),('850000','860891','拉萨',NULL,NULL,'123456'),('857000','860891','日喀则',NULL,NULL,'123456'),('856100','860891','山南',NULL,NULL,'123456'),('860100','860891','林芝',NULL,NULL,'123456'),('854000','860891','昌都',NULL,NULL,'123456'),('852000','860891','那曲',NULL,NULL,'123456'),('859000','860891','阿里',NULL,NULL,'123456'),('100027','86010','东城区',NULL,NULL,'123456'),('100029','86010','西城区',NULL,NULL,'123456'),('100093','86010','海淀区',NULL,NULL,'123456'),('100020','86010','朝阳区',NULL,NULL,'123456'),('100039','86010','丰台区',NULL,NULL,'123456'),('100041','86010','石景山区',NULL,NULL,'123456'),('10085','86010','昌平区',NULL,NULL,'123456'),('101300','86010','顺义区',NULL,NULL,'123456'),('101400','86010','怀柔区',NULL,NULL,'123456'),('101200','86010','平谷区',NULL,NULL,'123456'),('101100','86010','通州区',NULL,NULL,'123456'),('102600','86010','大兴区',NULL,NULL,'123456'),('102400','86010','房山区',NULL,NULL,'123456'),('102300','86010','门头沟区',NULL,NULL,'123456'),('102100','86010','延庆县',NULL,NULL,'123456'),('101500','86010','密云县',NULL,NULL,'123456'),('200050','86021','长宁区',NULL,NULL,'123456'),('201900','86021','宝山区',NULL,NULL,'123456'),('201700','86021','青浦区',NULL,NULL,'123456'),('200001','86021','黄浦区',NULL,NULL,'123456'),('200333','86021','普陀区',NULL,NULL,'123456'),('201100','86021','闵行区',NULL,NULL,'123456'),('201400','86021','奉贤区',NULL,NULL,'123456'),('200020','86021','卢湾区',NULL,NULL,'123456'),('200070','86021','闸北区',NULL,NULL,'123456'),('201800','86021','嘉定区',NULL,NULL,'123456'),('200040','86021','静安区',NULL,NULL,'123456'),('200080','86021','虹口区',NULL,NULL,'123456'),('201500','86021','金山区',NULL,NULL,'123456'),('200030','86021','徐汇区',NULL,NULL,'123456'),('200082','86021','杨浦区',NULL,NULL,'123456'),('201600','86021','松江区',NULL,NULL,'123456'),('202150','86021','崇明县',NULL,NULL,'123456');
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `company` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `industry_id` varchar(1000) DEFAULT NULL,
  `is_intermediary` varchar(1000) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `welfares` varchar(1000) DEFAULT NULL,
  `linkman` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  `map_ponit` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES (14412819591444,14384506219094,'北京个','gvn845ld','0',3,2,'这里是简介','北京市朝阳区草房-地铁站','五险一金,包吃,包住','刘璇生','18610814074','190080329@qq.com','www.dbdbd.cn','{\"lng\":116.621774,\"lat\":39.931165}');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `education_experience`
--

DROP TABLE IF EXISTS `education_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `education_experience` (
  `id` bigint(20) NOT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `school` varchar(45) DEFAULT NULL,
  `professional` varchar(45) DEFAULT NULL,
  `degree` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `education_experience`
--

LOCK TABLES `education_experience` WRITE;
/*!40000 ALTER TABLE `education_experience` DISABLE KEYS */;
INSERT INTO `education_experience` VALUES (14405588011031,14398261056801,'2015-07-27','2015-08-28','长春理工大学','生物',5),(14462580295862,14462559627802,'2008-09-01','2012-06-01','南阳理工学院','计算机网络',5),(14462654983464,14462652041472,'2013-04-01','2015-10-30','山东广播电视大学','计算机工程',4);
/*!40000 ALTER TABLE `education_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expand`
--

DROP TABLE IF EXISTS `expand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `expand` (
  `id` bigint(20) NOT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expand`
--

LOCK TABLES `expand` WRITE;
/*!40000 ALTER TABLE `expand` DISABLE KEYS */;
INSERT INTO `expand` VALUES (14406601083541,14398261056801,'fgdsg','sdgsdgsdgbbbbnnn');
/*!40000 ALTER TABLE `expand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `industry`
--

DROP TABLE IF EXISTS `industry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `industry` (
  `id` varchar(255) NOT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `industry`
--

LOCK TABLES `industry` WRITE;
/*!40000 ALTER TABLE `industry` DISABLE KEYS */;
INSERT INTO `industry` VALUES ('p37uhi9a','p37u','农/林/牧/渔'),('gvn8','0','金融业'),('dbug','0','IT丨通信丨互联网'),('28d0','0','房地产丨建筑'),('qdz3','0','商业服务'),('qchq','0','贸易丨批发丨零售丨租赁'),('hr44','0','文体教育丨艺术美术'),('15ce','0','生产丨加工丨制造'),('3gkx','0','交通丨运输丨物流丨仓运'),('cop3','0','服务业'),('if08','0','文化丨传媒丨娱乐丨体育'),('9z9q','0','能源丨矿产丨环保'),('0h37','0','政府丨非盈利机构'),('p37u','0','农丨林丨牧丨渔丨其他'),('p37uhkmi','p37u','宽领域经营'),('p37ul0ep','p37u','其他'),('nullmbz5',NULL,NULL),('gvn845ld','gvn8','基金/证券/期货/投资'),('gvn875d4','gvn8','保险'),('gvn8dgch','gvn8','银行'),('gvn8id0a','gvn8','信托/担保/拍卖/典当'),('dbugpd5h','dbug','互联网/电子商务'),('dbugg1we','dbug','计算机软件'),('dbugoazk','dbug','IT服务(系统/数据/维护)'),('dbugd0zm','dbug','电子技术/半导体/集成电路'),('dbugsfnb','dbug','计算机硬件'),('dbugayrn','dbug','通信/电信/网络设备'),('dbugsuog','dbug','通信/电信运行/增值服务'),('dbuglvqn','dbug','网络游戏'),('28d05vma','28d0','房地产/建筑/建材/工程'),('28d09tdo','28d0','家具/室内设计/装饰装潢'),('28d0ys3k','28d0','物业管理/商业中心'),('qdz3zwx0','qdz3','专业服务/咨询(财会/法律/人力资源等)'),('qdz37eo3','qdz3','广告/会展/公关'),('qdz3kvy1','qdz3','中介服务'),('qdz35iwv','qdz3','检验/检测/认证'),('qdz3f5ld','qdz3','外包服务'),('qchqbvt4','qchq','贸易/进出口'),('qchqt3cd','qchq','零售/批发'),('qchqtew0','qchq','快速消费品(食品/饮料/烟酒/日化)'),('qchqft8l','qchq','耐用消费品(服饰/纺织/皮革/家具/家电)'),('qchqgggy','qchq','租赁服务'),('hr4420hx','hr44','教育/培训/院校'),('hr44o7hq','hr44','礼品/玩具/工艺美术/收藏品/奢侈品'),('15cednf8','15ce','汽车/摩托车'),('15cezvf2','15ce','大型设备/机电设备/重工业'),('15cewp2t','15ce','加工制造(原料加工/模具)'),('15ceng88','15ce','仪器仪表及工业自动化'),('15ced2zu','15ce','印刷/包装/造纸'),('15cey2qv','15ce','办公用品及设备'),('15cea73i','15ce','医药/生物工程'),('15cec4dx','15ce','医疗设备/器械'),('15ce4ayi','15ce','航空/航天研究与制造'),('3gkx6zsm','3gkx','交通/运输'),('3gkxm59g','3gkx','物流/仓储'),('cop3o1k3','cop3','医疗/护理/美容/保健/卫生服务'),('cop3v95l','cop3','酒店/餐饮'),('cop3papk','cop3','旅游/度假'),('if08muxg','if08','媒体/出版/影视/文化传播'),('if08mbxa','if08','娱乐/体育/休闲'),('9z9qotq7','9z9q','能源/矿产/采掘/冶炼'),('9z9qnzzd','9z9q','石油/石化/化工'),('9z9qr0gr','9z9q','电气/电力/水利'),('9z9qo36d','9z9q','环保'),('0h3798pk','0h37','政府/公共事业/非盈利机构'),('0h37req6','0h37','学术/科研'),('nullfagh',NULL,NULL);
/*!40000 ALTER TABLE `industry` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `interview` (
  `id` bigint(20) NOT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `content` text,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES (14564773606181,14414681159622,14406795598701,'ggdfgdfg','2016-02-26 17:02:40','2016-02-26 17:02:40');
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `city_id` varchar(1000) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `industry_id` varchar(255) DEFAULT NULL,
  `position_id` varchar(255) DEFAULT NULL,
  `content` text,
  `number` int(11) DEFAULT NULL,
  `education` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `contacts` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `company_id` bigint(20) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `work_years` int(11) DEFAULT NULL,
  `visible` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (14414681159622,14384506219094,'644000','这是职位名称','gvn8dgch','gzv7vwbzrrl2',NULL,1,3,2,'bbbb\r\nbbb\r\nbbb','连心园小区','llllll','18676650750',NULL,'liufeng45gh@163.com','2015-09-05 23:48:36','2015-09-05 23:48:36',4,0);
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_apply`
--

DROP TABLE IF EXISTS `job_apply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_apply` (
  `id` bigint(20) NOT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  `is_ignore` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_apply`
--

LOCK TABLES `job_apply` WRITE;
/*!40000 ALTER TABLE `job_apply` DISABLE KEYS */;
INSERT INTO `job_apply` VALUES (14563676976891,14414681159622,14406795598701,'2016-02-25 10:35:04','2016-02-25 10:35:04',0),(14563679483242,14414681159622,14406795598701,'2016-02-25 10:39:14','2016-02-25 10:39:14',0),(14563679999763,14414681159622,14406795598701,'2016-02-25 10:40:06','2016-02-25 10:40:06',1),(14563680040894,14414681159622,14402370104351,'2016-02-25 10:40:10','2016-02-25 10:40:10',0),(14563681163865,14414681159622,14406795598701,'2016-02-25 10:42:03','2016-02-25 10:42:03',0);
/*!40000 ALTER TABLE `job_apply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_experience`
--

DROP TABLE IF EXISTS `job_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_experience` (
  `id` bigint(20) NOT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `job` varchar(45) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_experience`
--

LOCK TABLES `job_experience` WRITE;
/*!40000 ALTER TABLE `job_experience` DISABLE KEYS */;
INSERT INTO `job_experience` VALUES (14403272975812,14398261056801,'2015-08-13','2015-08-19','北京旭宁信息技术有限公司','ios开发工程师','gsagadsfgdsfag密密麻麻吗',0),(14406796078942,14406795598701,'2015-08-10','2015-08-20','北京旭宁信息技术有限公司','ios开发工程师','减速工作内容',8),(14462579366011,14462559627802,'2014-02-03','2015-10-01',' 郑州文漫科技有限公司',' 手机应用开发工程师','手机应用开发工程师',6),(14462654360283,14462652041472,'2014-01-01','2015-10-30','北京意志力科技有限公司','软件工程师','ios技术 开发',6);
/*!40000 ALTER TABLE `job_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job_resume`
--

DROP TABLE IF EXISTS `job_resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `job_resume` (
  `id` bigint(20) NOT NULL,
  `job_id` bigint(20) DEFAULT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `occupation` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job_resume`
--

LOCK TABLES `job_resume` WRITE;
/*!40000 ALTER TABLE `job_resume` DISABLE KEYS */;
/*!40000 ALTER TABLE `job_resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `language` (
  `id` bigint(20) NOT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `ability` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
INSERT INTO `language` VALUES (14406027279052,14398261056801,'韩语',NULL,'良好'),(14406027193801,14398261056801,'英语',NULL,'精通'),(14406796231593,14406795598701,'英语',NULL,'良好'),(14462580937283,14462559627802,'英语',NULL,'良好'),(14462655256735,14462652041472,'英语',NULL,'精通');
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `position`
--

DROP TABLE IF EXISTS `position`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `position` (
  `id` varchar(255) NOT NULL,
  `parent_id` varchar(255) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `position`
--

LOCK TABLES `position` WRITE;
/*!40000 ALTER TABLE `position` DISABLE KEYS */;
INSERT INTO `position` VALUES ('gzv7','0','销售|客服|市场'),('xfap','0','项目|质量|高级管理'),('lg2e','0','财务|人力资源|行政'),('5h61','0','IT|互联网|通信'),('zurb','0','房产|建筑|物业管理'),('ue6h','0','金融'),('gybh','0','采购|贸易|交通|物流'),('ping','0','生产|制造'),('27su','0','传媒|印刷|艺术|设计'),('sv6d','0','咨询|法律|教育|翻译'),('h4gs','0','服务业'),('0y9x','0','能源|环保|农业|科研'),('6fgs','0','兼职|实习|社工|其他'),('gzv7mzgr','gzv7','销售业务'),('gzv7vtet','gzv7','销售管理'),('gzv7vwbz','gzv7','销售行政/商务'),('gzv7zpeg','gzv7','客服/售前/售后技术支持'),('gzv7og1u','gzv7','市场'),('gzv7mpmp','gzv7','公关/媒介'),('gzv7bk9g','gzv7','广告/会展'),('lg2eaab8','lg2e','财务/审计/税务'),('lg2ewli5','lg2e','人力资源'),('lg2e8omo','lg2e','行政/后勤/文秘'),('xfapzkrq','xfap','项目管理/项目协调'),('xfap5b4a','xfap','质量管理/安全防护'),('xfapnsq7','xfap','高级管理'),('5h61qryg','5h61','软件/互联网开发/系统集成'),('5h611vh0','5h61','硬件开发'),('5h61euv9','5h61','互联网产品/运营管理'),('5h61tm4z','5h61','IT质量管理/测试/配置管理'),('5h615lhh','5h61','IT运维/技术支持'),('5h61vvbg','5h61','IT管理/项目协调'),('5h61cft6','5h61','电信/通信技术开发及应用'),('zurb1cxs','zurb','房地产开发/经纪/中介'),('zurbbt03','zurb','土木/建筑/装修/市政工程'),('zurbk8l1','zurb','物业管理'),('ue6haiyu','ue6h','银行'),('ue6hz06f','ue6h','证券/期货/投资管理/服务'),('ue6hzao2','ue6h','保险'),('ue6hvwxt','ue6h','信托/担保/拍卖/典当'),('gybhd99f','gybh','采购/贸易'),('gybh6e26','gybh','交通运输服务'),('gybhxuvy','gybh','物流/仓储'),('pingoqa3','ping','生产管理/运营'),('pingngra','ping','电子/电器/半导体/仪器仪表'),('ping3mca','ping','汽车制造'),('pingzrmc','ping','汽车销售与服务'),('pingygzy','ping','机械设计/制造/维修'),('ping92z8','ping','服装/纺织/皮革设计/生产'),('ping070z','ping','技工/操作工'),('pingun8g','ping','生物/制药/医疗器械'),('pingi4bo','ping','化工'),('27su9ha9','27su','影视/媒体/出版/印刷'),('27su7wqw','27su','艺术/设计'),('sv6d9gi0','sv6d','咨询/顾问/调研/数据分析'),('sv6d720a','sv6d','教育/培训'),('sv6d8hci','sv6d','律师/法务/合规'),('sv6dm0yn','sv6d','翻译(口译与笔译)'),('h4gs7sav','h4gs','商超/酒店/娱乐管理/服务'),('h4gsufml','h4gs','旅游/度假/出入境服务'),('h4gsie2x','h4gs','烹饪/料理/食品研发'),('h4gs755hkhu5','h4gs755h','美发/发型师'),('h4gs755h','h4gs','保健/美容/美发/健身'),('h4gsukon','h4gs','医院/医疗/护理'),('h4gswvdh','h4gs','社区/居民/家政服务'),('0y9x2eq5','0y9x','能源/矿产/地址勘查'),('0y9xfg5u','0y9x','环境科学/环保'),('0y9x6qz8','0y9x','农/林/牧/渔业'),('0y9x3051','0y9x','公务员/事业单位/科研机构'),('6fgsptm5','6fgs','实习生/培训生/储备干部'),('6fgse74m','6fgs','志愿者/社会工作者'),('6fgs43xb','6fgs','兼职/临时'),('6fgseo36','6fgs','其他'),('gzv7mzgr2bnr','gzv7mzgr','销售代表'),('gzv7mzgrl8hc','gzv7mzgr','客户代表'),('gzv7mzgrrnd7','gzv7mzgr','销售工程师'),('gzv7mzgrzggg','gzv7mzgr','渠道/分销专员'),('gzv7mzgrhaxn','gzv7mzgr','区域销售人员/助理'),('gzv7mzgr9g9x','gzv7mzgr','业务拓展专员/助理'),('gzv7mzgr1ed0','gzv7mzgr','大客户销售代表'),('gzv7mzgr2hp0','gzv7mzgr','电话销售'),('gzv7mzgr5kbi','gzv7mzgr','网络/在线销售'),('gzv7mzgrnsa0','gzv7mzgr','团购业务员'),('gzv7mzgr6pw4','gzv7mzgr','销售业务跟单'),('gzv7mzgr34cy','gzv7mzgr','医药代表'),('gzv7mzgrpywg','gzv7mzgr','其他'),('gzv7vwbzrrl2','gzv7vwbz','销售行政经理/主管'),('gzv7vtetp8n9','gzv7vtet','销售总监'),('gzv7vtetwzsx','gzv7vtet','销售经理'),('gzv7vtetln16','gzv7vtet','销售主管'),('gzv7vtetk8n2','gzv7vtet','客户总监'),('gzv7vteta186','gzv7vtet','客户经理'),('gzv7vtetiyh2','gzv7vtet','客户主管'),('gzv7vtetw0bx','gzv7vtet','渠道/分销总监'),('gzv7vwbzggll','gzv7vwbz','销售运营经理/主管'),('gzv7vwbzanc0','gzv7vwbz','商务经理/主管'),('gzv7vwbzi2e4','gzv7vwbz','销售培训师/讲师'),('gzv7vwbzgx1w','gzv7vwbz','销售行政专员/助理'),('gzv7vwbzsqxa','gzv7vwbz','销售运营专员/助理'),('gzv7vwbzwtbx','gzv7vwbz','商务专员/助理'),('gzv7vwbzettv','gzv7vwbz','销售数据分析'),('gzv7vwbzv44x','gzv7vwbz','其他'),('gzv7zpegko7z','gzv7zpeg','销售服务总监'),('gzv7zpegzfu5','gzv7zpeg','销售服务经理'),('gzv7zpeg14f8','gzv7zpeg','客户服务主管'),('gzv7zpegveuh','gzv7zpeg','客户服务专员/助理'),('gzv7zpeg8fw7','gzv7zpeg','客户关系/投诉协调人员'),('gzv7zpegtm7r','gzv7zpeg','客户咨询热线/呼叫中心人员'),('gzv7zpegoicg','gzv7zpeg','网络/在线客服'),('gzv7zpeg3sr8','gzv7zpeg','售前/售后技术支持管理'),('gzv7zpegi32a','gzv7zpeg','售前/售后技术支持工程师'),('gzv7zpegah4q','gzv7zpeg','其他'),('gzv7og1udy67','gzv7og1u','市场总监'),('gzv7og1u8qac','gzv7og1u','市场经理'),('gzv7og1uyqzx','gzv7og1u','市场主管'),('gzv7og1u8cwg','gzv7og1u','市场专员/助理'),('gzv7og1ukq7c','gzv7og1u','市场营销经理'),('gzv7og1umztk','gzv7og1u','市场营销主管'),('gzv7og1usy14','gzv7og1u','市场营销专员/助理'),('gzv7og1ue10o','gzv7og1u','业务拓展经理/主管'),('gzv7og1ur7a9','gzv7og1u','业务拓展专员/助理'),('gzv7og1upgar','gzv7og1u','产品经理'),('gzv7og1ugakg','gzv7og1u','产品主管'),('gzv7og1uvepz','gzv7og1u','产品专员/助理'),('gzv7og1ue442','gzv7og1u','产品策划/企划经理/主管'),('gzv7og1ufons','gzv7og1u','品牌专员/助理'),('gzv7og1ucc5y','gzv7og1u','市场策划/市场专员/助理'),('gzv7og1ubvo9','gzv7og1u','市场文案策划'),('gzv7og1uues1','gzv7og1u','活动策划'),('gzv7og1ufumd','gzv7og1u','活动执行'),('gzv7og1umqd4','gzv7og1u','促销管理/督导'),('gzv7og1udslz','gzv7og1u','促销员'),('gzv7og1uspqk','gzv7og1u','网站推广'),('gzv7og1ux47s','gzv7og1u','Seo/Sem'),('gzv7og1u7g6d','gzv7og1u','网站推广'),('gzv7og1udqm5','gzv7og1u','选址拓展/新店开发'),('gzv7og1u82i4','gzv7og1u','市场调研与分析'),('gzv7og1u6hym','gzv7og1u','其他'),('gzv7mpmp5eem','gzv7mpmp','公关总监'),('gzv7mpmpp2ar','gzv7mpmp','公关经理/主管'),('gzv7mpmpgtgm','gzv7mpmp','公关专员/助理'),('gzv7mpmpqok9','gzv7mpmp','媒介专员/助理'),('gzv7mpmphcce','gzv7mpmp','政府事务与管理'),('gzv7mpmpnwzv','gzv7mpmp','媒介经理/主管'),('gzv7mpmp6dll','gzv7mpmp','其他'),('gzv7bk9g4rf6','gzv7bk9g','广告创意/设计总监'),('gzv7bk9gg9hm','gzv7bk9g','广告创意/设计经理/主管'),('gzv7bk9gga35','gzv7bk9g','广告创意/设计师'),('gzv7bk9g7mw3','gzv7bk9g','广告文案策划'),('gzv7bk9gz84r','gzv7bk9g','广告美术指导'),('gzv7bk9g3ucr','gzv7bk9g','广告制作执行'),('gzv7bk9g6e4n','gzv7bk9g','广告客户总监'),('gzv7bk9gihyv','gzv7bk9g','广告客户经理'),('gzv7bk9gbgtc','gzv7bk9g','广告客户主管'),('gzv7bk9gyau6','gzv7bk9g','广告客户代表'),('gzv7bk9gornc','gzv7bk9g','广告/会展业务拓展'),('gzv7bk9glf4k','gzv7bk9g','会展策划/设计'),('gzv7bk9g5c9g','gzv7bk9g','会展经理/主管'),('gzv7bk9gciga','gzv7bk9g','会务专员/助理'),('gzv7bk9gg5tn','gzv7bk9g','广告/会展项目管理'),('gzv7bk9gxv11','gzv7bk9g','其他'),('xfapzkrqwxa3','xfapzkrq','项目总监'),('xfapzkrql71w','xfapzkrq','项目经理/主管'),('xfaptg92','xfap','项目专员/助理'),('xfapzkrqws89','xfapzkrq','广告/展会项目管理'),('xfapzkrqyc3y','xfapzkrq','IT项目总监'),('xfapzkrqifn6','xfapzkrq','IT项目经理/主管'),('xfapzkrqcgz9','xfapzkrq','IT项目执行/协调人员'),('xfapzkrqglia','xfapzkrq','通信项目管理'),('xfapzkrqd8m0','xfapzkrq','房地产项目管理'),('xfapzkrqnpzw','xfapzkrq','证券/投资项目管理'),('xfapzkrqsprk','xfapzkrq','保险项目经理/主管'),('xfapzkrqlkre','xfapzkrq','生产项目经理/主管'),('xfapzkrqaxed','xfapzkrq','生产项目工程师'),('xfapzkrqxsk1','xfapzkrq','汽车工程项目管理'),('xfapzkrqo3qd','xfapzkrq','电子/电器项目管理'),('xfapzkrqkala','xfapzkrq','服装/纺织/皮革项目管理'),('xfapzkrqyw3p','xfapzkrq','医疗项目管理'),('xfapzkrqvavb','xfapzkrq','化工项目管理'),('xfapzkrqmi7g','xfapzkrq','物流/仓储项目管理'),('xfapzkrq4ebd','xfapzkrq','咨询项目管理'),('xfapzkrqkoch','xfapzkrq','能源/矿产项目管理'),('xfapzkrqmre2','xfapzkrq','其他'),('xfap5b4a4ob4','xfap5b4a','质量管理//测绘经理'),('xfap5b4ahxki','xfap5b4a','质量管理/测试工程师'),('xfap5b4aqg6u','xfap5b4a','质量检验员/测试员'),('xfap5b4akkcz','xfap5b4a','化验/检验'),('xfap5b4aipsu','xfap5b4a','认证/体系工程师/审核员'),('xfap5b4axhlo','xfap5b4a','环境/健康/安全经理/主管'),('xfap5b4a4fdo','xfap5b4a','环境/健康/安全工程师'),('xfap5b4apy0b','xfap5b4a','供应商/采购质量经理'),('xfap5b4at9ke','xfap5b4a','安全管理'),('xfap5b4a07uw','xfap5b4a','安全消防'),('xfap5b4af6ih','xfap5b4a','其他'),('xfapnsq7k7f1','xfapnsq7','首席执行官CEO/总裁@/总经理'),('xfapnsq7zufl','xfapnsq7','首席运营官COO'),('xfapnsq71e2m','xfapnsq7','首席财务官CFO'),('xfapnsq7rr82','xfapnsq7','CTO/CIO'),('xfapnsq79eph','xfapnsq7','副总裁/副总经理'),('xfapnsq78myt','xfapnsq7','分公司/代表处负责人'),('xfapnsq77wy9','xfapnsq7','部门/事业部管理'),('xfapnsq78o2r','xfapnsq7','总裁助理/总经理助理'),('xfapnsq7z888','xfapnsq7','总编/副总编'),('xfapnsq78845','xfapnsq7','行长/副行长'),('xfapnsq72yla','xfapnsq7','工厂厂长/副厂长'),('xfapnsq79hnd','xfapnsq7','校长/副校长'),('xfapnsq7gtbw','xfapnsq7','合伙人'),('xfapnsq75owk','xfapnsq7','其他'),('lg2eaab86gb3','lg2eaab8','首席财务官CFO'),('lg2eaab888nk','lg2eaab8','财务总监'),('lg2eaab8r1zc','lg2eaab8','财务经理'),('lg2eaab8bvpa','lg2eaab8','财务主管/总账主管'),('lg2eaab89gxo','lg2eaab8','财务顾问'),('lg2eaab8wlsu','lg2eaab8','财务助理'),('lg2eaab8k41c','lg2eaab8','财务分析经理/主管'),('lg2eaab8f4gb','lg2eaab8','财务分析员'),('lg2eaab8bnge','lg2eaab8','会计经理/主管'),('lg2eaab8yvp9','lg2eaab8','会计/会计师'),('lg2eaab8fv8d','lg2eaab8','会计助理/文员'),('lg2eaab8x9as','lg2eaab8','出纳员'),('lg2eaab8zid5','lg2eaab8','审计经理/主管'),('lg2eaab8n2og','lg2eaab8','审计专员/助理'),('lg2eaab8ekkp','lg2eaab8','税务经理/主管'),('lg2eaab8upsz','lg2eaab8','税务专员/助理'),('lg2eaab88oxw','lg2eaab8','成本经理/主管'),('lg2eaab8te5n','lg2eaab8','成本会计'),('lg2eaab8ggu2','lg2eaab8','资产/资金管理'),('lg2eaab8tdu0','lg2eaab8','资金专员'),('lg2eaab86tlb','lg2eaab8','统计员'),('lg2eaab8s2dd','lg2eaab8','其他'),('lg2ewli52grx','lg2ewli5','资产/资金管理'),('lg2ewli5cg5e','lg2ewli5','人力资源经理'),('lg2ewli5rpvg','lg2ewli5','人力资源主管'),('lg2ewli5l04z','lg2ewli5','人力资源专员/助理'),('lg2ewli5tckn','lg2ewli5','培训经理/主管'),('lg2ewli5b4oi','lg2ewli5','培训专员/助理'),('lg2ewli5aahc','lg2ewli5','招聘经理/主管'),('lg2ewli54tyq','lg2ewli5','招聘专员/助理'),('lg2ewli50zlu','lg2ewli5','薪酬福利经理/主管'),('lg2ewli5ka8z','lg2ewli5','薪酬福利专员/助理'),('lg2ewli5qdgd','lg2ewli5','绩效考核经理/主管'),('lg2ewli5wgf2','lg2ewli5','绩效考核专员/助理'),('lg2ewli51m0y','lg2ewli5','绩效考核专员/助理'),('lg2ewli5mz28','lg2ewli5','员工关系/企业文化/工会'),('lg2ewli5epaf','lg2ewli5','企业培训师/讲师'),('lg2ewli59s6n','lg2ewli5','人事信息系统(HRIS)管理'),('lg2ewli55zin','lg2ewli5','猎头顾问/助理'),('lg2ewli5qnyn','lg2ewli5','其他'),('lg2e8omo3m16','lg2e8omo','行政总监'),('lg2e8omobl4i','lg2e8omo','行政经理/主管/办公室主任'),('lg2e8omorxo2','lg2e8omo','行政专员/助理'),('lg2e8omozu2g','lg2e8omo','助理/秘书/文员'),('lg2e8omo4zsb','lg2e8omo','前台/总机/接待'),('lg2e8omotdmc','lg2e8omo','文档/资料管理'),('lg2e8omolln0','lg2e8omo','电脑操作/打字/录入员'),('lg2e8omo270c','lg2e8omo','后勤人员'),('lg2e8omoa7pd','lg2e8omo','其他'),('5h61qryg516y','5h61qryg','高级软件工程师'),('5h61qryg75w6','5h61qryg','软件工程师'),('5h61qryg1d3s','5h61qryg','软件研发工程师'),('5h61qrygz7et','5h61qryg','需求工程师'),('5h61qryguh60','5h61qryg','系统架构设计师'),('5h61qrygvqf1','5h61qryg','系统分析员'),('5h61qrygq1m7','5h61qryg','数据库开发工程师'),('5h61qrygglsk','5h61qryg','ERP技术/开发应用'),('5h61qryg69iy','5h61qryg','互联网软件工程师'),('5h61qrygh1ny','5h61qryg','手机软件开发工程师'),('5h61qryg89wm','5h61qryg','嵌入式软件开发'),('5h61qrygrsuv','5h61qryg','移动互联网开发'),('5h61qryg0ked','5h61qryg','WEB前端开发'),('5h61qryg2vbl','5h61qryg','语音/视频/图形开发'),('5h61qryg23x4','5h61qryg','用户界面（UI）设计'),('5h61qrygz877','5h61qryg','用户体验（UE/UX）设计'),('5h61qryg1lln','5h61qryg','网页设计/制作/美工'),('5h61qryggx5m','5h61qryg','游戏设计/开发'),('5h61qrygwz58','5h61qryg','游戏策划'),('5h61qryguedb','5h61qryg','游戏界面设计'),('5h61qryg0kgf','5h61qryg','系统集成工程师'),('5h61qryg5294','5h61qryg','其他'),('5h611vh0847k','5h611vh0','高级硬件工程师'),('5h611vh0s5wu','5h611vh0','硬件工程师'),('5h611vh0rfox','5h611vh0','嵌入式硬件开发'),('5h611vh0zfl3','5h611vh0','其他'),('5h61euv9e62p','5h61euv9','互联网产品经理/主管'),('5h61euv9idfa','5h61euv9','互联网产品专员/助理'),('5h61euv917wl','5h61euv9','电子商务经理/主管'),('5h61euv9pw4x','5h61euv9','电子商务专员/助理'),('5h61euv9fvy3','5h61euv9','网络运营管理'),('5h61euv9iu6y','5h61euv9','网络运营专员/助理'),('5h61euv9m5ke','5h61euv9','网站编辑'),('5h61euv95u8p','5h61euv9','SEO/SEM'),('5h61euv9ae0s','5h61euv9','其他'),('5h61tm4zqpdt','5h61tm4z','IT质量管理经理/主管管理经理/主管'),('5h61tm4zo6hi','5h61tm4z','IT质量管理工程师'),('5h61tm4zl5r0','5h61tm4z','系统测试'),('5h61tm4z72de','5h61tm4z','软件测试'),('5h61tm4zink8','5h61tm4z','硬件测试'),('5h61tm4zadm1','5h61tm4z','配置管理工程师'),('5h61tm4zv6bd','5h61tm4z','信息技术标准化工程师'),('5h61tm4zd4gr','5h61tm4z','其他'),('5h615lhhxdfs','5h615lhh','信息技术经理/主管'),('5h615lhhgltn','5h615lhh','信息技术专员'),('5h615lhh53dt','5h615lhh','IT技术支持/维护经理'),('5h615lhhlwqg','5h615lhh','IT技术支持/维护工程师'),('5h615lhhhk2u','5h615lhh','系统工程师'),('5h615lhhqi2a','5h615lhh','系统管理员'),('5h615lhhntdr','5h615lhh','网络工程师'),('5h615lhhbv56','5h615lhh','网络管理员'),('5h615lhhw4wh','5h615lhh','网络与信息安全工程师'),('5h615lhhgamg','5h615lhh','数据库管理员'),('5h615lhhkgom','5h615lhh','计算机硬件维护工程师'),('5h615lhh52xe','5h615lhh','ERP实施顾问'),('5h615lhhlux6','5h615lhh','IT技术文员/助理'),('5h615lhhpcmm','5h615lhh','IT技术文员/助理'),('5h615lhh3r5v','5h615lhh','IT文档工程师'),('5h615lhh9f2r','5h615lhh','Helpdesk'),('5h615lhhhe37','5h615lhh','其他'),('5h61vvbg3g6u','5h61vvbg','CTO/CIO'),('5h61vvbgo1qu','5h61vvbg','IT技术/研发总监'),('5h61vvbgxpbr','5h61vvbg','IT技术/研发经理/主管'),('5h61vvbgrr9g','5h61vvbg','IT项目总监'),('5h61vvbgy0d0','5h61vvbg','IT项目经理/主管'),('5h61vvbg6rbq','5h61vvbg','IT项目执行/协调人员'),('5h61vvbglzhv','5h61vvbg','其他'),('5h61cft6imbd','5h61cft6','通信技术工程师'),('5h61cft6yvlp','5h61cft6','通信研发工程师'),('5h61cft60z2r','5h61cft6','数据通信工程师'),('5h61cft6uw6n','5h61cft6','移动通信工程师'),('5h61cft6dih5','5h61cft6','电信网络工程师'),('5h61cft6gd66','5h61cft6','电信交换工程师'),('5h61cft6qbgy','5h61cft6','有线传输工程师'),('5h61cft6xt2x','5h61cft6','无线/射频通信工程师'),('5h61cft69dvr','5h61cft6','有线传输工程师'),('5h61cft68b4k','5h61cft6','无线/射频通信工程师'),('5h61cft6bqo3','5h61cft6','通信电源工程师'),('5h61cft67fc4','5h61cft6','通信标准化工程师'),('5h61cft68oc5','5h61cft6','通信项目管理'),('5h61cft6iceu','5h61cft6','其他'),('zurb1cxspgcd','zurb1cxs','房地产项目策划经理/主管'),('zurb1cxshx77','zurb1cxs','房地产项目策划专员/助理'),('zurb1cxs7ma1','zurb1cxs','房地产项目招投标'),('zurb1cxs63b6','zurb1cxs','房地产项目开发报建'),('zurb1cxsgkx9','zurb1cxs','房地产项目配套工程师'),('zurb1cxs3iyf','zurb1cxs','房地产销售经理'),('zurb1cxsrull','zurb1cxs','房地产销售主管'),('zurb1cxsd6i2','zurb1cxs','房地产销售/置业顾问'),('zurb1cxsrpzv','zurb1cxs','房地产评估'),('zurb1cxsb9hm','zurb1cxs','房地产中介/交易'),('zurb1cxs6xtx','zurb1cxs','房地产项目管理'),('zurb1cxs7wul','zurb1cxs','其他'),('zurbbt03kf9g','zurbbt03','高级建筑工程师/总工'),('zurbbt03z3g1','zurbbt03','建筑工程师'),('zurbbt03c17u','zurbbt03','建筑设计师'),('zurbbt03u170','zurbbt03','土木/土建/结构工程师'),('zurbbt03w7q3','zurbbt03','岩土工程'),('zurbbt034yi2','zurbbt03','建筑制图'),('zurbbt03c3h0','zurbbt03','建筑工程测绘/测量'),('zurbbt0337ca','zurbbt03','道路/桥梁/隧道工程技术'),('zurbbt037lra','zurbbt03','水利/港口工程技术'),('zurbbt03fcm7','zurbbt03','架线和管道工程技术'),('zurbbt03a90e','zurbbt03','给排水/暖通/空调工程'),('zurbbt03xrzl','zurbbt03','智能大厦/布线/弱电/安防'),('zurbbt03qgzh','zurbbt03','室内装潢设计'),('zurbbt03pry8','zurbbt03','幕墙工程师'),('zurbbt03hhex','zurbbt03','园林/景观设计'),('zurbbt036ntk','zurbbt03','城市规划与设计'),('zurbbt03yt3h','zurbbt03','市政工程师'),('zurbbt038kwb','zurbbt03','工程监理/质量管理'),('zurbbt03d9q6','zurbbt03','工程造价/预结算'),('zurbbt039um5','zurbbt03','工程资料管理'),('zurbbt03w6g0','zurbbt03','建筑施工现场管理'),('zurbbt03f3ap','zurbbt03','施工队长'),('zurbbt03dkov','zurbbt03','建筑工程安全管理'),('zurbbt03tmok','zurbbt03','其他'),('zurbk8l11t24','zurbk8l1','物业经理/主管'),('zurbk8l1bhzs','zurbk8l1','物业管理专员/助理'),('zurbk8l1f0yr','zurbk8l1','物业租赁/销售'),('zurbk8l1sfie','zurbk8l1','物业维修'),('zurbk8l12rlf','zurbk8l1','物业顾问'),('zurbk8l1dlg5','zurbk8l1','物业招商管理'),('zurbk8l18cgp','zurbk8l1','其他'),('ue6haiyuudcb','ue6haiyu','行长/副行长'),('ue6haiyuglvn','ue6haiyu','银行经理/主任'),('ue6haiyulnb0','ue6haiyu','银行大堂经理'),('ue6haiyu5wma','ue6haiyu','银行客户总监'),('ue6haiyud4rk','ue6haiyu','银行客户经理'),('ue6haiyu76a7','ue6haiyu','银行客户主管'),('ue6haiyucvza','ue6haiyu','银行客户代表'),('ue6haiyuc9ve','ue6haiyu','银行客户服务'),('ue6haiyuz6pb','ue6haiyu','综合业务经理/主管'),('ue6haiyu6a5y','ue6haiyu','综合业务专员/助理'),('ue6haiyul0i6','ue6haiyu','银行会计/柜员'),('ue6haiyu83l4','ue6haiyu','公司业务'),('ue6haiyu6tln','ue6haiyu','个人业务'),('ue6haiyu9pwu','ue6haiyu','银行卡/电子银行业务推广'),('ue6haiyu6nt7','ue6haiyu','信贷管理/资信评估/分析'),('ue6haiyut8o7','ue6haiyu','信审核查'),('ue6haiyuvlod','ue6haiyu','外汇交易'),('ue6haiyuzpwc','ue6haiyu','进出口/信用证结算'),('ue6haiyu7rh2','ue6haiyu','清算人员'),('ue6haiyugxnf','ue6haiyu','风险控制'),('ue6haiyu48vv','ue6haiyu','其他'),('ue6hz06f6w7l','ue6hz06f','证券总监/部门经理'),('ue6hz06fzdbg','ue6hz06f','证券/期货/外汇经纪人'),('ue6hz06fgwbl','ue6hz06f','证券/投资客户总监'),('ue6hz06fbgbw','ue6hz06f','证券/投资客户经理'),('ue6hz06fu071','ue6hz06f','证券/投资客户主管'),('ue6hz06fvqbp','ue6hz06f','证券/投资客户代表'),('ue6hz06f5w63','ue6hz06f','证券分析/金融研究'),('ue6hz06f2pop','ue6hz06f','投资/理财服务'),('ue6hz06fn2l3','ue6hz06f','投资银行业务'),('ue6hz06f6fyh','ue6hz06f','融资总监'),('ue6hz06fiml3','ue6hz06f','融资经理/主管'),('ue6hz06fiukw','ue6hz06f','融资专员/助理'),('ue6hz06f6gme','ue6hz06f','股票/期货操盘手'),('ue6hz06fng14','ue6hz06f','资产评估'),('ue6hz06fcct9','ue6hz06f','风险管理/控制/稽查'),('ue6hz06flug1','ue6hz06f','储备经理人'),('ue6hz06fxzaa','ue6hz06f','证券/投资项目管理'),('ue6hz06fywrp','ue6hz06f','其他'),('ue6hzao2gx35','ue6hzao2','保险业务管理'),('ue6hzao2olit','ue6hzao2','保险代理/经纪人/客户经理'),('ue6hzao2gu6i','ue6hzao2','保险顾问/财务规划师'),('ue6hzao2ryn3','ue6hzao2','保险产品开发/项目策划'),('ue6hzao2ez9q','ue6hzao2','保险培训师'),('ue6hzao2f1zv','ue6hzao2','保险契约管理'),('ue6hzao2zxll','ue6hzao2','核保理赔'),('ue6hzao2h3sk','ue6hzao2','汽车定损/车险理赔'),('ue6hzao252cg','ue6hzao2','保险精算师'),('ue6hzao2y2lz','ue6hzao2','汽车定损/车险理赔'),('ue6hzao2dhcn','ue6hzao2','保险精算师'),('ue6hzao2l050','ue6hzao2','客户服务/续期管理'),('ue6hzao24lie','ue6hzao2','保险内勤'),('ue6hzao2s3r0','ue6hzao2','保险项目经理/主管'),('ue6hzao2quc9','ue6hzao2','储备经理人'),('ue6hzao2064a','ue6hzao2','其他'),('ue6hvwxt46pg','ue6hvwxt','信托服务'),('ue6hvwxt170w','ue6hvwxt','担保业务'),('ue6hvwxt05um','ue6hvwxt','拍卖师'),('ue6hvwxtxc9p','ue6hvwxt','典当业务'),('ue6hvwxtrz6i','ue6hvwxt','珠宝/收藏品鉴定'),('ue6hvwxthlne','ue6hvwxt','其他'),('gybhd99f4b83','gybhd99f','采购总监'),('gybhd99fglbr','gybhd99f','采购经理/主管'),('gybhd99fb3a8','gybhd99f','采购专员/助理'),('gybhd99fg7g3','gybhd99f','供应商开发'),('gybhd99fgbcu','gybhd99f','供应链管理'),('gybhd99ftaz0','gybhd99f','买手'),('gybhd99fcgme','gybhd99f','外贸/贸易经理/主管'),('gybhd99f2zva','gybhd99f','外贸/贸易专员/助理'),('gybhd99fl3zq','gybhd99f','贸易跟单'),('gybhd99femmx','gybhd99f','报关员'),('gybhd99fbf2f','gybhd99f','其他'),('gybh6e26untu','gybh6e26','机动车司机/驾驶'),('gybh6e26244e','gybh6e26','列车驾驶/操作'),('gybh6e26zmhf','gybh6e26','船舶驾驶/操作'),('gybh6e26i199','gybh6e26','飞机驾驶/操作'),('gybh6e265y45','gybh6e26','公交/地铁乘务'),('gybh6e26zhcx','gybh6e26','列车乘务'),('gybh6e26kak9','gybh6e26','船舶乘务'),('gybh6e261rr3','gybh6e26','船员/水手'),('gybh6e261e1y','gybh6e26','航空乘务'),('gybh6e26021u','gybh6e26','航空乘务'),('gybh6e26mg2u','gybh6e26','地勤人员'),('gybh6e269n4m','gybh6e26','其他'),('gybhxuvy4eqx','gybhxuvy','物流总监'),('gybhxuvyp6qf','gybhxuvy','物流经理/主管'),('gybhxuvy5r1n','gybhxuvy','物流专员/助理'),('gybhxuvyswwv','gybhxuvy','货运代理'),('gybhxuvywxpt','gybhxuvy','运输经理/主管'),('gybhxuvyce2l','gybhxuvy','快递员/速递员'),('gybhxuvyggo2','gybhxuvy','水运/空运/陆运操作'),('gybhxuvyi0lt','gybhxuvy','集装箱业务'),('gybhxuvynypg','gybhxuvy','报关员'),('gybhxuvylvtp','gybhxuvy','单证员'),('gybhxuvydlnv','gybhxuvy','仓库经理/主管'),('gybhxuvy3ax1','gybhxuvy','仓库/物料管理员'),('gybhxuvy35gc','gybhxuvy','理货/分拣/打包'),('gybhxuvyvqn8','gybhxuvy','物流/仓储调度'),('gybhxuvyvs7s','gybhxuvy','物流/仓储项目管理'),('gybhxuvyzhye','gybhxuvy','搬运工'),('gybhxuvyxzy5','gybhxuvy','其他'),('pingoqa3uga8','pingoqa3','工厂厂长/副厂长'),('pingoqa3qscn','pingoqa3','生产总监'),('pingoqa34lnd','pingoqa3','生产经理/车间主任'),('pingoqa338e3','pingoqa3','生产主管/督导/组长'),('pingoqa3zd59','pingoqa3','生产运营管理'),('pingoqa3d0z7','pingoqa3','生产项目经理/主管'),('pingoqa3uuhm','pingoqa3','生产项目工程师'),('pingoqa32wl3','pingoqa3','产品管理'),('pingoqa39onk','pingoqa3','生产计划'),('pingoqa3022z','pingoqa3','制造工程师'),('pingoqa3c403','pingoqa3','工艺/制程工程师'),('pingoqa37bkg','pingoqa3','工业工程师'),('pingoqa3msr9','pingoqa3','生产设备管理'),('pingoqa378nl','pingoqa3','生产物料管理（PMC）'),('pingoqa316lk','pingoqa3','包装工程师'),('pingoqa37gqz','pingoqa3','技术文档工程师'),('pingoqa3nekg','pingoqa3','其他'),('pingngra7e9s','pingngra','电子技术研发工程师'),('pingngraqyp2','pingngra','电子/电器工程师'),('pingngrawmti','pingngra','电器研发工程师'),('pingngraqb33','pingngra','电子/电器工艺/制程工程师'),('pingngramg0o','pingngra','电路工程师/技术员'),('pingngra30m2','pingngra','模拟电路设计/应用工程师'),('pingngra3lyd','pingngra','版图设计工程师'),('pingngraq7sd','pingngra','集成电路IC设计/应用工程师'),('pingngra4afs','pingngra','IC验证工程师'),('pingngra4xfa','pingngra','电子元器件工程师'),('pingngra20yz','pingngra','射频工程师'),('pingngraci0v','pingngra','无线电工程师'),('pingngrap27y','pingngra','激光/光电子技术'),('pingngra4zng','pingngra','光源/照明工程师'),('pingngraclk1','pingngra','变压器与磁电工程师'),('pingngra984p','pingngra','电池/电源开发'),('pingngraq094','pingngra','家用电器/数码产品研发'),('pingngra1egw','pingngra','空调工程/设计'),('pingngra0fpw','pingngra','音频/视频工程师/技术员'),('pingngrab95e','pingngra','安防系统工程师'),('pingngra4dip','pingngra','电子/电器设备工程师'),('pingngrari82','pingngra','电子/电器维修/保养'),('pingngraybnx','pingngra','电子/电器项目管理'),('pingngras60t','pingngra','电气工程师'),('pingngraxeyu','pingngra','电气设计'),('pingngrag6ap','pingngra','电气线路设计'),('pingngrapg24','pingngra','线路结构设计'),('pingngrarrix','pingngra','半导体技术'),('pingngra03kk','pingngra','仪器/仪表/计量工程'),('pingngra4ebc','pingngra','自动化工程师'),('pingngraymig','pingngra','现场应用工程师（FAE）'),('pingngraidsn','pingngra','测试/可靠性工程师'),('pingngraycsd','pingngra','其他'),('ping3mca3prw','ping3mca','汽车动力系统工程师'),('ping3mcampkr','ping3mca','汽车底盘/总装工程师'),('ping3mca25zy','ping3mca','车身设计工程师'),('ping3mcaoyir','ping3mca','汽车电子工程师'),('ping3mcaube4','ping3mca','汽车机械工程师'),('ping3mcabctd','ping3mca','汽车零部件设计师'),('ping3mcanu0p','ping3mca','汽车装配工艺工程师'),('ping3mcaz7ax','ping3mca','安全性能工程师'),('ping3mcag2y7','ping3mca','汽车工程项目管理'),('ping3mcar7ii','ping3mca','其他'),('pingzrmc8k1p','pingzrmc','汽车销售'),('pingzrmc21ip','pingzrmc','汽车零配件销售'),('pingzrmcg4vl','pingzrmc','汽车售后服务/客户服务'),('pingzrmcmodh','pingzrmc','汽车维修/保养'),('pingzrmctrtv','pingzrmc','汽车质量管理/检验检测'),('pingzrmck9qm','pingzrmc','汽车定损/车险理赔'),('pingzrmcg1t9','pingzrmc','汽车装饰美容'),('pingzrmcq5oe','pingzrmc','二手车评估师'),('pingzrmcuphs','pingzrmc','4S店管理'),('pingzrmcxtg4','pingzrmc','其他'),('pingygzyc8ho','pingygzy','工程机械经理'),('pingygzy1b3c','pingygzy','工程机械主管'),('pingygzy7q71','pingygzy','机械设备经理'),('pingygzys9v3','pingygzy','机械设备工程师'),('pingygzyhwef','pingygzy','机械工程师'),('pingygzy3x76','pingygzy','机械设计师'),('pingygzyvddh','pingygzy','机械制图员'),('pingygzy48gf','pingygzy','机械研发工程师'),('pingygzy3c5w','pingygzy','机械结构工程师'),('pingygzykzob','pingygzy','机械工艺/制程工程师'),('pingygzyg8lb','pingygzy','气动工程师'),('pingygzydttu','pingygzy','CNC/数控工程师'),('pingygzygg4a','pingygzy','模具工程师'),('pingygzyyz27','pingygzy','夹具工程师'),('pingygzy9dp0','pingygzy','注塑工程师'),('pingygzytxnb','pingygzy','铸造/锻造工程师/技师'),('pingygzyum9e','pingygzy','机电工程师'),('pingygzytb2v','pingygzy','材料工程师'),('pingygzyetny','pingygzy','机械维修/保养'),('pingygzy18vu','pingygzy','飞机设计与制造'),('pingygzybgcd','pingygzy','飞机维修/保养'),('pingygzy5drq','pingygzy','列车设计与制造'),('pingygzywey8','pingygzy','列车维修/保养'),('pingygzyr68g','pingygzy','船舶设计与制造'),('pingygzypzrn','pingygzy','船舶维修/保养'),('pingygzy4a59','pingygzy','其他'),('ping92z8abqr','ping92z8','服装/纺织品设计'),('ping92z8yeoh','ping92z8','服装打样/制版'),('ping92z8kfh2','ping92z8','服装/纺织/皮革工艺师'),('ping92z8navi','ping92z8',' 电脑放码员'),('ping92z81ude','ping92z8','裁床'),('ping92z8kk0y','ping92z8','样衣工'),('ping92z8d7w1','ping92z8','面料辅料开发/采购'),('ping92z801n7','ping92z8','服装/纺织/皮革跟单'),('ping92z8sg00','ping92z8','服装/纺织品/皮革销售'),('ping92z81u00','ping92z8','服装/纺织品/皮革质量管理'),('ping92z8zvzb','ping92z8','服装/纺织/皮革项目管理'),('ping92z8k61r','ping92z8','其他'),('ping070z7b2y','ping070z','车床/磨床/铣床/冲床工'),('ping070zkkng','ping070z','模具工'),('ping070zg4s1','ping070z','钳工/机修工/钣金工'),('ping070zzpgo','ping070z','电焊工/铆焊工'),('ping070z3val','ping070z','电工'),('ping070zn60i','ping070z','水工/木工/油漆工'),('ping070zz4ym','ping070z','铲车/叉车工'),('ping070zw5oo','ping070z','空调工/电梯工/锅炉工'),('ping070za8vl','ping070z','汽车维修/保养'),('ping070zmqrb','ping070z','普工/操作工'),('pingun8guicx','pingun8g','医药代表'),('pingun8g1y2v','pingun8g','医药销售经理/主管'),('pingun8g31la','pingun8g','药品市场推广经理/主管'),('pingun8go3ea','pingun8g','药品市场推广专员/助理'),('pingun8gn99m','pingun8g','医疗器械销售'),('pingun8glwrv','pingun8g','医疗器械推广'),('pingun8g5gg3','pingun8g','医药学术推广'),('pingun8gzq3f','pingun8g','医药招商'),('pingun8gwge9','pingun8g','医药项目管理'),('pingun8g9exe','pingun8g','医药项目招投标管理'),('pingun8g6x9x','pingun8g','生物工程/生物制药'),('pingun8gclx9','pingun8g','药品研发'),('pingun8goqy1','pingun8g','医疗器械研发'),('pingun8gwsqm','pingun8g','临床研究员'),('pingun8g4shs','pingun8g','临床协调员'),('pingun8gulr7','pingun8g','临床数据分析员'),('pingun8g6u7k','pingun8g','医药化学分析'),('pingun8goog2','pingun8g','医药技术研发管理人员'),('pingun8gzgh3','pingun8g','药品注册'),('pingun8ge2px','pingun8g','医疗器械注册'),('pingun8gym7t','pingun8g','药品生产/质量管理'),('pingun8g7r8g','pingun8g','医疗器械生产/质量管理'),('pingun8gu14l','pingun8g','医疗器械维修/保养'),('pingun8gqc4h','pingun8g','其他'),('pingi4bo89b6','pingi4bo','化工工程师'),('pingi4bo4teb','pingi4bo','化工研发工程师'),('pingi4bo3eeq','pingi4bo','化学分析'),('pingi4boa7tt','pingi4bo','化学技术应用'),('pingi4bo3bpy','pingi4bo','化学操作'),('pingi4boam7f','pingi4bo','化学制剂研发'),('pingi4bopgsl','pingi4bo','油漆/化工涂料研发'),('pingi4boiae4','pingi4bo','塑料工程师'),('pingi4boh55g','pingi4bo','化学实验室技术员/研究员'),('pingi4bo2g4r','pingi4bo','化工项目管理'),('pingi4boxi2t','pingi4bo','其他'),('27su9ha9azld','27su9ha9','导演/编导'),('27su9ha967xn','27su9ha9',' 总编/副总编'),('27su9ha96c45','27su9ha9','艺术指导/舞美设计'),('27su9ha9a690','27su9ha9','摄影师/摄像师'),('27su9ha9u6ru','27su9ha9','化妆师/造型师/服装/道具'),('27su9ha9y1ur','27su9ha9','主持人/司仪'),('27su9ha9hfbl','27su9ha9','演员/模特'),('27su9ha9gr6s','27su9ha9','配音员'),('27su9ha9dy1h','27su9ha9','音效师'),('27su9ha91zvw','27su9ha9','后期制作'),('27su9ha92wdc','27su9ha9','经纪人/星探'),('27su9ha9v9f3','27su9ha9','放映管理'),('27su9ha974gh','27su9ha9','作家/编剧/撰稿人'),('27su9ha9wshq','27su9ha9','文字编辑/组稿'),('27su9ha99z2c','27su9ha9','美术编辑/美术设计'),('27su9ha99c8q','27su9ha9','记者/采编'),('27su9ha9o1dr','27su9ha9','电话采编'),('27su9ha9ezsu','27su9ha9','文案策划'),('27su9ha93un5','27su9ha9','校对/录入'),('27su9ha9hsx1','27su9ha9','发行管理'),('27su9ha9kpzi','27su9ha9','排版设计'),('27su9ha99sui','27su9ha9','印刷排版/制版'),('27su9ha9htrh','27su9ha9','印刷操作'),('27su9ha9ezia','27su9ha9','其他'),('27su7wqw3128','27su7wqw','设计管理人员'),('27su7wqwb324','27su7wqw',' 艺术/设计总监'),('27su7wqwszwn','27su7wqw','绘画'),('27su7wqw6eba','27su7wqw','原画师'),('27su7wqwfcl8','27su7wqw','CAD设计/制图'),('27su7wqwfsmg','27su7wqw','平面设计'),('27su7wqwrbbr','27su7wqw','三维/3D设计/制作'),('27su7wqwz6cf','27su7wqw','Flash设计/开发'),('27su7wqwnuid','27su7wqw','特效设计'),('27su7wqw9l0n','27su7wqw','视觉设计'),('27su7wqw4cwi','27su7wqw','用户体验（UE/UX）设计'),('27su7wqw38n9','27su7wqw','美术编辑/美术设计'),('27su7wqwae8e','27su7wqw','多媒体/动画设计'),('27su7wqwza0q','27su7wqw','包装设计'),('27su7wqworpt','27su7wqw','家具设计'),('27su7wqwlxax','27su7wqw','家居用品设计'),('27su7wqw0xwz','27su7wqw','工艺品/珠宝设计'),('27su7wqw1bug','27su7wqw','玩具设计'),('27su7wqwfs1g','27su7wqw','店面/展览/展示/陈列设计'),('27su7wqwykv0','27su7wqw','工业设计'),('27su7wqwr2cx','27su7wqw','游戏界面设计'),('sv6d9gi01h04','sv6d9gi0','咨询总监'),('sv6d9gi0vai1','sv6d9gi0','咨询经理/主管'),('sv6d9gi0h4yz','sv6d9gi0','咨询顾问/咨询员'),('sv6d9gi0kern','sv6d9gi0','专业顾问'),('sv6d9gi0gifl','sv6d9gi0','调研员'),('sv6d9gi0guyf','sv6d9gi0','数据分析师'),('sv6d9gi0cgba','sv6d9gi0','情报信息分析'),('sv6d9gi05rns','sv6d9gi0','猎头顾问/助理'),('sv6d9gi0r9bg','sv6d9gi0','咨询项目管理'),('sv6d9gi0r0ke','sv6d9gi0','其他'),('sv6d720apwtl','sv6d720a','幼教'),('sv6d720a28ld','sv6d720a','小学教师'),('sv6d720amyxb','sv6d720a','初中教师'),('sv6d720alen8','sv6d720a','高中教师'),('sv6d720awpen','sv6d720a','大学教师'),('sv6d720agh1r','sv6d720a','职业技术教师'),('sv6d720a4fkl','sv6d720a','家教'),('sv6d720ak2hp','sv6d720a','兼职教师'),('sv6d720aupuq','sv6d720a','理科教师'),('sv6d720ail60','sv6d720a','文科教师'),('sv6d720aavgs','sv6d720a','外语教师'),('sv6d720aeizq','sv6d720a','音乐教师'),('sv6d720aayxk','sv6d720a','美术教师'),('sv6d720altzt','sv6d720a','体育老师/教练'),('sv6d720amkrc','sv6d720a','校长/副校长'),('sv6d720axdh5','sv6d720a','教学/教务管理人员'),('sv6d720aec1v','sv6d720a','培训督导'),('sv6d720apdpb','sv6d720a','培训师/讲师'),('sv6d720aiit9','sv6d720a','培训助理/助教'),('sv6d720adu3l','sv6d720a','教育产品开发'),('sv6d720ao6nk','sv6d720a','培训策划'),('sv6d720ah43s','sv6d720a','培训/招生/课程顾问'),('sv6d720a8ns7','sv6d720a','其他'),('sv6d8hcig5hb','sv6d8hci','法务经理/主管'),('sv6d8hcipxtm','sv6d8hci','法务专员/助理'),('sv6d8hcig4oo','sv6d8hci','律师'),('sv6d8hciuuda','sv6d8hci','律师助理'),('sv6d8hci8fme','sv6d8hci','企业律师/合规经理/主管'),('sv6d8hciqlrt','sv6d8hci','企业律师/合规顾问'),('sv6d8hci96gz','sv6d8hci','知识产权/专利顾问/代理人'),('sv6d8hci69g7','sv6d8hci','合同管理'),('sv6d8hci83rd','sv6d8hci','其他'),('sv6dm0yn4gdr','sv6dm0yn','英语翻译'),('sv6dm0yn40vu','sv6dm0yn','法语翻译'),('sv6dm0yn73w7','sv6dm0yn','日语翻译'),('sv6dm0ynduxx','sv6dm0yn','德语翻译'),('sv6dm0ynsgyn','sv6dm0yn','俄语翻译'),('sv6dm0yn2p25','sv6dm0yn','西班牙语翻译'),('sv6dm0ynrcnm','sv6dm0yn','意大利语翻译'),('sv6dm0yn8za9','sv6dm0yn','葡萄牙语翻译'),('sv6dm0yn3x56','sv6dm0yn','阿拉伯语翻译'),('sv6dm0ynpw58','sv6dm0yn','韩语/朝鲜语翻译'),('sv6dm0yncgk3','sv6dm0yn','其他语种翻译'),('h4gs7savgtsu','h4gs7sav','店长/卖场管理'),('h4gs7savlp5a','h4gs7sav','楼面管理'),('h4gs7sav2k5p','h4gs7sav','品牌/连锁招商管理'),('h4gs7savl643','h4gs7sav','大堂经理/领班'),('h4gs7savhnu2','h4gs7sav','酒店管理'),('h4gs7sav7z8n','h4gs7sav','客房管理'),('h4gs7savogd9','h4gs7sav','收银主管'),('h4gs7savy79t','h4gs7sav','收银员'),('h4gs7savx1nk','h4gs7sav','店员/营业员/导购员'),('h4gs7savd929','h4gs7sav','理货员'),('h4gs7savwh6c','h4gs7sav','促销主管/督导'),('h4gs7sav7nie','h4gs7sav','促销员'),('h4gs7savvxth','h4gs7sav','品类管理'),('h4gs7savtqam','h4gs7sav','前厅接待/礼仪/迎宾'),('h4gs7sav1oel','h4gs7sav','预订员'),('h4gs7sav09iv','h4gs7sav','行李员'),('h4gs7sav3qxd','h4gs7sav','服务员'),('h4gs7sav41kz','h4gs7sav','防损员/内保'),('h4gs7savv7l3','h4gs7sav','奢侈品销售'),('h4gs7savitv7','h4gs7sav','主持人/司仪'),('h4gs7savka9s','h4gs7sav','其他'),('h4gsufml8iqb','h4gsufml','旅游产品销售'),('h4gsufml5k1y','h4gsufml','旅游顾问'),('h4gsufmlnf17','h4gsufml','导游/票务'),('h4gsufmlkmtr','h4gsufml','旅游计划调度'),('h4gsufmleguu','h4gsufml','旅游产品/线路策划'),('h4gsufml2gie','h4gsufml','签证业务办理'),('h4gsufml6eah','h4gsufml','其他'),('h4gsie2xxmwo','h4gsie2x','厨师/面点师'),('h4gsie2x74rg','h4gsie2x','食品加工/处理'),('h4gsie2xqanm','h4gsie2x','调酒师/茶艺师/咖啡师'),('h4gsie2x4u47','h4gsie2x','营养师'),('h4gsie2xxfkg','h4gsie2x','厨工'),('h4gsie2xy6qt','h4gsie2x','食品/饮料研发'),('h4gsie2x6na3','h4gsie2x','食品/饮料检验'),('h4gsie2xwdc5','h4gsie2x','其他'),('h4gs755hklg1','h4gs755h','化妆师'),('h4gs755h6wfw','h4gs755h','美容师/美甲师'),('h4gs755hn0nn','h4gs755h','美容顾问(BA)'),('h4gs755hntfy','h4gs755h','健身/美体/舞蹈教练'),('h4gs755hgv3r','h4gs755h','按摩/足疗'),('h4gs755hfbri','h4gs755h','救生员'),('h4gs755hcmyz','h4gs755h','其他'),('h4gsukon7xdg','h4gsukon','医疗管理人员'),('h4gsukonwc9g','h4gsukon','综合门诊/全科医生'),('h4gsukonk0ar','h4gsukon','内科医生'),('h4gsukonmrdn','h4gsukon','外科医生'),('h4gsukonuih2','h4gsukon','儿科医生'),('h4gsukoni8dz','h4gsukon','牙科医生'),('h4gsukonsgtt','h4gsukon','美容整形科医生'),('h4gsukondrd8','h4gsukon','中医科医生'),('h4gsukon82z1','h4gsukon','麻醉医生'),('h4gsukonl7hg','h4gsukon','心理医生'),('h4gsukongsu5','h4gsukon','眼科医生/验光师'),('h4gsukonhogh','h4gsukon','医学影像/放射科医师'),('h4gsukonyb2m','h4gsukon','化验/检验科医师'),('h4gsukon4ikn','h4gsukon','药房管理/药剂师'),('h4gsukony335','h4gsukon','理疗师'),('h4gsukonhagb','h4gsukon','兽医'),('h4gsukongyzb','h4gsukon','护士/护理人员'),('h4gsukonau3a','h4gsukon','营养师'),('h4gsukonmb1x','h4gsukon','针灸/推拿'),('h4gsukonvpe8','h4gsukon','其他'),('h4gswvdhf9y1','h4gswvdh','保安经理'),('h4gswvdhg044','h4gswvdh','保安'),('h4gswvdhxcag','h4gswvdh','家政人员'),('h4gswvdhule5','h4gswvdh','婚礼/庆典策划服务'),('h4gswvdhd8d4','h4gswvdh','宠物护理和美容'),('h4gswvdh8cm7','h4gswvdh','保姆/母婴护理'),('h4gswvdh3uen','h4gswvdh','搬运工'),('h4gswvdhknen','h4gswvdh','保洁'),('h4gswvdh43ro','h4gswvdh','其他'),('0y9x2eq5ycv8','0y9x2eq5','石油/天然气技术人员'),('0y9x2eq5tgpp','0y9x2eq5','空调/热能工程师'),('0y9x2eq5z9sf','0y9x2eq5','核力/火力工程师'),('0y9x2eq5xezw','0y9x2eq5','水利/水电工程师'),('0y9x2eq52d1t','0y9x2eq5','电力工程师/技术员'),('0y9x2eq5z3sd','0y9x2eq5','地质勘查/选矿/采矿'),('0y9x2eq54n8l','0y9x2eq5','能源/矿产项目管理'),('0y9x2eq5d4g6','0y9x2eq5','其他'),('0y9xfg5ub9r7','0y9xfg5u','环保技术工程师'),('0y9xfg5umnp9','0y9xfg5u','环境评价工程师'),('0y9xfg5uxvuq','0y9xfg5u','环境监测工程师'),('0y9xfg5us0hb','0y9xfg5u','水处理工程师'),('0y9xfg5u26a8','0y9xfg5u','固废处理工程师'),('0y9xfg5uvh78','0y9xfg5u','废气处理工程师'),('0y9xfg5ur20o','0y9xfg5u','生态治理/规划'),('0y9xfg5ul9yb','0y9xfg5u','环境管理/园林景区保护'),('0y9x6qz8guze','0y9x6qz8','农艺师'),('0y9x6qz8r2zn','0y9x6qz8','林业技术人员'),('0y9x6qz8e3wb','0y9x6qz8','园艺师'),('0y9x6qz82fls','0y9x6qz8','畜牧师'),('0y9x6qz8wv0p','0y9x6qz8','动物育种/养殖'),('0y9x6qz8gcsc','0y9x6qz8','动物营养/饲料研发'),('0y9x6qz8i7k6','0y9x6qz8','饲料销售'),('0y9x6qz8tc95','0y9x6qz8','其他'),('0y9x3051dv52','0y9x3051','公务员/事业单位人员'),('0y9x3051a9sg','0y9x3051','科研管理人员'),('0y9x3051bfm2','0y9x3051','科研人员'),('0y9x3051y0r5','0y9x3051','其他'),('6fgsptm5fkpq','6fgsptm5','实习生'),('6fgsptm5xggg','6fgsptm5','培训生'),('6fgsptm5zu8b','6fgsptm5','储备干部'),('6fgsptm5p3uc','6fgsptm5','其他'),('6fgse74mbt9o','6fgse74m','志愿者/义工'),('6fgse74mppd7','6fgse74m','社会工作者/社工'),('6fgse74mleiw','6fgse74m','其他'),('6fgs43xbxs7o','6fgs43xb','兼职'),('6fgs43xb0vpm','6fgs43xb','临时'),('6fgs43xb189b','6fgs43xb','其他'),('nullwhdk',NULL,NULL);
/*!40000 ALTER TABLE `position` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_experience`
--

DROP TABLE IF EXISTS `project_experience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_experience` (
  `id` bigint(20) NOT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `duty` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_experience`
--

LOCK TABLES `project_experience` WRITE;
/*!40000 ALTER TABLE `project_experience` DISABLE KEYS */;
INSERT INTO `project_experience` VALUES (14404302091383,14398261056801,'2015-08-06','2015-08-20','品读','这里是简介啊mm','这里是业绩与智者'),(14406027764093,14398261056801,'2015-08-05','2015-08-06','皓月之人','来简单介绍一下','我到底有什么业绩?'),(14406796813624,14406795598701,'2015-07-27','2015-08-14','英雄织女','这里是项目简介','这里是我的业绩');
/*!40000 ALTER TABLE `project_experience` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resume`
--

DROP TABLE IF EXISTS `resume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resume` (
  `id` bigint(20) NOT NULL,
  `title` varchar(255) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `city_id` varchar(255) DEFAULT NULL,
  `open` int(11) DEFAULT NULL,
  `industry_id` varchar(255) DEFAULT NULL,
  `position_id` varchar(255) DEFAULT NULL,
  `nature` int(11) DEFAULT NULL,
  `salary` int(11) DEFAULT NULL,
  `current_status` int(11) DEFAULT NULL,
  `evaluation` varchar(1000) DEFAULT NULL,
  `specialty` varchar(45) DEFAULT NULL,
  `start_work_date` date DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resume`
--

LOCK TABLES `resume` WRITE;
/*!40000 ALTER TABLE `resume` DISABLE KEYS */;
INSERT INTO `resume` VALUES (14398261056801,'ios开发fuxk',14384506219094,'551700',1,'dbugpd5h','gzv7mpmp5eem',NULL,4,NULL,'原来这里是评价啊',NULL,'2009-06-10',NULL,'2015-08-22 22:21:08'),(14398263285531,'ios开发',14384506219094,'551700',0,'dbugpd5h','gzv7mpmp5eem',NULL,4,NULL,'2',NULL,'2015-08-04',NULL,'2015-08-22 22:21:11'),(14402327260871,'ios开发',14384506219094,'66000',NULL,'gvn8dgch','xfap5b4aipsu',NULL,6,NULL,'这是自我评价吗',NULL,'2015-08-12',NULL,'2015-08-22 17:10:23'),(14402370104351,'我的简历',14384506219094,'528000',1,'dbugpd5h','gzv7mpmp5eem',NULL,3,NULL,'',NULL,'2015-08-13','2015-08-22 17:50:10','2015-08-22 22:22:18'),(14406795598701,'我的简历44',14384506219094,'644000',1,'dbuglvqn','gzv7zpeg14f8',NULL,8,NULL,'',NULL,'2015-08-18','2015-08-27 20:45:59','2015-08-27 20:45:59'),(14462559627802,'IOS开发工程师',14462554792311,'100020',1,'dbugg1we','5h61qryg516y',NULL,6,NULL,'1. 具有良好的编程习惯;? \r\n3. 在团队合作中,能够与队员很好的沟通,有较强的责任心和团队意识; \r\n4. 热爱设计编写程序，对IT行业充满激情。\r\niOS开发工程师',NULL,'2014-02-04','2015-10-31 09:46:02','2015-10-31 11:33:22'),(14462652041472,'iOS软件工程师',14462647789761,'100020',1,'dbugg1we','5h61qryg1d3s',NULL,6,NULL,'1.熟练掌握C/Objective-c，Xcode开发，具有良好的编程思维习惯; \r\n2.熟练掌握Json、Xml解析； \r\n3.熟练使用SDWebImage、GData、EGORefreshTableHeaderView\\Mjrefresh、FMDBDatabase、MBProgressHUD、zxing、极光推送、友盟分享、二维码等第三方库工具； \r\n   4.熟练使用SQLite数据库，NSUserDefaults以及CoreData； \r\n5.熟练掌握iOS设计模式，如：代理、MVC、Notification消息中心等模式，单例； \r\n6.熟悉XMPP即时通讯协议进行开发。 \r\n7.熟练掌握多线程的使用：NSThread、GCD 了解NSOperation； \r\n8.了解MapKit/CoreLocation地图组件，AVFoundation/CoreMedia，AVPlayer、MediaPlayer等媒体流 \r\n  用； \r\n9.熟悉git代码管理工具； \r\n10、熟练使用UI控件，掌握纯代码，Storyboard，XIB、可视化编程技术 \r\n11、了解Mac OSX 系统下终端命令操作',NULL,'2014-01-01','2015-10-31 12:20:04','2015-10-31 12:26:25');
/*!40000 ALTER TABLE `resume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `id` bigint(20) NOT NULL,
  `resume_id` bigint(20) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL,
  `course` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `place` varchar(45) DEFAULT NULL,
  `certificate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (14405803851901,14398261056801,'2015-08-04','2015-08-05','gdfsd','dhfgdh','hfghdhfgnnn','hfgdh','gfhfgh');
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `account` varchar(45) DEFAULT NULL,
  `register_type` varchar(45) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nick` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `telephone` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `active` int(11) DEFAULT NULL,
  `marital` varchar(45) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `education` int(11) DEFAULT NULL,
  `registered` varchar(255) DEFAULT NULL,
  `residence` varchar(255) DEFAULT NULL,
  `politics` varchar(45) DEFAULT NULL,
  `enable` int(11) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `real_name` varchar(45) DEFAULT NULL,
  `open` int(11) DEFAULT NULL,
  `origin_place` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (14384506219094,'liufeng45gh@163.com','email','liufeng45gh@163.com','fdsfds','190080329','18610814074',NULL,'male',NULL,NULL,'1983-12-15',1,NULL,'beijing changoo',NULL,1,'/avatar/f/8/3/7/f83726b3c43192e3acf20bf6c80fc0bb.jpg','张宁2',1,'吉林省蛟河市'),(14462554792311,'xiaoqi3515@163.com','email','xiaoqi3515@163.com','jianhui','qazwsxedc','18511460628',NULL,'male',NULL,NULL,'1989-06-07',NULL,NULL,'北京',NULL,1,NULL,'闫建辉',NULL,'南南'),(14462647789761,'1242899684@qq.com','email','1242899684@qq.com','peisen','qazwsx','18063105670',NULL,'male',NULL,NULL,'1993-05-17',NULL,NULL,NULL,NULL,1,NULL,'陈沛霖',NULL,NULL),(14475682659401,'liufx@143.com','email','liufx@143.com',NULL,'qazwsx','',NULL,'male',NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_token`
--

DROP TABLE IF EXISTS `user_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_token` (
  `token` varchar(45) NOT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`token`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_token`
--

LOCK TABLES `user_token` WRITE;
/*!40000 ALTER TABLE `user_token` DISABLE KEYS */;
INSERT INTO `user_token` VALUES ('dkj58ghDtpm9UezHotne',14384497406832),('nwAWDdmt9wd4s9NYOACx',14384501552511),('ggmQLBCiLct7YaKYFfHJ',14384504537262),('1abuj5baRScoMzvQXkjm',14384505455083),('qOAmYPjEsPIGkZAetgD4',14384506219094),('WHyCK14mkT4yGUUsHmnM',14462554792311),('iJpDs2pdaFmooLSWjToJ',14462647789761),('upvJ2PYVBg7tDOuikY3k',14475682659401);
/*!40000 ALTER TABLE `user_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-07-04 10:52:56

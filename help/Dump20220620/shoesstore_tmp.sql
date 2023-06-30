-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: shoesstore
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `tmp`
--

DROP TABLE IF EXISTS `tmp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tmp` (
  `id` char(6) NOT NULL,
  `name` varchar(100) NOT NULL,
  `cost` int NOT NULL,
  `discount` int DEFAULT NULL,
  `quantity` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `imageDetail` varchar(255) DEFAULT NULL,
  `brandId` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Brandstmp` (`brandId`),
  CONSTRAINT `FK_Brandstmp` FOREIGN KEY (`brandId`) REFERENCES `brands` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tmp`
--

LOCK TABLES `tmp` WRITE;
/*!40000 ALTER TABLE `tmp` DISABLE KEYS */;
INSERT INTO `tmp` VALUES ('159816','One Star Ox',1750000,12,12,'159816c-350-a-prem.jpg','1','',4),('162063','Converse 1970s',1950000,12,342,'162063-3-c8000c4a-510d-4b27-bfcc-fd79647bf147.jpg','1','converse_chuck_taylor_all_star_1970_____1525977631_0da98b23.jpg',4),('166708','Chuck Taylor All Star Low Peony Pink',1650000,40,40,'166708c-a-107x1.jpg','1','',4),('169881','Converse Chuck Taylor All-Star 70s Hi Offspring Paisley',2790000,32,2131,'converse-chuck-taylor-all-star-70s-hi-offspring-paisley-169881c.jpg','1','',4),('1JM007','FILA Interlation',2150000,0,321,'fila-interlation-off-white-1jm00790-920-2-jpg-v-1575865944813.jpg','1','fila-interlation-off-white-1jm00790-920-4.jpg',5),('1RM011','Fila Ray Tracer',2200000,41,312,'fila-ray-tracer-white-blue-red-1rm01153-926-1-jpg-v-1577423851180.jpg','1','',5),('32SHC1','New York Yankees - MLB',2690000,3,213,'750x750.jpg','1','750x7501.jpg',7),('371318','Puma Bari Mule',1850000,12,123,'2019566-l.jpg','1','',6),('372279','Puma PopCat White/Black',850000,5,13,'dep-puma-popcat-white-black-logo-372279-02-jpeg.jpg','1','',6),('373033','Puma Bari Z',2490000,40,200,'giay-puma-bari-z-sneakers-white-black-373033-01-jpeg.jpg','1','',6),('4F6679','Vans Style 36 Lemon',1990000,10,12,'vn0a54f6679-1600x-jpg-v-1642696807.jpg','1','',3),('553558','Jordan 1 Low',4300000,10,12,'jordan-1-553558-606.jpg','1','air-jordan-1-low-varsity-red-release-date-2_89299e6c434c4b109eb1094c58bd2478_master.jpg',7),('555088','Air Jordan 1 Retro High OG',6500000,0,12,'jordan-1-retro-patina-555088-033.jpg','1','',2),('882694','Nike Tanjun Sandal',1450000,50,40,'tanjun-flip-flop-kf0n7z.jpg','1','',2),('A80848','Running Zoom Fly',3650000,4,8,'s-l1000-7a2e6ce3-8070-4e33-adab-d30ebdee30e5.jpg','1','5bb96907N6b36ad71.jpg',2),('AF5141','Ultra Boost 2.0 Chính Hãng',3900000,44,1312,'ultra-boost-shoes-black-af5141-01-standard.jpg','1','72ab4216f8ed4bd4ad58a96601057b95_9366.jpg',1),('AO1742','Air Max 2 Light',2850000,12,2421,'72643447-2390605941201031-5611775041701150720-n.jpg','1','',2),('AT7859','Air Force 1 Type',2950000,12,214,'percen3.jpg','1','',2),('B37365','POD-S3.1',2450000,0,13,'pod-s3-1-shoes-grey-b37365-01-standard.jpg','1','4fc886d69fd2487c9729a91200fcfd8c_9366.jpg',1),('B41955','Sobakov',2350000,0,324,'sobakov-shoes-white-b41955-01-standard.jpg','1','ecf8f41ce00d418d9385a90b00fd07cb_9366.jpg',1),('B42199','NMD R1',2890000,12,1234,'66724867-387467541884900-1887719743855525888-n.jpg','1','B42199_02_standard.jpg',1),('BQ6972','Nike EXP-X14 QS',2950000,51,123,'nike-expx14-qs-1547715852-7f422007.jpg','1','nike-exp-x14-multicolore-coucher-de-soleil-2.jpg',2),('BV7427','LeBron Witness 4 Red Carpet',2890000,12,412,'nike-lebron-witness-4-bv7427-005.jpg','1','img_7443_copia.jpg',2),('C29112','Boston Red Sox - MLB',2690000,34,231,'634x634.jpg','1','7468fa2c2f9db84e.jpg',7),('CD5082','PG 4 EP usa',3500000,57,231,'85ad75bc-0633-42df-b950-4a0cf734ad4c-jpg-v-1615897831243.jpg','1','78654492-ac20-4c72-b64f-ea70d81e5b02.jpg',2),('CM997H','New Balance 997H',2690000,2,12,'cm997hca-new-balance-cm997hca.jpg','1','44f12d48b6226a46020628b32df0c613851bc041_CM997HCA_New_Balance_CM997HCA_Grey_SM_1_1024x1024_crop_center.jpg',7),('CN7188','Aztrek',2340000,4,45,'reebok-aztrek-black-cn7188-01-standard.jpg','1','',7),('CQ3022','Prophere',2650000,5,12,'prophere-shoes-black-cq3022-01-standard.jpg','1','cc72123fd7c34111819ea82900cbdaaf_9366.jpg',1),('CT2816','Nike Air Force 1 Low 3D',2950000,24,123,'nike-air-force-1-07-ct2816-001.jpg','1','Nike-Air-Force-1-CT2816-001-Release-Date-1.jpg',2),('CT8527','Jordan 4 Retro University Blue',7900000,12,3,'air-jordan-4-university-blue-ct8527-400-release-date-2-1.jpg','1','',2),('CV2206','Nike React Element 55 Valentines Day',2450000,56,213,'bandbselectshop-cv2206-661.jpg','1','20200210163603_5e4107e38aea6.jpg',2),('D97353','I-5923',1850000,10,211,'i-5923-shoes-black-d97353-01-standard.jpg','1','589c1556712748c2872fa934009621f7_9366.jpg',1),('DA6364','Nike Blazer Low 77 Vintage',2990000,5,213,'blazer-low-77-vintage-mens-shoe-hsxxnh.jpg','1','590a0a051e361515bcc1c5ab7b341ca9.jpg',2),('DB2605','Yung-96',2350000,46,60,'yung-96-shoes-grey-db2605-01-standard.jpg','1','f753d5a7f64f40379d14a9a101048a3c_9366.jpg',1),('DD3111','Nike Blazer Mid Jumbo University Blue',2990000,25,123,'47349a97458f9a8196a5af6cc7bbdf8a-9cd09db0-6989-43f9-a647-67f6467649d9.jpg','1','ナイキ-ブレーザー-mid-77-ジャンボ-メンズシューズ-2N3DN5.jpg',2),('DD3112','Nike Blazer Mid 77 Jumbo Dark Russet',3250000,30,603,'ec1bbb42e3499c66e925de49243cd878-0bd2d187-c35a-454b-ad22-70000e275369.jpg','1','427db0af48e38b354c8096942746bda226b0e029_DD3111_101_nike_blazer_mid_77_jumbo_white_dark_russet_white_sail_SM_1_1024x1024_crop_center.jpg',2),('EA7331','Nike Blazer Mid 77 Paint Splatter',2650000,24,324,'giay-nike-blazer-mid-77-paint-splatter-dc7331-100-2.jpg','1','',2),('EE7009','OZWEEGO',2450000,0,90,'ozweego-shoes-white-ee7009-01-standard.jpg','1','9404122de6f243b58173aa2c012e8872_9366.jpg',1),('EE7238','Yung-96 Chasm',2300000,61,20,'yung-96-chasm-shoes-white-ee7238-01-standard.jpg','1','',1),('EH3463','Reebok Royal Turbo',2450000,50,122,'org.jpg','1','10813643.jpg',7),('FW5303','Reebok Zig Kinetica Horizon',2990000,2,34,'zig-kinetica-horizon-shoes-black-fw5303-01-standard.jpg','1','',7),('FX3433','Reebok Club C',1190000,10,52,'club-c-85-men-s-shoes-white-fx3433-01-standard.jpg','1','',7),('FX5092','Continental 80',2450000,9,213,'continental-80-shoes-white-fx5092-01-standard.jpg','1','0968757e54da459c9cd6ac3a011f48b3_9366.jpg',1),('FY2138','Swift Run X Cloud White',2250000,50,12,'swift-run-x-shoes-white-fy2138-01-standard.jpg','1','4720c5c54c074a728c3fabab013843e1_9366.jpg',1),('FY8786','Dép Adidas Duramo Core Black',1450000,34,101,'duramo-sl-slides-black-fy8786-01-standard.jpg','1','e054f729447145c0ab5aac5400cc0da5_9366.jpg',1),('G27893','Stan Smith',2350000,37,12,'stan-smith-shoes-white-g27893-01-standard.jpg','1','Stan_Smith_Shoes_White_G27893_04_standard.jpg',1),('G28565','Alphaboost Parley',2350000,20,324,'alphaboost-shoes-beige-g28565-01-standard.jpg','1','2c43e1700cdf438f946fa9fc01790582_9366.jpg',1),('HMT921','Domba Moonlake',1500000,9,122,'1993238-l.jpg','1','',7),('M19643','Tubular Runner',1850000,46,37,'dsff.jpg','1','',1),('vn0a38','Era Big Daisies',1850000,10,21,'vn0a38frtoz1-vn0a38frtoz1-primary.jpg','1','VN0A38FRTOZ1_VN0A38FRTOZ1_3.jpg',3),('VN0A54','Vans Freestyle Old Skool 36 DX',2490000,48,213,'vn0a54f397a.jpg','1','10068872_1.jpg',3),('VN0A55','Vans Style 36',2490000,38,9,'s-l400.jpg','1','O1CN01t5K5JG1r7WLB8PUaf_!!3176125584.jpg',3),('VN0ALO','Era YOD',1950000,5,6,'57514000012.jpg','1','',3);
/*!40000 ALTER TABLE `tmp` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-20 23:23:54

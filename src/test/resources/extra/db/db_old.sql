-- MariaDB dump 10.18  Distrib 10.5.7-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: petstore
-- ------------------------------------------------------
-- Server version	10.5.7-MariaDB-1:10.5.7+maria~focal

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `data`
--

DROP TABLE IF EXISTS `data`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_mascota` int(11) NOT NULL,
  `id_categoria` int(11) NOT NULL,
  `valor` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data`
--

LOCK TABLES `data` WRITE;
/*!40000 ALTER TABLE `data` DISABLE KEYS */;
/*!40000 ALTER TABLE `data` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `direccion`
--

DROP TABLE IF EXISTS `direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `direccion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calle_numero` varchar(128) DEFAULT NULL,
  `colonia` varchar(64) DEFAULT NULL,
  `id_pais` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `id_municipio` int(11) NOT NULL,
  `id_tipo_direccion` int(11) NOT NULL,
  `cp` varchar(5) DEFAULT NULL,
  `referencias` varchar(256) DEFAULT NULL,
  `activo` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_direccion_pais` (`id_pais`),
  KEY `fk_direccion_estado` (`id_estado`),
  KEY `fk_direccion_municipio` (`id_municipio`),
  KEY `fk_direccion_tipo_direccion` (`id_tipo_direccion`),
  CONSTRAINT `fk_direccion_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`),
  CONSTRAINT `fk_direccion_municipio` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id`),
  CONSTRAINT `fk_direccion_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`),
  CONSTRAINT `fk_direccion_tipo_direccion` FOREIGN KEY (`id_tipo_direccion`) REFERENCES `tipo_direccion` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direccion`
--

LOCK TABLES `direccion` WRITE;
/*!40000 ALTER TABLE `direccion` DISABLE KEYS */;
INSERT INTO `direccion` VALUES (1,'Lluvia 5678','Jardines de Pedregal',1,1,1,1,'14100','Entre calle Fuego y Calle piedra Tronada',1),(4,'Agua 1234','Jardines de Pedregal',1,1,1,1,'14100','Entre calle Fuego y Lluvia',1);
/*!40000 ALTER TABLE `direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pais` int(11) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_estado_pais` (`id_pais`),
  CONSTRAINT `fk_estado_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,1,'Aguascalientes'),(2,1,'Baja california'),(3,1,'Baja california Sur'),(4,1,'Campeche'),(5,2,'Alabama'),(6,2,'Baltimore'),(7,2,'California'),(8,2,'New York'),(9,3,'Toronto'),(10,3,'Montreal'),(11,3,'Otawa');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipio`
--

DROP TABLE IF EXISTS `municipio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `municipio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_estado` int(11) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_municipio_estado` (`id_estado`),
  CONSTRAINT `fk_municipio_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipio`
--

LOCK TABLES `municipio` WRITE;
/*!40000 ALTER TABLE `municipio` DISABLE KEYS */;
INSERT INTO `municipio` VALUES 
(1,1,'Aguascalientes'),
(2,1,'Jesús Maria'),
(3,1,'Pabellón'),
(4,1,'Calvillo'),
(5,1,'Asientos'),
(6,1,'Cosio'),
(7,1,'Pabellon de Arteaga'),
(8,1,'Rincon de Romos'),
(9,1,'San Jose de Gracia'),
(10,1,'Tepezala'),
(11,1,'San Pancho'),

(12,2,'Mexicali'),
(13,2,'Tijuana'),
(14,2,'Ensenada'),

(15,3,'Cabo San Lucas'),
(16,3,'La Paz'),
(17,3,'Todos los santos'),

(18,4,'Tenabo'),

(19,5,'m01'),
(20,6,'m02'),
(21,7,'m03'),
(22,8,'m04'),
(23,9,'m05'),
(24,10,'m06'),
(25,11,'m07');
/*!40000 ALTER TABLE `municipio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pais`
--

DROP TABLE IF EXISTS `pais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pais` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pais`
--

LOCK TABLES `pais` WRITE;
/*!40000 ALTER TABLE `pais` DISABLE KEYS */;
INSERT INTO `pais` VALUES (1,'México'),(2,'USA'),(3,'Canada');
/*!40000 ALTER TABLE `pais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'admin',1),(2,'normal',1),(3,'operador',1);
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_direccion`
--

DROP TABLE IF EXISTS `tipo_direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_direccion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_direccion`
--

LOCK TABLES `tipo_direccion` WRITE;
/*!40000 ALTER TABLE `tipo_direccion` DISABLE KEYS */;
INSERT INTO `tipo_direccion` VALUES (1,'Casa',1),(2,'Trabajo',1),(3,'Bancaria',1),(4,'Alt',1),(5,'Fiscal',1);
/*!40000 ALTER TABLE `tipo_direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(128) NOT NULL,
  `clave` varchar(128) NOT NULL DEFAULT 'temp',
  `creado` bigint(20) NOT NULL DEFAULT 0,
  `activo` tinyint(1) NOT NULL DEFAULT 0,
  `acceso_negado_contador` int(11) NOT NULL DEFAULT 0,
  `instante_bloqueo` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_acceso` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_cambio_clave` bigint(20) NOT NULL DEFAULT 0,
  `regenera_clave_token` varchar(128) NOT NULL DEFAULT 'NA',
  `regenera_clave_instante` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_usuario_correo` (`correo`),
  KEY `idx_usuario_regenera` (`regenera_clave_token`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'gustavo_arellano@gmail.com','399a89d772ebdc27d7dff05af2877b58f87c3a04086cd32db71bcd3b2c1dc5c4',1618526083301,1,0,0,1619184349779,0,'Kebblar2017',0),(2,'gustavo-arellano@gmail.com','3290a9ceb7ea40b7bfcd82298e02a828a08640d7744f9dd193493c0a15eca7c8',1618526122665,1,0,0,1619184503388,0,'Kebblar2017',0),(3,'gustavo.arellano@gmail.com','704f4f853f903b20c57aba43798d6966b4b5a141bb26fe47d6186473c085c6b6',1618526267651,1,0,0,1618541768297,0,'NA',0),(4,'arellano@gmail.com','13021c93c6bae8e351321ddb6f9d1280cf5bc42fb5205b3c7ee463e1ef3ebb45',1618526343588,1,0,0,0,0,'NA',0),(6,'gustavo@gmail.com','fe8c2458a4a18094721990a4c3e46a5b70d126533c3a0aa1a85d2ebb2b3a3ccc',1618526363060,1,0,0,0,0,'NA',0);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_detalle`
--

DROP TABLE IF EXISTS `usuario_detalle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_detalle` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(32) NOT NULL,
  `apellido_paterno` varchar(32) NOT NULL,
  `apellido_materno` varchar(32) NOT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `nick_name` varchar(128) NOT NULL,
  `telefono_casa` varchar(128) NOT NULL,
  `telefono_celular` varchar(128) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `fk_usuario_detalle_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_detalle`
--

LOCK TABLES `usuario_detalle` WRITE;
/*!40000 ALTER TABLE `usuario_detalle` DISABLE KEYS */;
INSERT INTO `usuario_detalle` VALUES (1,'Miguel','Cervantes','Saavedra',NULL,'Micke','55 9876 5432','55 1234 5678'),(2,'gustavo','arellano','sandoval',NULL,'goose','55 9876 5432','55 5678 8765'),(3,'carlos','salinas','de gortari',NULL,'charlie','55 9876 1111','55 5678 2222');
/*!40000 ALTER TABLE `usuario_detalle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_direccion`
--

DROP TABLE IF EXISTS `usuario_direccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_direccion` (
  `id_usuario` int(11) NOT NULL,
  `id_direccion` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_direccion`),
  KEY `fk_usuario_direccion_direccion` (`id_direccion`),
  CONSTRAINT `fk_usuario_direccion_direccion` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id`),
  CONSTRAINT `fk_usuario_direccion_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_direccion`
--

LOCK TABLES `usuario_direccion` WRITE;
/*!40000 ALTER TABLE `usuario_direccion` DISABLE KEYS */;
INSERT INTO `usuario_direccion` VALUES (1,1),(1,4),(2,4),(3,1);
/*!40000 ALTER TABLE `usuario_direccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_rol`
--

DROP TABLE IF EXISTS `usuario_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_rol` (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(12) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_rol`),
  KEY `fk_usuario_rol_rol` (`id_rol`),
  CONSTRAINT `fk_usuario_rol_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`),
  CONSTRAINT `fk_usuario_rol_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_rol`
--

LOCK TABLES `usuario_rol` WRITE;
/*!40000 ALTER TABLE `usuario_rol` DISABLE KEYS */;
INSERT INTO `usuario_rol` VALUES (1,1),(1,2),(1,3),(2,2),(3,2),(3,3),(4,3),(6,2),(6,3);
/*!40000 ALTER TABLE `usuario_rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-04-28 23:32:18

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
-- Temporary table structure for view `administracion_compras`
--

DROP TABLE IF EXISTS `administracion_compras`;
/*!50001 DROP VIEW IF EXISTS `administracion_compras`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `administracion_compras` (
  `estado_envio` tinyint NOT NULL,
  `calle_numero` tinyint NOT NULL,
  `colonia` tinyint NOT NULL,
  `cp` tinyint NOT NULL,
  `id_direccion` tinyint NOT NULL,
  `cve_orden_compra` tinyint NOT NULL,
  `id_mascota` tinyint NOT NULL,
  `nombre_anuncio` tinyint NOT NULL,
  `recibo` tinyint NOT NULL,
  `id_compra` tinyint NOT NULL,
  `fecha_hora_comprar` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

-- ----------------------------
-- Table structure for anuncio
-- ----------------------------
DROP TABLE IF EXISTS `anuncio`;
CREATE TABLE `anuncio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_categoria` int(11) UNSIGNED NOT NULL,
  `sku` varchar(14) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `titulo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `descripcion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `precio` decimal(10, 2) NOT NULL,
  `fecha_inicio_vigencia` date NULL DEFAULT NULL,
  `fecha_fin_vigencia` date NULL DEFAULT NULL,
  `fecha_alta` datetime(0) NOT NULL,
  `fecha_modificacion` datetime(0) NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  `fecha_eliminacion` datetime(0) NULL DEFAULT NULL,
  `estatus` smallint(2) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_anuncio_categoria`(`id_categoria`) USING BTREE,
  CONSTRAINT `fk_anuncio_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of anuncio
-- ----------------------------

-- ----------------------------
-- Table structure for anuncio_atributo
-- ----------------------------
DROP TABLE IF EXISTS `anuncio_atributo`;
CREATE TABLE `anuncio_atributo`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_anuncio` int(11) NOT NULL,
  `id_atributo` int(11) UNSIGNED NOT NULL,
  `valor` int(11) UNSIGNED NOT NULL,
  `unidad` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_anunacio_atributo`(`id_atributo`) USING BTREE,
  INDEX `fk_anuncio_atributo_anuncio`(`id_anuncio`) USING BTREE,
  CONSTRAINT `fk_anunacio_atributo` FOREIGN KEY (`id_atributo`) REFERENCES `atributo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_anuncio_atributo_anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of anuncio_atributo
-- ----------------------------

-- ----------------------------
-- Table structure for anuncio_imagen
-- ----------------------------
DROP TABLE IF EXISTS `anuncio_imagen`;
CREATE TABLE `anuncio_imagen`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_anuncio` int(11) NOT NULL,
  `uuid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `imagen` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_anuncio_imagen_anuncio`(`id_anuncio`) USING BTREE,
  CONSTRAINT `fk_anuncio_imagen_anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of anuncio_imagen
-- ----------------------------

-- ----------------------------
-- Table structure for atributo
-- ----------------------------
DROP TABLE IF EXISTS `atributo`;
CREATE TABLE `atributo`  (
  `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `atributo` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of atributo
-- ----------------------------
INSERT INTO `atributo` VALUES (1, 'PESO');
INSERT INTO `atributo` VALUES (2, 'RAZA');
INSERT INTO `atributo` VALUES (3, 'COLOR');
INSERT INTO `atributo` VALUES (4, 'TAMAÑO');
INSERT INTO `atributo` VALUES (5, 'EDAD');
INSERT INTO `atributo` VALUES (6, 'LONGEVIDAD');
INSERT INTO `atributo` VALUES (7, 'TIPO DE AGUA');

-- ----------------------------
-- Table structure for btc_wallet
-- ----------------------------
DROP TABLE IF EXISTS `btc_wallet`;
CREATE TABLE `btc_wallet`  (
  `id_usuario` int(11) NOT NULL,
  `wallet_number` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `p_key` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`wallet_number`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of btc_wallet
-- ----------------------------

-- ----------------------------
-- Table structure for categoria
-- ----------------------------
DROP TABLE IF EXISTS `categoria`;
CREATE TABLE `categoria`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `categoria` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `activo` bit(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categoria
-- ----------------------------
INSERT INTO `categoria` VALUES (1, 'CANINOS', b'1');
INSERT INTO `categoria` VALUES (2, 'FELINOS', b'1');
INSERT INTO `categoria` VALUES (3, 'ARACNIDOS', b'1');
INSERT INTO `categoria` VALUES (4, 'REPTILES', b'1');
INSERT INTO `categoria` VALUES (5, 'PECES', b'1');
INSERT INTO `categoria` VALUES (6, 'AVES', b'1');
INSERT INTO `categoria` VALUES (7, 'ROEDORES', b'1');

-- ----------------------------
-- Table structure for categoria_atributo
-- ----------------------------
DROP TABLE IF EXISTS `categoria_atributo`;
CREATE TABLE `categoria_atributo`  (
  `id_categoria` int(11) UNSIGNED NOT NULL,
  `id_atributo` int(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_categoria`, `id_atributo`) USING BTREE,
  INDEX `fk_categoria_atributo`(`id_atributo`) USING BTREE,
  CONSTRAINT `fk_categoria_atributo` FOREIGN KEY (`id_atributo`) REFERENCES `atributo` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_categoria_categoria` FOREIGN KEY (`id_categoria`) REFERENCES `categoria` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of categoria_atributo
-- ----------------------------
INSERT INTO `categoria_atributo` VALUES (1, 1);
INSERT INTO `categoria_atributo` VALUES (1, 2);
INSERT INTO `categoria_atributo` VALUES (1, 3);
INSERT INTO `categoria_atributo` VALUES (1, 4);
INSERT INTO `categoria_atributo` VALUES (1, 5);
INSERT INTO `categoria_atributo` VALUES (1, 6);
INSERT INTO `categoria_atributo` VALUES (2, 1);
INSERT INTO `categoria_atributo` VALUES (2, 3);
INSERT INTO `categoria_atributo` VALUES (2, 4);
INSERT INTO `categoria_atributo` VALUES (2, 5);
INSERT INTO `categoria_atributo` VALUES (2, 6);
INSERT INTO `categoria_atributo` VALUES (3, 1);
INSERT INTO `categoria_atributo` VALUES (3, 4);
INSERT INTO `categoria_atributo` VALUES (3, 5);
INSERT INTO `categoria_atributo` VALUES (3, 6);
INSERT INTO `categoria_atributo` VALUES (4, 1);
INSERT INTO `categoria_atributo` VALUES (4, 4);
INSERT INTO `categoria_atributo` VALUES (4, 5);
INSERT INTO `categoria_atributo` VALUES (4, 6);
INSERT INTO `categoria_atributo` VALUES (5, 1);
INSERT INTO `categoria_atributo` VALUES (5, 3);
INSERT INTO `categoria_atributo` VALUES (5, 4);
INSERT INTO `categoria_atributo` VALUES (5, 5);
INSERT INTO `categoria_atributo` VALUES (5, 6);
INSERT INTO `categoria_atributo` VALUES (5, 7);
INSERT INTO `categoria_atributo` VALUES (6, 1);
INSERT INTO `categoria_atributo` VALUES (6, 3);
INSERT INTO `categoria_atributo` VALUES (6, 4);
INSERT INTO `categoria_atributo` VALUES (6, 5);
INSERT INTO `categoria_atributo` VALUES (6, 6);
INSERT INTO `categoria_atributo` VALUES (7, 1);
INSERT INTO `categoria_atributo` VALUES (7, 3);
INSERT INTO `categoria_atributo` VALUES (7, 4);
INSERT INTO `categoria_atributo` VALUES (7, 5);
INSERT INTO `categoria_atributo` VALUES (7, 6);

-- ----------------------------
-- Table structure for direccion
-- ----------------------------
DROP TABLE IF EXISTS `direccion`;
CREATE TABLE `direccion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `calle_numero` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `colonia` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_pais` int(11) NOT NULL,
  `id_estado` int(11) NOT NULL,
  `id_municipio` int(11) NOT NULL,
  `id_tipo_direccion` int(11) NOT NULL,
  `cp` varchar(5) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `referencias` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `activo` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_direccion_pais`(`id_pais`) USING BTREE,
  INDEX `fk_direccion_estado`(`id_estado`) USING BTREE,
  INDEX `fk_direccion_municipio`(`id_municipio`) USING BTREE,
  INDEX `fk_direccion_tipo_direccion`(`id_tipo_direccion`) USING BTREE,
  CONSTRAINT `fk_direccion_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_direccion_municipio` FOREIGN KEY (`id_municipio`) REFERENCES `municipio` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_direccion_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_direccion_tipo_direccion` FOREIGN KEY (`id_tipo_direccion`) REFERENCES `tipo_direccion` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of direccion
-- ----------------------------
INSERT INTO `direccion` VALUES (35, 'calle 3', 'col 6', 1, 15, 676, 1, '25869', 'casa verde', 1);
INSERT INTO `direccion` VALUES (36, 'srwaer 23', 'col 5', 1, 15, 693, 1, '05265', 'casa verde', 1);
INSERT INTO `direccion` VALUES (37, 'Calle 4`', 'Col 5', 1, 12, 383, 1, '00256', 'casa verde', 1);

-- ----------------------------
-- Table structure for direccion_con_nombre
-- ----------------------------
DROP TABLE IF EXISTS `direccion_con_nombre`;
CREATE TABLE `direccion_con_nombre`  (
  `id` tinyint(4) NOT NULL,
  `calle_numero` tinyint(4) NOT NULL,
  `colonia` tinyint(4) NOT NULL,
  `cp` tinyint(4) NOT NULL,
  `activo` tinyint(4) NOT NULL,
  `municipio_nombre` tinyint(4) NOT NULL,
  `estado_nombre` tinyint(4) NOT NULL,
  `pais_nombre` tinyint(4) NOT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of direccion_con_nombre
-- ----------------------------

-- ----------------------------
-- Table structure for estado
-- ----------------------------
DROP TABLE IF EXISTS `estado`;
CREATE TABLE `estado`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_pais` int(11) NOT NULL,
  `nombre` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_estado_pais`(`id_pais`) USING BTREE,
  CONSTRAINT `fk_estado_pais` FOREIGN KEY (`id_pais`) REFERENCES `pais` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of estado
-- ----------------------------
INSERT INTO `estado` VALUES (1, 1, 'Aguascalientes');
INSERT INTO `estado` VALUES (2, 1, 'Baja California');
INSERT INTO `estado` VALUES (3, 1, 'Baja California Sur');
INSERT INTO `estado` VALUES (4, 1, 'Campeche');
INSERT INTO `estado` VALUES (5, 1, 'Coahuila');
INSERT INTO `estado` VALUES (6, 1, 'Colima');
INSERT INTO `estado` VALUES (7, 1, 'Chiapas');
INSERT INTO `estado` VALUES (8, 1, 'Chihuahua');
INSERT INTO `estado` VALUES (9, 1, 'Distrito Federal');
INSERT INTO `estado` VALUES (10, 1, 'Durango');
INSERT INTO `estado` VALUES (11, 1, 'Guanajuato');
INSERT INTO `estado` VALUES (12, 1, 'Guerrero');
INSERT INTO `estado` VALUES (13, 1, 'Hidalgo');
INSERT INTO `estado` VALUES (14, 1, 'Jalisco');
INSERT INTO `estado` VALUES (15, 1, 'Estado de Mxico');
INSERT INTO `estado` VALUES (16, 1, 'Michoacan');
INSERT INTO `estado` VALUES (17, 1, 'Morelos');
INSERT INTO `estado` VALUES (18, 1, 'Nayarit');
INSERT INTO `estado` VALUES (19, 1, 'Nuevo Lennn');
INSERT INTO `estado` VALUES (20, 1, 'Oaxaca');
INSERT INTO `estado` VALUES (21, 1, 'Puebla');
INSERT INTO `estado` VALUES (22, 1, 'Quertaro');
INSERT INTO `estado` VALUES (23, 1, 'Quintana Roo');
INSERT INTO `estado` VALUES (24, 1, 'San Luis Potosi');
INSERT INTO `estado` VALUES (25, 1, 'Sinaloa');
INSERT INTO `estado` VALUES (26, 1, 'Sonora');
INSERT INTO `estado` VALUES (27, 1, 'Tabasco');
INSERT INTO `estado` VALUES (28, 1, 'Tamaulipas');
INSERT INTO `estado` VALUES (29, 1, 'Tlaxcala');
INSERT INTO `estado` VALUES (30, 1, 'Veracruz');
INSERT INTO `estado` VALUES (31, 1, 'Yucatn');
INSERT INTO `estado` VALUES (32, 1, 'Zacatecas');
INSERT INTO `estado` VALUES (33, 2, 'Alabama');
INSERT INTO `estado` VALUES (34, 2, 'Alaska');
INSERT INTO `estado` VALUES (35, 2, 'Arizona');
INSERT INTO `estado` VALUES (36, 2, 'Arkansas');
INSERT INTO `estado` VALUES (37, 2, 'California');
INSERT INTO `estado` VALUES (38, 2, 'Colorado');
INSERT INTO `estado` VALUES (39, 2, 'Connecticut');
INSERT INTO `estado` VALUES (40, 2, 'Delaware');
INSERT INTO `estado` VALUES (41, 2, 'Florida');
INSERT INTO `estado` VALUES (42, 2, 'Georgia');
INSERT INTO `estado` VALUES (43, 2, 'Hawaii');
INSERT INTO `estado` VALUES (44, 2, 'Idaho');
INSERT INTO `estado` VALUES (45, 2, 'Indiana');
INSERT INTO `estado` VALUES (46, 2, 'Iowa');
INSERT INTO `estado` VALUES (47, 2, 'Kansas');
INSERT INTO `estado` VALUES (48, 2, 'Kentucky');
INSERT INTO `estado` VALUES (49, 2, 'Louisiana');
INSERT INTO `estado` VALUES (50, 2, 'Maine');
INSERT INTO `estado` VALUES (51, 2, 'Maryland');
INSERT INTO `estado` VALUES (52, 2, 'Massachusetts');
INSERT INTO `estado` VALUES (53, 2, 'Michigan');
INSERT INTO `estado` VALUES (54, 2, 'Minnesota');
INSERT INTO `estado` VALUES (55, 2, 'Mississippi');
INSERT INTO `estado` VALUES (56, 2, 'Missouri');
INSERT INTO `estado` VALUES (57, 2, 'Montana');
INSERT INTO `estado` VALUES (58, 2, 'Nebraska');
INSERT INTO `estado` VALUES (59, 2, 'Nevada');
INSERT INTO `estado` VALUES (60, 2, 'New Hampshire');
INSERT INTO `estado` VALUES (61, 2, 'New Jersey');
INSERT INTO `estado` VALUES (62, 2, 'New Mexico');
INSERT INTO `estado` VALUES (63, 2, 'New York');
INSERT INTO `estado` VALUES (64, 2, 'North Carolina');
INSERT INTO `estado` VALUES (65, 2, 'North Dakota');
INSERT INTO `estado` VALUES (66, 2, 'Ohio');
INSERT INTO `estado` VALUES (67, 2, 'Oklahoma');
INSERT INTO `estado` VALUES (68, 2, 'Oregon');
INSERT INTO `estado` VALUES (69, 2, 'Pennsylvania');
INSERT INTO `estado` VALUES (70, 2, 'Rhode Island');
INSERT INTO `estado` VALUES (71, 2, 'South Carolina');
INSERT INTO `estado` VALUES (72, 2, 'South Dakota');
INSERT INTO `estado` VALUES (73, 2, 'Tennessee');
INSERT INTO `estado` VALUES (74, 2, 'Texas');
INSERT INTO `estado` VALUES (75, 2, 'Utah');
INSERT INTO `estado` VALUES (76, 2, 'Vermont');
INSERT INTO `estado` VALUES (77, 2, 'Virginia');
INSERT INTO `estado` VALUES (78, 2, 'Washington');
INSERT INTO `estado` VALUES (79, 2, 'West Virginia');
INSERT INTO `estado` VALUES (80, 2, 'Wisconsin');
INSERT INTO `estado` VALUES (81, 2, 'Wyoming');

-- ----------------------------
-- Table structure for historial_compras
-- ----------------------------
DROP TABLE IF EXISTS `historial_compras`;
CREATE TABLE `historial_compras`  (
  `id` tinyint(4) NOT NULL,
  `fecha_hora_comprar` tinyint(4) NOT NULL,
  `estado_envio` tinyint(4) NOT NULL,
  `nombre_anuncio` tinyint(4) NOT NULL,
  `tipo` tinyint(4) NOT NULL,
  `correo` tinyint(4) NOT NULL,
  `recibo` tinyint(4) NOT NULL,
  `imagen` tinyint(4) NOT NULL,
  `id_usuario` tinyint(4) NOT NULL
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Fixed;

-- ----------------------------
-- Records of historial_compras
-- ----------------------------

-- ----------------------------
-- Table structure for mascota
-- ----------------------------
DROP TABLE IF EXISTS `mascota`;
CREATE TABLE `mascota`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de mascota',
  `nombre` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Atributo que representa el nombre de una mascota',
  `descuento` tinyint(3) NULL DEFAULT NULL COMMENT 'Atributo que representa el descuento que podria tener una mascota',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mascota
-- ----------------------------
INSERT INTO `mascota` VALUES (1, 'perro', 1);

-- ----------------------------
-- Table structure for metodo_pago
-- ----------------------------
DROP TABLE IF EXISTS `metodo_pago`;
CREATE TABLE `metodo_pago`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de metodo de pago',
  `tipo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Atributo que representa el tipo de pago, por ejemplo, tarjeta de crdito, dbito, PayPal, etc.',
  `activo` tinyint(1) NULL DEFAULT NULL COMMENT 'Atributo que representa si el registro se encuentra activo',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of metodo_pago
-- ----------------------------
INSERT INTO `metodo_pago` VALUES (1, 'paypal', 1);

-- ----------------------------
-- Table structure for moneda
-- ----------------------------
DROP TABLE IF EXISTS `moneda`;
CREATE TABLE `moneda`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Identificador de moneda',
  `nombre` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'Atributo que representa el nombre de de la moneda, por ejemplo dlllar, pesos, euros, etc',
  `activo` tinyint(1) NULL DEFAULT NULL COMMENT 'Atributo que representa si el registro se encuentra activo',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of moneda
-- ----------------------------
INSERT INTO `moneda` VALUES (1, 'pesos', 1);

-- ----------------------------
-- Table structure for municipio
-- ----------------------------
DROP TABLE IF EXISTS `municipio`;
CREATE TABLE `municipio`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_estado` int(11) NOT NULL,
  `nombre` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_orden` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_municipio_estado`(`id_estado`) USING BTREE,
  CONSTRAINT `fk_municipio_estado` FOREIGN KEY (`id_estado`) REFERENCES `estado` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2598 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of municipio
-- ----------------------------
INSERT INTO `municipio` VALUES (1, 1, 'AGUASCALIENTES', 1);
INSERT INTO `municipio` VALUES (2, 1, 'ASIENTOS', 2);
INSERT INTO `municipio` VALUES (3, 1, 'CALVILLO', 3);
INSERT INTO `municipio` VALUES (4, 1, 'COSIO', 4);
INSERT INTO `municipio` VALUES (5, 1, 'JESUS MARIA', 5);
INSERT INTO `municipio` VALUES (6, 1, 'PABELLON DE ARTEAGA', 6);
INSERT INTO `municipio` VALUES (7, 1, 'RINCON DE ROMOS', 7);
INSERT INTO `municipio` VALUES (8, 1, 'SAN JOSE DE GRACIA', 8);
INSERT INTO `municipio` VALUES (9, 1, 'TEPEZALA', 9);
INSERT INTO `municipio` VALUES (10, 1, 'EL LLANO', 10);
INSERT INTO `municipio` VALUES (11, 1, 'SAN FRANCISCO DE LOS ROMO', 11);
INSERT INTO `municipio` VALUES (13, 2, 'ENSENADA', 1);
INSERT INTO `municipio` VALUES (14, 2, 'MEXICALI', 2);
INSERT INTO `municipio` VALUES (15, 2, 'TECATE', 3);
INSERT INTO `municipio` VALUES (16, 2, 'TIJUANA', 4);
INSERT INTO `municipio` VALUES (17, 2, 'PLAYAS DE ROSARITO', 5);
INSERT INTO `municipio` VALUES (19, 3, 'COMONDU', 1);
INSERT INTO `municipio` VALUES (20, 3, 'MULEGE', 2);
INSERT INTO `municipio` VALUES (21, 3, 'LA PAZ', 3);
INSERT INTO `municipio` VALUES (22, 3, 'LOS CABOS', 8);
INSERT INTO `municipio` VALUES (23, 3, 'LORETO', 9);
INSERT INTO `municipio` VALUES (25, 4, 'CALKINI', 1);
INSERT INTO `municipio` VALUES (26, 4, 'CAMPECHE', 2);
INSERT INTO `municipio` VALUES (27, 4, 'CARMEN', 3);
INSERT INTO `municipio` VALUES (28, 4, 'CHAMPOTON', 4);
INSERT INTO `municipio` VALUES (29, 4, 'HECELCHAKAN', 5);
INSERT INTO `municipio` VALUES (30, 4, 'HOPELCHEN', 6);
INSERT INTO `municipio` VALUES (31, 4, 'PALIZADA', 7);
INSERT INTO `municipio` VALUES (32, 4, 'TENABO', 8);
INSERT INTO `municipio` VALUES (33, 4, 'ESCARCEGA', 9);
INSERT INTO `municipio` VALUES (34, 4, 'CALAKMUL', 10);
INSERT INTO `municipio` VALUES (35, 4, 'CANDELARIA', 11);
INSERT INTO `municipio` VALUES (37, 5, 'ABASOLO', 1);
INSERT INTO `municipio` VALUES (38, 5, 'ACUNA', 2);
INSERT INTO `municipio` VALUES (39, 5, 'ALLENDE', 3);
INSERT INTO `municipio` VALUES (40, 5, 'ARTEAGA', 4);
INSERT INTO `municipio` VALUES (41, 5, 'CANDELA', 5);
INSERT INTO `municipio` VALUES (42, 5, 'CASTANOS', 6);
INSERT INTO `municipio` VALUES (43, 5, 'CUATRO CIENEGAS', 7);
INSERT INTO `municipio` VALUES (44, 5, 'ESCOBEDO', 8);
INSERT INTO `municipio` VALUES (45, 5, 'FRANCISCO I. MADERO', 9);
INSERT INTO `municipio` VALUES (46, 5, 'FRONTERA', 10);
INSERT INTO `municipio` VALUES (47, 5, 'GENERAL CEPEDA', 11);
INSERT INTO `municipio` VALUES (48, 5, 'GUERRERO', 12);
INSERT INTO `municipio` VALUES (49, 5, 'HIDALGO', 13);
INSERT INTO `municipio` VALUES (50, 5, 'JIMENEZ', 14);
INSERT INTO `municipio` VALUES (51, 5, 'JUAREZ', 15);
INSERT INTO `municipio` VALUES (52, 5, 'LAMADRID', 16);
INSERT INTO `municipio` VALUES (53, 5, 'MATAMOROS', 17);
INSERT INTO `municipio` VALUES (54, 5, 'MONCLOVA', 18);
INSERT INTO `municipio` VALUES (55, 5, 'MORELOS', 19);
INSERT INTO `municipio` VALUES (56, 5, 'MUZQUIZ', 20);
INSERT INTO `municipio` VALUES (57, 5, 'NADADORES', 21);
INSERT INTO `municipio` VALUES (58, 5, 'NAVA', 22);
INSERT INTO `municipio` VALUES (59, 5, 'OCAMPO', 23);
INSERT INTO `municipio` VALUES (60, 5, 'PARRAS', 24);
INSERT INTO `municipio` VALUES (61, 5, 'PIEDRAS NEGRAS', 25);
INSERT INTO `municipio` VALUES (62, 5, 'PROGRESO', 26);
INSERT INTO `municipio` VALUES (63, 5, 'RAMOS ARIZPE', 27);
INSERT INTO `municipio` VALUES (64, 5, 'SABINAS', 28);
INSERT INTO `municipio` VALUES (65, 5, 'SACRAMENTO', 29);
INSERT INTO `municipio` VALUES (66, 5, 'SALTILLO', 30);
INSERT INTO `municipio` VALUES (67, 5, 'SAN BUENAVENTURA', 31);
INSERT INTO `municipio` VALUES (68, 5, 'SAN JUAN DE SABINAS', 32);
INSERT INTO `municipio` VALUES (69, 5, 'SAN PEDRO', 33);
INSERT INTO `municipio` VALUES (70, 5, 'SIERRA MOJADA', 34);
INSERT INTO `municipio` VALUES (71, 5, 'TORREON', 35);
INSERT INTO `municipio` VALUES (72, 5, 'VIESCA', 36);
INSERT INTO `municipio` VALUES (73, 5, 'VILLA UNION', 37);
INSERT INTO `municipio` VALUES (74, 5, 'ZARAGOZA', 38);
INSERT INTO `municipio` VALUES (76, 6, 'ARMERIA', 1);
INSERT INTO `municipio` VALUES (77, 6, 'COLIMA', 2);
INSERT INTO `municipio` VALUES (78, 6, 'COMALA', 3);
INSERT INTO `municipio` VALUES (79, 6, 'COQUIMATLAN', 4);
INSERT INTO `municipio` VALUES (80, 6, 'CUAUHTEMOC', 5);
INSERT INTO `municipio` VALUES (81, 6, 'IXTLAHUACAN', 6);
INSERT INTO `municipio` VALUES (82, 6, 'MANZANILLO', 7);
INSERT INTO `municipio` VALUES (83, 6, 'MINATITLAN', 8);
INSERT INTO `municipio` VALUES (84, 6, 'TECOMAN', 9);
INSERT INTO `municipio` VALUES (85, 6, 'VILLA DE ALVAREZ', 10);
INSERT INTO `municipio` VALUES (87, 7, 'ACACOYAGUA', 1);
INSERT INTO `municipio` VALUES (88, 7, 'ACALA', 2);
INSERT INTO `municipio` VALUES (89, 7, 'ACAPETAHUA', 3);
INSERT INTO `municipio` VALUES (90, 7, 'ALTAMIRANO', 4);
INSERT INTO `municipio` VALUES (91, 7, 'AMATAN', 5);
INSERT INTO `municipio` VALUES (92, 7, 'AMATENANGO DE LA FRONTERA', 6);
INSERT INTO `municipio` VALUES (93, 7, 'AMATENANGO DEL VALLE', 7);
INSERT INTO `municipio` VALUES (94, 7, 'ANGEL ALBINO CORZO', 8);
INSERT INTO `municipio` VALUES (95, 7, 'ARRIAGA', 9);
INSERT INTO `municipio` VALUES (96, 7, 'BEJUCAL DE OCAMPO', 10);
INSERT INTO `municipio` VALUES (97, 7, 'BELLA VISTA', 11);
INSERT INTO `municipio` VALUES (98, 7, 'BERRIOZABAL', 12);
INSERT INTO `municipio` VALUES (99, 7, 'BOCHIL', 13);
INSERT INTO `municipio` VALUES (100, 7, 'EL BOSQUE', 14);
INSERT INTO `municipio` VALUES (101, 7, 'CACAHOATAN', 15);
INSERT INTO `municipio` VALUES (102, 7, 'CATAZAJA', 16);
INSERT INTO `municipio` VALUES (103, 7, 'CINTALAPA', 17);
INSERT INTO `municipio` VALUES (104, 7, 'COAPILLA', 18);
INSERT INTO `municipio` VALUES (105, 7, 'COMITAN DE DOMINGUEZ', 19);
INSERT INTO `municipio` VALUES (106, 7, 'LA CONCORDIA', 20);
INSERT INTO `municipio` VALUES (107, 7, 'COPAINALA', 21);
INSERT INTO `municipio` VALUES (108, 7, 'CHALCHIHUITAN', 22);
INSERT INTO `municipio` VALUES (109, 7, 'CHAMULA', 23);
INSERT INTO `municipio` VALUES (110, 7, 'CHANAL', 24);
INSERT INTO `municipio` VALUES (111, 7, 'CHAPULTENANGO', 25);
INSERT INTO `municipio` VALUES (112, 7, 'CHENALHO', 26);
INSERT INTO `municipio` VALUES (113, 7, 'CHIAPA DE CORZO', 27);
INSERT INTO `municipio` VALUES (114, 7, 'CHIAPILLA', 28);
INSERT INTO `municipio` VALUES (115, 7, 'CHICOASEN', 29);
INSERT INTO `municipio` VALUES (116, 7, 'CHICOMUSELO', 30);
INSERT INTO `municipio` VALUES (117, 7, 'CHILON', 31);
INSERT INTO `municipio` VALUES (118, 7, 'ESCUINTLA', 32);
INSERT INTO `municipio` VALUES (119, 7, 'FRANCISCO LEON', 33);
INSERT INTO `municipio` VALUES (120, 7, 'FRONTERA COMALAPA', 34);
INSERT INTO `municipio` VALUES (121, 7, 'FRONTERA HIDALGO', 35);
INSERT INTO `municipio` VALUES (122, 7, 'LA GRANDEZA', 36);
INSERT INTO `municipio` VALUES (123, 7, 'HUEHUETAN', 37);
INSERT INTO `municipio` VALUES (124, 7, 'HUIXTAN', 38);
INSERT INTO `municipio` VALUES (125, 7, 'HUITIUPAN', 39);
INSERT INTO `municipio` VALUES (126, 7, 'HUIXTLA', 40);
INSERT INTO `municipio` VALUES (127, 7, 'LA INDEPENDENCIA', 41);
INSERT INTO `municipio` VALUES (128, 7, 'IXHUATAN', 42);
INSERT INTO `municipio` VALUES (129, 7, 'IXTACOMITAN', 43);
INSERT INTO `municipio` VALUES (130, 7, 'IXTAPA', 44);
INSERT INTO `municipio` VALUES (131, 7, 'IXTAPANGAJOYA', 45);
INSERT INTO `municipio` VALUES (132, 7, 'JIQUIPILAS', 46);
INSERT INTO `municipio` VALUES (133, 7, 'JITOTOL', 47);
INSERT INTO `municipio` VALUES (134, 7, 'JUAREZ', 48);
INSERT INTO `municipio` VALUES (135, 7, 'LARRAINZAR', 49);
INSERT INTO `municipio` VALUES (136, 7, 'LA LIBERTAD', 50);
INSERT INTO `municipio` VALUES (137, 7, 'MAPASTEPEC', 51);
INSERT INTO `municipio` VALUES (138, 7, 'LAS MARGARITAS', 52);
INSERT INTO `municipio` VALUES (139, 7, 'MAZAPA DE MADERO', 53);
INSERT INTO `municipio` VALUES (140, 7, 'MAZATAN', 54);
INSERT INTO `municipio` VALUES (141, 7, 'METAPA', 55);
INSERT INTO `municipio` VALUES (142, 7, 'MITONTIC', 56);
INSERT INTO `municipio` VALUES (143, 7, 'MOTOZINTLA', 57);
INSERT INTO `municipio` VALUES (144, 7, 'NICOLAS RUIZ', 58);
INSERT INTO `municipio` VALUES (145, 7, 'OCOSINGO', 59);
INSERT INTO `municipio` VALUES (146, 7, 'OCOTEPEC', 60);
INSERT INTO `municipio` VALUES (147, 7, 'OCOZOCOAUTLA DE ESPINOSA', 61);
INSERT INTO `municipio` VALUES (148, 7, 'OSTUACAN', 62);
INSERT INTO `municipio` VALUES (149, 7, 'OSUMACINTA', 63);
INSERT INTO `municipio` VALUES (150, 7, 'OXCHUC', 64);
INSERT INTO `municipio` VALUES (151, 7, 'PALENQUE', 65);
INSERT INTO `municipio` VALUES (152, 7, 'PANTELHO', 66);
INSERT INTO `municipio` VALUES (153, 7, 'PANTEPEC', 67);
INSERT INTO `municipio` VALUES (154, 7, 'PICHUCALCO', 68);
INSERT INTO `municipio` VALUES (155, 7, 'PIJIJIAPAN', 69);
INSERT INTO `municipio` VALUES (156, 7, 'EL PORVENIR', 70);
INSERT INTO `municipio` VALUES (157, 7, 'VILLA COMALTITLAN', 71);
INSERT INTO `municipio` VALUES (158, 7, 'PUEBLO NUEVO SOLISTAHUACAN', 72);
INSERT INTO `municipio` VALUES (159, 7, 'RAYON', 73);
INSERT INTO `municipio` VALUES (160, 7, 'REFORMA', 74);
INSERT INTO `municipio` VALUES (161, 7, 'LAS ROSAS', 75);
INSERT INTO `municipio` VALUES (162, 7, 'SABANILLA', 76);
INSERT INTO `municipio` VALUES (163, 7, 'SALTO DE AGUA', 77);
INSERT INTO `municipio` VALUES (164, 7, 'SAN CRISTOBAL DE LAS CASAS', 78);
INSERT INTO `municipio` VALUES (165, 7, 'SAN FERNANDO', 79);
INSERT INTO `municipio` VALUES (166, 7, 'SILTEPEC', 80);
INSERT INTO `municipio` VALUES (167, 7, 'SIMOJOVEL', 81);
INSERT INTO `municipio` VALUES (168, 7, 'SITALA', 82);
INSERT INTO `municipio` VALUES (169, 7, 'SOCOLTENANGO', 83);
INSERT INTO `municipio` VALUES (170, 7, 'SOLOSUCHIAPA', 84);
INSERT INTO `municipio` VALUES (171, 7, 'SOYALO', 85);
INSERT INTO `municipio` VALUES (172, 7, 'SUCHIAPA', 86);
INSERT INTO `municipio` VALUES (173, 7, 'SUCHIATE', 87);
INSERT INTO `municipio` VALUES (174, 7, 'SUNUAPA', 88);
INSERT INTO `municipio` VALUES (175, 7, 'TAPACHULA', 89);
INSERT INTO `municipio` VALUES (176, 7, 'TAPALAPA', 90);
INSERT INTO `municipio` VALUES (177, 7, 'TAPILULA', 91);
INSERT INTO `municipio` VALUES (178, 7, 'TECPATAN', 92);
INSERT INTO `municipio` VALUES (179, 7, 'TENEJAPA', 93);
INSERT INTO `municipio` VALUES (180, 7, 'TEOPISCA', 94);
INSERT INTO `municipio` VALUES (181, 7, 'TILA', 96);
INSERT INTO `municipio` VALUES (182, 7, 'TONALA', 97);
INSERT INTO `municipio` VALUES (183, 7, 'TOTOLAPA', 98);
INSERT INTO `municipio` VALUES (184, 7, 'LA TRINITARIA', 99);
INSERT INTO `municipio` VALUES (185, 7, 'TUMBALA', 100);
INSERT INTO `municipio` VALUES (186, 7, 'TUXTLA GUTIERREZ', 101);
INSERT INTO `municipio` VALUES (187, 7, 'TUXTLA CHICO', 102);
INSERT INTO `municipio` VALUES (188, 7, 'TUZANTAN', 103);
INSERT INTO `municipio` VALUES (189, 7, 'TZIMOL', 104);
INSERT INTO `municipio` VALUES (190, 7, 'UNION JUAREZ', 105);
INSERT INTO `municipio` VALUES (191, 7, 'VENUSTIANO CARRANZA', 106);
INSERT INTO `municipio` VALUES (192, 7, 'VILLA CORZO', 107);
INSERT INTO `municipio` VALUES (193, 7, 'VILLAFLORES', 108);
INSERT INTO `municipio` VALUES (194, 7, 'YAJALON', 109);
INSERT INTO `municipio` VALUES (195, 7, 'SAN LUCAS', 110);
INSERT INTO `municipio` VALUES (196, 7, 'ZINACANTAN', 111);
INSERT INTO `municipio` VALUES (197, 7, 'SAN JUAN CANCUC', 112);
INSERT INTO `municipio` VALUES (198, 7, 'ALDAMA', 113);
INSERT INTO `municipio` VALUES (199, 7, 'BENEMERITO DE LAS AMERICAS', 114);
INSERT INTO `municipio` VALUES (200, 7, 'MARAVILLA TENEJAPA', 115);
INSERT INTO `municipio` VALUES (201, 7, 'MARQUES DE COMILLAS', 116);
INSERT INTO `municipio` VALUES (202, 7, 'MONTECRISTO DE GUERRERO', 117);
INSERT INTO `municipio` VALUES (203, 7, 'SAN ANDRES DURAZNAL', 118);
INSERT INTO `municipio` VALUES (204, 7, 'SANTIAGO EL PINAR', 119);
INSERT INTO `municipio` VALUES (205, 7, 'CAPITAN LUIS ANGEL VIDAL', 120);
INSERT INTO `municipio` VALUES (206, 7, 'RINCON CHAMULA SAN PEDRO', 121);
INSERT INTO `municipio` VALUES (207, 7, 'EL PARRAL', 122);
INSERT INTO `municipio` VALUES (208, 7, 'EMILIANO ZAPATA', 123);
INSERT INTO `municipio` VALUES (209, 7, 'MEZCALAPA', 124);
INSERT INTO `municipio` VALUES (211, 8, 'AHUMADA', 1);
INSERT INTO `municipio` VALUES (212, 8, 'ALDAMA', 2);
INSERT INTO `municipio` VALUES (213, 8, 'ALLENDE', 3);
INSERT INTO `municipio` VALUES (214, 8, 'AQUILES SERDAN', 4);
INSERT INTO `municipio` VALUES (215, 8, 'ASCENSION', 5);
INSERT INTO `municipio` VALUES (216, 8, 'BACHINIVA', 6);
INSERT INTO `municipio` VALUES (217, 8, 'BALLEZA', 7);
INSERT INTO `municipio` VALUES (218, 8, 'BATOPILAS DE MANUEL GOMEZ MORIN', 8);
INSERT INTO `municipio` VALUES (219, 8, 'BOCOYNA', 9);
INSERT INTO `municipio` VALUES (220, 8, 'BUENAVENTURA', 10);
INSERT INTO `municipio` VALUES (221, 8, 'CAMARGO', 11);
INSERT INTO `municipio` VALUES (222, 8, 'CARICHI', 12);
INSERT INTO `municipio` VALUES (223, 8, 'CASAS GRANDES', 13);
INSERT INTO `municipio` VALUES (224, 8, 'CORONADO', 14);
INSERT INTO `municipio` VALUES (225, 8, 'COYAME DEL SOTOL', 15);
INSERT INTO `municipio` VALUES (226, 8, 'LA CRUZ', 16);
INSERT INTO `municipio` VALUES (227, 8, 'CUAUHTEMOC', 17);
INSERT INTO `municipio` VALUES (228, 8, 'CUSIHUIRIACHI', 18);
INSERT INTO `municipio` VALUES (229, 8, 'CHIHUAHUA', 19);
INSERT INTO `municipio` VALUES (230, 8, 'CHINIPAS', 20);
INSERT INTO `municipio` VALUES (231, 8, 'DELICIAS', 21);
INSERT INTO `municipio` VALUES (232, 8, 'DR. BELISARIO DOMINGUEZ', 22);
INSERT INTO `municipio` VALUES (233, 8, 'GALEANA', 23);
INSERT INTO `municipio` VALUES (234, 8, 'SANTA ISABEL', 24);
INSERT INTO `municipio` VALUES (235, 8, 'GOMEZ FARIAS', 25);
INSERT INTO `municipio` VALUES (236, 8, 'GRAN MORELOS', 26);
INSERT INTO `municipio` VALUES (237, 8, 'GUACHOCHI', 27);
INSERT INTO `municipio` VALUES (238, 8, 'GUADALUPE', 28);
INSERT INTO `municipio` VALUES (239, 8, 'GUADALUPE Y CALVO', 29);
INSERT INTO `municipio` VALUES (240, 8, 'GUAZAPARES', 30);
INSERT INTO `municipio` VALUES (241, 8, 'GUERRERO', 31);
INSERT INTO `municipio` VALUES (242, 8, 'HIDALGO DEL PARRAL', 32);
INSERT INTO `municipio` VALUES (243, 8, 'HUEJOTITAN', 33);
INSERT INTO `municipio` VALUES (244, 8, 'IGNACIO ZARAGOZA', 34);
INSERT INTO `municipio` VALUES (245, 8, 'JANOS', 35);
INSERT INTO `municipio` VALUES (246, 8, 'JIMENEZ', 36);
INSERT INTO `municipio` VALUES (247, 8, 'JUAREZ', 37);
INSERT INTO `municipio` VALUES (248, 8, 'JULIMES', 38);
INSERT INTO `municipio` VALUES (249, 8, 'LOPEZ', 39);
INSERT INTO `municipio` VALUES (250, 8, 'MADERA', 40);
INSERT INTO `municipio` VALUES (251, 8, 'MAGUARICHI', 41);
INSERT INTO `municipio` VALUES (252, 8, 'MANUEL BENAVIDES', 42);
INSERT INTO `municipio` VALUES (253, 8, 'MATACHI', 43);
INSERT INTO `municipio` VALUES (254, 8, 'MATAMOROS', 44);
INSERT INTO `municipio` VALUES (255, 8, 'MEOQUI', 45);
INSERT INTO `municipio` VALUES (256, 8, 'MORELOS', 46);
INSERT INTO `municipio` VALUES (257, 8, 'MORIS', 47);
INSERT INTO `municipio` VALUES (258, 8, 'NAMIQUIPA', 48);
INSERT INTO `municipio` VALUES (259, 8, 'NONOAVA', 49);
INSERT INTO `municipio` VALUES (260, 8, 'NUEVO CASAS GRANDES', 50);
INSERT INTO `municipio` VALUES (261, 8, 'OCAMPO', 51);
INSERT INTO `municipio` VALUES (262, 8, 'OJINAGA', 52);
INSERT INTO `municipio` VALUES (263, 8, 'PRAXEDIS G. GUERRERO', 53);
INSERT INTO `municipio` VALUES (264, 8, 'RIVA PALACIO', 54);
INSERT INTO `municipio` VALUES (265, 8, 'ROSALES', 55);
INSERT INTO `municipio` VALUES (266, 8, 'ROSARIO', 56);
INSERT INTO `municipio` VALUES (267, 8, 'SAN FRANCISCO DE BORJA', 57);
INSERT INTO `municipio` VALUES (268, 8, 'SAN FRANCISCO DE CONCHOS', 58);
INSERT INTO `municipio` VALUES (269, 8, 'SAN FRANCISCO DEL ORO', 59);
INSERT INTO `municipio` VALUES (270, 8, 'SANTA BARBARA', 60);
INSERT INTO `municipio` VALUES (271, 8, 'SATEVO', 61);
INSERT INTO `municipio` VALUES (272, 8, 'SAUCILLO', 62);
INSERT INTO `municipio` VALUES (273, 8, 'TEMOSACHIC', 63);
INSERT INTO `municipio` VALUES (274, 8, 'EL TULE', 64);
INSERT INTO `municipio` VALUES (275, 8, 'URIQUE', 65);
INSERT INTO `municipio` VALUES (276, 8, 'URUACHI', 66);
INSERT INTO `municipio` VALUES (277, 8, 'VALLE DE ZARAGOZA', 67);
INSERT INTO `municipio` VALUES (279, 9, 'AZCAPOTZALCO', 2);
INSERT INTO `municipio` VALUES (280, 9, 'COYOACAN', 3);
INSERT INTO `municipio` VALUES (281, 9, 'CUAJIMALPA DE MORELOS', 4);
INSERT INTO `municipio` VALUES (282, 9, 'GUSTAVO A. MADERO', 5);
INSERT INTO `municipio` VALUES (283, 9, 'IZTACALCO', 6);
INSERT INTO `municipio` VALUES (284, 9, 'IZTAPALAPA', 7);
INSERT INTO `municipio` VALUES (285, 9, 'LA MAGDALENA CONTRERAS', 8);
INSERT INTO `municipio` VALUES (286, 9, 'MILPA ALTA', 9);
INSERT INTO `municipio` VALUES (287, 9, 'ALVARO OBREGON', 10);
INSERT INTO `municipio` VALUES (288, 9, 'TLAHUAC', 11);
INSERT INTO `municipio` VALUES (289, 9, 'TLALPAN', 12);
INSERT INTO `municipio` VALUES (290, 9, 'XOCHIMILCO', 13);
INSERT INTO `municipio` VALUES (291, 9, 'BENITO JUAREZ', 14);
INSERT INTO `municipio` VALUES (292, 9, 'CUAUHTEMOC', 15);
INSERT INTO `municipio` VALUES (293, 9, 'MIGUEL HIDALGO', 16);
INSERT INTO `municipio` VALUES (294, 9, 'VENUSTIANO CARRANZA', 17);
INSERT INTO `municipio` VALUES (296, 10, 'CANATLAN', 1);
INSERT INTO `municipio` VALUES (297, 10, 'CANELAS', 2);
INSERT INTO `municipio` VALUES (298, 10, 'CONETO DE COMONFORT', 3);
INSERT INTO `municipio` VALUES (299, 10, 'CUENCAME', 4);
INSERT INTO `municipio` VALUES (300, 10, 'DURANGO', 5);
INSERT INTO `municipio` VALUES (301, 10, 'GENERAL SIMON BOLIVAR', 6);
INSERT INTO `municipio` VALUES (302, 10, 'GOMEZ PALACIO', 7);
INSERT INTO `municipio` VALUES (303, 10, 'GUADALUPE VICTORIA', 8);
INSERT INTO `municipio` VALUES (304, 10, 'GUANACEVI', 9);
INSERT INTO `municipio` VALUES (305, 10, 'HIDALGO', 10);
INSERT INTO `municipio` VALUES (306, 10, 'INDE', 11);
INSERT INTO `municipio` VALUES (307, 10, 'LERDO', 12);
INSERT INTO `municipio` VALUES (308, 10, 'MAPIMI', 13);
INSERT INTO `municipio` VALUES (309, 10, 'MEZQUITAL', 14);
INSERT INTO `municipio` VALUES (310, 10, 'NAZAS', 15);
INSERT INTO `municipio` VALUES (311, 10, 'NOMBRE DE DIOS', 16);
INSERT INTO `municipio` VALUES (312, 10, 'OCAMPO', 17);
INSERT INTO `municipio` VALUES (313, 10, 'EL ORO', 18);
INSERT INTO `municipio` VALUES (314, 10, 'OTAEZ', 19);
INSERT INTO `municipio` VALUES (315, 10, 'PANUCO DE CORONADO', 20);
INSERT INTO `municipio` VALUES (316, 10, 'PENON BLANCO', 21);
INSERT INTO `municipio` VALUES (317, 10, 'POANAS', 22);
INSERT INTO `municipio` VALUES (318, 10, 'PUEBLO NUEVO', 23);
INSERT INTO `municipio` VALUES (319, 10, 'RODEO', 24);
INSERT INTO `municipio` VALUES (320, 10, 'SAN BERNARDO', 25);
INSERT INTO `municipio` VALUES (321, 10, 'SAN DIMAS', 26);
INSERT INTO `municipio` VALUES (322, 10, 'SAN JUAN DE GUADALUPE', 27);
INSERT INTO `municipio` VALUES (323, 10, 'SAN JUAN DEL RIO', 28);
INSERT INTO `municipio` VALUES (324, 10, 'SAN LUIS DEL CORDERO', 29);
INSERT INTO `municipio` VALUES (325, 10, 'SAN PEDRO DEL GALLO', 30);
INSERT INTO `municipio` VALUES (326, 10, 'SANTA CLARA', 31);
INSERT INTO `municipio` VALUES (327, 10, 'SANTIAGO PAPASQUIARO', 32);
INSERT INTO `municipio` VALUES (328, 10, 'SUCHIL', 33);
INSERT INTO `municipio` VALUES (329, 10, 'TAMAZULA', 34);
INSERT INTO `municipio` VALUES (330, 10, 'TEPEHUANES', 35);
INSERT INTO `municipio` VALUES (331, 10, 'TLAHUALILO', 36);
INSERT INTO `municipio` VALUES (332, 10, 'TOPIA', 37);
INSERT INTO `municipio` VALUES (333, 10, 'VICENTE GUERRERO', 38);
INSERT INTO `municipio` VALUES (334, 10, 'NUEVO IDEAL', 39);
INSERT INTO `municipio` VALUES (336, 11, 'ABASOLO', 1);
INSERT INTO `municipio` VALUES (337, 11, 'ACAMBARO', 2);
INSERT INTO `municipio` VALUES (338, 11, 'SAN MIGUEL DE ALLENDE', 3);
INSERT INTO `municipio` VALUES (339, 11, 'APASEO EL ALTO', 4);
INSERT INTO `municipio` VALUES (340, 11, 'APASEO EL GRANDE', 5);
INSERT INTO `municipio` VALUES (341, 11, 'ATARJEA', 6);
INSERT INTO `municipio` VALUES (342, 11, 'CELAYA', 7);
INSERT INTO `municipio` VALUES (343, 11, 'MANUEL DOBLADO', 8);
INSERT INTO `municipio` VALUES (344, 11, 'COMONFORT', 9);
INSERT INTO `municipio` VALUES (345, 11, 'CORONEO', 10);
INSERT INTO `municipio` VALUES (346, 11, 'CORTAZAR', 11);
INSERT INTO `municipio` VALUES (347, 11, 'CUERAMARO', 12);
INSERT INTO `municipio` VALUES (348, 11, 'DOCTOR MORA', 13);
INSERT INTO `municipio` VALUES (349, 11, 'DOLORES HIDALGO', 14);
INSERT INTO `municipio` VALUES (350, 11, 'GUANAJUATO', 15);
INSERT INTO `municipio` VALUES (351, 11, 'HUANIMARO', 16);
INSERT INTO `municipio` VALUES (352, 11, 'IRAPUATO', 17);
INSERT INTO `municipio` VALUES (353, 11, 'JARAL DEL PROGRESO', 18);
INSERT INTO `municipio` VALUES (354, 11, 'JERECUARO', 19);
INSERT INTO `municipio` VALUES (355, 11, 'LEON', 20);
INSERT INTO `municipio` VALUES (356, 11, 'MOROLEON', 21);
INSERT INTO `municipio` VALUES (357, 11, 'OCAMPO', 22);
INSERT INTO `municipio` VALUES (358, 11, 'PENJAMO', 23);
INSERT INTO `municipio` VALUES (359, 11, 'PUEBLO NUEVO', 24);
INSERT INTO `municipio` VALUES (360, 11, 'PURISIMA DEL RINCON', 25);
INSERT INTO `municipio` VALUES (361, 11, 'ROMITA', 26);
INSERT INTO `municipio` VALUES (362, 11, 'SALAMANCA', 27);
INSERT INTO `municipio` VALUES (363, 11, 'SALVATIERRA', 28);
INSERT INTO `municipio` VALUES (364, 11, 'SAN DIEGO DE LA UNION', 29);
INSERT INTO `municipio` VALUES (365, 11, 'SAN FELIPE', 30);
INSERT INTO `municipio` VALUES (366, 11, 'SAN FRANCISCO DEL RINCON', 31);
INSERT INTO `municipio` VALUES (367, 11, 'SAN JOSE ITURBIDE', 32);
INSERT INTO `municipio` VALUES (368, 11, 'SAN LUIS DE LA PAZ', 33);
INSERT INTO `municipio` VALUES (369, 11, 'SANTA CATARINA', 34);
INSERT INTO `municipio` VALUES (370, 11, 'SANTA CRUZ DE JUVENTINO ROSAS', 35);
INSERT INTO `municipio` VALUES (371, 11, 'SANTIAGO MARAVATIO', 36);
INSERT INTO `municipio` VALUES (372, 11, 'SILAO DE LA VICTORIA', 37);
INSERT INTO `municipio` VALUES (373, 11, 'TARANDACUAO', 38);
INSERT INTO `municipio` VALUES (374, 11, 'TARIMORO', 39);
INSERT INTO `municipio` VALUES (375, 11, 'TIERRA BLANCA', 40);
INSERT INTO `municipio` VALUES (376, 11, 'URIANGATO', 41);
INSERT INTO `municipio` VALUES (377, 11, 'VALLE DE SANTIAGO', 42);
INSERT INTO `municipio` VALUES (378, 11, 'VICTORIA', 43);
INSERT INTO `municipio` VALUES (379, 11, 'VILLAGRAN', 44);
INSERT INTO `municipio` VALUES (380, 11, 'XICHU', 45);
INSERT INTO `municipio` VALUES (381, 11, 'YURIRIA', 46);
INSERT INTO `municipio` VALUES (383, 12, 'ACAPULCO DE JUAREZ', 1);
INSERT INTO `municipio` VALUES (384, 12, 'AHUACUOTZINGO', 2);
INSERT INTO `municipio` VALUES (385, 12, 'AJUCHITLAN DEL PROGRESO', 3);
INSERT INTO `municipio` VALUES (386, 12, 'ALCOZAUCA DE GUERRERO', 4);
INSERT INTO `municipio` VALUES (387, 12, 'ALPOYECA', 5);
INSERT INTO `municipio` VALUES (388, 12, 'APAXTLA', 6);
INSERT INTO `municipio` VALUES (389, 12, 'ARCELIA', 7);
INSERT INTO `municipio` VALUES (390, 12, 'ATENANGO DEL RIO', 8);
INSERT INTO `municipio` VALUES (391, 12, 'ATLAMAJALCINGO DEL MONTE', 9);
INSERT INTO `municipio` VALUES (392, 12, 'ATLIXTAC', 10);
INSERT INTO `municipio` VALUES (393, 12, 'ATOYAC DE ALVAREZ', 11);
INSERT INTO `municipio` VALUES (394, 12, 'AYUTLA DE LOS LIBRES', 12);
INSERT INTO `municipio` VALUES (395, 12, 'AZOYU', 13);
INSERT INTO `municipio` VALUES (396, 12, 'BENITO JUAREZ', 14);
INSERT INTO `municipio` VALUES (397, 12, 'BUENAVISTA DE CUELLAR', 15);
INSERT INTO `municipio` VALUES (398, 12, 'COAHUAYUTLA DE JOSE MARIA IZAZAGA', 16);
INSERT INTO `municipio` VALUES (399, 12, 'COCULA', 17);
INSERT INTO `municipio` VALUES (400, 12, 'COPALA', 18);
INSERT INTO `municipio` VALUES (401, 12, 'COPALILLO', 19);
INSERT INTO `municipio` VALUES (402, 12, 'COPANATOYAC', 20);
INSERT INTO `municipio` VALUES (403, 12, 'COYUCA DE BENITEZ', 21);
INSERT INTO `municipio` VALUES (404, 12, 'COYUCA DE CATALAN', 22);
INSERT INTO `municipio` VALUES (405, 12, 'CUAJINICUILAPA', 23);
INSERT INTO `municipio` VALUES (406, 12, 'CUALAC', 24);
INSERT INTO `municipio` VALUES (407, 12, 'CUAUTEPEC', 25);
INSERT INTO `municipio` VALUES (408, 12, 'CUETZALA DEL PROGRESO', 26);
INSERT INTO `municipio` VALUES (409, 12, 'CUTZAMALA DE PINZON', 27);
INSERT INTO `municipio` VALUES (410, 12, 'CHILAPA DE ALVAREZ', 28);
INSERT INTO `municipio` VALUES (411, 12, 'CHILPANCINGO DE LOS BRAVO', 29);
INSERT INTO `municipio` VALUES (412, 12, 'FLORENCIO VILLARREAL', 30);
INSERT INTO `municipio` VALUES (413, 12, 'GENERAL CANUTO A. NERI', 31);
INSERT INTO `municipio` VALUES (414, 12, 'GENERAL HELIODORO CASTILLO', 32);
INSERT INTO `municipio` VALUES (415, 12, 'HUAMUXTITLAN', 33);
INSERT INTO `municipio` VALUES (416, 12, 'HUITZUCO DE LOS FIGUEROA', 34);
INSERT INTO `municipio` VALUES (417, 12, 'IGUALA DE LA INDEPENDENCIA', 35);
INSERT INTO `municipio` VALUES (418, 12, 'IGUALAPA', 36);
INSERT INTO `municipio` VALUES (419, 12, 'IXCATEOPAN DE CUAUHTEMOC', 37);
INSERT INTO `municipio` VALUES (420, 12, 'ZIHUATANEJO DE AZUETA', 38);
INSERT INTO `municipio` VALUES (421, 12, 'JUAN R. ESCUDERO', 39);
INSERT INTO `municipio` VALUES (422, 12, 'LEONARDO BRAVO', 40);
INSERT INTO `municipio` VALUES (423, 12, 'MALINALTEPEC', 41);
INSERT INTO `municipio` VALUES (424, 12, 'MARTIR DE CUILAPAN', 42);
INSERT INTO `municipio` VALUES (425, 12, 'METLATONOC', 43);
INSERT INTO `municipio` VALUES (426, 12, 'MOCHITLAN', 44);
INSERT INTO `municipio` VALUES (427, 12, 'OLINALA', 45);
INSERT INTO `municipio` VALUES (428, 12, 'OMETEPEC', 46);
INSERT INTO `municipio` VALUES (429, 12, 'PEDRO ASCENCIO ALQUISIRAS', 47);
INSERT INTO `municipio` VALUES (430, 12, 'PETATLAN', 48);
INSERT INTO `municipio` VALUES (431, 12, 'PILCAYA', 49);
INSERT INTO `municipio` VALUES (432, 12, 'PUNGARABATO', 50);
INSERT INTO `municipio` VALUES (433, 12, 'QUECHULTENANGO', 51);
INSERT INTO `municipio` VALUES (434, 12, 'SAN LUIS ACATLAN', 52);
INSERT INTO `municipio` VALUES (435, 12, 'SAN MARCOS', 53);
INSERT INTO `municipio` VALUES (436, 12, 'SAN MIGUEL TOTOLAPAN', 54);
INSERT INTO `municipio` VALUES (437, 12, 'TAXCO DE ALARCON', 55);
INSERT INTO `municipio` VALUES (438, 12, 'TECOANAPA', 56);
INSERT INTO `municipio` VALUES (439, 12, 'TECPAN DE GALEANA', 57);
INSERT INTO `municipio` VALUES (440, 12, 'TELOLOAPAN', 58);
INSERT INTO `municipio` VALUES (441, 12, 'TEPECOACUILCO DE TRUJANO', 59);
INSERT INTO `municipio` VALUES (442, 12, 'TETIPAC', 60);
INSERT INTO `municipio` VALUES (443, 12, 'TIXTLA DE GUERRERO', 61);
INSERT INTO `municipio` VALUES (444, 12, 'TLACOACHISTLAHUACA', 62);
INSERT INTO `municipio` VALUES (445, 12, 'TLACOAPA', 63);
INSERT INTO `municipio` VALUES (446, 12, 'TLALCHAPA', 64);
INSERT INTO `municipio` VALUES (447, 12, 'TLALIXTAQUILLA DE MALDONADO', 65);
INSERT INTO `municipio` VALUES (448, 12, 'TLAPA DE COMONFORT', 66);
INSERT INTO `municipio` VALUES (449, 12, 'TLAPEHUALA', 67);
INSERT INTO `municipio` VALUES (450, 12, 'LA UNION DE ISIDORO MONTES DE OCA', 68);
INSERT INTO `municipio` VALUES (451, 12, 'XALPATLAHUAC', 69);
INSERT INTO `municipio` VALUES (452, 12, 'XOCHIHUEHUETLAN', 70);
INSERT INTO `municipio` VALUES (453, 12, 'XOCHISTLAHUACA', 71);
INSERT INTO `municipio` VALUES (454, 12, 'ZAPOTITLAN TABLAS', 72);
INSERT INTO `municipio` VALUES (455, 12, 'ZIRANDARO', 73);
INSERT INTO `municipio` VALUES (456, 12, 'ZITLALA', 74);
INSERT INTO `municipio` VALUES (457, 12, 'EDUARDO NERI', 75);
INSERT INTO `municipio` VALUES (458, 12, 'ACATEPEC', 76);
INSERT INTO `municipio` VALUES (459, 12, 'MARQUELIA', 77);
INSERT INTO `municipio` VALUES (460, 12, 'COCHOAPA EL GRANDE', 78);
INSERT INTO `municipio` VALUES (461, 12, 'JOSE JOAQUIN DE HERRERA', 79);
INSERT INTO `municipio` VALUES (462, 12, 'JUCHITAN', 80);
INSERT INTO `municipio` VALUES (463, 12, 'ILIATENCO', 81);
INSERT INTO `municipio` VALUES (465, 13, 'ACATLAN', 1);
INSERT INTO `municipio` VALUES (466, 13, 'ACAXOCHITLAN', 2);
INSERT INTO `municipio` VALUES (467, 13, 'ACTOPAN', 3);
INSERT INTO `municipio` VALUES (468, 13, 'AGUA BLANCA DE ITURBIDE', 4);
INSERT INTO `municipio` VALUES (469, 13, 'AJACUBA', 5);
INSERT INTO `municipio` VALUES (470, 13, 'ALFAJAYUCAN', 6);
INSERT INTO `municipio` VALUES (471, 13, 'ALMOLOYA', 7);
INSERT INTO `municipio` VALUES (472, 13, 'APAN', 8);
INSERT INTO `municipio` VALUES (473, 13, 'EL ARENAL', 9);
INSERT INTO `municipio` VALUES (474, 13, 'ATITALAQUIA', 10);
INSERT INTO `municipio` VALUES (475, 13, 'ATLAPEXCO', 11);
INSERT INTO `municipio` VALUES (476, 13, 'ATOTONILCO EL GRANDE', 12);
INSERT INTO `municipio` VALUES (477, 13, 'ATOTONILCO DE TULA', 13);
INSERT INTO `municipio` VALUES (478, 13, 'CALNALI', 14);
INSERT INTO `municipio` VALUES (479, 13, 'CARDONAL', 15);
INSERT INTO `municipio` VALUES (480, 13, 'CUAUTEPEC DE HINOJOSA', 16);
INSERT INTO `municipio` VALUES (481, 13, 'CHAPANTONGO', 17);
INSERT INTO `municipio` VALUES (482, 13, 'CHAPULHUACAN', 18);
INSERT INTO `municipio` VALUES (483, 13, 'CHILCUAUTLA', 19);
INSERT INTO `municipio` VALUES (484, 13, 'ELOXOCHITLAN', 20);
INSERT INTO `municipio` VALUES (485, 13, 'EMILIANO ZAPATA', 21);
INSERT INTO `municipio` VALUES (486, 13, 'EPAZOYUCAN', 22);
INSERT INTO `municipio` VALUES (487, 13, 'FRANCISCO I. MADERO', 23);
INSERT INTO `municipio` VALUES (488, 13, 'HUASCA DE OCAMPO', 24);
INSERT INTO `municipio` VALUES (489, 13, 'HUAUTLA', 25);
INSERT INTO `municipio` VALUES (490, 13, 'HUAZALINGO', 26);
INSERT INTO `municipio` VALUES (491, 13, 'HUEHUETLA', 27);
INSERT INTO `municipio` VALUES (492, 13, 'HUEJUTLA DE REYES', 28);
INSERT INTO `municipio` VALUES (493, 13, 'HUICHAPAN', 29);
INSERT INTO `municipio` VALUES (494, 13, 'IXMIQUILPAN', 30);
INSERT INTO `municipio` VALUES (495, 13, 'JACALA DE LEDEZMA', 31);
INSERT INTO `municipio` VALUES (496, 13, 'JALTOCAN', 32);
INSERT INTO `municipio` VALUES (497, 13, 'JUAREZ HIDALGO', 33);
INSERT INTO `municipio` VALUES (498, 13, 'LOLOTLA', 34);
INSERT INTO `municipio` VALUES (499, 13, 'METEPEC', 35);
INSERT INTO `municipio` VALUES (500, 13, 'SAN AGUSTIN METZQUITITLAN', 36);
INSERT INTO `municipio` VALUES (501, 13, 'METZTITLAN', 37);
INSERT INTO `municipio` VALUES (502, 13, 'MINERAL DEL CHICO', 38);
INSERT INTO `municipio` VALUES (503, 13, 'MINERAL DEL MONTE', 39);
INSERT INTO `municipio` VALUES (504, 13, 'LA MISION', 40);
INSERT INTO `municipio` VALUES (505, 13, 'MIXQUIAHUALA DE JUAREZ', 41);
INSERT INTO `municipio` VALUES (506, 13, 'MOLANGO DE ESCAMILLA', 42);
INSERT INTO `municipio` VALUES (507, 13, 'NICOLAS FLORES', 43);
INSERT INTO `municipio` VALUES (508, 13, 'NOPALA DE VILLAGRAN', 44);
INSERT INTO `municipio` VALUES (509, 13, 'OMITLAN DE JUAREZ', 45);
INSERT INTO `municipio` VALUES (510, 13, 'SAN FELIPE ORIZATLAN', 46);
INSERT INTO `municipio` VALUES (511, 13, 'PACULA', 47);
INSERT INTO `municipio` VALUES (512, 13, 'PACHUCA DE SOTO', 48);
INSERT INTO `municipio` VALUES (513, 13, 'PISAFLORES', 49);
INSERT INTO `municipio` VALUES (514, 13, 'PROGRESO DE OBREGON', 50);
INSERT INTO `municipio` VALUES (515, 13, 'MINERAL DE LA REFORMA', 51);
INSERT INTO `municipio` VALUES (516, 13, 'SAN AGUSTIN TLAXIACA', 52);
INSERT INTO `municipio` VALUES (517, 13, 'SAN BARTOLO TUTOTEPEC', 53);
INSERT INTO `municipio` VALUES (518, 13, 'SAN SALVADOR', 54);
INSERT INTO `municipio` VALUES (519, 13, 'SANTIAGO DE ANAYA', 55);
INSERT INTO `municipio` VALUES (520, 13, 'SANTIAGO TULANTEPEC DE LUGO', 56);
INSERT INTO `municipio` VALUES (521, 13, 'SINGUILUCAN', 57);
INSERT INTO `municipio` VALUES (522, 13, 'TASQUILLO', 58);
INSERT INTO `municipio` VALUES (523, 13, 'TECOZAUTLA', 59);
INSERT INTO `municipio` VALUES (524, 13, 'TENANGO DE DORIA', 60);
INSERT INTO `municipio` VALUES (525, 13, 'TEPEAPULCO', 61);
INSERT INTO `municipio` VALUES (526, 13, 'TEPEHUACAN DE GUERRERO', 62);
INSERT INTO `municipio` VALUES (527, 13, 'TEPEJI DEL RIO DE OCAMPO', 63);
INSERT INTO `municipio` VALUES (528, 13, 'TEPETITLAN', 64);
INSERT INTO `municipio` VALUES (529, 13, 'TETEPANGO', 65);
INSERT INTO `municipio` VALUES (530, 13, 'VILLA DE TEZONTEPEC', 66);
INSERT INTO `municipio` VALUES (531, 13, 'TEZONTEPEC DE ALDAMA', 67);
INSERT INTO `municipio` VALUES (532, 13, 'TIANGUISTENGO', 68);
INSERT INTO `municipio` VALUES (533, 13, 'TIZAYUCA', 69);
INSERT INTO `municipio` VALUES (534, 13, 'TLAHUELILPAN', 70);
INSERT INTO `municipio` VALUES (535, 13, 'TLAHUILTEPA', 71);
INSERT INTO `municipio` VALUES (536, 13, 'TLANALAPA', 72);
INSERT INTO `municipio` VALUES (537, 13, 'TLANCHINOL', 73);
INSERT INTO `municipio` VALUES (538, 13, 'TLAXCOAPAN', 74);
INSERT INTO `municipio` VALUES (539, 13, 'TOLCAYUCA', 75);
INSERT INTO `municipio` VALUES (540, 13, 'TULA DE ALLENDE', 76);
INSERT INTO `municipio` VALUES (541, 13, 'TULANCINGO DE BRAVO', 77);
INSERT INTO `municipio` VALUES (542, 13, 'XOCHIATIPAN', 78);
INSERT INTO `municipio` VALUES (543, 13, 'XOCHICOATLAN', 79);
INSERT INTO `municipio` VALUES (544, 13, 'YAHUALICA', 80);
INSERT INTO `municipio` VALUES (545, 13, 'ZACUALTIPAN DE ANGELES', 81);
INSERT INTO `municipio` VALUES (546, 13, 'ZAPOTLAN DE JUAREZ', 82);
INSERT INTO `municipio` VALUES (547, 13, 'ZEMPOALA', 83);
INSERT INTO `municipio` VALUES (548, 13, 'ZIMAPAN', 84);
INSERT INTO `municipio` VALUES (550, 14, 'ACATIC', 1);
INSERT INTO `municipio` VALUES (551, 14, 'ACATLAN DE JUAREZ', 2);
INSERT INTO `municipio` VALUES (552, 14, 'AHUALULCO DE MERCADO', 3);
INSERT INTO `municipio` VALUES (553, 14, 'AMACUECA', 4);
INSERT INTO `municipio` VALUES (554, 14, 'AMATITAN', 5);
INSERT INTO `municipio` VALUES (555, 14, 'AMECA', 6);
INSERT INTO `municipio` VALUES (556, 14, 'SAN JUANITO DE ESCOBEDO', 7);
INSERT INTO `municipio` VALUES (557, 14, 'ARANDAS', 8);
INSERT INTO `municipio` VALUES (558, 14, 'EL ARENAL', 9);
INSERT INTO `municipio` VALUES (559, 14, 'ATEMAJAC DE BRIZUELA', 10);
INSERT INTO `municipio` VALUES (560, 14, 'ATENGO', 11);
INSERT INTO `municipio` VALUES (561, 14, 'ATENGUILLO', 12);
INSERT INTO `municipio` VALUES (562, 14, 'ATOTONILCO EL ALTO', 13);
INSERT INTO `municipio` VALUES (563, 14, 'ATOYAC', 14);
INSERT INTO `municipio` VALUES (564, 14, 'AUTLAN DE NAVARRO', 15);
INSERT INTO `municipio` VALUES (565, 14, 'AYOTLAN', 16);
INSERT INTO `municipio` VALUES (566, 14, 'AYUTLA', 17);
INSERT INTO `municipio` VALUES (567, 14, 'LA BARCA', 18);
INSERT INTO `municipio` VALUES (568, 14, 'BOLANOS', 19);
INSERT INTO `municipio` VALUES (569, 14, 'CABO CORRIENTES', 20);
INSERT INTO `municipio` VALUES (570, 14, 'CASIMIRO CASTILLO', 21);
INSERT INTO `municipio` VALUES (571, 14, 'CIHUATLAN', 22);
INSERT INTO `municipio` VALUES (572, 14, 'ZAPOTLAN EL GRANDE', 23);
INSERT INTO `municipio` VALUES (573, 14, 'COCULA', 24);
INSERT INTO `municipio` VALUES (574, 14, 'COLOTLAN', 25);
INSERT INTO `municipio` VALUES (575, 14, 'CONCEPCION DE BUENOS AIRES', 26);
INSERT INTO `municipio` VALUES (576, 14, 'CUAUTITLAN DE GARCIA BARRAGAN', 27);
INSERT INTO `municipio` VALUES (577, 14, 'CUAUTLA', 28);
INSERT INTO `municipio` VALUES (578, 14, 'CUQUIO', 29);
INSERT INTO `municipio` VALUES (579, 14, 'CHAPALA', 30);
INSERT INTO `municipio` VALUES (580, 14, 'CHIMALTITAN', 31);
INSERT INTO `municipio` VALUES (581, 14, 'CHIQUILISTLAN', 32);
INSERT INTO `municipio` VALUES (582, 14, 'DEGOLLADO', 33);
INSERT INTO `municipio` VALUES (583, 14, 'EJUTLA', 34);
INSERT INTO `municipio` VALUES (584, 14, 'ENCARNACION DE DIAZ', 35);
INSERT INTO `municipio` VALUES (585, 14, 'ETZATLAN', 36);
INSERT INTO `municipio` VALUES (586, 14, 'EL GRULLO', 37);
INSERT INTO `municipio` VALUES (587, 14, 'GUACHINANGO', 38);
INSERT INTO `municipio` VALUES (588, 14, 'GUADALAJARA', 39);
INSERT INTO `municipio` VALUES (589, 14, 'HOSTOTIPAQUILLO', 40);
INSERT INTO `municipio` VALUES (590, 14, 'HUEJUCAR', 41);
INSERT INTO `municipio` VALUES (591, 14, 'HUEJUQUILLA EL ALTO', 42);
INSERT INTO `municipio` VALUES (592, 14, 'LA HUERTA', 43);
INSERT INTO `municipio` VALUES (593, 14, 'IXTLAHUACAN DE LOS MEMBRILLOS', 44);
INSERT INTO `municipio` VALUES (594, 14, 'IXTLAHUACAN DEL RIO', 45);
INSERT INTO `municipio` VALUES (595, 14, 'JALOSTOTITLAN', 46);
INSERT INTO `municipio` VALUES (596, 14, 'JAMAY', 47);
INSERT INTO `municipio` VALUES (597, 14, 'JESUS MARIA', 48);
INSERT INTO `municipio` VALUES (598, 14, 'JILOTLAN DE LOS DOLORES', 49);
INSERT INTO `municipio` VALUES (599, 14, 'JOCOTEPEC', 50);
INSERT INTO `municipio` VALUES (600, 14, 'JUANACATLAN', 51);
INSERT INTO `municipio` VALUES (601, 14, 'JUCHITLAN', 52);
INSERT INTO `municipio` VALUES (602, 14, 'LAGOS DE MORENO', 53);
INSERT INTO `municipio` VALUES (603, 14, 'EL LIMON', 54);
INSERT INTO `municipio` VALUES (604, 14, 'MAGDALENA', 55);
INSERT INTO `municipio` VALUES (605, 14, 'SANTA MARIA DEL ORO', 56);
INSERT INTO `municipio` VALUES (606, 14, 'LA MANZANILLA DE LA PAZ', 57);
INSERT INTO `municipio` VALUES (607, 14, 'MASCOTA', 58);
INSERT INTO `municipio` VALUES (608, 14, 'MAZAMITLA', 59);
INSERT INTO `municipio` VALUES (609, 14, 'MEXTICACAN', 60);
INSERT INTO `municipio` VALUES (610, 14, 'MEZQUITIC', 61);
INSERT INTO `municipio` VALUES (611, 14, 'MIXTLAN', 62);
INSERT INTO `municipio` VALUES (612, 14, 'OCOTLAN', 63);
INSERT INTO `municipio` VALUES (613, 14, 'OJUELOS DE JALISCO', 64);
INSERT INTO `municipio` VALUES (614, 14, 'PIHUAMO', 65);
INSERT INTO `municipio` VALUES (615, 14, 'PONCITLAN', 66);
INSERT INTO `municipio` VALUES (616, 14, 'PUERTO VALLARTA', 67);
INSERT INTO `municipio` VALUES (617, 14, 'VILLA PURIFICACION', 68);
INSERT INTO `municipio` VALUES (618, 14, 'QUITUPAN', 69);
INSERT INTO `municipio` VALUES (619, 14, 'EL SALTO', 70);
INSERT INTO `municipio` VALUES (620, 14, 'SAN CRISTOBAL DE LA BARRANCA', 71);
INSERT INTO `municipio` VALUES (621, 14, 'SAN DIEGO DE ALEJANDRIA', 72);
INSERT INTO `municipio` VALUES (622, 14, 'SAN JUAN DE LOS LAGOS', 73);
INSERT INTO `municipio` VALUES (623, 14, 'SAN JULIAN', 74);
INSERT INTO `municipio` VALUES (624, 14, 'SAN MARCOS', 75);
INSERT INTO `municipio` VALUES (625, 14, 'SAN MARTIN DE BOLANOS', 76);
INSERT INTO `municipio` VALUES (626, 14, 'SAN MARTIN HIDALGO', 77);
INSERT INTO `municipio` VALUES (627, 14, 'SAN MIGUEL EL ALTO', 78);
INSERT INTO `municipio` VALUES (628, 14, 'GOMEZ FARIAS', 79);
INSERT INTO `municipio` VALUES (629, 14, 'SAN SEBASTIAN DEL OESTE', 80);
INSERT INTO `municipio` VALUES (630, 14, 'SANTA MARIA DE LOS ANGELES', 81);
INSERT INTO `municipio` VALUES (631, 14, 'SAYULA', 82);
INSERT INTO `municipio` VALUES (632, 14, 'TALA', 83);
INSERT INTO `municipio` VALUES (633, 14, 'TALPA DE ALLENDE', 84);
INSERT INTO `municipio` VALUES (634, 14, 'TAMAZULA DE GORDIANO', 85);
INSERT INTO `municipio` VALUES (635, 14, 'TAPALPA', 86);
INSERT INTO `municipio` VALUES (636, 14, 'TECALITLAN', 87);
INSERT INTO `municipio` VALUES (637, 14, 'TECOLOTLAN', 88);
INSERT INTO `municipio` VALUES (638, 14, 'TECHALUTA DE MONTENEGRO', 89);
INSERT INTO `municipio` VALUES (639, 14, 'TENAMAXTLAN', 90);
INSERT INTO `municipio` VALUES (640, 14, 'TEOCALTICHE', 91);
INSERT INTO `municipio` VALUES (641, 14, 'TEOCUITATLAN DE CORONA', 92);
INSERT INTO `municipio` VALUES (642, 14, 'TEPATITLAN DE MORELOS', 93);
INSERT INTO `municipio` VALUES (643, 14, 'TEQUILA', 94);
INSERT INTO `municipio` VALUES (644, 14, 'TEUCHITLAN', 95);
INSERT INTO `municipio` VALUES (645, 14, 'TIZAPAN EL ALTO', 96);
INSERT INTO `municipio` VALUES (646, 14, 'TLAJOMULCO DE ZUNIGA', 97);
INSERT INTO `municipio` VALUES (647, 14, 'SAN PEDRO TLAQUEPAQUE', 98);
INSERT INTO `municipio` VALUES (648, 14, 'TOLIMAN', 99);
INSERT INTO `municipio` VALUES (649, 14, 'TOMATLAN', 100);
INSERT INTO `municipio` VALUES (650, 14, 'TONALA', 101);
INSERT INTO `municipio` VALUES (651, 14, 'TONAYA', 102);
INSERT INTO `municipio` VALUES (652, 14, 'TONILA', 103);
INSERT INTO `municipio` VALUES (653, 14, 'TOTATICHE', 104);
INSERT INTO `municipio` VALUES (654, 14, 'TOTOTLAN', 105);
INSERT INTO `municipio` VALUES (655, 14, 'TUXCACUESCO', 106);
INSERT INTO `municipio` VALUES (656, 14, 'TUXCUECA', 107);
INSERT INTO `municipio` VALUES (657, 14, 'TUXPAN', 108);
INSERT INTO `municipio` VALUES (658, 14, 'UNION DE SAN ANTONIO', 109);
INSERT INTO `municipio` VALUES (659, 14, 'UNION DE TULA', 110);
INSERT INTO `municipio` VALUES (660, 14, 'VALLE DE GUADALUPE', 111);
INSERT INTO `municipio` VALUES (661, 14, 'VALLE DE JUAREZ', 112);
INSERT INTO `municipio` VALUES (662, 14, 'SAN GABRIEL', 113);
INSERT INTO `municipio` VALUES (663, 14, 'VILLA CORONA', 114);
INSERT INTO `municipio` VALUES (664, 14, 'VILLA GUERRERO', 115);
INSERT INTO `municipio` VALUES (665, 14, 'VILLA HIDALGO', 116);
INSERT INTO `municipio` VALUES (666, 14, 'CANADAS DE OBREGON', 117);
INSERT INTO `municipio` VALUES (667, 14, 'YAHUALICA DE GONZALEZ GALLO', 118);
INSERT INTO `municipio` VALUES (668, 14, 'ZACOALCO DE TORRES', 119);
INSERT INTO `municipio` VALUES (669, 14, 'ZAPOPAN', 120);
INSERT INTO `municipio` VALUES (670, 14, 'ZAPOTILTIC', 121);
INSERT INTO `municipio` VALUES (671, 14, 'ZAPOTITLAN DE VADILLO', 122);
INSERT INTO `municipio` VALUES (672, 14, 'ZAPOTLAN DEL REY', 123);
INSERT INTO `municipio` VALUES (673, 14, 'ZAPOTLANEJO', 124);
INSERT INTO `municipio` VALUES (674, 14, 'SAN IGNACIO CERRO GORDO', 125);
INSERT INTO `municipio` VALUES (676, 15, 'ACAMBAY DE RUIZ CASTANEDA', 1);
INSERT INTO `municipio` VALUES (677, 15, 'ACOLMAN', 2);
INSERT INTO `municipio` VALUES (678, 15, 'ACULCO', 3);
INSERT INTO `municipio` VALUES (679, 15, 'ALMOLOYA DE ALQUISIRAS', 4);
INSERT INTO `municipio` VALUES (680, 15, 'ALMOLOYA DE JUAREZ', 5);
INSERT INTO `municipio` VALUES (681, 15, 'ALMOLOYA DEL RIO', 6);
INSERT INTO `municipio` VALUES (682, 15, 'AMANALCO', 7);
INSERT INTO `municipio` VALUES (683, 15, 'AMATEPEC', 8);
INSERT INTO `municipio` VALUES (684, 15, 'AMECAMECA', 9);
INSERT INTO `municipio` VALUES (685, 15, 'APAXCO', 10);
INSERT INTO `municipio` VALUES (686, 15, 'ATENCO', 11);
INSERT INTO `municipio` VALUES (687, 15, 'ATIZAPAN', 12);
INSERT INTO `municipio` VALUES (688, 15, 'ATIZAPAN DE ZARAGOZA', 13);
INSERT INTO `municipio` VALUES (689, 15, 'ATLACOMULCO', 14);
INSERT INTO `municipio` VALUES (690, 15, 'ATLAUTLA', 15);
INSERT INTO `municipio` VALUES (691, 15, 'AXAPUSCO', 16);
INSERT INTO `municipio` VALUES (692, 15, 'AYAPANGO', 17);
INSERT INTO `municipio` VALUES (693, 15, 'CALIMAYA', 18);
INSERT INTO `municipio` VALUES (694, 15, 'CAPULHUAC', 19);
INSERT INTO `municipio` VALUES (695, 15, 'COACALCO DE BERRIOZABAL', 20);
INSERT INTO `municipio` VALUES (696, 15, 'COATEPEC HARINAS', 21);
INSERT INTO `municipio` VALUES (697, 15, 'COCOTITLAN', 22);
INSERT INTO `municipio` VALUES (698, 15, 'COYOTEPEC', 23);
INSERT INTO `municipio` VALUES (699, 15, 'CUAUTITLAN', 24);
INSERT INTO `municipio` VALUES (700, 15, 'CHALCO', 25);
INSERT INTO `municipio` VALUES (701, 15, 'CHAPA DE MOTA', 26);
INSERT INTO `municipio` VALUES (702, 15, 'CHAPULTEPEC', 27);
INSERT INTO `municipio` VALUES (703, 15, 'CHIAUTLA', 28);
INSERT INTO `municipio` VALUES (704, 15, 'CHICOLOAPAN', 29);
INSERT INTO `municipio` VALUES (705, 15, 'CHICONCUAC', 30);
INSERT INTO `municipio` VALUES (706, 15, 'CHIMALHUACAN', 31);
INSERT INTO `municipio` VALUES (707, 15, 'DONATO GUERRA', 32);
INSERT INTO `municipio` VALUES (708, 15, 'ECATEPEC DE MORELOS', 33);
INSERT INTO `municipio` VALUES (709, 15, 'ECATZINGO', 34);
INSERT INTO `municipio` VALUES (710, 15, 'HUEHUETOCA', 35);
INSERT INTO `municipio` VALUES (711, 15, 'HUEYPOXTLA', 36);
INSERT INTO `municipio` VALUES (712, 15, 'HUIXQUILUCAN', 37);
INSERT INTO `municipio` VALUES (713, 15, 'ISIDRO FABELA', 38);
INSERT INTO `municipio` VALUES (714, 15, 'IXTAPALUCA', 39);
INSERT INTO `municipio` VALUES (715, 15, 'IXTAPAN DE LA SAL', 40);
INSERT INTO `municipio` VALUES (716, 15, 'IXTAPAN DEL ORO', 41);
INSERT INTO `municipio` VALUES (717, 15, 'IXTLAHUACA', 42);
INSERT INTO `municipio` VALUES (718, 15, 'XALATLACO', 43);
INSERT INTO `municipio` VALUES (719, 15, 'JALTENCO', 44);
INSERT INTO `municipio` VALUES (720, 15, 'JILOTEPEC', 45);
INSERT INTO `municipio` VALUES (721, 15, 'JILOTZINGO', 46);
INSERT INTO `municipio` VALUES (722, 15, 'JIQUIPILCO', 47);
INSERT INTO `municipio` VALUES (723, 15, 'JOCOTITLAN', 48);
INSERT INTO `municipio` VALUES (724, 15, 'JOQUICINGO', 49);
INSERT INTO `municipio` VALUES (725, 15, 'JUCHITEPEC', 50);
INSERT INTO `municipio` VALUES (726, 15, 'LERMA', 51);
INSERT INTO `municipio` VALUES (727, 15, 'MALINALCO', 52);
INSERT INTO `municipio` VALUES (728, 15, 'MELCHOR OCAMPO', 53);
INSERT INTO `municipio` VALUES (729, 15, 'METEPEC', 54);
INSERT INTO `municipio` VALUES (730, 15, 'MEXICALTZINGO', 55);
INSERT INTO `municipio` VALUES (731, 15, 'MORELOS', 56);
INSERT INTO `municipio` VALUES (732, 15, 'NAUCALPAN DE JUAREZ', 57);
INSERT INTO `municipio` VALUES (733, 15, 'NEZAHUALCOYOTL', 58);
INSERT INTO `municipio` VALUES (734, 15, 'NEXTLALPAN', 59);
INSERT INTO `municipio` VALUES (735, 15, 'NICOLAS ROMERO', 60);
INSERT INTO `municipio` VALUES (736, 15, 'NOPALTEPEC', 61);
INSERT INTO `municipio` VALUES (737, 15, 'OCOYOACAC', 62);
INSERT INTO `municipio` VALUES (738, 15, 'OCUILAN', 63);
INSERT INTO `municipio` VALUES (739, 15, 'EL ORO', 64);
INSERT INTO `municipio` VALUES (740, 15, 'OTUMBA', 65);
INSERT INTO `municipio` VALUES (741, 15, 'OTZOLOAPAN', 66);
INSERT INTO `municipio` VALUES (742, 15, 'OTZOLOTEPEC', 67);
INSERT INTO `municipio` VALUES (743, 15, 'OZUMBA', 68);
INSERT INTO `municipio` VALUES (744, 15, 'PAPALOTLA', 69);
INSERT INTO `municipio` VALUES (745, 15, 'LA PAZ', 70);
INSERT INTO `municipio` VALUES (746, 15, 'POLOTITLAN', 71);
INSERT INTO `municipio` VALUES (747, 15, 'RAYON', 72);
INSERT INTO `municipio` VALUES (748, 15, 'SAN ANTONIO LA ISLA', 73);
INSERT INTO `municipio` VALUES (749, 15, 'SAN FELIPE DEL PROGRESO', 74);
INSERT INTO `municipio` VALUES (750, 15, 'SAN MARTIN DE LAS PIRAMIDES', 75);
INSERT INTO `municipio` VALUES (751, 15, 'SAN MATEO ATENCO', 76);
INSERT INTO `municipio` VALUES (752, 15, 'SAN SIMON DE GUERRERO', 77);
INSERT INTO `municipio` VALUES (753, 15, 'SANTO TOMAS', 78);
INSERT INTO `municipio` VALUES (754, 15, 'SOYANIQUILPAN DE JUAREZ', 79);
INSERT INTO `municipio` VALUES (755, 15, 'SULTEPEC', 80);
INSERT INTO `municipio` VALUES (756, 15, 'TECAMAC', 81);
INSERT INTO `municipio` VALUES (757, 15, 'TEJUPILCO', 82);
INSERT INTO `municipio` VALUES (758, 15, 'TEMAMATLA', 83);
INSERT INTO `municipio` VALUES (759, 15, 'TEMASCALAPA', 84);
INSERT INTO `municipio` VALUES (760, 15, 'TEMASCALCINGO', 85);
INSERT INTO `municipio` VALUES (761, 15, 'TEMASCALTEPEC', 86);
INSERT INTO `municipio` VALUES (762, 15, 'TEMOAYA', 87);
INSERT INTO `municipio` VALUES (763, 15, 'TENANCINGO', 88);
INSERT INTO `municipio` VALUES (764, 15, 'TENANGO DEL AIRE', 89);
INSERT INTO `municipio` VALUES (765, 15, 'TENANGO DEL VALLE', 90);
INSERT INTO `municipio` VALUES (766, 15, 'TEOLOYUCAN', 91);
INSERT INTO `municipio` VALUES (767, 15, 'TEOTIHUACAN', 92);
INSERT INTO `municipio` VALUES (768, 15, 'TEPETLAOXTOC', 93);
INSERT INTO `municipio` VALUES (769, 15, 'TEPETLIXPA', 94);
INSERT INTO `municipio` VALUES (770, 15, 'TEPOTZOTLAN', 95);
INSERT INTO `municipio` VALUES (771, 15, 'TEQUIXQUIAC', 96);
INSERT INTO `municipio` VALUES (772, 15, 'TEXCALTITLAN', 97);
INSERT INTO `municipio` VALUES (773, 15, 'TEXCALYACAC', 98);
INSERT INTO `municipio` VALUES (774, 15, 'TEXCOCO', 99);
INSERT INTO `municipio` VALUES (775, 15, 'TEZOYUCA', 100);
INSERT INTO `municipio` VALUES (776, 15, 'TIANGUISTENCO', 101);
INSERT INTO `municipio` VALUES (777, 15, 'TIMILPAN', 102);
INSERT INTO `municipio` VALUES (778, 15, 'TLALMANALCO', 103);
INSERT INTO `municipio` VALUES (779, 15, 'TLALNEPANTLA DE BAZ', 104);
INSERT INTO `municipio` VALUES (780, 15, 'TLATLAYA', 105);
INSERT INTO `municipio` VALUES (781, 15, 'TOLUCA', 106);
INSERT INTO `municipio` VALUES (782, 15, 'TONATICO', 107);
INSERT INTO `municipio` VALUES (783, 15, 'TULTEPEC', 108);
INSERT INTO `municipio` VALUES (784, 15, 'TULTITLAN', 109);
INSERT INTO `municipio` VALUES (785, 15, 'VALLE DE BRAVO', 110);
INSERT INTO `municipio` VALUES (786, 15, 'VILLA DE ALLENDE', 111);
INSERT INTO `municipio` VALUES (787, 15, 'VILLA DEL CARBON', 112);
INSERT INTO `municipio` VALUES (788, 15, 'VILLA GUERRERO', 113);
INSERT INTO `municipio` VALUES (789, 15, 'VILLA VICTORIA', 114);
INSERT INTO `municipio` VALUES (790, 15, 'XONACATLAN', 115);
INSERT INTO `municipio` VALUES (791, 15, 'ZACAZONAPAN', 116);
INSERT INTO `municipio` VALUES (792, 15, 'ZACUALPAN', 117);
INSERT INTO `municipio` VALUES (793, 15, 'ZINACANTEPEC', 118);
INSERT INTO `municipio` VALUES (794, 15, 'ZUMPAHUACAN', 119);
INSERT INTO `municipio` VALUES (795, 15, 'ZUMPANGO', 120);
INSERT INTO `municipio` VALUES (796, 15, 'CUAUTITLAN IZCALLI', 121);
INSERT INTO `municipio` VALUES (797, 15, 'VALLE DE CHALCO SOLIDARIDAD', 122);
INSERT INTO `municipio` VALUES (798, 15, 'LUVIANOS', 123);
INSERT INTO `municipio` VALUES (799, 15, 'SAN JOSE DEL RINCON', 124);
INSERT INTO `municipio` VALUES (800, 15, 'TONANITLA', 125);
INSERT INTO `municipio` VALUES (802, 16, 'ACUITZIO', 1);
INSERT INTO `municipio` VALUES (803, 16, 'AGUILILLA', 2);
INSERT INTO `municipio` VALUES (804, 16, 'ALVARO OBREGON', 3);
INSERT INTO `municipio` VALUES (805, 16, 'ANGAMACUTIRO', 4);
INSERT INTO `municipio` VALUES (806, 16, 'ANGANGUEO', 5);
INSERT INTO `municipio` VALUES (807, 16, 'APATZINGAN', 6);
INSERT INTO `municipio` VALUES (808, 16, 'APORO', 7);
INSERT INTO `municipio` VALUES (809, 16, 'AQUILA', 8);
INSERT INTO `municipio` VALUES (810, 16, 'ARIO', 9);
INSERT INTO `municipio` VALUES (811, 16, 'ARTEAGA', 10);
INSERT INTO `municipio` VALUES (812, 16, 'BRISENAS', 11);
INSERT INTO `municipio` VALUES (813, 16, 'BUENAVISTA', 12);
INSERT INTO `municipio` VALUES (814, 16, 'CARACUARO', 13);
INSERT INTO `municipio` VALUES (815, 16, 'COAHUAYANA', 14);
INSERT INTO `municipio` VALUES (816, 16, 'COALCOMAN DE VAZQUEZ PALLARES', 15);
INSERT INTO `municipio` VALUES (817, 16, 'COENEO', 16);
INSERT INTO `municipio` VALUES (818, 16, 'CONTEPEC', 17);
INSERT INTO `municipio` VALUES (819, 16, 'COPANDARO', 18);
INSERT INTO `municipio` VALUES (820, 16, 'COTIJA', 19);
INSERT INTO `municipio` VALUES (821, 16, 'CUITZEO', 20);
INSERT INTO `municipio` VALUES (822, 16, 'CHARAPAN', 21);
INSERT INTO `municipio` VALUES (823, 16, 'CHARO', 22);
INSERT INTO `municipio` VALUES (824, 16, 'CHAVINDA', 23);
INSERT INTO `municipio` VALUES (825, 16, 'CHERAN', 24);
INSERT INTO `municipio` VALUES (826, 16, 'CHILCHOTA', 25);
INSERT INTO `municipio` VALUES (827, 16, 'CHINICUILA', 26);
INSERT INTO `municipio` VALUES (828, 16, 'CHUCANDIRO', 27);
INSERT INTO `municipio` VALUES (829, 16, 'CHURINTZIO', 28);
INSERT INTO `municipio` VALUES (830, 16, 'CHURUMUCO', 29);
INSERT INTO `municipio` VALUES (831, 16, 'ECUANDUREO', 30);
INSERT INTO `municipio` VALUES (832, 16, 'EPITACIO HUERTA', 31);
INSERT INTO `municipio` VALUES (833, 16, 'ERONGARICUARO', 32);
INSERT INTO `municipio` VALUES (834, 16, 'GABRIEL ZAMORA', 33);
INSERT INTO `municipio` VALUES (835, 16, 'HIDALGO', 34);
INSERT INTO `municipio` VALUES (836, 16, 'LA HUACANA', 35);
INSERT INTO `municipio` VALUES (837, 16, 'HUANDACAREO', 36);
INSERT INTO `municipio` VALUES (838, 16, 'HUANIQUEO', 37);
INSERT INTO `municipio` VALUES (839, 16, 'HUETAMO', 38);
INSERT INTO `municipio` VALUES (840, 16, 'HUIRAMBA', 39);
INSERT INTO `municipio` VALUES (841, 16, 'INDAPARAPEO', 40);
INSERT INTO `municipio` VALUES (842, 16, 'IRIMBO', 41);
INSERT INTO `municipio` VALUES (843, 16, 'IXTLAN', 42);
INSERT INTO `municipio` VALUES (844, 16, 'JACONA', 43);
INSERT INTO `municipio` VALUES (845, 16, 'JIMENEZ', 44);
INSERT INTO `municipio` VALUES (846, 16, 'JIQUILPAN', 45);
INSERT INTO `municipio` VALUES (847, 16, 'JUAREZ', 46);
INSERT INTO `municipio` VALUES (848, 16, 'JUNGAPEO', 47);
INSERT INTO `municipio` VALUES (849, 16, 'LAGUNILLAS', 48);
INSERT INTO `municipio` VALUES (850, 16, 'MADERO', 49);
INSERT INTO `municipio` VALUES (851, 16, 'MARAVATIO', 50);
INSERT INTO `municipio` VALUES (852, 16, 'MARCOS CASTELLANOS', 51);
INSERT INTO `municipio` VALUES (853, 16, 'LAZARO CARDENAS', 52);
INSERT INTO `municipio` VALUES (854, 16, 'MORELIA', 53);
INSERT INTO `municipio` VALUES (855, 16, 'MORELOS', 54);
INSERT INTO `municipio` VALUES (856, 16, 'MUGICA', 55);
INSERT INTO `municipio` VALUES (857, 16, 'NAHUATZEN', 56);
INSERT INTO `municipio` VALUES (858, 16, 'NOCUPETARO', 57);
INSERT INTO `municipio` VALUES (859, 16, 'NUEVO PARANGARICUTIRO', 58);
INSERT INTO `municipio` VALUES (860, 16, 'NUEVO URECHO', 59);
INSERT INTO `municipio` VALUES (861, 16, 'NUMARAN', 60);
INSERT INTO `municipio` VALUES (862, 16, 'OCAMPO', 61);
INSERT INTO `municipio` VALUES (863, 16, 'PAJACUARAN', 62);
INSERT INTO `municipio` VALUES (864, 16, 'PANINDICUARO', 63);
INSERT INTO `municipio` VALUES (865, 16, 'PARACUARO', 64);
INSERT INTO `municipio` VALUES (866, 16, 'PARACHO', 65);
INSERT INTO `municipio` VALUES (867, 16, 'PATZCUARO', 66);
INSERT INTO `municipio` VALUES (868, 16, 'PENJAMILLO', 67);
INSERT INTO `municipio` VALUES (869, 16, 'PERIBAN', 68);
INSERT INTO `municipio` VALUES (870, 16, 'LA PIEDAD', 69);
INSERT INTO `municipio` VALUES (871, 16, 'PUREPERO', 70);
INSERT INTO `municipio` VALUES (872, 16, 'PURUANDIRO', 71);
INSERT INTO `municipio` VALUES (873, 16, 'QUERENDARO', 72);
INSERT INTO `municipio` VALUES (874, 16, 'QUIROGA', 73);
INSERT INTO `municipio` VALUES (875, 16, 'COJUMATLAN DE REGULES', 74);
INSERT INTO `municipio` VALUES (876, 16, 'LOS REYES', 75);
INSERT INTO `municipio` VALUES (877, 16, 'SAHUAYO', 76);
INSERT INTO `municipio` VALUES (878, 16, 'SAN LUCAS', 77);
INSERT INTO `municipio` VALUES (879, 16, 'SANTA ANA MAYA', 78);
INSERT INTO `municipio` VALUES (880, 16, 'SALVADOR ESCALANTE', 79);
INSERT INTO `municipio` VALUES (881, 16, 'SENGUIO', 80);
INSERT INTO `municipio` VALUES (882, 16, 'SUSUPUATO', 81);
INSERT INTO `municipio` VALUES (883, 16, 'TACAMBARO', 82);
INSERT INTO `municipio` VALUES (884, 16, 'TANCITARO', 83);
INSERT INTO `municipio` VALUES (885, 16, 'TANGAMANDAPIO', 84);
INSERT INTO `municipio` VALUES (886, 16, 'TANGANCICUARO', 85);
INSERT INTO `municipio` VALUES (887, 16, 'TANHUATO', 86);
INSERT INTO `municipio` VALUES (888, 16, 'TARETAN', 87);
INSERT INTO `municipio` VALUES (889, 16, 'TARIMBARO', 88);
INSERT INTO `municipio` VALUES (890, 16, 'TEPALCATEPEC', 89);
INSERT INTO `municipio` VALUES (891, 16, 'TINGAMBATO', 90);
INSERT INTO `municipio` VALUES (892, 16, 'TINGINDIN', 91);
INSERT INTO `municipio` VALUES (893, 16, 'TIQUICHEO DE NICOLAS ROMERO', 92);
INSERT INTO `municipio` VALUES (894, 16, 'TLALPUJAHUA', 93);
INSERT INTO `municipio` VALUES (895, 16, 'TLAZAZALCA', 94);
INSERT INTO `municipio` VALUES (896, 16, 'TOCUMBO', 95);
INSERT INTO `municipio` VALUES (897, 16, 'TUMBISCATIO', 96);
INSERT INTO `municipio` VALUES (898, 16, 'TURICATO', 97);
INSERT INTO `municipio` VALUES (899, 16, 'TUXPAN', 98);
INSERT INTO `municipio` VALUES (900, 16, 'TUZANTLA', 99);
INSERT INTO `municipio` VALUES (901, 16, 'TZINTZUNTZAN', 100);
INSERT INTO `municipio` VALUES (902, 16, 'TZITZIO', 101);
INSERT INTO `municipio` VALUES (903, 16, 'URUAPAN', 102);
INSERT INTO `municipio` VALUES (904, 16, 'VENUSTIANO CARRANZA', 103);
INSERT INTO `municipio` VALUES (905, 16, 'VILLAMAR', 104);
INSERT INTO `municipio` VALUES (906, 16, 'VISTA HERMOSA', 105);
INSERT INTO `municipio` VALUES (907, 16, 'YURECUARO', 106);
INSERT INTO `municipio` VALUES (908, 16, 'ZACAPU', 107);
INSERT INTO `municipio` VALUES (909, 16, 'ZAMORA', 108);
INSERT INTO `municipio` VALUES (910, 16, 'ZINAPARO', 109);
INSERT INTO `municipio` VALUES (911, 16, 'ZINAPECUARO', 110);
INSERT INTO `municipio` VALUES (912, 16, 'ZIRACUARETIRO', 111);
INSERT INTO `municipio` VALUES (913, 16, 'ZITACUARO', 112);
INSERT INTO `municipio` VALUES (914, 16, 'JOSE SIXTO VERDUZCO', 113);
INSERT INTO `municipio` VALUES (916, 17, 'AMACUZAC', 1);
INSERT INTO `municipio` VALUES (917, 17, 'ATLATLAHUCAN', 2);
INSERT INTO `municipio` VALUES (918, 17, 'AXOCHIAPAN', 3);
INSERT INTO `municipio` VALUES (919, 17, 'AYALA', 4);
INSERT INTO `municipio` VALUES (920, 17, 'COATLAN DEL RIO', 5);
INSERT INTO `municipio` VALUES (921, 17, 'CUAUTLA', 6);
INSERT INTO `municipio` VALUES (922, 17, 'CUERNAVACA', 7);
INSERT INTO `municipio` VALUES (923, 17, 'EMILIANO ZAPATA', 8);
INSERT INTO `municipio` VALUES (924, 17, 'HUITZILAC', 9);
INSERT INTO `municipio` VALUES (925, 17, 'JANTETELCO', 10);
INSERT INTO `municipio` VALUES (926, 17, 'JIUTEPEC', 11);
INSERT INTO `municipio` VALUES (927, 17, 'JOJUTLA', 12);
INSERT INTO `municipio` VALUES (928, 17, 'JONACATEPEC DE LEANDRO VALLE', 13);
INSERT INTO `municipio` VALUES (929, 17, 'MAZATEPEC', 14);
INSERT INTO `municipio` VALUES (930, 17, 'MIACATLAN', 15);
INSERT INTO `municipio` VALUES (931, 17, 'OCUITUCO', 16);
INSERT INTO `municipio` VALUES (932, 17, 'PUENTE DE IXTLA', 17);
INSERT INTO `municipio` VALUES (933, 17, 'TEMIXCO', 18);
INSERT INTO `municipio` VALUES (934, 17, 'TEPALCINGO', 19);
INSERT INTO `municipio` VALUES (935, 17, 'TEPOZTLAN', 20);
INSERT INTO `municipio` VALUES (936, 17, 'TETECALA', 21);
INSERT INTO `municipio` VALUES (937, 17, 'TETELA DEL VOLCAN', 22);
INSERT INTO `municipio` VALUES (938, 17, 'TLALNEPANTLA', 23);
INSERT INTO `municipio` VALUES (939, 17, 'TLALTIZAPAN DE ZAPATA', 24);
INSERT INTO `municipio` VALUES (940, 17, 'TLAQUILTENANGO', 25);
INSERT INTO `municipio` VALUES (941, 17, 'TLAYACAPAN', 26);
INSERT INTO `municipio` VALUES (942, 17, 'TOTOLAPAN', 27);
INSERT INTO `municipio` VALUES (943, 17, 'XOCHITEPEC', 28);
INSERT INTO `municipio` VALUES (944, 17, 'YAUTEPEC', 29);
INSERT INTO `municipio` VALUES (945, 17, 'YECAPIXTLA', 30);
INSERT INTO `municipio` VALUES (946, 17, 'ZACATEPEC', 31);
INSERT INTO `municipio` VALUES (947, 17, 'ZACUALPAN DE AMILPAS', 32);
INSERT INTO `municipio` VALUES (948, 17, 'TEMOAC', 33);
INSERT INTO `municipio` VALUES (949, 17, 'COATETELCO', 34);
INSERT INTO `municipio` VALUES (950, 17, 'XOXOCOTLA', 35);
INSERT INTO `municipio` VALUES (952, 18, 'ACAPONETA', 1);
INSERT INTO `municipio` VALUES (953, 18, 'AHUACATLAN', 2);
INSERT INTO `municipio` VALUES (954, 18, 'AMATLAN DE CANAS', 3);
INSERT INTO `municipio` VALUES (955, 18, 'COMPOSTELA', 4);
INSERT INTO `municipio` VALUES (956, 18, 'HUAJICORI', 5);
INSERT INTO `municipio` VALUES (957, 18, 'IXTLAN DEL RIO', 6);
INSERT INTO `municipio` VALUES (958, 18, 'JALA', 7);
INSERT INTO `municipio` VALUES (959, 18, 'XALISCO', 8);
INSERT INTO `municipio` VALUES (960, 18, 'DEL NAYAR', 9);
INSERT INTO `municipio` VALUES (961, 18, 'ROSAMORADA', 10);
INSERT INTO `municipio` VALUES (962, 18, 'RUIZ', 11);
INSERT INTO `municipio` VALUES (963, 18, 'SAN BLAS', 12);
INSERT INTO `municipio` VALUES (964, 18, 'SAN PEDRO LAGUNILLAS', 13);
INSERT INTO `municipio` VALUES (965, 18, 'SANTA MARIA DEL ORO', 14);
INSERT INTO `municipio` VALUES (966, 18, 'SANTIAGO IXCUINTLA', 15);
INSERT INTO `municipio` VALUES (967, 18, 'TECUALA', 16);
INSERT INTO `municipio` VALUES (968, 18, 'TEPIC', 17);
INSERT INTO `municipio` VALUES (969, 18, 'TUXPAN', 18);
INSERT INTO `municipio` VALUES (970, 18, 'LA YESCA', 19);
INSERT INTO `municipio` VALUES (971, 18, 'BAHIA DE BANDERAS', 20);
INSERT INTO `municipio` VALUES (973, 19, 'ABASOLO', 1);
INSERT INTO `municipio` VALUES (974, 19, 'AGUALEGUAS', 2);
INSERT INTO `municipio` VALUES (975, 19, 'LOS ALDAMAS', 3);
INSERT INTO `municipio` VALUES (976, 19, 'ALLENDE', 4);
INSERT INTO `municipio` VALUES (977, 19, 'ANAHUAC', 5);
INSERT INTO `municipio` VALUES (978, 19, 'APODACA', 6);
INSERT INTO `municipio` VALUES (979, 19, 'ARAMBERRI', 7);
INSERT INTO `municipio` VALUES (980, 19, 'BUSTAMANTE', 8);
INSERT INTO `municipio` VALUES (981, 19, 'CADEREYTA JIMENEZ', 9);
INSERT INTO `municipio` VALUES (982, 19, 'EL CARMEN', 10);
INSERT INTO `municipio` VALUES (983, 19, 'CERRALVO', 11);
INSERT INTO `municipio` VALUES (984, 19, 'CIENEGA DE FLORES', 12);
INSERT INTO `municipio` VALUES (985, 19, 'CHINA', 13);
INSERT INTO `municipio` VALUES (986, 19, 'DOCTOR ARROYO', 14);
INSERT INTO `municipio` VALUES (987, 19, 'DOCTOR COSS', 15);
INSERT INTO `municipio` VALUES (988, 19, 'DOCTOR GONZALEZ', 16);
INSERT INTO `municipio` VALUES (989, 19, 'GALEANA', 17);
INSERT INTO `municipio` VALUES (990, 19, 'GARCIA', 18);
INSERT INTO `municipio` VALUES (991, 19, 'SAN PEDRO GARZA GARCIA', 19);
INSERT INTO `municipio` VALUES (992, 19, 'GENERAL BRAVO', 20);
INSERT INTO `municipio` VALUES (993, 19, 'GENERAL ESCOBEDO', 21);
INSERT INTO `municipio` VALUES (994, 19, 'GENERAL TERAN', 22);
INSERT INTO `municipio` VALUES (995, 19, 'GENERAL TREVINO', 23);
INSERT INTO `municipio` VALUES (996, 19, 'GENERAL ZARAGOZA', 24);
INSERT INTO `municipio` VALUES (997, 19, 'GENERAL ZUAZUA', 25);
INSERT INTO `municipio` VALUES (998, 19, 'GUADALUPE', 26);
INSERT INTO `municipio` VALUES (999, 19, 'LOS HERRERAS', 27);
INSERT INTO `municipio` VALUES (1000, 19, 'HIGUERAS', 28);
INSERT INTO `municipio` VALUES (1001, 19, 'HUALAHUISES', 29);
INSERT INTO `municipio` VALUES (1002, 19, 'ITURBIDE', 30);
INSERT INTO `municipio` VALUES (1003, 19, 'JUAREZ', 31);
INSERT INTO `municipio` VALUES (1004, 19, 'LAMPAZOS DE NARANJO', 32);
INSERT INTO `municipio` VALUES (1005, 19, 'LINARES', 33);
INSERT INTO `municipio` VALUES (1006, 19, 'MARIN', 34);
INSERT INTO `municipio` VALUES (1007, 19, 'MELCHOR OCAMPO', 35);
INSERT INTO `municipio` VALUES (1008, 19, 'MIER Y NORIEGA', 36);
INSERT INTO `municipio` VALUES (1009, 19, 'MINA', 37);
INSERT INTO `municipio` VALUES (1010, 19, 'MONTEMORELOS', 38);
INSERT INTO `municipio` VALUES (1011, 19, 'MONTERREY', 39);
INSERT INTO `municipio` VALUES (1012, 19, 'PARAS', 40);
INSERT INTO `municipio` VALUES (1013, 19, 'PESQUERIA', 41);
INSERT INTO `municipio` VALUES (1014, 19, 'LOS RAMONES', 42);
INSERT INTO `municipio` VALUES (1015, 19, 'RAYONES', 43);
INSERT INTO `municipio` VALUES (1016, 19, 'SABINAS HIDALGO', 44);
INSERT INTO `municipio` VALUES (1017, 19, 'SALINAS VICTORIA', 45);
INSERT INTO `municipio` VALUES (1018, 19, 'SAN NICOLAS DE LOS GARZA', 46);
INSERT INTO `municipio` VALUES (1019, 19, 'HIDALGO', 47);
INSERT INTO `municipio` VALUES (1020, 19, 'SANTA CATARINA', 48);
INSERT INTO `municipio` VALUES (1021, 19, 'SANTIAGO', 49);
INSERT INTO `municipio` VALUES (1022, 19, 'VALLECILLO', 50);
INSERT INTO `municipio` VALUES (1023, 19, 'VILLALDAMA', 51);
INSERT INTO `municipio` VALUES (1025, 20, 'ABEJONES', 1);
INSERT INTO `municipio` VALUES (1026, 20, 'ACATLAN DE PEREZ FIGUEROA', 2);
INSERT INTO `municipio` VALUES (1027, 20, 'ASUNCION CACALOTEPEC', 3);
INSERT INTO `municipio` VALUES (1028, 20, 'ASUNCION CUYOTEPEJI', 4);
INSERT INTO `municipio` VALUES (1029, 20, 'ASUNCION IXTALTEPEC', 5);
INSERT INTO `municipio` VALUES (1030, 20, 'ASUNCION NOCHIXTLAN', 6);
INSERT INTO `municipio` VALUES (1031, 20, 'ASUNCION OCOTLAN', 7);
INSERT INTO `municipio` VALUES (1032, 20, 'ASUNCION TLACOLULITA', 8);
INSERT INTO `municipio` VALUES (1033, 20, 'AYOTZINTEPEC', 9);
INSERT INTO `municipio` VALUES (1034, 20, 'EL BARRIO DE LA SOLEDAD', 10);
INSERT INTO `municipio` VALUES (1035, 20, 'CALIHUALA', 11);
INSERT INTO `municipio` VALUES (1036, 20, 'CANDELARIA LOXICHA', 12);
INSERT INTO `municipio` VALUES (1037, 20, 'CIENEGA DE ZIMATLAN', 13);
INSERT INTO `municipio` VALUES (1038, 20, 'CIUDAD IXTEPEC', 14);
INSERT INTO `municipio` VALUES (1039, 20, 'COATECAS ALTAS', 15);
INSERT INTO `municipio` VALUES (1040, 20, 'COICOYAN DE LAS FLORES', 16);
INSERT INTO `municipio` VALUES (1041, 20, 'LA COMPANIA', 17);
INSERT INTO `municipio` VALUES (1042, 20, 'CONCEPCION BUENAVISTA', 18);
INSERT INTO `municipio` VALUES (1043, 20, 'CONCEPCION PAPALO', 19);
INSERT INTO `municipio` VALUES (1044, 20, 'CONSTANCIA DEL ROSARIO', 20);
INSERT INTO `municipio` VALUES (1045, 20, 'COSOLAPA', 21);
INSERT INTO `municipio` VALUES (1046, 20, 'COSOLTEPEC', 22);
INSERT INTO `municipio` VALUES (1047, 20, 'CUILAPAM DE GUERRERO', 23);
INSERT INTO `municipio` VALUES (1048, 20, 'CUYAMECALCO VILLA DE ZARAGOZA', 24);
INSERT INTO `municipio` VALUES (1049, 20, 'CHAHUITES', 25);
INSERT INTO `municipio` VALUES (1050, 20, 'CHALCATONGO DE HIDALGO', 26);
INSERT INTO `municipio` VALUES (1051, 20, 'CHIQUIHUITLAN DE BENITO JUAREZ', 27);
INSERT INTO `municipio` VALUES (1052, 20, 'HEROICA CIUDAD DE EJUTLA DE CRESPO', 28);
INSERT INTO `municipio` VALUES (1053, 20, 'ELOXOCHITLAN DE FLORES MAGON', 29);
INSERT INTO `municipio` VALUES (1054, 20, 'EL ESPINAL', 30);
INSERT INTO `municipio` VALUES (1055, 20, 'TAMAZULAPAM DEL ESPIRITU SANTO', 31);
INSERT INTO `municipio` VALUES (1056, 20, 'FRESNILLO DE TRUJANO', 32);
INSERT INTO `municipio` VALUES (1057, 20, 'GUADALUPE ETLA', 33);
INSERT INTO `municipio` VALUES (1058, 20, 'GUADALUPE DE RAMIREZ', 34);
INSERT INTO `municipio` VALUES (1059, 20, 'GUELATAO DE JUAREZ', 35);
INSERT INTO `municipio` VALUES (1060, 20, 'GUEVEA DE HUMBOLDT', 36);
INSERT INTO `municipio` VALUES (1061, 20, 'MESONES HIDALGO', 37);
INSERT INTO `municipio` VALUES (1062, 20, 'VILLA HIDALGO', 38);
INSERT INTO `municipio` VALUES (1063, 20, 'HEROICA CIUDAD DE HUAJUAPAN DE LEON', 39);
INSERT INTO `municipio` VALUES (1064, 20, 'HUAUTEPEC', 40);
INSERT INTO `municipio` VALUES (1065, 20, 'HUAUTLA DE JIMENEZ', 41);
INSERT INTO `municipio` VALUES (1066, 20, 'IXTLAN DE JUAREZ', 42);
INSERT INTO `municipio` VALUES (1067, 20, 'JUCHITAN DE ZARAGOZA', 43);
INSERT INTO `municipio` VALUES (1068, 20, 'LOMA BONITA', 44);
INSERT INTO `municipio` VALUES (1069, 20, 'MAGDALENA APASCO', 45);
INSERT INTO `municipio` VALUES (1070, 20, 'MAGDALENA JALTEPEC', 46);
INSERT INTO `municipio` VALUES (1071, 20, 'SANTA MAGDALENA JICOTLAN', 47);
INSERT INTO `municipio` VALUES (1072, 20, 'MAGDALENA MIXTEPEC', 48);
INSERT INTO `municipio` VALUES (1073, 20, 'MAGDALENA OCOTLAN', 49);
INSERT INTO `municipio` VALUES (1074, 20, 'MAGDALENA PENASCO', 50);
INSERT INTO `municipio` VALUES (1075, 20, 'MAGDALENA TEITIPAC', 51);
INSERT INTO `municipio` VALUES (1076, 20, 'MAGDALENA TEQUISISTLAN', 52);
INSERT INTO `municipio` VALUES (1077, 20, 'MAGDALENA TLACOTEPEC', 53);
INSERT INTO `municipio` VALUES (1078, 20, 'MAGDALENA ZAHUATLAN', 54);
INSERT INTO `municipio` VALUES (1079, 20, 'MARISCALA DE JUAREZ', 55);
INSERT INTO `municipio` VALUES (1080, 20, 'MARTIRES DE TACUBAYA', 56);
INSERT INTO `municipio` VALUES (1081, 20, 'MATIAS ROMERO AVENDANO', 57);
INSERT INTO `municipio` VALUES (1082, 20, 'MAZATLAN VILLA DE FLORES', 58);
INSERT INTO `municipio` VALUES (1083, 20, 'MIAHUATLAN DE PORFIRIO DIAZ', 59);
INSERT INTO `municipio` VALUES (1084, 20, 'MIXISTLAN DE LA REFORMA', 60);
INSERT INTO `municipio` VALUES (1085, 20, 'MONJAS', 61);
INSERT INTO `municipio` VALUES (1086, 20, 'NATIVIDAD', 62);
INSERT INTO `municipio` VALUES (1087, 20, 'NAZARENO ETLA', 63);
INSERT INTO `municipio` VALUES (1088, 20, 'NEJAPA DE MADERO', 64);
INSERT INTO `municipio` VALUES (1089, 20, 'IXPANTEPEC NIEVES', 65);
INSERT INTO `municipio` VALUES (1090, 20, 'SANTIAGO NILTEPEC', 66);
INSERT INTO `municipio` VALUES (1091, 20, 'OAXACA DE JUAREZ', 67);
INSERT INTO `municipio` VALUES (1092, 20, 'OCOTLAN DE MORELOS', 68);
INSERT INTO `municipio` VALUES (1093, 20, 'LA PE', 69);
INSERT INTO `municipio` VALUES (1094, 20, 'PINOTEPA DE DON LUIS', 70);
INSERT INTO `municipio` VALUES (1095, 20, 'PLUMA HIDALGO', 71);
INSERT INTO `municipio` VALUES (1096, 20, 'SAN JOSE DEL PROGRESO', 72);
INSERT INTO `municipio` VALUES (1097, 20, 'PUTLA VILLA DE GUERRERO', 73);
INSERT INTO `municipio` VALUES (1098, 20, 'SANTA CATARINA QUIOQUITANI', 74);
INSERT INTO `municipio` VALUES (1099, 20, 'REFORMA DE PINEDA', 75);
INSERT INTO `municipio` VALUES (1100, 20, 'LA REFORMA', 76);
INSERT INTO `municipio` VALUES (1101, 20, 'REYES ETLA', 77);
INSERT INTO `municipio` VALUES (1102, 20, 'ROJAS DE CUAUHTEMOC', 78);
INSERT INTO `municipio` VALUES (1103, 20, 'SALINA CRUZ', 79);
INSERT INTO `municipio` VALUES (1104, 20, 'SAN AGUSTIN AMATENGO', 80);
INSERT INTO `municipio` VALUES (1105, 20, 'SAN AGUSTIN ATENANGO', 81);
INSERT INTO `municipio` VALUES (1106, 20, 'SAN AGUSTIN CHAYUCO', 82);
INSERT INTO `municipio` VALUES (1107, 20, 'SAN AGUSTIN DE LAS JUNTAS', 83);
INSERT INTO `municipio` VALUES (1108, 20, 'SAN AGUSTIN ETLA', 84);
INSERT INTO `municipio` VALUES (1109, 20, 'SAN AGUSTIN LOXICHA', 85);
INSERT INTO `municipio` VALUES (1110, 20, 'SAN AGUSTIN TLACOTEPEC', 86);
INSERT INTO `municipio` VALUES (1111, 20, 'SAN AGUSTIN YATARENI', 87);
INSERT INTO `municipio` VALUES (1112, 20, 'SAN ANDRES CABECERA NUEVA', 88);
INSERT INTO `municipio` VALUES (1113, 20, 'SAN ANDRES DINICUITI', 89);
INSERT INTO `municipio` VALUES (1114, 20, 'SAN ANDRES HUAXPALTEPEC', 90);
INSERT INTO `municipio` VALUES (1115, 20, 'SAN ANDRES HUAYAPAM', 91);
INSERT INTO `municipio` VALUES (1116, 20, 'SAN ANDRES IXTLAHUACA', 92);
INSERT INTO `municipio` VALUES (1117, 20, 'SAN ANDRES LAGUNAS', 93);
INSERT INTO `municipio` VALUES (1118, 20, 'SAN ANDRES NUXINO', 94);
INSERT INTO `municipio` VALUES (1119, 20, 'SAN ANDRES PAXTLAN', 95);
INSERT INTO `municipio` VALUES (1120, 20, 'SAN ANDRES SINAXTLA', 96);
INSERT INTO `municipio` VALUES (1121, 20, 'SAN ANDRES SOLAGA', 97);
INSERT INTO `municipio` VALUES (1122, 20, 'SAN ANDRES TEOTILALPAM', 98);
INSERT INTO `municipio` VALUES (1123, 20, 'SAN ANDRES TEPETLAPA', 99);
INSERT INTO `municipio` VALUES (1124, 20, 'SAN ANDRES YAA', 100);
INSERT INTO `municipio` VALUES (1125, 20, 'SAN ANDRES ZABACHE', 101);
INSERT INTO `municipio` VALUES (1126, 20, 'SAN ANDRES ZAUTLA', 102);
INSERT INTO `municipio` VALUES (1127, 20, 'SAN ANTONINO CASTILLO VELASCO', 103);
INSERT INTO `municipio` VALUES (1128, 20, 'SAN ANTONINO EL ALTO', 104);
INSERT INTO `municipio` VALUES (1129, 20, 'SAN ANTONINO MONTE VERDE', 105);
INSERT INTO `municipio` VALUES (1130, 20, 'SAN ANTONIO ACUTLA', 106);
INSERT INTO `municipio` VALUES (1131, 20, 'SAN ANTONIO DE LA CAL', 107);
INSERT INTO `municipio` VALUES (1132, 20, 'SAN ANTONIO HUITEPEC', 108);
INSERT INTO `municipio` VALUES (1133, 20, 'SAN ANTONIO NANAHUATIPAM', 109);
INSERT INTO `municipio` VALUES (1134, 20, 'SAN ANTONIO SINICAHUA', 110);
INSERT INTO `municipio` VALUES (1135, 20, 'SAN ANTONIO TEPETLAPA', 111);
INSERT INTO `municipio` VALUES (1136, 20, 'SAN BALTAZAR CHICHICAPAM', 112);
INSERT INTO `municipio` VALUES (1137, 20, 'SAN BALTAZAR LOXICHA', 113);
INSERT INTO `municipio` VALUES (1138, 20, 'SAN BALTAZAR YATZACHI EL BAJO', 114);
INSERT INTO `municipio` VALUES (1139, 20, 'SAN BARTOLO COYOTEPEC', 115);
INSERT INTO `municipio` VALUES (1140, 20, 'SAN BARTOLOME AYAUTLA', 116);
INSERT INTO `municipio` VALUES (1141, 20, 'SAN BARTOLOME LOXICHA', 117);
INSERT INTO `municipio` VALUES (1142, 20, 'SAN BARTOLOME QUIALANA', 118);
INSERT INTO `municipio` VALUES (1143, 20, 'SAN BARTOLOME YUCUANE', 119);
INSERT INTO `municipio` VALUES (1144, 20, 'SAN BARTOLOME ZOOGOCHO', 120);
INSERT INTO `municipio` VALUES (1145, 20, 'SAN BARTOLO SOYALTEPEC', 121);
INSERT INTO `municipio` VALUES (1146, 20, 'SAN BARTOLO YAUTEPEC', 122);
INSERT INTO `municipio` VALUES (1147, 20, 'SAN BERNARDO MIXTEPEC', 123);
INSERT INTO `municipio` VALUES (1148, 20, 'SAN BLAS ATEMPA', 124);
INSERT INTO `municipio` VALUES (1149, 20, 'SAN CARLOS YAUTEPEC', 125);
INSERT INTO `municipio` VALUES (1150, 20, 'SAN CRISTOBAL AMATLAN', 126);
INSERT INTO `municipio` VALUES (1151, 20, 'SAN CRISTOBAL AMOLTEPEC', 127);
INSERT INTO `municipio` VALUES (1152, 20, 'SAN CRISTOBAL LACHIRIOAG', 128);
INSERT INTO `municipio` VALUES (1153, 20, 'SAN CRISTOBAL SUCHIXTLAHUACA', 129);
INSERT INTO `municipio` VALUES (1154, 20, 'SAN DIONISIO DEL MAR', 130);
INSERT INTO `municipio` VALUES (1155, 20, 'SAN DIONISIO OCOTEPEC', 131);
INSERT INTO `municipio` VALUES (1156, 20, 'SAN DIONISIO OCOTLAN', 132);
INSERT INTO `municipio` VALUES (1157, 20, 'SAN ESTEBAN ATATLAHUCA', 133);
INSERT INTO `municipio` VALUES (1158, 20, 'SAN FELIPE JALAPA DE DIAZ', 134);
INSERT INTO `municipio` VALUES (1159, 20, 'SAN FELIPE TEJALAPAM', 135);
INSERT INTO `municipio` VALUES (1160, 20, 'SAN FELIPE USILA', 136);
INSERT INTO `municipio` VALUES (1161, 20, 'SAN FRANCISCO CAHUACUA', 137);
INSERT INTO `municipio` VALUES (1162, 20, 'SAN FRANCISCO CAJONOS', 138);
INSERT INTO `municipio` VALUES (1163, 20, 'SAN FRANCISCO CHAPULAPA', 139);
INSERT INTO `municipio` VALUES (1164, 20, 'SAN FRANCISCO CHINDUA', 140);
INSERT INTO `municipio` VALUES (1165, 20, 'SAN FRANCISCO DEL MAR', 141);
INSERT INTO `municipio` VALUES (1166, 20, 'SAN FRANCISCO HUEHUETLAN', 142);
INSERT INTO `municipio` VALUES (1167, 20, 'SAN FRANCISCO IXHUATAN', 143);
INSERT INTO `municipio` VALUES (1168, 20, 'SAN FRANCISCO JALTEPETONGO', 144);
INSERT INTO `municipio` VALUES (1169, 20, 'SAN FRANCISCO LACHIGOLO', 145);
INSERT INTO `municipio` VALUES (1170, 20, 'SAN FRANCISCO LOGUECHE', 146);
INSERT INTO `municipio` VALUES (1171, 20, 'SAN FRANCISCO NUXANO', 147);
INSERT INTO `municipio` VALUES (1172, 20, 'SAN FRANCISCO OZOLOTEPEC', 148);
INSERT INTO `municipio` VALUES (1173, 20, 'SAN FRANCISCO SOLA', 149);
INSERT INTO `municipio` VALUES (1174, 20, 'SAN FRANCISCO TELIXTLAHUACA', 150);
INSERT INTO `municipio` VALUES (1175, 20, 'SAN FRANCISCO TEOPAN', 151);
INSERT INTO `municipio` VALUES (1176, 20, 'SAN FRANCISCO TLAPANCINGO', 152);
INSERT INTO `municipio` VALUES (1177, 20, 'SAN GABRIEL MIXTEPEC', 153);
INSERT INTO `municipio` VALUES (1178, 20, 'SAN ILDEFONSO AMATLAN', 154);
INSERT INTO `municipio` VALUES (1179, 20, 'SAN ILDEFONSO SOLA', 155);
INSERT INTO `municipio` VALUES (1180, 20, 'SAN ILDEFONSO VILLA ALTA', 156);
INSERT INTO `municipio` VALUES (1181, 20, 'SAN JACINTO AMILPAS', 157);
INSERT INTO `municipio` VALUES (1182, 20, 'SAN JACINTO TLACOTEPEC', 158);
INSERT INTO `municipio` VALUES (1183, 20, 'SAN JERONIMO COATLAN', 159);
INSERT INTO `municipio` VALUES (1184, 20, 'SAN JERONIMO SILACAYOAPILLA', 160);
INSERT INTO `municipio` VALUES (1185, 20, 'SAN JERONIMO SOSOLA', 161);
INSERT INTO `municipio` VALUES (1186, 20, 'SAN JERONIMO TAVICHE', 162);
INSERT INTO `municipio` VALUES (1187, 20, 'SAN JERONIMO TECOATL', 163);
INSERT INTO `municipio` VALUES (1188, 20, 'SAN JORGE NUCHITA', 164);
INSERT INTO `municipio` VALUES (1189, 20, 'SAN JOSE AYUQUILA', 165);
INSERT INTO `municipio` VALUES (1190, 20, 'SAN JOSE CHILTEPEC', 166);
INSERT INTO `municipio` VALUES (1191, 20, 'SAN JOSE DEL PENASCO', 167);
INSERT INTO `municipio` VALUES (1192, 20, 'SAN JOSE ESTANCIA GRANDE', 168);
INSERT INTO `municipio` VALUES (1193, 20, 'SAN JOSE INDEPENDENCIA', 169);
INSERT INTO `municipio` VALUES (1194, 20, 'SAN JOSE LACHIGUIRI', 170);
INSERT INTO `municipio` VALUES (1195, 20, 'SAN JOSE TENANGO', 171);
INSERT INTO `municipio` VALUES (1196, 20, 'SAN JUAN ACHIUTLA', 172);
INSERT INTO `municipio` VALUES (1197, 20, 'SAN JUAN ATEPEC', 173);
INSERT INTO `municipio` VALUES (1198, 20, 'ANIMAS TRUJANO', 174);
INSERT INTO `municipio` VALUES (1199, 20, 'SAN JUAN BAUTISTA ATATLAHUCA', 175);
INSERT INTO `municipio` VALUES (1200, 20, 'SAN JUAN BAUTISTA COIXTLAHUACA', 176);
INSERT INTO `municipio` VALUES (1201, 20, 'SAN JUAN BAUTISTA CUICATLAN', 177);
INSERT INTO `municipio` VALUES (1202, 20, 'SAN JUAN BAUTISTA GUELACHE', 178);
INSERT INTO `municipio` VALUES (1203, 20, 'SAN JUAN BAUTISTA JAYACATLAN', 179);
INSERT INTO `municipio` VALUES (1204, 20, 'SAN JUAN BAUTISTA LO DE SOTO', 180);
INSERT INTO `municipio` VALUES (1205, 20, 'SAN JUAN BAUTISTA SUCHITEPEC', 181);
INSERT INTO `municipio` VALUES (1206, 20, 'SAN JUAN BAUTISTA TLACOATZINTEPEC', 182);
INSERT INTO `municipio` VALUES (1207, 20, 'SAN JUAN BAUTISTA TLACHICHILCO', 183);
INSERT INTO `municipio` VALUES (1208, 20, 'SAN JUAN BAUTISTA TUXTEPEC', 184);
INSERT INTO `municipio` VALUES (1209, 20, 'SAN JUAN CACAHUATEPEC', 185);
INSERT INTO `municipio` VALUES (1210, 20, 'SAN JUAN CIENEGUILLA', 186);
INSERT INTO `municipio` VALUES (1211, 20, 'SAN JUAN COATZOSPAM', 187);
INSERT INTO `municipio` VALUES (1212, 20, 'SAN JUAN COLORADO', 188);
INSERT INTO `municipio` VALUES (1213, 20, 'SAN JUAN COMALTEPEC', 189);
INSERT INTO `municipio` VALUES (1214, 20, 'SAN JUAN COTZOCON', 190);
INSERT INTO `municipio` VALUES (1215, 20, 'SAN JUAN CHICOMEZUCHIL', 191);
INSERT INTO `municipio` VALUES (1216, 20, 'SAN JUAN CHILATECA', 192);
INSERT INTO `municipio` VALUES (1217, 20, 'SAN JUAN DEL ESTADO', 193);
INSERT INTO `municipio` VALUES (1218, 20, 'SAN JUAN DEL RIO', 194);
INSERT INTO `municipio` VALUES (1219, 20, 'SAN JUAN DIUXI', 195);
INSERT INTO `municipio` VALUES (1220, 20, 'SAN JUAN EVANGELISTA ANALCO', 196);
INSERT INTO `municipio` VALUES (1221, 20, 'SAN JUAN GUELAVIA', 197);
INSERT INTO `municipio` VALUES (1222, 20, 'SAN JUAN GUICHICOVI', 198);
INSERT INTO `municipio` VALUES (1223, 20, 'SAN JUAN IHUALTEPEC', 199);
INSERT INTO `municipio` VALUES (1224, 20, 'SAN JUAN JUQUILA MIXES', 200);
INSERT INTO `municipio` VALUES (1225, 20, 'SAN JUAN JUQUILA VIJANOS', 201);
INSERT INTO `municipio` VALUES (1226, 20, 'SAN JUAN LACHAO', 202);
INSERT INTO `municipio` VALUES (1227, 20, 'SAN JUAN LACHIGALLA', 203);
INSERT INTO `municipio` VALUES (1228, 20, 'SAN JUAN LAJARCIA', 204);
INSERT INTO `municipio` VALUES (1229, 20, 'SAN JUAN LALANA', 205);
INSERT INTO `municipio` VALUES (1230, 20, 'SAN JUAN DE LOS CUES', 206);
INSERT INTO `municipio` VALUES (1231, 20, 'SAN JUAN MAZATLAN', 207);
INSERT INTO `municipio` VALUES (1232, 20, 'SAN JUAN MIXTEPEC', 208);
INSERT INTO `municipio` VALUES (1233, 20, 'SAN JUAN MIXTEPEC', 209);
INSERT INTO `municipio` VALUES (1234, 20, 'SAN JUAN NUMI', 210);
INSERT INTO `municipio` VALUES (1235, 20, 'SAN JUAN OZOLOTEPEC', 211);
INSERT INTO `municipio` VALUES (1236, 20, 'SAN JUAN PETLAPA', 212);
INSERT INTO `municipio` VALUES (1237, 20, 'SAN JUAN QUIAHIJE', 213);
INSERT INTO `municipio` VALUES (1238, 20, 'SAN JUAN QUIOTEPEC', 214);
INSERT INTO `municipio` VALUES (1239, 20, 'SAN JUAN SAYULTEPEC', 215);
INSERT INTO `municipio` VALUES (1240, 20, 'SAN JUAN TABAA', 216);
INSERT INTO `municipio` VALUES (1241, 20, 'SAN JUAN TAMAZOLA', 217);
INSERT INTO `municipio` VALUES (1242, 20, 'SAN JUAN TEITA', 218);
INSERT INTO `municipio` VALUES (1243, 20, 'SAN JUAN TEITIPAC', 219);
INSERT INTO `municipio` VALUES (1244, 20, 'SAN JUAN TEPEUXILA', 220);
INSERT INTO `municipio` VALUES (1245, 20, 'SAN JUAN TEPOSCOLULA', 221);
INSERT INTO `municipio` VALUES (1246, 20, 'SAN JUAN YAEE', 222);
INSERT INTO `municipio` VALUES (1247, 20, 'SAN JUAN YATZONA', 223);
INSERT INTO `municipio` VALUES (1248, 20, 'SAN JUAN YUCUITA', 224);
INSERT INTO `municipio` VALUES (1249, 20, 'SAN LORENZO', 225);
INSERT INTO `municipio` VALUES (1250, 20, 'SAN LORENZO ALBARRADAS', 226);
INSERT INTO `municipio` VALUES (1251, 20, 'SAN LORENZO CACAOTEPEC', 227);
INSERT INTO `municipio` VALUES (1252, 20, 'SAN LORENZO CUAUNECUILTITLA', 228);
INSERT INTO `municipio` VALUES (1253, 20, 'SAN LORENZO TEXMELUCAN', 229);
INSERT INTO `municipio` VALUES (1254, 20, 'SAN LORENZO VICTORIA', 230);
INSERT INTO `municipio` VALUES (1255, 20, 'SAN LUCAS CAMOTLAN', 231);
INSERT INTO `municipio` VALUES (1256, 20, 'SAN LUCAS OJITLAN', 232);
INSERT INTO `municipio` VALUES (1257, 20, 'SAN LUCAS QUIAVINI', 233);
INSERT INTO `municipio` VALUES (1258, 20, 'SAN LUCAS ZOQUIAPAM', 234);
INSERT INTO `municipio` VALUES (1259, 20, 'SAN LUIS AMATLAN', 235);
INSERT INTO `municipio` VALUES (1260, 20, 'SAN MARCIAL OZOLOTEPEC', 236);
INSERT INTO `municipio` VALUES (1261, 20, 'SAN MARCOS ARTEAGA', 237);
INSERT INTO `municipio` VALUES (1262, 20, 'SAN MARTIN DE LOS CANSECOS', 238);
INSERT INTO `municipio` VALUES (1263, 20, 'SAN MARTIN HUAMELULPAM', 239);
INSERT INTO `municipio` VALUES (1264, 20, 'SAN MARTIN ITUNYOSO', 240);
INSERT INTO `municipio` VALUES (1265, 20, 'SAN MARTIN LACHILA', 241);
INSERT INTO `municipio` VALUES (1266, 20, 'SAN MARTIN PERAS', 242);
INSERT INTO `municipio` VALUES (1267, 20, 'SAN MARTIN TILCAJETE', 243);
INSERT INTO `municipio` VALUES (1268, 20, 'SAN MARTIN TOXPALAN', 244);
INSERT INTO `municipio` VALUES (1269, 20, 'SAN MARTIN ZACATEPEC', 245);
INSERT INTO `municipio` VALUES (1270, 20, 'SAN MATEO CAJONOS', 246);
INSERT INTO `municipio` VALUES (1271, 20, 'CAPULALPAM DE MENDEZ', 247);
INSERT INTO `municipio` VALUES (1272, 20, 'SAN MATEO DEL MAR', 248);
INSERT INTO `municipio` VALUES (1273, 20, 'SAN MATEO YOLOXOCHITLAN', 249);
INSERT INTO `municipio` VALUES (1274, 20, 'SAN MATEO ETLATONGO', 250);
INSERT INTO `municipio` VALUES (1275, 20, 'SAN MATEO NEJAPAM', 251);
INSERT INTO `municipio` VALUES (1276, 20, 'SAN MATEO PENASCO', 252);
INSERT INTO `municipio` VALUES (1277, 20, 'SAN MATEO PINAS', 253);
INSERT INTO `municipio` VALUES (1278, 20, 'SAN MATEO RIO HONDO', 254);
INSERT INTO `municipio` VALUES (1279, 20, 'SAN MATEO SINDIHUI', 255);
INSERT INTO `municipio` VALUES (1280, 20, 'SAN MATEO TLAPILTEPEC', 256);
INSERT INTO `municipio` VALUES (1281, 20, 'SAN MELCHOR BETAZA', 257);
INSERT INTO `municipio` VALUES (1282, 20, 'SAN MIGUEL ACHIUTLA', 258);
INSERT INTO `municipio` VALUES (1283, 20, 'SAN MIGUEL AHUEHUETITLAN', 259);
INSERT INTO `municipio` VALUES (1284, 20, 'SAN MIGUEL ALOAPAM', 260);
INSERT INTO `municipio` VALUES (1285, 20, 'SAN MIGUEL AMATITLAN', 261);
INSERT INTO `municipio` VALUES (1286, 20, 'SAN MIGUEL AMATLAN', 262);
INSERT INTO `municipio` VALUES (1287, 20, 'SAN MIGUEL COATLAN', 263);
INSERT INTO `municipio` VALUES (1288, 20, 'SAN MIGUEL CHICAHUA', 264);
INSERT INTO `municipio` VALUES (1289, 20, 'SAN MIGUEL CHIMALAPA', 265);
INSERT INTO `municipio` VALUES (1290, 20, 'SAN MIGUEL DEL PUERTO', 266);
INSERT INTO `municipio` VALUES (1291, 20, 'SAN MIGUEL DEL RIO', 267);
INSERT INTO `municipio` VALUES (1292, 20, 'SAN MIGUEL EJUTLA', 268);
INSERT INTO `municipio` VALUES (1293, 20, 'SAN MIGUEL EL GRANDE', 269);
INSERT INTO `municipio` VALUES (1294, 20, 'SAN MIGUEL HUAUTLA', 270);
INSERT INTO `municipio` VALUES (1295, 20, 'SAN MIGUEL MIXTEPEC', 271);
INSERT INTO `municipio` VALUES (1296, 20, 'SAN MIGUEL PANIXTLAHUACA', 272);
INSERT INTO `municipio` VALUES (1297, 20, 'SAN MIGUEL PERAS', 273);
INSERT INTO `municipio` VALUES (1298, 20, 'SAN MIGUEL PIEDRAS', 274);
INSERT INTO `municipio` VALUES (1299, 20, 'SAN MIGUEL QUETZALTEPEC', 275);
INSERT INTO `municipio` VALUES (1300, 20, 'SAN MIGUEL SANTA FLOR', 276);
INSERT INTO `municipio` VALUES (1301, 20, 'VILLA SOLA DE VEGA', 277);
INSERT INTO `municipio` VALUES (1302, 20, 'SAN MIGUEL SOYALTEPEC', 278);
INSERT INTO `municipio` VALUES (1303, 20, 'SAN MIGUEL SUCHIXTEPEC', 279);
INSERT INTO `municipio` VALUES (1304, 20, 'VILLA TALEA DE CASTRO', 280);
INSERT INTO `municipio` VALUES (1305, 20, 'SAN MIGUEL TECOMATLAN', 281);
INSERT INTO `municipio` VALUES (1306, 20, 'SAN MIGUEL TENANGO', 282);
INSERT INTO `municipio` VALUES (1307, 20, 'SAN MIGUEL TEQUIXTEPEC', 283);
INSERT INTO `municipio` VALUES (1308, 20, 'SAN MIGUEL TILQUIAPAM', 284);
INSERT INTO `municipio` VALUES (1309, 20, 'SAN MIGUEL TLACAMAMA', 285);
INSERT INTO `municipio` VALUES (1310, 20, 'SAN MIGUEL TLACOTEPEC', 286);
INSERT INTO `municipio` VALUES (1311, 20, 'SAN MIGUEL TULANCINGO', 287);
INSERT INTO `municipio` VALUES (1312, 20, 'SAN MIGUEL YOTAO', 288);
INSERT INTO `municipio` VALUES (1313, 20, 'SAN NICOLAS', 289);
INSERT INTO `municipio` VALUES (1314, 20, 'SAN NICOLAS HIDALGO', 290);
INSERT INTO `municipio` VALUES (1315, 20, 'SAN PABLO COATLAN', 291);
INSERT INTO `municipio` VALUES (1316, 20, 'SAN PABLO CUATRO VENADOS', 292);
INSERT INTO `municipio` VALUES (1317, 20, 'SAN PABLO ETLA', 293);
INSERT INTO `municipio` VALUES (1318, 20, 'SAN PABLO HUITZO', 294);
INSERT INTO `municipio` VALUES (1319, 20, 'SAN PABLO HUIXTEPEC', 295);
INSERT INTO `municipio` VALUES (1320, 20, 'SAN PABLO MACUILTIANGUIS', 296);
INSERT INTO `municipio` VALUES (1321, 20, 'SAN PABLO TIJALTEPEC', 297);
INSERT INTO `municipio` VALUES (1322, 20, 'SAN PABLO VILLA DE MITLA', 298);
INSERT INTO `municipio` VALUES (1323, 20, 'SAN PABLO YAGANIZA', 299);
INSERT INTO `municipio` VALUES (1324, 20, 'SAN PEDRO AMUZGOS', 300);
INSERT INTO `municipio` VALUES (1325, 20, 'SAN PEDRO APOSTOL', 301);
INSERT INTO `municipio` VALUES (1326, 20, 'SAN PEDRO ATOYAC', 302);
INSERT INTO `municipio` VALUES (1327, 20, 'SAN PEDRO CAJONOS', 303);
INSERT INTO `municipio` VALUES (1328, 20, 'SAN PEDRO COXCALTEPEC CANTAROS', 304);
INSERT INTO `municipio` VALUES (1329, 20, 'SAN PEDRO COMITANCILLO', 305);
INSERT INTO `municipio` VALUES (1330, 20, 'SAN PEDRO EL ALTO', 306);
INSERT INTO `municipio` VALUES (1331, 20, 'SAN PEDRO HUAMELULA', 307);
INSERT INTO `municipio` VALUES (1332, 20, 'SAN PEDRO HUILOTEPEC', 308);
INSERT INTO `municipio` VALUES (1333, 20, 'SAN PEDRO IXCATLAN', 309);
INSERT INTO `municipio` VALUES (1334, 20, 'SAN PEDRO IXTLAHUACA', 310);
INSERT INTO `municipio` VALUES (1335, 20, 'SAN PEDRO JALTEPETONGO', 311);
INSERT INTO `municipio` VALUES (1336, 20, 'SAN PEDRO JICAYAN', 312);
INSERT INTO `municipio` VALUES (1337, 20, 'SAN PEDRO JOCOTIPAC', 313);
INSERT INTO `municipio` VALUES (1338, 20, 'SAN PEDRO JUCHATENGO', 314);
INSERT INTO `municipio` VALUES (1339, 20, 'SAN PEDRO MARTIR', 315);
INSERT INTO `municipio` VALUES (1340, 20, 'SAN PEDRO MARTIR QUIECHAPA', 316);
INSERT INTO `municipio` VALUES (1341, 20, 'SAN PEDRO MARTIR YUCUXACO', 317);
INSERT INTO `municipio` VALUES (1342, 20, 'SAN PEDRO MIXTEPEC', 318);
INSERT INTO `municipio` VALUES (1343, 20, 'SAN PEDRO MIXTEPEC', 319);
INSERT INTO `municipio` VALUES (1344, 20, 'SAN PEDRO MOLINOS', 320);
INSERT INTO `municipio` VALUES (1345, 20, 'SAN PEDRO NOPALA', 321);
INSERT INTO `municipio` VALUES (1346, 20, 'SAN PEDRO OCOPETATILLO', 322);
INSERT INTO `municipio` VALUES (1347, 20, 'SAN PEDRO OCOTEPEC', 323);
INSERT INTO `municipio` VALUES (1348, 20, 'SAN PEDRO POCHUTLA', 324);
INSERT INTO `municipio` VALUES (1349, 20, 'SAN PEDRO QUIATONI', 325);
INSERT INTO `municipio` VALUES (1350, 20, 'SAN PEDRO SOCHIAPAM', 326);
INSERT INTO `municipio` VALUES (1351, 20, 'SAN PEDRO TAPANATEPEC', 327);
INSERT INTO `municipio` VALUES (1352, 20, 'SAN PEDRO TAVICHE', 328);
INSERT INTO `municipio` VALUES (1353, 20, 'SAN PEDRO TEOZACOALCO', 329);
INSERT INTO `municipio` VALUES (1354, 20, 'SAN PEDRO TEUTILA', 330);
INSERT INTO `municipio` VALUES (1355, 20, 'SAN PEDRO TIDAA', 331);
INSERT INTO `municipio` VALUES (1356, 20, 'SAN PEDRO TOPILTEPEC', 332);
INSERT INTO `municipio` VALUES (1357, 20, 'SAN PEDRO TOTOLAPAM', 333);
INSERT INTO `municipio` VALUES (1358, 20, 'VILLA DE TUTUTEPEC', 334);
INSERT INTO `municipio` VALUES (1359, 20, 'SAN PEDRO YANERI', 335);
INSERT INTO `municipio` VALUES (1360, 20, 'SAN PEDRO YOLOX', 336);
INSERT INTO `municipio` VALUES (1361, 20, 'SAN PEDRO Y SAN PABLO AYUTLA', 337);
INSERT INTO `municipio` VALUES (1362, 20, 'VILLA DE ETLA', 338);
INSERT INTO `municipio` VALUES (1363, 20, 'SAN PEDRO Y SAN PABLO TEPOSCOLULA', 339);
INSERT INTO `municipio` VALUES (1364, 20, 'SAN PEDRO Y SAN PABLO TEQUIXTEPEC', 340);
INSERT INTO `municipio` VALUES (1365, 20, 'SAN PEDRO YUCUNAMA', 341);
INSERT INTO `municipio` VALUES (1366, 20, 'SAN RAYMUNDO JALPAN', 342);
INSERT INTO `municipio` VALUES (1367, 20, 'SAN SEBASTIAN ABASOLO', 343);
INSERT INTO `municipio` VALUES (1368, 20, 'SAN SEBASTIAN COATLAN', 344);
INSERT INTO `municipio` VALUES (1369, 20, 'SAN SEBASTIAN IXCAPA', 345);
INSERT INTO `municipio` VALUES (1370, 20, 'SAN SEBASTIAN NICANANDUTA', 346);
INSERT INTO `municipio` VALUES (1371, 20, 'SAN SEBASTIAN RIO HONDO', 347);
INSERT INTO `municipio` VALUES (1372, 20, 'SAN SEBASTIAN TECOMAXTLAHUACA', 348);
INSERT INTO `municipio` VALUES (1373, 20, 'SAN SEBASTIAN TEITIPAC', 349);
INSERT INTO `municipio` VALUES (1374, 20, 'SAN SEBASTIAN TUTLA', 350);
INSERT INTO `municipio` VALUES (1375, 20, 'SAN SIMON ALMOLONGAS', 351);
INSERT INTO `municipio` VALUES (1376, 20, 'SAN SIMON ZAHUATLAN', 352);
INSERT INTO `municipio` VALUES (1377, 20, 'SANTA ANA', 353);
INSERT INTO `municipio` VALUES (1378, 20, 'SANTA ANA ATEIXTLAHUACA', 354);
INSERT INTO `municipio` VALUES (1379, 20, 'SANTA ANA CUAUHTEMOC', 355);
INSERT INTO `municipio` VALUES (1380, 20, 'SANTA ANA DEL VALLE', 356);
INSERT INTO `municipio` VALUES (1381, 20, 'SANTA ANA TAVELA', 357);
INSERT INTO `municipio` VALUES (1382, 20, 'SANTA ANA TLAPACOYAN', 358);
INSERT INTO `municipio` VALUES (1383, 20, 'SANTA ANA YARENI', 359);
INSERT INTO `municipio` VALUES (1384, 20, 'SANTA ANA ZEGACHE', 360);
INSERT INTO `municipio` VALUES (1385, 20, 'SANTA CATALINA QUIERI', 361);
INSERT INTO `municipio` VALUES (1386, 20, 'SANTA CATARINA CUIXTLA', 362);
INSERT INTO `municipio` VALUES (1387, 20, 'SANTA CATARINA IXTEPEJI', 363);
INSERT INTO `municipio` VALUES (1388, 20, 'SANTA CATARINA JUQUILA', 364);
INSERT INTO `municipio` VALUES (1389, 20, 'SANTA CATARINA LACHATAO', 365);
INSERT INTO `municipio` VALUES (1390, 20, 'SANTA CATARINA LOXICHA', 366);
INSERT INTO `municipio` VALUES (1391, 20, 'SANTA CATARINA MECHOACAN', 367);
INSERT INTO `municipio` VALUES (1392, 20, 'SANTA CATARINA MINAS', 368);
INSERT INTO `municipio` VALUES (1393, 20, 'SANTA CATARINA QUIANE', 369);
INSERT INTO `municipio` VALUES (1394, 20, 'SANTA CATARINA TAYATA', 370);
INSERT INTO `municipio` VALUES (1395, 20, 'SANTA CATARINA TICUA', 371);
INSERT INTO `municipio` VALUES (1396, 20, 'SANTA CATARINA YOSONOTU', 372);
INSERT INTO `municipio` VALUES (1397, 20, 'SANTA CATARINA ZAPOQUILA', 373);
INSERT INTO `municipio` VALUES (1398, 20, 'SANTA CRUZ ACATEPEC', 374);
INSERT INTO `municipio` VALUES (1399, 20, 'SANTA CRUZ AMILPAS', 375);
INSERT INTO `municipio` VALUES (1400, 20, 'SANTA CRUZ DE BRAVO', 376);
INSERT INTO `municipio` VALUES (1401, 20, 'SANTA CRUZ ITUNDUJIA', 377);
INSERT INTO `municipio` VALUES (1402, 20, 'SANTA CRUZ MIXTEPEC', 378);
INSERT INTO `municipio` VALUES (1403, 20, 'SANTA CRUZ NUNDACO', 379);
INSERT INTO `municipio` VALUES (1404, 20, 'SANTA CRUZ PAPALUTLA', 380);
INSERT INTO `municipio` VALUES (1405, 20, 'SANTA CRUZ TACACHE DE MINA', 381);
INSERT INTO `municipio` VALUES (1406, 20, 'SANTA CRUZ TACAHUA', 382);
INSERT INTO `municipio` VALUES (1407, 20, 'SANTA CRUZ TAYATA', 383);
INSERT INTO `municipio` VALUES (1408, 20, 'SANTA CRUZ XITLA', 384);
INSERT INTO `municipio` VALUES (1409, 20, 'SANTA CRUZ XOXOCOTLAN', 385);
INSERT INTO `municipio` VALUES (1410, 20, 'SANTA CRUZ ZENZONTEPEC', 386);
INSERT INTO `municipio` VALUES (1411, 20, 'SANTA GERTRUDIS', 387);
INSERT INTO `municipio` VALUES (1412, 20, 'SANTA INES DEL MONTE', 388);
INSERT INTO `municipio` VALUES (1413, 20, 'SANTA INES YATZECHE', 389);
INSERT INTO `municipio` VALUES (1414, 20, 'SANTA LUCIA DEL CAMINO', 390);
INSERT INTO `municipio` VALUES (1415, 20, 'SANTA LUCIA MIAHUATLAN', 391);
INSERT INTO `municipio` VALUES (1416, 20, 'SANTA LUCIA MONTEVERDE', 392);
INSERT INTO `municipio` VALUES (1417, 20, 'SANTA LUCIA OCOTLAN', 393);
INSERT INTO `municipio` VALUES (1418, 20, 'SANTA MARIA ALOTEPEC', 394);
INSERT INTO `municipio` VALUES (1419, 20, 'SANTA MARIA APAZCO', 395);
INSERT INTO `municipio` VALUES (1420, 20, 'SANTA MARIA LA ASUNCION', 396);
INSERT INTO `municipio` VALUES (1421, 20, 'HEROICA CIUDAD DE TLAXIACO', 397);
INSERT INTO `municipio` VALUES (1422, 20, 'AYOQUEZCO DE ALDAMA', 398);
INSERT INTO `municipio` VALUES (1423, 20, 'SANTA MARIA ATZOMPA', 399);
INSERT INTO `municipio` VALUES (1424, 20, 'SANTA MARIA CAMOTLAN', 400);
INSERT INTO `municipio` VALUES (1425, 20, 'SANTA MARIA COLOTEPEC', 401);
INSERT INTO `municipio` VALUES (1426, 20, 'SANTA MARIA CORTIJO', 402);
INSERT INTO `municipio` VALUES (1427, 20, 'SANTA MARIA COYOTEPEC', 403);
INSERT INTO `municipio` VALUES (1428, 20, 'SANTA MARIA CHACHOAPAM', 404);
INSERT INTO `municipio` VALUES (1429, 20, 'VILLA DE CHILAPA DE DIAZ', 405);
INSERT INTO `municipio` VALUES (1430, 20, 'SANTA MARIA CHILCHOTLA', 406);
INSERT INTO `municipio` VALUES (1431, 20, 'SANTA MARIA CHIMALAPA', 407);
INSERT INTO `municipio` VALUES (1432, 20, 'SANTA MARIA DEL ROSARIO', 408);
INSERT INTO `municipio` VALUES (1433, 20, 'SANTA MARIA DEL TULE', 409);
INSERT INTO `municipio` VALUES (1434, 20, 'SANTA MARIA ECATEPEC', 410);
INSERT INTO `municipio` VALUES (1435, 20, 'SANTA MARIA GUELACE', 411);
INSERT INTO `municipio` VALUES (1436, 20, 'SANTA MARIA GUIENAGATI', 412);
INSERT INTO `municipio` VALUES (1437, 20, 'SANTA MARIA HUATULCO', 413);
INSERT INTO `municipio` VALUES (1438, 20, 'SANTA MARIA HUAZOLOTITLAN', 414);
INSERT INTO `municipio` VALUES (1439, 20, 'SANTA MARIA IPALAPA', 415);
INSERT INTO `municipio` VALUES (1440, 20, 'SANTA MARIA IXCATLAN', 416);
INSERT INTO `municipio` VALUES (1441, 20, 'SANTA MARIA JACATEPEC', 417);
INSERT INTO `municipio` VALUES (1442, 20, 'SANTA MARIA JALAPA DEL MARQUES', 418);
INSERT INTO `municipio` VALUES (1443, 20, 'SANTA MARIA JALTIANGUIS', 419);
INSERT INTO `municipio` VALUES (1444, 20, 'SANTA MARIA LACHIXIO', 420);
INSERT INTO `municipio` VALUES (1445, 20, 'SANTA MARIA MIXTEQUILLA', 421);
INSERT INTO `municipio` VALUES (1446, 20, 'SANTA MARIA NATIVITAS', 422);
INSERT INTO `municipio` VALUES (1447, 20, 'SANTA MARIA NDUAYACO', 423);
INSERT INTO `municipio` VALUES (1448, 20, 'SANTA MARIA OZOLOTEPEC', 424);
INSERT INTO `municipio` VALUES (1449, 20, 'SANTA MARIA PAPALO', 425);
INSERT INTO `municipio` VALUES (1450, 20, 'SANTA MARIA PENOLES', 426);
INSERT INTO `municipio` VALUES (1451, 20, 'SANTA MARIA PETAPA', 427);
INSERT INTO `municipio` VALUES (1452, 20, 'SANTA MARIA QUIEGOLANI', 428);
INSERT INTO `municipio` VALUES (1453, 20, 'SANTA MARIA SOLA', 429);
INSERT INTO `municipio` VALUES (1454, 20, 'SANTA MARIA TATALTEPEC', 430);
INSERT INTO `municipio` VALUES (1455, 20, 'SANTA MARIA TECOMAVACA', 431);
INSERT INTO `municipio` VALUES (1456, 20, 'SANTA MARIA TEMAXCALAPA', 432);
INSERT INTO `municipio` VALUES (1457, 20, 'SANTA MARIA TEMAXCALTEPEC', 433);
INSERT INTO `municipio` VALUES (1458, 20, 'SANTA MARIA TEOPOXCO', 434);
INSERT INTO `municipio` VALUES (1459, 20, 'SANTA MARIA TEPANTLALI', 435);
INSERT INTO `municipio` VALUES (1460, 20, 'SANTA MARIA TEXCATITLAN', 436);
INSERT INTO `municipio` VALUES (1461, 20, 'SANTA MARIA TLAHUITOLTEPEC', 437);
INSERT INTO `municipio` VALUES (1462, 20, 'SANTA MARIA TLALIXTAC', 438);
INSERT INTO `municipio` VALUES (1463, 20, 'SANTA MARIA TONAMECA', 439);
INSERT INTO `municipio` VALUES (1464, 20, 'SANTA MARIA TOTOLAPILLA', 440);
INSERT INTO `municipio` VALUES (1465, 20, 'SANTA MARIA XADANI', 441);
INSERT INTO `municipio` VALUES (1466, 20, 'SANTA MARIA YALINA', 442);
INSERT INTO `municipio` VALUES (1467, 20, 'SANTA MARIA YAVESIA', 443);
INSERT INTO `municipio` VALUES (1468, 20, 'SANTA MARIA YOLOTEPEC', 444);
INSERT INTO `municipio` VALUES (1469, 20, 'SANTA MARIA YOSOYUA', 445);
INSERT INTO `municipio` VALUES (1470, 20, 'SANTA MARIA YUCUHITI', 446);
INSERT INTO `municipio` VALUES (1471, 20, 'SANTA MARIA ZACATEPEC', 447);
INSERT INTO `municipio` VALUES (1472, 20, 'SANTA MARIA ZANIZA', 448);
INSERT INTO `municipio` VALUES (1473, 20, 'SANTA MARIA ZOQUITLAN', 449);
INSERT INTO `municipio` VALUES (1474, 20, 'SANTIAGO AMOLTEPEC', 450);
INSERT INTO `municipio` VALUES (1475, 20, 'SANTIAGO APOALA', 451);
INSERT INTO `municipio` VALUES (1476, 20, 'SANTIAGO APOSTOL', 452);
INSERT INTO `municipio` VALUES (1477, 20, 'SANTIAGO ASTATA', 453);
INSERT INTO `municipio` VALUES (1478, 20, 'SANTIAGO ATITLAN', 454);
INSERT INTO `municipio` VALUES (1479, 20, 'SANTIAGO AYUQUILILLA', 455);
INSERT INTO `municipio` VALUES (1480, 20, 'SANTIAGO CACALOXTEPEC', 456);
INSERT INTO `municipio` VALUES (1481, 20, 'SANTIAGO CAMOTLAN', 457);
INSERT INTO `municipio` VALUES (1482, 20, 'SANTIAGO COMALTEPEC', 458);
INSERT INTO `municipio` VALUES (1483, 20, 'VILLA DE SANTIAGO CHAZUMBA', 459);
INSERT INTO `municipio` VALUES (1484, 20, 'SANTIAGO CHOAPAM', 460);
INSERT INTO `municipio` VALUES (1485, 20, 'SANTIAGO DEL RIO', 461);
INSERT INTO `municipio` VALUES (1486, 20, 'SANTIAGO HUAJOLOTITLAN', 462);
INSERT INTO `municipio` VALUES (1487, 20, 'SANTIAGO HUAUCLILLA', 463);
INSERT INTO `municipio` VALUES (1488, 20, 'SANTIAGO IHUITLAN PLUMAS', 464);
INSERT INTO `municipio` VALUES (1489, 20, 'SANTIAGO IXCUINTEPEC', 465);
INSERT INTO `municipio` VALUES (1490, 20, 'SANTIAGO IXTAYUTLA', 466);
INSERT INTO `municipio` VALUES (1491, 20, 'SANTIAGO JAMILTEPEC', 467);
INSERT INTO `municipio` VALUES (1492, 20, 'SANTIAGO JOCOTEPEC', 468);
INSERT INTO `municipio` VALUES (1493, 20, 'SANTIAGO JUXTLAHUACA', 469);
INSERT INTO `municipio` VALUES (1494, 20, 'SANTIAGO LACHIGUIRI', 470);
INSERT INTO `municipio` VALUES (1495, 20, 'SANTIAGO LALOPA', 471);
INSERT INTO `municipio` VALUES (1496, 20, 'SANTIAGO LAOLLAGA', 472);
INSERT INTO `municipio` VALUES (1497, 20, 'SANTIAGO LAXOPA', 473);
INSERT INTO `municipio` VALUES (1498, 20, 'SANTIAGO LLANO GRANDE', 474);
INSERT INTO `municipio` VALUES (1499, 20, 'SANTIAGO MATATLAN', 475);
INSERT INTO `municipio` VALUES (1500, 20, 'SANTIAGO MILTEPEC', 476);
INSERT INTO `municipio` VALUES (1501, 20, 'SANTIAGO MINAS', 477);
INSERT INTO `municipio` VALUES (1502, 20, 'SANTIAGO NACALTEPEC', 478);
INSERT INTO `municipio` VALUES (1503, 20, 'SANTIAGO NEJAPILLA', 479);
INSERT INTO `municipio` VALUES (1504, 20, 'SANTIAGO NUNDICHE', 480);
INSERT INTO `municipio` VALUES (1505, 20, 'SANTIAGO NUYOO', 481);
INSERT INTO `municipio` VALUES (1506, 20, 'SANTIAGO PINOTEPA NACIONAL', 482);
INSERT INTO `municipio` VALUES (1507, 20, 'SANTIAGO SUCHILQUITONGO', 483);
INSERT INTO `municipio` VALUES (1508, 20, 'SANTIAGO TAMAZOLA', 484);
INSERT INTO `municipio` VALUES (1509, 20, 'SANTIAGO TAPEXTLA', 485);
INSERT INTO `municipio` VALUES (1510, 20, 'VILLA TEJUPAM DE LA UNION', 486);
INSERT INTO `municipio` VALUES (1511, 20, 'SANTIAGO TENANGO', 487);
INSERT INTO `municipio` VALUES (1512, 20, 'SANTIAGO TEPETLAPA', 488);
INSERT INTO `municipio` VALUES (1513, 20, 'SANTIAGO TETEPEC', 489);
INSERT INTO `municipio` VALUES (1514, 20, 'SANTIAGO TEXCALCINGO', 490);
INSERT INTO `municipio` VALUES (1515, 20, 'SANTIAGO TEXTITLAN', 491);
INSERT INTO `municipio` VALUES (1516, 20, 'SANTIAGO TILANTONGO', 492);
INSERT INTO `municipio` VALUES (1517, 20, 'SANTIAGO TILLO', 493);
INSERT INTO `municipio` VALUES (1518, 20, 'SANTIAGO TLAZOYALTEPEC', 494);
INSERT INTO `municipio` VALUES (1519, 20, 'SANTIAGO XANICA', 495);
INSERT INTO `municipio` VALUES (1520, 20, 'SANTIAGO XIACUI', 496);
INSERT INTO `municipio` VALUES (1521, 20, 'SANTIAGO YAITEPEC', 497);
INSERT INTO `municipio` VALUES (1522, 20, 'SANTIAGO YAVEO', 498);
INSERT INTO `municipio` VALUES (1523, 20, 'SANTIAGO YOLOMECATL', 499);
INSERT INTO `municipio` VALUES (1524, 20, 'SANTIAGO YOSONDUA', 500);
INSERT INTO `municipio` VALUES (1525, 20, 'SANTIAGO YUCUYACHI', 501);
INSERT INTO `municipio` VALUES (1526, 20, 'SANTIAGO ZACATEPEC', 502);
INSERT INTO `municipio` VALUES (1527, 20, 'SANTIAGO ZOOCHILA', 503);
INSERT INTO `municipio` VALUES (1528, 20, 'NUEVO ZOQUIAPAM', 504);
INSERT INTO `municipio` VALUES (1529, 20, 'SANTO DOMINGO INGENIO', 505);
INSERT INTO `municipio` VALUES (1530, 20, 'SANTO DOMINGO ALBARRADAS', 506);
INSERT INTO `municipio` VALUES (1531, 20, 'SANTO DOMINGO ARMENTA', 507);
INSERT INTO `municipio` VALUES (1532, 20, 'SANTO DOMINGO CHIHUITAN', 508);
INSERT INTO `municipio` VALUES (1533, 20, 'SANTO DOMINGO DE MORELOS', 509);
INSERT INTO `municipio` VALUES (1534, 20, 'SANTO DOMINGO IXCATLAN', 510);
INSERT INTO `municipio` VALUES (1535, 20, 'SANTO DOMINGO NUXAA', 511);
INSERT INTO `municipio` VALUES (1536, 20, 'SANTO DOMINGO OZOLOTEPEC', 512);
INSERT INTO `municipio` VALUES (1537, 20, 'SANTO DOMINGO PETAPA', 513);
INSERT INTO `municipio` VALUES (1538, 20, 'SANTO DOMINGO ROAYAGA', 514);
INSERT INTO `municipio` VALUES (1539, 20, 'SANTO DOMINGO TEHUANTEPEC', 515);
INSERT INTO `municipio` VALUES (1540, 20, 'SANTO DOMINGO TEOJOMULCO', 516);
INSERT INTO `municipio` VALUES (1541, 20, 'SANTO DOMINGO TEPUXTEPEC', 517);
INSERT INTO `municipio` VALUES (1542, 20, 'SANTO DOMINGO TLATAYAPAM', 518);
INSERT INTO `municipio` VALUES (1543, 20, 'SANTO DOMINGO TOMALTEPEC', 519);
INSERT INTO `municipio` VALUES (1544, 20, 'SANTO DOMINGO TONALA', 520);
INSERT INTO `municipio` VALUES (1545, 20, 'SANTO DOMINGO TONALTEPEC', 521);
INSERT INTO `municipio` VALUES (1546, 20, 'SANTO DOMINGO XAGACIA', 522);
INSERT INTO `municipio` VALUES (1547, 20, 'SANTO DOMINGO YANHUITLAN', 523);
INSERT INTO `municipio` VALUES (1548, 20, 'SANTO DOMINGO YODOHINO', 524);
INSERT INTO `municipio` VALUES (1549, 20, 'SANTO DOMINGO ZANATEPEC', 525);
INSERT INTO `municipio` VALUES (1550, 20, 'SANTOS REYES NOPALA', 526);
INSERT INTO `municipio` VALUES (1551, 20, 'SANTOS REYES PAPALO', 527);
INSERT INTO `municipio` VALUES (1552, 20, 'SANTOS REYES TEPEJILLO', 528);
INSERT INTO `municipio` VALUES (1553, 20, 'SANTOS REYES YUCUNA', 529);
INSERT INTO `municipio` VALUES (1554, 20, 'SANTO TOMAS JALIEZA', 530);
INSERT INTO `municipio` VALUES (1555, 20, 'SANTO TOMAS MAZALTEPEC', 531);
INSERT INTO `municipio` VALUES (1556, 20, 'SANTO TOMAS OCOTEPEC', 532);
INSERT INTO `municipio` VALUES (1557, 20, 'SANTO TOMAS TAMAZULAPAN', 533);
INSERT INTO `municipio` VALUES (1558, 20, 'SAN VICENTE COATLAN', 534);
INSERT INTO `municipio` VALUES (1559, 20, 'SAN VICENTE LACHIXIO', 535);
INSERT INTO `municipio` VALUES (1560, 20, 'SAN VICENTE NUNU', 536);
INSERT INTO `municipio` VALUES (1561, 20, 'SILACAYOAPAM', 537);
INSERT INTO `municipio` VALUES (1562, 20, 'SITIO DE XITLAPEHUA', 538);
INSERT INTO `municipio` VALUES (1563, 20, 'SOLEDAD ETLA', 539);
INSERT INTO `municipio` VALUES (1564, 20, 'VILLA DE TAMAZULAPAM DEL PROGRESO', 540);
INSERT INTO `municipio` VALUES (1565, 20, 'TANETZE DE ZARAGOZA', 541);
INSERT INTO `municipio` VALUES (1566, 20, 'TANICHE', 542);
INSERT INTO `municipio` VALUES (1567, 20, 'TATALTEPEC DE VALDES', 543);
INSERT INTO `municipio` VALUES (1568, 20, 'TEOCOCUILCO DE MARCOS PEREZ', 544);
INSERT INTO `municipio` VALUES (1569, 20, 'TEOTITLAN DE FLORES MAGON', 545);
INSERT INTO `municipio` VALUES (1570, 20, 'TEOTITLAN DEL VALLE', 546);
INSERT INTO `municipio` VALUES (1571, 20, 'TEOTONGO', 547);
INSERT INTO `municipio` VALUES (1572, 20, 'TEPELMEME VILLA DE MORELOS', 548);
INSERT INTO `municipio` VALUES (1573, 20, 'HEROICA VILLA TEZOATLAN', 549);
INSERT INTO `municipio` VALUES (1574, 20, 'SAN JERONIMO TLACOCHAHUAYA', 550);
INSERT INTO `municipio` VALUES (1575, 20, 'TLACOLULA DE MATAMOROS', 551);
INSERT INTO `municipio` VALUES (1576, 20, 'TLACOTEPEC PLUMAS', 552);
INSERT INTO `municipio` VALUES (1577, 20, 'TLALIXTAC DE CABRERA', 553);
INSERT INTO `municipio` VALUES (1578, 20, 'TOTONTEPEC VILLA DE MORELOS', 554);
INSERT INTO `municipio` VALUES (1579, 20, 'TRINIDAD ZAACHILA', 555);
INSERT INTO `municipio` VALUES (1580, 20, 'LA TRINIDAD VISTA HERMOSA', 556);
INSERT INTO `municipio` VALUES (1581, 20, 'UNION HIDALGO', 557);
INSERT INTO `municipio` VALUES (1582, 20, 'VALERIO TRUJANO', 558);
INSERT INTO `municipio` VALUES (1583, 20, 'SAN JUAN BAUTISTA VALLE NACIONAL', 559);
INSERT INTO `municipio` VALUES (1584, 20, 'VILLA DIAZ ORDAZ', 560);
INSERT INTO `municipio` VALUES (1585, 20, 'YAXE', 561);
INSERT INTO `municipio` VALUES (1586, 20, 'MAGDALENA YODOCONO DE PORFIRIO DIAZ', 562);
INSERT INTO `municipio` VALUES (1587, 20, 'YOGANA', 563);
INSERT INTO `municipio` VALUES (1588, 20, 'YUTANDUCHI DE GUERRERO', 564);
INSERT INTO `municipio` VALUES (1589, 20, 'VILLA DE ZAACHILA', 565);
INSERT INTO `municipio` VALUES (1590, 20, 'SAN MATEO YUCUTINDOO', 566);
INSERT INTO `municipio` VALUES (1591, 20, 'ZAPOTITLAN LAGUNAS', 567);
INSERT INTO `municipio` VALUES (1592, 20, 'ZAPOTITLAN PALMAS', 568);
INSERT INTO `municipio` VALUES (1593, 20, 'SANTA INES DE ZARAGOZA', 569);
INSERT INTO `municipio` VALUES (1594, 20, 'ZIMATLAN DE ALVAREZ', 570);
INSERT INTO `municipio` VALUES (1596, 21, 'ACAJETE', 1);
INSERT INTO `municipio` VALUES (1597, 21, 'ACATENO', 2);
INSERT INTO `municipio` VALUES (1598, 21, 'ACATLAN', 3);
INSERT INTO `municipio` VALUES (1599, 21, 'ACATZINGO', 4);
INSERT INTO `municipio` VALUES (1600, 21, 'ACTEOPAN', 5);
INSERT INTO `municipio` VALUES (1601, 21, 'AHUACATLAN', 6);
INSERT INTO `municipio` VALUES (1602, 21, 'AHUATLAN', 7);
INSERT INTO `municipio` VALUES (1603, 21, 'AHUAZOTEPEC', 8);
INSERT INTO `municipio` VALUES (1604, 21, 'AHUEHUETITLA', 9);
INSERT INTO `municipio` VALUES (1605, 21, 'AJALPAN', 10);
INSERT INTO `municipio` VALUES (1606, 21, 'ALBINO ZERTUCHE', 11);
INSERT INTO `municipio` VALUES (1607, 21, 'ALJOJUCA', 12);
INSERT INTO `municipio` VALUES (1608, 21, 'ALTEPEXI', 13);
INSERT INTO `municipio` VALUES (1609, 21, 'AMIXTLAN', 14);
INSERT INTO `municipio` VALUES (1610, 21, 'AMOZOC', 15);
INSERT INTO `municipio` VALUES (1611, 21, 'AQUIXTLA', 16);
INSERT INTO `municipio` VALUES (1612, 21, 'ATEMPAN', 17);
INSERT INTO `municipio` VALUES (1613, 21, 'ATEXCAL', 18);
INSERT INTO `municipio` VALUES (1614, 21, 'ATLIXCO', 19);
INSERT INTO `municipio` VALUES (1615, 21, 'ATOYATEMPAN', 20);
INSERT INTO `municipio` VALUES (1616, 21, 'ATZALA', 21);
INSERT INTO `municipio` VALUES (1617, 21, 'ATZITZIHUACAN', 22);
INSERT INTO `municipio` VALUES (1618, 21, 'ATZITZINTLA', 23);
INSERT INTO `municipio` VALUES (1619, 21, 'AXUTLA', 24);
INSERT INTO `municipio` VALUES (1620, 21, 'AYOTOXCO DE GUERRERO', 25);
INSERT INTO `municipio` VALUES (1621, 21, 'CALPAN', 26);
INSERT INTO `municipio` VALUES (1622, 21, 'CALTEPEC', 27);
INSERT INTO `municipio` VALUES (1623, 21, 'CAMOCUAUTLA', 28);
INSERT INTO `municipio` VALUES (1624, 21, 'CAXHUACAN', 29);
INSERT INTO `municipio` VALUES (1625, 21, 'COATEPEC', 30);
INSERT INTO `municipio` VALUES (1626, 21, 'COATZINGO', 31);
INSERT INTO `municipio` VALUES (1627, 21, 'COHETZALA', 32);
INSERT INTO `municipio` VALUES (1628, 21, 'COHUECAN', 33);
INSERT INTO `municipio` VALUES (1629, 21, 'CORONANGO', 34);
INSERT INTO `municipio` VALUES (1630, 21, 'COXCATLAN', 35);
INSERT INTO `municipio` VALUES (1631, 21, 'COYOMEAPAN', 36);
INSERT INTO `municipio` VALUES (1632, 21, 'COYOTEPEC', 37);
INSERT INTO `municipio` VALUES (1633, 21, 'CUAPIAXTLA DE MADERO', 38);
INSERT INTO `municipio` VALUES (1634, 21, 'CUAUTEMPAN', 39);
INSERT INTO `municipio` VALUES (1635, 21, 'CUAUTINCHAN', 40);
INSERT INTO `municipio` VALUES (1636, 21, 'CUAUTLANCINGO', 41);
INSERT INTO `municipio` VALUES (1637, 21, 'CUAYUCA DE ANDRADE', 42);
INSERT INTO `municipio` VALUES (1638, 21, 'CUETZALAN DEL PROGRESO', 43);
INSERT INTO `municipio` VALUES (1639, 21, 'CUYOACO', 44);
INSERT INTO `municipio` VALUES (1640, 21, 'CHALCHICOMULA DE SESMA', 45);
INSERT INTO `municipio` VALUES (1641, 21, 'CHAPULCO', 46);
INSERT INTO `municipio` VALUES (1642, 21, 'CHIAUTLA', 47);
INSERT INTO `municipio` VALUES (1643, 21, 'CHIAUTZINGO', 48);
INSERT INTO `municipio` VALUES (1644, 21, 'CHICONCUAUTLA', 49);
INSERT INTO `municipio` VALUES (1645, 21, 'CHICHIQUILA', 50);
INSERT INTO `municipio` VALUES (1646, 21, 'CHIETLA', 51);
INSERT INTO `municipio` VALUES (1647, 21, 'CHIGMECATITLAN', 52);
INSERT INTO `municipio` VALUES (1648, 21, 'CHIGNAHUAPAN', 53);
INSERT INTO `municipio` VALUES (1649, 21, 'CHIGNAUTLA', 54);
INSERT INTO `municipio` VALUES (1650, 21, 'CHILA', 55);
INSERT INTO `municipio` VALUES (1651, 21, 'CHILA DE LA SAL', 56);
INSERT INTO `municipio` VALUES (1652, 21, 'HONEY', 57);
INSERT INTO `municipio` VALUES (1653, 21, 'CHILCHOTLA', 58);
INSERT INTO `municipio` VALUES (1654, 21, 'CHINANTLA', 59);
INSERT INTO `municipio` VALUES (1655, 21, 'DOMINGO ARENAS', 60);
INSERT INTO `municipio` VALUES (1656, 21, 'ELOXOCHITLAN', 61);
INSERT INTO `municipio` VALUES (1657, 21, 'EPATLAN', 62);
INSERT INTO `municipio` VALUES (1658, 21, 'ESPERANZA', 63);
INSERT INTO `municipio` VALUES (1659, 21, 'FRANCISCO Z. MENA', 64);
INSERT INTO `municipio` VALUES (1660, 21, 'GENERAL FELIPE ANGELES', 65);
INSERT INTO `municipio` VALUES (1661, 21, 'GUADALUPE', 66);
INSERT INTO `municipio` VALUES (1662, 21, 'GUADALUPE VICTORIA', 67);
INSERT INTO `municipio` VALUES (1663, 21, 'HERMENEGILDO GALEANA', 68);
INSERT INTO `municipio` VALUES (1664, 21, 'HUAQUECHULA', 69);
INSERT INTO `municipio` VALUES (1665, 21, 'HUATLATLAUCA', 70);
INSERT INTO `municipio` VALUES (1666, 21, 'HUAUCHINANGO', 71);
INSERT INTO `municipio` VALUES (1667, 21, 'HUEHUETLA', 72);
INSERT INTO `municipio` VALUES (1668, 21, 'HUEHUETLAN EL CHICO', 73);
INSERT INTO `municipio` VALUES (1669, 21, 'HUEJOTZINGO', 74);
INSERT INTO `municipio` VALUES (1670, 21, 'HUEYAPAN', 75);
INSERT INTO `municipio` VALUES (1671, 21, 'HUEYTAMALCO', 76);
INSERT INTO `municipio` VALUES (1672, 21, 'HUEYTLALPAN', 77);
INSERT INTO `municipio` VALUES (1673, 21, 'HUITZILAN DE SERDAN', 78);
INSERT INTO `municipio` VALUES (1674, 21, 'HUITZILTEPEC', 79);
INSERT INTO `municipio` VALUES (1675, 21, 'ATLEQUIZAYAN', 80);
INSERT INTO `municipio` VALUES (1676, 21, 'IXCAMILPA DE GUERRERO', 81);
INSERT INTO `municipio` VALUES (1677, 21, 'IXCAQUIXTLA', 82);
INSERT INTO `municipio` VALUES (1678, 21, 'IXTACAMAXTITLAN', 83);
INSERT INTO `municipio` VALUES (1679, 21, 'IXTEPEC', 84);
INSERT INTO `municipio` VALUES (1680, 21, 'IZUCAR DE MATAMOROS', 85);
INSERT INTO `municipio` VALUES (1681, 21, 'JALPAN', 86);
INSERT INTO `municipio` VALUES (1682, 21, 'JOLALPAN', 87);
INSERT INTO `municipio` VALUES (1683, 21, 'JONOTLA', 88);
INSERT INTO `municipio` VALUES (1684, 21, 'JOPALA', 89);
INSERT INTO `municipio` VALUES (1685, 21, 'JUAN C. BONILLA', 90);
INSERT INTO `municipio` VALUES (1686, 21, 'JUAN GALINDO', 91);
INSERT INTO `municipio` VALUES (1687, 21, 'JUAN N. MENDEZ', 92);
INSERT INTO `municipio` VALUES (1688, 21, 'LAFRAGUA', 93);
INSERT INTO `municipio` VALUES (1689, 21, 'LIBRES', 94);
INSERT INTO `municipio` VALUES (1690, 21, 'LA MAGDALENA TLATLAUQUITEPEC', 95);
INSERT INTO `municipio` VALUES (1691, 21, 'MAZAPILTEPEC DE JUAREZ', 96);
INSERT INTO `municipio` VALUES (1692, 21, 'MIXTLA', 97);
INSERT INTO `municipio` VALUES (1693, 21, 'MOLCAXAC', 98);
INSERT INTO `municipio` VALUES (1694, 21, 'CANADA MORELOS', 99);
INSERT INTO `municipio` VALUES (1695, 21, 'NAUPAN', 100);
INSERT INTO `municipio` VALUES (1696, 21, 'NAUZONTLA', 101);
INSERT INTO `municipio` VALUES (1697, 21, 'NEALTICAN', 102);
INSERT INTO `municipio` VALUES (1698, 21, 'NICOLAS BRAVO', 103);
INSERT INTO `municipio` VALUES (1699, 21, 'NOPALUCAN', 104);
INSERT INTO `municipio` VALUES (1700, 21, 'OCOTEPEC', 105);
INSERT INTO `municipio` VALUES (1701, 21, 'OCOYUCAN', 106);
INSERT INTO `municipio` VALUES (1702, 21, 'OLINTLA', 107);
INSERT INTO `municipio` VALUES (1703, 21, 'ORIENTAL', 108);
INSERT INTO `municipio` VALUES (1704, 21, 'PAHUATLAN', 109);
INSERT INTO `municipio` VALUES (1705, 21, 'PALMAR DE BRAVO', 110);
INSERT INTO `municipio` VALUES (1706, 21, 'PANTEPEC', 111);
INSERT INTO `municipio` VALUES (1707, 21, 'PETLALCINGO', 112);
INSERT INTO `municipio` VALUES (1708, 21, 'PIAXTLA', 113);
INSERT INTO `municipio` VALUES (1709, 21, 'PUEBLA', 114);
INSERT INTO `municipio` VALUES (1710, 21, 'QUECHOLAC', 115);
INSERT INTO `municipio` VALUES (1711, 21, 'QUIMIXTLAN', 116);
INSERT INTO `municipio` VALUES (1712, 21, 'RAFAEL LARA GRAJALES', 117);
INSERT INTO `municipio` VALUES (1713, 21, 'LOS REYES DE JUAREZ', 118);
INSERT INTO `municipio` VALUES (1714, 21, 'SAN ANDRES CHOLULA', 119);
INSERT INTO `municipio` VALUES (1715, 21, 'SAN ANTONIO CANADA', 120);
INSERT INTO `municipio` VALUES (1716, 21, 'SAN DIEGO LA MESA TOCHIMILTZINGO', 121);
INSERT INTO `municipio` VALUES (1717, 21, 'SAN FELIPE TEOTLALCINGO', 122);
INSERT INTO `municipio` VALUES (1718, 21, 'SAN FELIPE TEPATLAN', 123);
INSERT INTO `municipio` VALUES (1719, 21, 'SAN GABRIEL CHILAC', 124);
INSERT INTO `municipio` VALUES (1720, 21, 'SAN GREGORIO ATZOMPA', 125);
INSERT INTO `municipio` VALUES (1721, 21, 'SAN JERONIMO TECUANIPAN', 126);
INSERT INTO `municipio` VALUES (1722, 21, 'SAN JERONIMO XAYACATLAN', 127);
INSERT INTO `municipio` VALUES (1723, 21, 'SAN JOSE CHIAPA', 128);
INSERT INTO `municipio` VALUES (1724, 21, 'SAN JOSE MIAHUATLAN', 129);
INSERT INTO `municipio` VALUES (1725, 21, 'SAN JUAN ATENCO', 130);
INSERT INTO `municipio` VALUES (1726, 21, 'SAN JUAN ATZOMPA', 131);
INSERT INTO `municipio` VALUES (1727, 21, 'SAN MARTIN TEXMELUCAN', 132);
INSERT INTO `municipio` VALUES (1728, 21, 'SAN MARTIN TOTOLTEPEC', 133);
INSERT INTO `municipio` VALUES (1729, 21, 'SAN MATIAS TLALANCALECA', 134);
INSERT INTO `municipio` VALUES (1730, 21, 'SAN MIGUEL IXITLAN', 135);
INSERT INTO `municipio` VALUES (1731, 21, 'SAN MIGUEL XOXTLA', 136);
INSERT INTO `municipio` VALUES (1732, 21, 'SAN NICOLAS BUENOS AIRES', 137);
INSERT INTO `municipio` VALUES (1733, 21, 'SAN NICOLAS DE LOS RANCHOS', 138);
INSERT INTO `municipio` VALUES (1734, 21, 'SAN PABLO ANICANO', 139);
INSERT INTO `municipio` VALUES (1735, 21, 'SAN PEDRO CHOLULA', 140);
INSERT INTO `municipio` VALUES (1736, 21, 'SAN PEDRO YELOIXTLAHUACA', 141);
INSERT INTO `municipio` VALUES (1737, 21, 'SAN SALVADOR EL SECO', 142);
INSERT INTO `municipio` VALUES (1738, 21, 'SAN SALVADOR EL VERDE', 143);
INSERT INTO `municipio` VALUES (1739, 21, 'SAN SALVADOR HUIXCOLOTLA', 144);
INSERT INTO `municipio` VALUES (1740, 21, 'SAN SEBASTIAN TLACOTEPEC', 145);
INSERT INTO `municipio` VALUES (1741, 21, 'SANTA CATARINA TLALTEMPAN', 146);
INSERT INTO `municipio` VALUES (1742, 21, 'SANTA INES AHUATEMPAN', 147);
INSERT INTO `municipio` VALUES (1743, 21, 'SANTA ISABEL CHOLULA', 148);
INSERT INTO `municipio` VALUES (1744, 21, 'SANTIAGO MIAHUATLAN', 149);
INSERT INTO `municipio` VALUES (1745, 21, 'HUEHUETLAN EL GRANDE', 150);
INSERT INTO `municipio` VALUES (1746, 21, 'SANTO TOMAS HUEYOTLIPAN', 151);
INSERT INTO `municipio` VALUES (1747, 21, 'SOLTEPEC', 152);
INSERT INTO `municipio` VALUES (1748, 21, 'TECALI DE HERRERA', 153);
INSERT INTO `municipio` VALUES (1749, 21, 'TECAMACHALCO', 154);
INSERT INTO `municipio` VALUES (1750, 21, 'TECOMATLAN', 155);
INSERT INTO `municipio` VALUES (1751, 21, 'TEHUACAN', 156);
INSERT INTO `municipio` VALUES (1752, 21, 'TEHUITZINGO', 157);
INSERT INTO `municipio` VALUES (1753, 21, 'TENAMPULCO', 158);
INSERT INTO `municipio` VALUES (1754, 21, 'TEOPANTLAN', 159);
INSERT INTO `municipio` VALUES (1755, 21, 'TEOTLALCO', 160);
INSERT INTO `municipio` VALUES (1756, 21, 'TEPANCO DE LOPEZ', 161);
INSERT INTO `municipio` VALUES (1757, 21, 'TEPANGO DE RODRIGUEZ', 162);
INSERT INTO `municipio` VALUES (1758, 21, 'TEPATLAXCO DE HIDALGO', 163);
INSERT INTO `municipio` VALUES (1759, 21, 'TEPEACA', 164);
INSERT INTO `municipio` VALUES (1760, 21, 'TEPEMAXALCO', 165);
INSERT INTO `municipio` VALUES (1761, 21, 'TEPEOJUMA', 166);
INSERT INTO `municipio` VALUES (1762, 21, 'TEPETZINTLA', 167);
INSERT INTO `municipio` VALUES (1763, 21, 'TEPEXCO', 168);
INSERT INTO `municipio` VALUES (1764, 21, 'TEPEXI DE RODRIGUEZ', 169);
INSERT INTO `municipio` VALUES (1765, 21, 'TEPEYAHUALCO', 170);
INSERT INTO `municipio` VALUES (1766, 21, 'TEPEYAHUALCO DE CUAUHTEMOC', 171);
INSERT INTO `municipio` VALUES (1767, 21, 'TETELA DE OCAMPO', 172);
INSERT INTO `municipio` VALUES (1768, 21, 'TETELES DE AVILA CASTILLO', 173);
INSERT INTO `municipio` VALUES (1769, 21, 'TEZIUTLAN', 174);
INSERT INTO `municipio` VALUES (1770, 21, 'TIANGUISMANALCO', 175);
INSERT INTO `municipio` VALUES (1771, 21, 'TILAPA', 176);
INSERT INTO `municipio` VALUES (1772, 21, 'TLACOTEPEC DE BENITO JUAREZ', 177);
INSERT INTO `municipio` VALUES (1773, 21, 'TLACUILOTEPEC', 178);
INSERT INTO `municipio` VALUES (1774, 21, 'TLACHICHUCA', 179);
INSERT INTO `municipio` VALUES (1775, 21, 'TLAHUAPAN', 180);
INSERT INTO `municipio` VALUES (1776, 21, 'TLALTENANGO', 181);
INSERT INTO `municipio` VALUES (1777, 21, 'TLANEPANTLA', 182);
INSERT INTO `municipio` VALUES (1778, 21, 'TLAOLA', 183);
INSERT INTO `municipio` VALUES (1779, 21, 'TLAPACOYA', 184);
INSERT INTO `municipio` VALUES (1780, 21, 'TLAPANALA', 185);
INSERT INTO `municipio` VALUES (1781, 21, 'TLATLAUQUITEPEC', 186);
INSERT INTO `municipio` VALUES (1782, 21, 'TLAXCO', 187);
INSERT INTO `municipio` VALUES (1783, 21, 'TOCHIMILCO', 188);
INSERT INTO `municipio` VALUES (1784, 21, 'TOCHTEPEC', 189);
INSERT INTO `municipio` VALUES (1785, 21, 'TOTOLTEPEC DE GUERRERO', 190);
INSERT INTO `municipio` VALUES (1786, 21, 'TULCINGO', 191);
INSERT INTO `municipio` VALUES (1787, 21, 'TUZAMAPAN DE GALEANA', 192);
INSERT INTO `municipio` VALUES (1788, 21, 'TZICATLACOYAN', 193);
INSERT INTO `municipio` VALUES (1789, 21, 'VENUSTIANO CARRANZA', 194);
INSERT INTO `municipio` VALUES (1790, 21, 'VICENTE GUERRERO', 195);
INSERT INTO `municipio` VALUES (1791, 21, 'XAYACATLAN DE BRAVO', 196);
INSERT INTO `municipio` VALUES (1792, 21, 'XICOTEPEC', 197);
INSERT INTO `municipio` VALUES (1793, 21, 'XICOTLAN', 198);
INSERT INTO `municipio` VALUES (1794, 21, 'XIUTETELCO', 199);
INSERT INTO `municipio` VALUES (1795, 21, 'XOCHIAPULCO', 200);
INSERT INTO `municipio` VALUES (1796, 21, 'XOCHILTEPEC', 201);
INSERT INTO `municipio` VALUES (1797, 21, 'XOCHITLAN DE VICENTE SUAREZ', 202);
INSERT INTO `municipio` VALUES (1798, 21, 'XOCHITLAN TODOS SANTOS', 203);
INSERT INTO `municipio` VALUES (1799, 21, 'YAONAHUAC', 204);
INSERT INTO `municipio` VALUES (1800, 21, 'YEHUALTEPEC', 205);
INSERT INTO `municipio` VALUES (1801, 21, 'ZACAPALA', 206);
INSERT INTO `municipio` VALUES (1802, 21, 'ZACAPOAXTLA', 207);
INSERT INTO `municipio` VALUES (1803, 21, 'ZACATLAN', 208);
INSERT INTO `municipio` VALUES (1804, 21, 'ZAPOTITLAN', 209);
INSERT INTO `municipio` VALUES (1805, 21, 'ZAPOTITLAN DE MENDEZ', 210);
INSERT INTO `municipio` VALUES (1806, 21, 'ZARAGOZA', 211);
INSERT INTO `municipio` VALUES (1807, 21, 'ZAUTLA', 212);
INSERT INTO `municipio` VALUES (1808, 21, 'ZIHUATEUTLA', 213);
INSERT INTO `municipio` VALUES (1809, 21, 'ZINACATEPEC', 214);
INSERT INTO `municipio` VALUES (1810, 21, 'ZONGOZOTLA', 215);
INSERT INTO `municipio` VALUES (1811, 21, 'ZOQUIAPAN', 216);
INSERT INTO `municipio` VALUES (1812, 21, 'ZOQUITLAN', 217);
INSERT INTO `municipio` VALUES (1814, 22, 'AMEALCO DE BONFIL', 1);
INSERT INTO `municipio` VALUES (1815, 22, 'PINAL DE AMOLES', 2);
INSERT INTO `municipio` VALUES (1816, 22, 'ARROYO SECO', 3);
INSERT INTO `municipio` VALUES (1817, 22, 'CADEREYTA DE MONTES', 4);
INSERT INTO `municipio` VALUES (1818, 22, 'COLON', 5);
INSERT INTO `municipio` VALUES (1819, 22, 'CORREGIDORA', 6);
INSERT INTO `municipio` VALUES (1820, 22, 'EZEQUIEL MONTES', 7);
INSERT INTO `municipio` VALUES (1821, 22, 'HUIMILPAN', 8);
INSERT INTO `municipio` VALUES (1822, 22, 'JALPAN DE SERRA', 9);
INSERT INTO `municipio` VALUES (1823, 22, 'LANDA DE MATAMOROS', 10);
INSERT INTO `municipio` VALUES (1824, 22, 'EL MARQUES', 11);
INSERT INTO `municipio` VALUES (1825, 22, 'PEDRO ESCOBEDO', 12);
INSERT INTO `municipio` VALUES (1826, 22, 'PENAMILLER', 13);
INSERT INTO `municipio` VALUES (1827, 22, 'QUERETARO', 14);
INSERT INTO `municipio` VALUES (1828, 22, 'SAN JOAQUIN', 15);
INSERT INTO `municipio` VALUES (1829, 22, 'SAN JUAN DEL RIO', 16);
INSERT INTO `municipio` VALUES (1830, 22, 'TEQUISQUIAPAN', 17);
INSERT INTO `municipio` VALUES (1831, 22, 'TOLIMAN', 18);
INSERT INTO `municipio` VALUES (1833, 23, 'COZUMEL', 1);
INSERT INTO `municipio` VALUES (1834, 23, 'FELIPE CARRILLO PUERTO', 2);
INSERT INTO `municipio` VALUES (1835, 23, 'ISLA MUJERES', 3);
INSERT INTO `municipio` VALUES (1836, 23, 'OTHON P. BLANCO', 4);
INSERT INTO `municipio` VALUES (1837, 23, 'BENITO JUAREZ', 5);
INSERT INTO `municipio` VALUES (1838, 23, 'JOSE MARIA MORELOS', 6);
INSERT INTO `municipio` VALUES (1839, 23, 'LAZARO CARDENAS', 7);
INSERT INTO `municipio` VALUES (1840, 23, 'SOLIDARIDAD', 8);
INSERT INTO `municipio` VALUES (1841, 23, 'TULUM', 9);
INSERT INTO `municipio` VALUES (1842, 23, 'BACALAR', 10);
INSERT INTO `municipio` VALUES (1843, 23, 'PUERTO MORELOS', 11);
INSERT INTO `municipio` VALUES (1845, 24, 'AHUALULCO', 1);
INSERT INTO `municipio` VALUES (1846, 24, 'ALAQUINES', 2);
INSERT INTO `municipio` VALUES (1847, 24, 'AQUISMON', 3);
INSERT INTO `municipio` VALUES (1848, 24, 'ARMADILLO DE LOS INFANTE', 4);
INSERT INTO `municipio` VALUES (1849, 24, 'CARDENAS', 5);
INSERT INTO `municipio` VALUES (1850, 24, 'CATORCE', 6);
INSERT INTO `municipio` VALUES (1851, 24, 'CEDRAL', 7);
INSERT INTO `municipio` VALUES (1852, 24, 'CERRITOS', 8);
INSERT INTO `municipio` VALUES (1853, 24, 'CERRO DE SAN PEDRO', 9);
INSERT INTO `municipio` VALUES (1854, 24, 'CIUDAD DEL MAIZ', 10);
INSERT INTO `municipio` VALUES (1855, 24, 'CIUDAD FERNANDEZ', 11);
INSERT INTO `municipio` VALUES (1856, 24, 'TANCANHUITZ', 12);
INSERT INTO `municipio` VALUES (1857, 24, 'CIUDAD VALLES', 13);
INSERT INTO `municipio` VALUES (1858, 24, 'COXCATLAN', 14);
INSERT INTO `municipio` VALUES (1859, 24, 'CHARCAS', 15);
INSERT INTO `municipio` VALUES (1860, 24, 'EBANO', 16);
INSERT INTO `municipio` VALUES (1861, 24, 'GUADALCAZAR', 17);
INSERT INTO `municipio` VALUES (1862, 24, 'HUEHUETLAN', 18);
INSERT INTO `municipio` VALUES (1863, 24, 'LAGUNILLAS', 19);
INSERT INTO `municipio` VALUES (1864, 24, 'MATEHUALA', 20);
INSERT INTO `municipio` VALUES (1865, 24, 'MEXQUITIC DE CARMONA', 21);
INSERT INTO `municipio` VALUES (1866, 24, 'MOCTEZUMA', 22);
INSERT INTO `municipio` VALUES (1867, 24, 'RAYON', 23);
INSERT INTO `municipio` VALUES (1868, 24, 'RIOVERDE', 24);
INSERT INTO `municipio` VALUES (1869, 24, 'SALINAS', 25);
INSERT INTO `municipio` VALUES (1870, 24, 'SAN ANTONIO', 26);
INSERT INTO `municipio` VALUES (1871, 24, 'SAN CIRO DE ACOSTA', 27);
INSERT INTO `municipio` VALUES (1872, 24, 'SAN LUIS POTOSI', 28);
INSERT INTO `municipio` VALUES (1873, 24, 'SAN MARTIN CHALCHICUAUTLA', 29);
INSERT INTO `municipio` VALUES (1874, 24, 'SAN NICOLAS TOLENTINO', 30);
INSERT INTO `municipio` VALUES (1875, 24, 'SANTA CATARINA', 31);
INSERT INTO `municipio` VALUES (1876, 24, 'SANTA MARIA DEL RIO', 32);
INSERT INTO `municipio` VALUES (1877, 24, 'SANTO DOMINGO', 33);
INSERT INTO `municipio` VALUES (1878, 24, 'SAN VICENTE TANCUAYALAB', 34);
INSERT INTO `municipio` VALUES (1879, 24, 'SOLEDAD DE GRACIANO SANCHEZ', 35);
INSERT INTO `municipio` VALUES (1880, 24, 'TAMASOPO', 36);
INSERT INTO `municipio` VALUES (1881, 24, 'TAMAZUNCHALE', 37);
INSERT INTO `municipio` VALUES (1882, 24, 'TAMPACAN', 38);
INSERT INTO `municipio` VALUES (1883, 24, 'TAMPAMOLON CORONA', 39);
INSERT INTO `municipio` VALUES (1884, 24, 'TAMUIN', 40);
INSERT INTO `municipio` VALUES (1885, 24, 'TANLAJAS', 41);
INSERT INTO `municipio` VALUES (1886, 24, 'TANQUIAN DE ESCOBEDO', 42);
INSERT INTO `municipio` VALUES (1887, 24, 'TIERRA NUEVA', 43);
INSERT INTO `municipio` VALUES (1888, 24, 'VANEGAS', 44);
INSERT INTO `municipio` VALUES (1889, 24, 'VENADO', 45);
INSERT INTO `municipio` VALUES (1890, 24, 'VILLA DE ARRIAGA', 46);
INSERT INTO `municipio` VALUES (1891, 24, 'VILLA DE GUADALUPE', 47);
INSERT INTO `municipio` VALUES (1892, 24, 'VILLA DE LA PAZ', 48);
INSERT INTO `municipio` VALUES (1893, 24, 'VILLA DE RAMOS', 49);
INSERT INTO `municipio` VALUES (1894, 24, 'VILLA DE REYES', 50);
INSERT INTO `municipio` VALUES (1895, 24, 'VILLA HIDALGO', 51);
INSERT INTO `municipio` VALUES (1896, 24, 'VILLA JUAREZ', 52);
INSERT INTO `municipio` VALUES (1897, 24, 'AXTLA DE TERRAZAS', 53);
INSERT INTO `municipio` VALUES (1898, 24, 'XILITLA', 54);
INSERT INTO `municipio` VALUES (1899, 24, 'ZARAGOZA', 55);
INSERT INTO `municipio` VALUES (1900, 24, 'VILLA DE ARISTA', 56);
INSERT INTO `municipio` VALUES (1901, 24, 'MATLAPA', 57);
INSERT INTO `municipio` VALUES (1902, 24, 'EL NARANJO', 58);
INSERT INTO `municipio` VALUES (1904, 25, 'AHOME', 1);
INSERT INTO `municipio` VALUES (1905, 25, 'ANGOSTURA', 2);
INSERT INTO `municipio` VALUES (1906, 25, 'BADIRAGUATO', 3);
INSERT INTO `municipio` VALUES (1907, 25, 'CONCORDIA', 4);
INSERT INTO `municipio` VALUES (1908, 25, 'COSALA', 5);
INSERT INTO `municipio` VALUES (1909, 25, 'CULIACAN', 6);
INSERT INTO `municipio` VALUES (1910, 25, 'CHOIX', 7);
INSERT INTO `municipio` VALUES (1911, 25, 'ELOTA', 8);
INSERT INTO `municipio` VALUES (1912, 25, 'ESCUINAPA', 9);
INSERT INTO `municipio` VALUES (1913, 25, 'EL FUERTE', 10);
INSERT INTO `municipio` VALUES (1914, 25, 'GUASAVE', 11);
INSERT INTO `municipio` VALUES (1915, 25, 'MAZATLAN', 12);
INSERT INTO `municipio` VALUES (1916, 25, 'MOCORITO', 13);
INSERT INTO `municipio` VALUES (1917, 25, 'ROSARIO', 14);
INSERT INTO `municipio` VALUES (1918, 25, 'SALVADOR ALVARADO', 15);
INSERT INTO `municipio` VALUES (1919, 25, 'SAN IGNACIO', 16);
INSERT INTO `municipio` VALUES (1920, 25, 'SINALOA', 17);
INSERT INTO `municipio` VALUES (1921, 25, 'NAVOLATO', 18);
INSERT INTO `municipio` VALUES (1923, 26, 'ACONCHI', 1);
INSERT INTO `municipio` VALUES (1924, 26, 'AGUA PRIETA', 2);
INSERT INTO `municipio` VALUES (1925, 26, 'ALAMOS', 3);
INSERT INTO `municipio` VALUES (1926, 26, 'ALTAR', 4);
INSERT INTO `municipio` VALUES (1927, 26, 'ARIVECHI', 5);
INSERT INTO `municipio` VALUES (1928, 26, 'ARIZPE', 6);
INSERT INTO `municipio` VALUES (1929, 26, 'ATIL', 7);
INSERT INTO `municipio` VALUES (1930, 26, 'BACADEHUACHI', 8);
INSERT INTO `municipio` VALUES (1931, 26, 'BACANORA', 9);
INSERT INTO `municipio` VALUES (1932, 26, 'BACERAC', 10);
INSERT INTO `municipio` VALUES (1933, 26, 'BACOACHI', 11);
INSERT INTO `municipio` VALUES (1934, 26, 'BACUM', 12);
INSERT INTO `municipio` VALUES (1935, 26, 'BANAMICHI', 13);
INSERT INTO `municipio` VALUES (1936, 26, 'BAVIACORA', 14);
INSERT INTO `municipio` VALUES (1937, 26, 'BAVISPE', 15);
INSERT INTO `municipio` VALUES (1938, 26, 'BENJAMIN HILL', 16);
INSERT INTO `municipio` VALUES (1939, 26, 'CABORCA', 17);
INSERT INTO `municipio` VALUES (1940, 26, 'CAJEME', 18);
INSERT INTO `municipio` VALUES (1941, 26, 'CANANEA', 19);
INSERT INTO `municipio` VALUES (1942, 26, 'CARBO', 20);
INSERT INTO `municipio` VALUES (1943, 26, 'LA COLORADA', 21);
INSERT INTO `municipio` VALUES (1944, 26, 'CUCURPE', 22);
INSERT INTO `municipio` VALUES (1945, 26, 'CUMPAS', 23);
INSERT INTO `municipio` VALUES (1946, 26, 'DIVISADEROS', 24);
INSERT INTO `municipio` VALUES (1947, 26, 'EMPALME', 25);
INSERT INTO `municipio` VALUES (1948, 26, 'ETCHOJOA', 26);
INSERT INTO `municipio` VALUES (1949, 26, 'FRONTERAS', 27);
INSERT INTO `municipio` VALUES (1950, 26, 'GRANADOS', 28);
INSERT INTO `municipio` VALUES (1951, 26, 'GUAYMAS', 29);
INSERT INTO `municipio` VALUES (1952, 26, 'HERMOSILLO', 30);
INSERT INTO `municipio` VALUES (1953, 26, 'HUACHINERA', 31);
INSERT INTO `municipio` VALUES (1954, 26, 'HUASABAS', 32);
INSERT INTO `municipio` VALUES (1955, 26, 'HUATABAMPO', 33);
INSERT INTO `municipio` VALUES (1956, 26, 'HUEPAC', 34);
INSERT INTO `municipio` VALUES (1957, 26, 'IMURIS', 35);
INSERT INTO `municipio` VALUES (1958, 26, 'MAGDALENA', 36);
INSERT INTO `municipio` VALUES (1959, 26, 'MAZATAN', 37);
INSERT INTO `municipio` VALUES (1960, 26, 'MOCTEZUMA', 38);
INSERT INTO `municipio` VALUES (1961, 26, 'NACO', 39);
INSERT INTO `municipio` VALUES (1962, 26, 'NACORI CHICO', 40);
INSERT INTO `municipio` VALUES (1963, 26, 'NACOZARI DE GARCIA', 41);
INSERT INTO `municipio` VALUES (1964, 26, 'NAVOJOA', 42);
INSERT INTO `municipio` VALUES (1965, 26, 'NOGALES', 43);
INSERT INTO `municipio` VALUES (1966, 26, 'ONAVAS', 44);
INSERT INTO `municipio` VALUES (1967, 26, 'OPODEPE', 45);
INSERT INTO `municipio` VALUES (1968, 26, 'OQUITOA', 46);
INSERT INTO `municipio` VALUES (1969, 26, 'PITIQUITO', 47);
INSERT INTO `municipio` VALUES (1970, 26, 'PUERTO PENASCO', 48);
INSERT INTO `municipio` VALUES (1971, 26, 'QUIRIEGO', 49);
INSERT INTO `municipio` VALUES (1972, 26, 'RAYON', 50);
INSERT INTO `municipio` VALUES (1973, 26, 'ROSARIO', 51);
INSERT INTO `municipio` VALUES (1974, 26, 'SAHUARIPA', 52);
INSERT INTO `municipio` VALUES (1975, 26, 'SAN FELIPE DE JESUS', 53);
INSERT INTO `municipio` VALUES (1976, 26, 'SAN JAVIER', 54);
INSERT INTO `municipio` VALUES (1977, 26, 'SAN LUIS RIO COLORADO', 55);
INSERT INTO `municipio` VALUES (1978, 26, 'SAN MIGUEL DE HORCASITAS', 56);
INSERT INTO `municipio` VALUES (1979, 26, 'SAN PEDRO DE LA CUEVA', 57);
INSERT INTO `municipio` VALUES (1980, 26, 'SANTA ANA', 58);
INSERT INTO `municipio` VALUES (1981, 26, 'SANTA CRUZ', 59);
INSERT INTO `municipio` VALUES (1982, 26, 'SARIC', 60);
INSERT INTO `municipio` VALUES (1983, 26, 'SOYOPA', 61);
INSERT INTO `municipio` VALUES (1984, 26, 'SUAQUI GRANDE', 62);
INSERT INTO `municipio` VALUES (1985, 26, 'TEPACHE', 63);
INSERT INTO `municipio` VALUES (1986, 26, 'TRINCHERAS', 64);
INSERT INTO `municipio` VALUES (1987, 26, 'TUBUTAMA', 65);
INSERT INTO `municipio` VALUES (1988, 26, 'URES', 66);
INSERT INTO `municipio` VALUES (1989, 26, 'VILLA HIDALGO', 67);
INSERT INTO `municipio` VALUES (1990, 26, 'VILLA PESQUEIRA', 68);
INSERT INTO `municipio` VALUES (1991, 26, 'YECORA', 69);
INSERT INTO `municipio` VALUES (1992, 26, 'GENERAL PLUTARCO ELIAS CALLES', 70);
INSERT INTO `municipio` VALUES (1993, 26, 'BENITO JUAREZ', 71);
INSERT INTO `municipio` VALUES (1994, 26, 'SAN IGNACIO RIO MUERTO', 72);
INSERT INTO `municipio` VALUES (1996, 27, 'BALANCAN', 1);
INSERT INTO `municipio` VALUES (1997, 27, 'CARDENAS', 2);
INSERT INTO `municipio` VALUES (1998, 27, 'CENTLA', 3);
INSERT INTO `municipio` VALUES (1999, 27, 'CENTRO', 4);
INSERT INTO `municipio` VALUES (2000, 27, 'COMALCALCO', 5);
INSERT INTO `municipio` VALUES (2001, 27, 'CUNDUACAN', 6);
INSERT INTO `municipio` VALUES (2002, 27, 'EMILIANO ZAPATA', 7);
INSERT INTO `municipio` VALUES (2003, 27, 'HUIMANGUILLO', 8);
INSERT INTO `municipio` VALUES (2004, 27, 'JALAPA', 9);
INSERT INTO `municipio` VALUES (2005, 27, 'JALPA DE MENDEZ', 10);
INSERT INTO `municipio` VALUES (2006, 27, 'JONUTA', 11);
INSERT INTO `municipio` VALUES (2007, 27, 'MACUSPANA', 12);
INSERT INTO `municipio` VALUES (2008, 27, 'NACAJUCA', 13);
INSERT INTO `municipio` VALUES (2009, 27, 'PARAISO', 14);
INSERT INTO `municipio` VALUES (2010, 27, 'TACOTALPA', 15);
INSERT INTO `municipio` VALUES (2011, 27, 'TEAPA', 16);
INSERT INTO `municipio` VALUES (2012, 27, 'TENOSIQUE', 17);
INSERT INTO `municipio` VALUES (2014, 28, 'ABASOLO', 1);
INSERT INTO `municipio` VALUES (2015, 28, 'ALDAMA', 2);
INSERT INTO `municipio` VALUES (2016, 28, 'ALTAMIRA', 3);
INSERT INTO `municipio` VALUES (2017, 28, 'ANTIGUO MORELOS', 4);
INSERT INTO `municipio` VALUES (2018, 28, 'BURGOS', 5);
INSERT INTO `municipio` VALUES (2019, 28, 'BUSTAMANTE', 6);
INSERT INTO `municipio` VALUES (2020, 28, 'CAMARGO', 7);
INSERT INTO `municipio` VALUES (2021, 28, 'CASAS', 8);
INSERT INTO `municipio` VALUES (2022, 28, 'CIUDAD MADERO', 9);
INSERT INTO `municipio` VALUES (2023, 28, 'CRUILLAS', 10);
INSERT INTO `municipio` VALUES (2024, 28, 'GOMEZ FARIAS', 11);
INSERT INTO `municipio` VALUES (2025, 28, 'GONZALEZ', 12);
INSERT INTO `municipio` VALUES (2026, 28, 'GEMEZ', 13);
INSERT INTO `municipio` VALUES (2027, 28, 'GUERRERO', 14);
INSERT INTO `municipio` VALUES (2028, 28, 'GUSTAVO DIAZ ORDAZ', 15);
INSERT INTO `municipio` VALUES (2029, 28, 'HIDALGO', 16);
INSERT INTO `municipio` VALUES (2030, 28, 'JAUMAVE', 17);
INSERT INTO `municipio` VALUES (2031, 28, 'JIMENEZ', 18);
INSERT INTO `municipio` VALUES (2032, 28, 'LLERA', 19);
INSERT INTO `municipio` VALUES (2033, 28, 'MAINERO', 20);
INSERT INTO `municipio` VALUES (2034, 28, 'EL MANTE', 21);
INSERT INTO `municipio` VALUES (2035, 28, 'MATAMOROS', 22);
INSERT INTO `municipio` VALUES (2036, 28, 'MENDEZ', 23);
INSERT INTO `municipio` VALUES (2037, 28, 'MIER', 24);
INSERT INTO `municipio` VALUES (2038, 28, 'MIGUEL ALEMAN', 25);
INSERT INTO `municipio` VALUES (2039, 28, 'MIQUIHUANA', 26);
INSERT INTO `municipio` VALUES (2040, 28, 'NUEVO LAREDO', 27);
INSERT INTO `municipio` VALUES (2041, 28, 'NUEVO MORELOS', 28);
INSERT INTO `municipio` VALUES (2042, 28, 'OCAMPO', 29);
INSERT INTO `municipio` VALUES (2043, 28, 'PADILLA', 30);
INSERT INTO `municipio` VALUES (2044, 28, 'PALMILLAS', 31);
INSERT INTO `municipio` VALUES (2045, 28, 'REYNOSA', 32);
INSERT INTO `municipio` VALUES (2046, 28, 'RIO BRAVO', 33);
INSERT INTO `municipio` VALUES (2047, 28, 'SAN CARLOS', 34);
INSERT INTO `municipio` VALUES (2048, 28, 'SAN FERNANDO', 35);
INSERT INTO `municipio` VALUES (2049, 28, 'SAN NICOLAS', 36);
INSERT INTO `municipio` VALUES (2050, 28, 'SOTO LA MARINA', 37);
INSERT INTO `municipio` VALUES (2051, 28, 'TAMPICO', 38);
INSERT INTO `municipio` VALUES (2052, 28, 'TULA', 39);
INSERT INTO `municipio` VALUES (2053, 28, 'VALLE HERMOSO', 40);
INSERT INTO `municipio` VALUES (2054, 28, 'VICTORIA', 41);
INSERT INTO `municipio` VALUES (2055, 28, 'VILLAGRAN', 42);
INSERT INTO `municipio` VALUES (2056, 28, 'XICOTENCATL', 43);
INSERT INTO `municipio` VALUES (2058, 29, 'AMAXAC DE GUERRERO', 1);
INSERT INTO `municipio` VALUES (2059, 29, 'APETATITLAN DE ANTONIO CARVAJAL', 2);
INSERT INTO `municipio` VALUES (2060, 29, 'ATLANGATEPEC', 3);
INSERT INTO `municipio` VALUES (2061, 29, 'ATLTZAYANCA', 4);
INSERT INTO `municipio` VALUES (2062, 29, 'APIZACO', 5);
INSERT INTO `municipio` VALUES (2063, 29, 'CALPULALPAN', 6);
INSERT INTO `municipio` VALUES (2064, 29, 'EL CARMEN TEQUEXQUITLA', 7);
INSERT INTO `municipio` VALUES (2065, 29, 'CUAPIAXTLA', 8);
INSERT INTO `municipio` VALUES (2066, 29, 'CUAXOMULCO', 9);
INSERT INTO `municipio` VALUES (2067, 29, 'CHIAUTEMPAN', 10);
INSERT INTO `municipio` VALUES (2068, 29, 'MUNOZ DE DOMINGO ARENAS', 11);
INSERT INTO `municipio` VALUES (2069, 29, 'ESPANITA', 12);
INSERT INTO `municipio` VALUES (2070, 29, 'HUAMANTLA', 13);
INSERT INTO `municipio` VALUES (2071, 29, 'HUEYOTLIPAN', 14);
INSERT INTO `municipio` VALUES (2072, 29, 'IXTACUIXTLA DE MARIANO MATAMOROS', 15);
INSERT INTO `municipio` VALUES (2073, 29, 'IXTENCO', 16);
INSERT INTO `municipio` VALUES (2074, 29, 'MAZATECOCHCO DE JOSE MARIA MORELOS', 17);
INSERT INTO `municipio` VALUES (2075, 29, 'CONTLA DE JUAN CUAMATZI', 18);
INSERT INTO `municipio` VALUES (2076, 29, 'TEPETITLA DE LARDIZABAL', 19);
INSERT INTO `municipio` VALUES (2077, 29, 'SANCTORUM DE LAZARO CARDENAS', 20);
INSERT INTO `municipio` VALUES (2078, 29, 'NANACAMILPA DE MARIANO ARISTA', 21);
INSERT INTO `municipio` VALUES (2079, 29, 'ACUAMANALA DE MIGUEL HIDALGO', 22);
INSERT INTO `municipio` VALUES (2080, 29, 'NATIVITAS', 23);
INSERT INTO `municipio` VALUES (2081, 29, 'PANOTLA', 24);
INSERT INTO `municipio` VALUES (2082, 29, 'SAN PABLO DEL MONTE', 25);
INSERT INTO `municipio` VALUES (2083, 29, 'SANTA CRUZ TLAXCALA', 26);
INSERT INTO `municipio` VALUES (2084, 29, 'TENANCINGO', 27);
INSERT INTO `municipio` VALUES (2085, 29, 'TEOLOCHOLCO', 28);
INSERT INTO `municipio` VALUES (2086, 29, 'TEPEYANCO', 29);
INSERT INTO `municipio` VALUES (2087, 29, 'TERRENATE', 30);
INSERT INTO `municipio` VALUES (2088, 29, 'TETLA DE LA SOLIDARIDAD', 31);
INSERT INTO `municipio` VALUES (2089, 29, 'TETLATLAHUCA', 32);
INSERT INTO `municipio` VALUES (2090, 29, 'TLAXCALA', 33);
INSERT INTO `municipio` VALUES (2091, 29, 'TLAXCO', 34);
INSERT INTO `municipio` VALUES (2092, 29, 'TOCATLAN', 35);
INSERT INTO `municipio` VALUES (2093, 29, 'TOTOLAC', 36);
INSERT INTO `municipio` VALUES (2094, 29, 'ZILTLALTEPEC DE TRINIDAD SANCHEZ SANTOS', 37);
INSERT INTO `municipio` VALUES (2095, 29, 'TZOMPANTEPEC', 38);
INSERT INTO `municipio` VALUES (2096, 29, 'XALOZTOC', 39);
INSERT INTO `municipio` VALUES (2097, 29, 'XALTOCAN', 40);
INSERT INTO `municipio` VALUES (2098, 29, 'PAPALOTLA DE XICOHTENCATL', 41);
INSERT INTO `municipio` VALUES (2099, 29, 'XICOHTZINCO', 42);
INSERT INTO `municipio` VALUES (2100, 29, 'YAUHQUEMEHCAN', 43);
INSERT INTO `municipio` VALUES (2101, 29, 'ZACATELCO', 44);
INSERT INTO `municipio` VALUES (2102, 29, 'BENITO JUAREZ', 45);
INSERT INTO `municipio` VALUES (2103, 29, 'EMILIANO ZAPATA', 46);
INSERT INTO `municipio` VALUES (2104, 29, 'LAZARO CARDENAS', 47);
INSERT INTO `municipio` VALUES (2105, 29, 'LA MAGDALENA TLALTELULCO', 48);
INSERT INTO `municipio` VALUES (2106, 29, 'SAN DAMIAN TEXOLOC', 49);
INSERT INTO `municipio` VALUES (2107, 29, 'SAN FRANCISCO TETLANOHCAN', 50);
INSERT INTO `municipio` VALUES (2108, 29, 'SAN JERONIMO ZACUALPAN', 51);
INSERT INTO `municipio` VALUES (2109, 29, 'SAN JOSE TEACALCO', 52);
INSERT INTO `municipio` VALUES (2110, 29, 'SAN JUAN HUACTZINCO', 53);
INSERT INTO `municipio` VALUES (2111, 29, 'SAN LORENZO AXOCOMANITLA', 54);
INSERT INTO `municipio` VALUES (2112, 29, 'SAN LUCAS TECOPILCO', 55);
INSERT INTO `municipio` VALUES (2113, 29, 'SANTA ANA NOPALUCAN', 56);
INSERT INTO `municipio` VALUES (2114, 29, 'SANTA APOLONIA TEACALCO', 57);
INSERT INTO `municipio` VALUES (2115, 29, 'SANTA CATARINA AYOMETLA', 58);
INSERT INTO `municipio` VALUES (2116, 29, 'SANTA CRUZ QUILEHTLA', 59);
INSERT INTO `municipio` VALUES (2117, 29, 'SANTA ISABEL XILOXOXTLA', 60);
INSERT INTO `municipio` VALUES (2119, 30, 'ACAJETE', 1);
INSERT INTO `municipio` VALUES (2120, 30, 'ACATLAN', 2);
INSERT INTO `municipio` VALUES (2121, 30, 'ACAYUCAN', 3);
INSERT INTO `municipio` VALUES (2122, 30, 'ACTOPAN', 4);
INSERT INTO `municipio` VALUES (2123, 30, 'ACULA', 5);
INSERT INTO `municipio` VALUES (2124, 30, 'ACULTZINGO', 6);
INSERT INTO `municipio` VALUES (2125, 30, 'CAMARON DE TEJEDA', 7);
INSERT INTO `municipio` VALUES (2126, 30, 'ALPATLAHUAC', 8);
INSERT INTO `municipio` VALUES (2127, 30, 'ALTO LUCERO DE GUTIERREZ BARRIOS', 9);
INSERT INTO `municipio` VALUES (2128, 30, 'ALTOTONGA', 10);
INSERT INTO `municipio` VALUES (2129, 30, 'ALVARADO', 11);
INSERT INTO `municipio` VALUES (2130, 30, 'AMATITLAN', 12);
INSERT INTO `municipio` VALUES (2131, 30, 'NARANJOS AMATLAN', 13);
INSERT INTO `municipio` VALUES (2132, 30, 'AMATLAN DE LOS REYES', 14);
INSERT INTO `municipio` VALUES (2133, 30, 'ANGEL R. CABADA', 15);
INSERT INTO `municipio` VALUES (2134, 30, 'LA ANTIGUA', 16);
INSERT INTO `municipio` VALUES (2135, 30, 'APAZAPAN', 17);
INSERT INTO `municipio` VALUES (2136, 30, 'AQUILA', 18);
INSERT INTO `municipio` VALUES (2137, 30, 'ASTACINGA', 19);
INSERT INTO `municipio` VALUES (2138, 30, 'ATLAHUILCO', 20);
INSERT INTO `municipio` VALUES (2139, 30, 'ATOYAC', 21);
INSERT INTO `municipio` VALUES (2140, 30, 'ATZACAN', 22);
INSERT INTO `municipio` VALUES (2141, 30, 'ATZALAN', 23);
INSERT INTO `municipio` VALUES (2142, 30, 'TLALTETELA', 24);
INSERT INTO `municipio` VALUES (2143, 30, 'AYAHUALULCO', 25);
INSERT INTO `municipio` VALUES (2144, 30, 'BANDERILLA', 26);
INSERT INTO `municipio` VALUES (2145, 30, 'BENITO JUAREZ', 27);
INSERT INTO `municipio` VALUES (2146, 30, 'BOCA DEL RIO', 28);
INSERT INTO `municipio` VALUES (2147, 30, 'CALCAHUALCO', 29);
INSERT INTO `municipio` VALUES (2148, 30, 'CAMERINO Z. MENDOZA', 30);
INSERT INTO `municipio` VALUES (2149, 30, 'CARRILLO PUERTO', 31);
INSERT INTO `municipio` VALUES (2150, 30, 'CATEMACO', 32);
INSERT INTO `municipio` VALUES (2151, 30, 'CAZONES DE HERRERA', 33);
INSERT INTO `municipio` VALUES (2152, 30, 'CERRO AZUL', 34);
INSERT INTO `municipio` VALUES (2153, 30, 'CITLALTEPETL', 35);
INSERT INTO `municipio` VALUES (2154, 30, 'COACOATZINTLA', 36);
INSERT INTO `municipio` VALUES (2155, 30, 'COAHUITLAN', 37);
INSERT INTO `municipio` VALUES (2156, 30, 'COATEPEC', 38);
INSERT INTO `municipio` VALUES (2157, 30, 'COATZACOALCOS', 39);
INSERT INTO `municipio` VALUES (2158, 30, 'COATZINTLA', 40);
INSERT INTO `municipio` VALUES (2159, 30, 'COETZALA', 41);
INSERT INTO `municipio` VALUES (2160, 30, 'COLIPA', 42);
INSERT INTO `municipio` VALUES (2161, 30, 'COMAPA', 43);
INSERT INTO `municipio` VALUES (2162, 30, 'CORDOBA', 44);
INSERT INTO `municipio` VALUES (2163, 30, 'COSAMALOAPAN DE CARPIO', 45);
INSERT INTO `municipio` VALUES (2164, 30, 'COSAUTLAN DE CARVAJAL', 46);
INSERT INTO `municipio` VALUES (2165, 30, 'COSCOMATEPEC', 47);
INSERT INTO `municipio` VALUES (2166, 30, 'COSOLEACAQUE', 48);
INSERT INTO `municipio` VALUES (2167, 30, 'COTAXTLA', 49);
INSERT INTO `municipio` VALUES (2168, 30, 'COXQUIHUI', 50);
INSERT INTO `municipio` VALUES (2169, 30, 'COYUTLA', 51);
INSERT INTO `municipio` VALUES (2170, 30, 'CUICHAPA', 52);
INSERT INTO `municipio` VALUES (2171, 30, 'CUITLAHUAC', 53);
INSERT INTO `municipio` VALUES (2172, 30, 'CHACALTIANGUIS', 54);
INSERT INTO `municipio` VALUES (2173, 30, 'CHALMA', 55);
INSERT INTO `municipio` VALUES (2174, 30, 'CHICONAMEL', 56);
INSERT INTO `municipio` VALUES (2175, 30, 'CHICONQUIACO', 57);
INSERT INTO `municipio` VALUES (2176, 30, 'CHICONTEPEC', 58);
INSERT INTO `municipio` VALUES (2177, 30, 'CHINAMECA', 59);
INSERT INTO `municipio` VALUES (2178, 30, 'CHINAMPA DE GOROSTIZA', 60);
INSERT INTO `municipio` VALUES (2179, 30, 'LAS CHOAPAS', 61);
INSERT INTO `municipio` VALUES (2180, 30, 'CHOCAMAN', 62);
INSERT INTO `municipio` VALUES (2181, 30, 'CHONTLA', 63);
INSERT INTO `municipio` VALUES (2182, 30, 'CHUMATLAN', 64);
INSERT INTO `municipio` VALUES (2183, 30, 'EMILIANO ZAPATA', 65);
INSERT INTO `municipio` VALUES (2184, 30, 'ESPINAL', 66);
INSERT INTO `municipio` VALUES (2185, 30, 'FILOMENO MATA', 67);
INSERT INTO `municipio` VALUES (2186, 30, 'FORTIN', 68);
INSERT INTO `municipio` VALUES (2187, 30, 'GUTIERREZ ZAMORA', 69);
INSERT INTO `municipio` VALUES (2188, 30, 'HIDALGOTITLAN', 70);
INSERT INTO `municipio` VALUES (2189, 30, 'HUATUSCO', 71);
INSERT INTO `municipio` VALUES (2190, 30, 'HUAYACOCOTLA', 72);
INSERT INTO `municipio` VALUES (2191, 30, 'HUEYAPAN DE OCAMPO', 73);
INSERT INTO `municipio` VALUES (2192, 30, 'HUILOAPAN DE CUAUHTEMOC', 74);
INSERT INTO `municipio` VALUES (2193, 30, 'IGNACIO DE LA LLAVE', 75);
INSERT INTO `municipio` VALUES (2194, 30, 'ILAMATLAN', 76);
INSERT INTO `municipio` VALUES (2195, 30, 'ISLA', 77);
INSERT INTO `municipio` VALUES (2196, 30, 'IXCATEPEC', 78);
INSERT INTO `municipio` VALUES (2197, 30, 'IXHUACAN DE LOS REYES', 79);
INSERT INTO `municipio` VALUES (2198, 30, 'IXHUATLAN DEL CAFE', 80);
INSERT INTO `municipio` VALUES (2199, 30, 'IXHUATLANCILLO', 81);
INSERT INTO `municipio` VALUES (2200, 30, 'IXHUATLAN DEL SURESTE', 82);
INSERT INTO `municipio` VALUES (2201, 30, 'IXHUATLAN DE MADERO', 83);
INSERT INTO `municipio` VALUES (2202, 30, 'IXMATLAHUACAN', 84);
INSERT INTO `municipio` VALUES (2203, 30, 'IXTACZOQUITLAN', 85);
INSERT INTO `municipio` VALUES (2204, 30, 'JALACINGO', 86);
INSERT INTO `municipio` VALUES (2205, 30, 'XALAPA', 87);
INSERT INTO `municipio` VALUES (2206, 30, 'JALCOMULCO', 88);
INSERT INTO `municipio` VALUES (2207, 30, 'JALTIPAN', 89);
INSERT INTO `municipio` VALUES (2208, 30, 'JAMAPA', 90);
INSERT INTO `municipio` VALUES (2209, 30, 'JESUS CARRANZA', 91);
INSERT INTO `municipio` VALUES (2210, 30, 'XICO', 92);
INSERT INTO `municipio` VALUES (2211, 30, 'JILOTEPEC', 93);
INSERT INTO `municipio` VALUES (2212, 30, 'JUAN RODRIGUEZ CLARA', 94);
INSERT INTO `municipio` VALUES (2213, 30, 'JUCHIQUE DE FERRER', 95);
INSERT INTO `municipio` VALUES (2214, 30, 'LANDERO Y COSS', 96);
INSERT INTO `municipio` VALUES (2215, 30, 'LERDO DE TEJADA', 97);
INSERT INTO `municipio` VALUES (2216, 30, 'MAGDALENA', 98);
INSERT INTO `municipio` VALUES (2217, 30, 'MALTRATA', 99);
INSERT INTO `municipio` VALUES (2218, 30, 'MANLIO FABIO ALTAMIRANO', 100);
INSERT INTO `municipio` VALUES (2219, 30, 'MARIANO ESCOBEDO', 101);
INSERT INTO `municipio` VALUES (2220, 30, 'MARTINEZ DE LA TORRE', 102);
INSERT INTO `municipio` VALUES (2221, 30, 'MECATLAN', 103);
INSERT INTO `municipio` VALUES (2222, 30, 'MECAYAPAN', 104);
INSERT INTO `municipio` VALUES (2223, 30, 'MEDELLIN DE BRAVO', 105);
INSERT INTO `municipio` VALUES (2224, 30, 'MIAHUATLAN', 106);
INSERT INTO `municipio` VALUES (2225, 30, 'LAS MINAS', 107);
INSERT INTO `municipio` VALUES (2226, 30, 'MINATITLAN', 108);
INSERT INTO `municipio` VALUES (2227, 30, 'MISANTLA', 109);
INSERT INTO `municipio` VALUES (2228, 30, 'MIXTLA DE ALTAMIRANO', 110);
INSERT INTO `municipio` VALUES (2229, 30, 'MOLOACAN', 111);
INSERT INTO `municipio` VALUES (2230, 30, 'NAOLINCO', 112);
INSERT INTO `municipio` VALUES (2231, 30, 'NARANJAL', 113);
INSERT INTO `municipio` VALUES (2232, 30, 'NAUTLA', 114);
INSERT INTO `municipio` VALUES (2233, 30, 'NOGALES', 115);
INSERT INTO `municipio` VALUES (2234, 30, 'OLUTA', 116);
INSERT INTO `municipio` VALUES (2235, 30, 'OMEALCA', 117);
INSERT INTO `municipio` VALUES (2236, 30, 'ORIZABA', 118);
INSERT INTO `municipio` VALUES (2237, 30, 'OTATITLAN', 119);
INSERT INTO `municipio` VALUES (2238, 30, 'OTEAPAN', 120);
INSERT INTO `municipio` VALUES (2239, 30, 'OZULUAMA DE MASCARENAS', 121);
INSERT INTO `municipio` VALUES (2240, 30, 'PAJAPAN', 122);
INSERT INTO `municipio` VALUES (2241, 30, 'PANUCO', 123);
INSERT INTO `municipio` VALUES (2242, 30, 'PAPANTLA', 124);
INSERT INTO `municipio` VALUES (2243, 30, 'PASO DEL MACHO', 125);
INSERT INTO `municipio` VALUES (2244, 30, 'PASO DE OVEJAS', 126);
INSERT INTO `municipio` VALUES (2245, 30, 'LA PERLA', 127);
INSERT INTO `municipio` VALUES (2246, 30, 'PEROTE', 128);
INSERT INTO `municipio` VALUES (2247, 30, 'PLATON SANCHEZ', 129);
INSERT INTO `municipio` VALUES (2248, 30, 'PLAYA VICENTE', 130);
INSERT INTO `municipio` VALUES (2249, 30, 'POZA RICA DE HIDALGO', 131);
INSERT INTO `municipio` VALUES (2250, 30, 'LAS VIGAS DE RAMIREZ', 132);
INSERT INTO `municipio` VALUES (2251, 30, 'PUEBLO VIEJO', 133);
INSERT INTO `municipio` VALUES (2252, 30, 'PUENTE NACIONAL', 134);
INSERT INTO `municipio` VALUES (2253, 30, 'RAFAEL DELGADO', 135);
INSERT INTO `municipio` VALUES (2254, 30, 'RAFAEL LUCIO', 136);
INSERT INTO `municipio` VALUES (2255, 30, 'LOS REYES', 137);
INSERT INTO `municipio` VALUES (2256, 30, 'RIO BLANCO', 138);
INSERT INTO `municipio` VALUES (2257, 30, 'SALTABARRANCA', 139);
INSERT INTO `municipio` VALUES (2258, 30, 'SAN ANDRES TENEJAPAN', 140);
INSERT INTO `municipio` VALUES (2259, 30, 'SAN ANDRES TUXTLA', 141);
INSERT INTO `municipio` VALUES (2260, 30, 'SAN JUAN EVANGELISTA', 142);
INSERT INTO `municipio` VALUES (2261, 30, 'SANTIAGO TUXTLA', 143);
INSERT INTO `municipio` VALUES (2262, 30, 'SAYULA DE ALEMAN', 144);
INSERT INTO `municipio` VALUES (2263, 30, 'SOCONUSCO', 145);
INSERT INTO `municipio` VALUES (2264, 30, 'SOCHIAPA', 146);
INSERT INTO `municipio` VALUES (2265, 30, 'SOLEDAD ATZOMPA', 147);
INSERT INTO `municipio` VALUES (2266, 30, 'SOLEDAD DE DOBLADO', 148);
INSERT INTO `municipio` VALUES (2267, 30, 'SOTEAPAN', 149);
INSERT INTO `municipio` VALUES (2268, 30, 'TAMALIN', 150);
INSERT INTO `municipio` VALUES (2269, 30, 'TAMIAHUA', 151);
INSERT INTO `municipio` VALUES (2270, 30, 'TAMPICO ALTO', 152);
INSERT INTO `municipio` VALUES (2271, 30, 'TANCOCO', 153);
INSERT INTO `municipio` VALUES (2272, 30, 'TANTIMA', 154);
INSERT INTO `municipio` VALUES (2273, 30, 'TANTOYUCA', 155);
INSERT INTO `municipio` VALUES (2274, 30, 'TATATILA', 156);
INSERT INTO `municipio` VALUES (2275, 30, 'CASTILLO DE TEAYO', 157);
INSERT INTO `municipio` VALUES (2276, 30, 'TECOLUTLA', 158);
INSERT INTO `municipio` VALUES (2277, 30, 'TEHUIPANGO', 159);
INSERT INTO `municipio` VALUES (2278, 30, 'ALAMO TEMAPACHE', 160);
INSERT INTO `municipio` VALUES (2279, 30, 'TEMPOAL', 161);
INSERT INTO `municipio` VALUES (2280, 30, 'TENAMPA', 162);
INSERT INTO `municipio` VALUES (2281, 30, 'TENOCHTITLAN', 163);
INSERT INTO `municipio` VALUES (2282, 30, 'TEOCELO', 164);
INSERT INTO `municipio` VALUES (2283, 30, 'TEPATLAXCO', 165);
INSERT INTO `municipio` VALUES (2284, 30, 'TEPETLAN', 166);
INSERT INTO `municipio` VALUES (2285, 30, 'TEPETZINTLA', 167);
INSERT INTO `municipio` VALUES (2286, 30, 'TEQUILA', 168);
INSERT INTO `municipio` VALUES (2287, 30, 'JOSE AZUETA', 169);
INSERT INTO `municipio` VALUES (2288, 30, 'TEXCATEPEC', 170);
INSERT INTO `municipio` VALUES (2289, 30, 'TEXHUACAN', 171);
INSERT INTO `municipio` VALUES (2290, 30, 'TEXISTEPEC', 172);
INSERT INTO `municipio` VALUES (2291, 30, 'TEZONAPA', 173);
INSERT INTO `municipio` VALUES (2292, 30, 'TIERRA BLANCA', 174);
INSERT INTO `municipio` VALUES (2293, 30, 'TIHUATLAN', 175);
INSERT INTO `municipio` VALUES (2294, 30, 'TLACOJALPAN', 176);
INSERT INTO `municipio` VALUES (2295, 30, 'TLACOLULAN', 177);
INSERT INTO `municipio` VALUES (2296, 30, 'TLACOTALPAN', 178);
INSERT INTO `municipio` VALUES (2297, 30, 'TLACOTEPEC DE MEJIA', 179);
INSERT INTO `municipio` VALUES (2298, 30, 'TLACHICHILCO', 180);
INSERT INTO `municipio` VALUES (2299, 30, 'TLALIXCOYAN', 181);
INSERT INTO `municipio` VALUES (2300, 30, 'TLALNELHUAYOCAN', 182);
INSERT INTO `municipio` VALUES (2301, 30, 'TLAPACOYAN', 183);
INSERT INTO `municipio` VALUES (2302, 30, 'TLAQUILPA', 184);
INSERT INTO `municipio` VALUES (2303, 30, 'TLILAPAN', 185);
INSERT INTO `municipio` VALUES (2304, 30, 'TOMATLAN', 186);
INSERT INTO `municipio` VALUES (2305, 30, 'TONAYAN', 187);
INSERT INTO `municipio` VALUES (2306, 30, 'TOTUTLA', 188);
INSERT INTO `municipio` VALUES (2307, 30, 'TUXPAN', 189);
INSERT INTO `municipio` VALUES (2308, 30, 'TUXTILLA', 190);
INSERT INTO `municipio` VALUES (2309, 30, 'URSULO GALVAN', 191);
INSERT INTO `municipio` VALUES (2310, 30, 'VEGA DE ALATORRE', 192);
INSERT INTO `municipio` VALUES (2311, 30, 'VERACRUZ', 193);
INSERT INTO `municipio` VALUES (2312, 30, 'VILLA ALDAMA', 194);
INSERT INTO `municipio` VALUES (2313, 30, 'XOXOCOTLA', 195);
INSERT INTO `municipio` VALUES (2314, 30, 'YANGA', 196);
INSERT INTO `municipio` VALUES (2315, 30, 'YECUATLA', 197);
INSERT INTO `municipio` VALUES (2316, 30, 'ZACUALPAN', 198);
INSERT INTO `municipio` VALUES (2317, 30, 'ZARAGOZA', 199);
INSERT INTO `municipio` VALUES (2318, 30, 'ZENTLA', 200);
INSERT INTO `municipio` VALUES (2319, 30, 'ZONGOLICA', 201);
INSERT INTO `municipio` VALUES (2320, 30, 'ZONTECOMATLAN DE LOPEZ Y FUENTES', 202);
INSERT INTO `municipio` VALUES (2321, 30, 'ZOZOCOLCO DE HIDALGO', 203);
INSERT INTO `municipio` VALUES (2322, 30, 'AGUA DULCE', 204);
INSERT INTO `municipio` VALUES (2323, 30, 'EL HIGO', 205);
INSERT INTO `municipio` VALUES (2324, 30, 'NANCHITAL DE LAZARO CARDENAS DEL RIO', 206);
INSERT INTO `municipio` VALUES (2325, 30, 'TRES VALLES', 207);
INSERT INTO `municipio` VALUES (2326, 30, 'CARLOS A. CARRILLO', 208);
INSERT INTO `municipio` VALUES (2327, 30, 'TATAHUICAPAN DE JUAREZ', 209);
INSERT INTO `municipio` VALUES (2328, 30, 'UXPANAPA', 210);
INSERT INTO `municipio` VALUES (2329, 30, 'SAN RAFAEL', 211);
INSERT INTO `municipio` VALUES (2330, 30, 'SANTIAGO SOCHIAPAN', 212);
INSERT INTO `municipio` VALUES (2332, 31, 'ABALA', 1);
INSERT INTO `municipio` VALUES (2333, 31, 'ACANCEH', 2);
INSERT INTO `municipio` VALUES (2334, 31, 'AKIL', 3);
INSERT INTO `municipio` VALUES (2335, 31, 'BACA', 4);
INSERT INTO `municipio` VALUES (2336, 31, 'BOKOBA', 5);
INSERT INTO `municipio` VALUES (2337, 31, 'BUCTZOTZ', 6);
INSERT INTO `municipio` VALUES (2338, 31, 'CACALCHEN', 7);
INSERT INTO `municipio` VALUES (2339, 31, 'CALOTMUL', 8);
INSERT INTO `municipio` VALUES (2340, 31, 'CANSAHCAB', 9);
INSERT INTO `municipio` VALUES (2341, 31, 'CANTAMAYEC', 10);
INSERT INTO `municipio` VALUES (2342, 31, 'CELESTUN', 11);
INSERT INTO `municipio` VALUES (2343, 31, 'CENOTILLO', 12);
INSERT INTO `municipio` VALUES (2344, 31, 'CONKAL', 13);
INSERT INTO `municipio` VALUES (2345, 31, 'CUNCUNUL', 14);
INSERT INTO `municipio` VALUES (2346, 31, 'CUZAMA', 15);
INSERT INTO `municipio` VALUES (2347, 31, 'CHACSINKIN', 16);
INSERT INTO `municipio` VALUES (2348, 31, 'CHANKOM', 17);
INSERT INTO `municipio` VALUES (2349, 31, 'CHAPAB', 18);
INSERT INTO `municipio` VALUES (2350, 31, 'CHEMAX', 19);
INSERT INTO `municipio` VALUES (2351, 31, 'CHICXULUB PUEBLO', 20);
INSERT INTO `municipio` VALUES (2352, 31, 'CHICHIMILA', 21);
INSERT INTO `municipio` VALUES (2353, 31, 'CHIKINDZONOT', 22);
INSERT INTO `municipio` VALUES (2354, 31, 'CHOCHOLA', 23);
INSERT INTO `municipio` VALUES (2355, 31, 'CHUMAYEL', 24);
INSERT INTO `municipio` VALUES (2356, 31, 'DZAN', 25);
INSERT INTO `municipio` VALUES (2357, 31, 'DZEMUL', 26);
INSERT INTO `municipio` VALUES (2358, 31, 'DZIDZANTUN', 27);
INSERT INTO `municipio` VALUES (2359, 31, 'DZILAM DE BRAVO', 28);
INSERT INTO `municipio` VALUES (2360, 31, 'DZILAM GONZALEZ', 29);
INSERT INTO `municipio` VALUES (2361, 31, 'DZITAS', 30);
INSERT INTO `municipio` VALUES (2362, 31, 'DZONCAUICH', 31);
INSERT INTO `municipio` VALUES (2363, 31, 'ESPITA', 32);
INSERT INTO `municipio` VALUES (2364, 31, 'HALACHO', 33);
INSERT INTO `municipio` VALUES (2365, 31, 'HOCABA', 34);
INSERT INTO `municipio` VALUES (2366, 31, 'HOCTUN', 35);
INSERT INTO `municipio` VALUES (2367, 31, 'HOMUN', 36);
INSERT INTO `municipio` VALUES (2368, 31, 'HUHI', 37);
INSERT INTO `municipio` VALUES (2369, 31, 'HUNUCMA', 38);
INSERT INTO `municipio` VALUES (2370, 31, 'IXIL', 39);
INSERT INTO `municipio` VALUES (2371, 31, 'IZAMAL', 40);
INSERT INTO `municipio` VALUES (2372, 31, 'KANASIN', 41);
INSERT INTO `municipio` VALUES (2373, 31, 'KANTUNIL', 42);
INSERT INTO `municipio` VALUES (2374, 31, 'KAUA', 43);
INSERT INTO `municipio` VALUES (2375, 31, 'KINCHIL', 44);
INSERT INTO `municipio` VALUES (2376, 31, 'KOPOMA', 45);
INSERT INTO `municipio` VALUES (2377, 31, 'MAMA', 46);
INSERT INTO `municipio` VALUES (2378, 31, 'MANI', 47);
INSERT INTO `municipio` VALUES (2379, 31, 'MAXCANU', 48);
INSERT INTO `municipio` VALUES (2380, 31, 'MAYAPAN', 49);
INSERT INTO `municipio` VALUES (2381, 31, 'MERIDA', 50);
INSERT INTO `municipio` VALUES (2382, 31, 'MOCOCHA', 51);
INSERT INTO `municipio` VALUES (2383, 31, 'MOTUL', 52);
INSERT INTO `municipio` VALUES (2384, 31, 'MUNA', 53);
INSERT INTO `municipio` VALUES (2385, 31, 'MUXUPIP', 54);
INSERT INTO `municipio` VALUES (2386, 31, 'OPICHEN', 55);
INSERT INTO `municipio` VALUES (2387, 31, 'OXKUTZCAB', 56);
INSERT INTO `municipio` VALUES (2388, 31, 'PANABA', 57);
INSERT INTO `municipio` VALUES (2389, 31, 'PETO', 58);
INSERT INTO `municipio` VALUES (2390, 31, 'PROGRESO', 59);
INSERT INTO `municipio` VALUES (2391, 31, 'QUINTANA ROO', 60);
INSERT INTO `municipio` VALUES (2392, 31, 'RIO LAGARTOS', 61);
INSERT INTO `municipio` VALUES (2393, 31, 'SACALUM', 62);
INSERT INTO `municipio` VALUES (2394, 31, 'SAMAHIL', 63);
INSERT INTO `municipio` VALUES (2395, 31, 'SANAHCAT', 64);
INSERT INTO `municipio` VALUES (2396, 31, 'SAN FELIPE', 65);
INSERT INTO `municipio` VALUES (2397, 31, 'SANTA ELENA', 66);
INSERT INTO `municipio` VALUES (2398, 31, 'SEYE', 67);
INSERT INTO `municipio` VALUES (2399, 31, 'SINANCHE', 68);
INSERT INTO `municipio` VALUES (2400, 31, 'SOTUTA', 69);
INSERT INTO `municipio` VALUES (2401, 31, 'SUCILA', 70);
INSERT INTO `municipio` VALUES (2402, 31, 'SUDZAL', 71);
INSERT INTO `municipio` VALUES (2403, 31, 'SUMA', 72);
INSERT INTO `municipio` VALUES (2404, 31, 'TAHDZIU', 73);
INSERT INTO `municipio` VALUES (2405, 31, 'TAHMEK', 74);
INSERT INTO `municipio` VALUES (2406, 31, 'TEABO', 75);
INSERT INTO `municipio` VALUES (2407, 31, 'TECOH', 76);
INSERT INTO `municipio` VALUES (2408, 31, 'TEKAL DE VENEGAS', 77);
INSERT INTO `municipio` VALUES (2409, 31, 'TEKANTO', 78);
INSERT INTO `municipio` VALUES (2410, 31, 'TEKAX', 79);
INSERT INTO `municipio` VALUES (2411, 31, 'TEKIT', 80);
INSERT INTO `municipio` VALUES (2412, 31, 'TEKOM', 81);
INSERT INTO `municipio` VALUES (2413, 31, 'TELCHAC PUEBLO', 82);
INSERT INTO `municipio` VALUES (2414, 31, 'TELCHAC PUERTO', 83);
INSERT INTO `municipio` VALUES (2415, 31, 'TEMAX', 84);
INSERT INTO `municipio` VALUES (2416, 31, 'TEMOZON', 85);
INSERT INTO `municipio` VALUES (2417, 31, 'TEPAKAN', 86);
INSERT INTO `municipio` VALUES (2418, 31, 'TETIZ', 87);
INSERT INTO `municipio` VALUES (2419, 31, 'TEYA', 88);
INSERT INTO `municipio` VALUES (2420, 31, 'TICUL', 89);
INSERT INTO `municipio` VALUES (2421, 31, 'TIMUCUY', 90);
INSERT INTO `municipio` VALUES (2422, 31, 'TINUM', 91);
INSERT INTO `municipio` VALUES (2423, 31, 'TIXCACALCUPUL', 92);
INSERT INTO `municipio` VALUES (2424, 31, 'TIXKOKOB', 93);
INSERT INTO `municipio` VALUES (2425, 31, 'TIXMEHUAC', 94);
INSERT INTO `municipio` VALUES (2426, 31, 'TIXPEHUAL', 95);
INSERT INTO `municipio` VALUES (2427, 31, 'TIZIMIN', 96);
INSERT INTO `municipio` VALUES (2428, 31, 'TUNKAS', 97);
INSERT INTO `municipio` VALUES (2429, 31, 'TZUCACAB', 98);
INSERT INTO `municipio` VALUES (2430, 31, 'UAYMA', 99);
INSERT INTO `municipio` VALUES (2431, 31, 'UCU', 100);
INSERT INTO `municipio` VALUES (2432, 31, 'UMAN', 101);
INSERT INTO `municipio` VALUES (2433, 31, 'VALLADOLID', 102);
INSERT INTO `municipio` VALUES (2434, 31, 'XOCCHEL', 103);
INSERT INTO `municipio` VALUES (2435, 31, 'YAXCABA', 104);
INSERT INTO `municipio` VALUES (2436, 31, 'YAXKUKUL', 105);
INSERT INTO `municipio` VALUES (2437, 31, 'YOBAIN', 106);
INSERT INTO `municipio` VALUES (2439, 32, 'APOZOL', 1);
INSERT INTO `municipio` VALUES (2440, 32, 'APULCO', 2);
INSERT INTO `municipio` VALUES (2441, 32, 'ATOLINGA', 3);
INSERT INTO `municipio` VALUES (2442, 32, 'BENITO JUAREZ', 4);
INSERT INTO `municipio` VALUES (2443, 32, 'CALERA', 5);
INSERT INTO `municipio` VALUES (2444, 32, 'CANITAS DE FELIPE PESCADOR', 6);
INSERT INTO `municipio` VALUES (2445, 32, 'CONCEPCION DEL ORO', 7);
INSERT INTO `municipio` VALUES (2446, 32, 'CUAUHTEMOC', 8);
INSERT INTO `municipio` VALUES (2447, 32, 'CHALCHIHUITES', 9);
INSERT INTO `municipio` VALUES (2448, 32, 'FRESNILLO', 10);
INSERT INTO `municipio` VALUES (2449, 32, 'TRINIDAD GARCIA DE LA CADENA', 11);
INSERT INTO `municipio` VALUES (2450, 32, 'GENARO CODINA', 12);
INSERT INTO `municipio` VALUES (2451, 32, 'GENERAL ENRIQUE ESTRADA', 13);
INSERT INTO `municipio` VALUES (2452, 32, 'GENERAL FRANCISCO R. MURGUIA', 14);
INSERT INTO `municipio` VALUES (2453, 32, 'EL PLATEADO DE JOAQUIN AMARO', 15);
INSERT INTO `municipio` VALUES (2454, 32, 'GENERAL PANFILO NATERA', 16);
INSERT INTO `municipio` VALUES (2455, 32, 'GUADALUPE', 17);
INSERT INTO `municipio` VALUES (2456, 32, 'HUANUSCO', 18);
INSERT INTO `municipio` VALUES (2457, 32, 'JALPA', 19);
INSERT INTO `municipio` VALUES (2458, 32, 'JEREZ', 20);
INSERT INTO `municipio` VALUES (2459, 32, 'JIMENEZ DEL TEUL', 21);
INSERT INTO `municipio` VALUES (2460, 32, 'JUAN ALDAMA', 22);
INSERT INTO `municipio` VALUES (2461, 32, 'JUCHIPILA', 23);
INSERT INTO `municipio` VALUES (2462, 32, 'LORETO', 24);
INSERT INTO `municipio` VALUES (2463, 32, 'LUIS MOYA', 25);
INSERT INTO `municipio` VALUES (2464, 32, 'MAZAPIL', 26);
INSERT INTO `municipio` VALUES (2465, 32, 'MELCHOR OCAMPO', 27);
INSERT INTO `municipio` VALUES (2466, 32, 'MEZQUITAL DEL ORO', 28);
INSERT INTO `municipio` VALUES (2467, 32, 'MIGUEL AUZA', 29);
INSERT INTO `municipio` VALUES (2468, 32, 'MOMAX', 30);
INSERT INTO `municipio` VALUES (2469, 32, 'MONTE ESCOBEDO', 31);
INSERT INTO `municipio` VALUES (2470, 32, 'MORELOS', 32);
INSERT INTO `municipio` VALUES (2471, 32, 'MOYAHUA DE ESTRADA', 33);
INSERT INTO `municipio` VALUES (2472, 32, 'NOCHISTLAN DE MEJIA', 34);
INSERT INTO `municipio` VALUES (2473, 32, 'NORIA DE ANGELES', 35);
INSERT INTO `municipio` VALUES (2474, 32, 'OJOCALIENTE', 36);
INSERT INTO `municipio` VALUES (2475, 32, 'PANUCO', 37);
INSERT INTO `municipio` VALUES (2476, 32, 'PINOS', 38);
INSERT INTO `municipio` VALUES (2477, 32, 'RIO GRANDE', 39);
INSERT INTO `municipio` VALUES (2478, 32, 'SAIN ALTO', 40);
INSERT INTO `municipio` VALUES (2479, 32, 'EL SALVADOR', 41);
INSERT INTO `municipio` VALUES (2480, 32, 'SOMBRERETE', 42);
INSERT INTO `municipio` VALUES (2481, 32, 'SUSTICACAN', 43);
INSERT INTO `municipio` VALUES (2482, 32, 'TABASCO', 44);
INSERT INTO `municipio` VALUES (2483, 32, 'TEPECHITLAN', 45);
INSERT INTO `municipio` VALUES (2484, 32, 'TEPETONGO', 46);
INSERT INTO `municipio` VALUES (2485, 32, 'TEUL DE GONZALEZ ORTEGA', 47);
INSERT INTO `municipio` VALUES (2486, 32, 'TLALTENANGO DE SANCHEZ ROMAN', 48);
INSERT INTO `municipio` VALUES (2487, 32, 'VALPARAISO', 49);
INSERT INTO `municipio` VALUES (2488, 32, 'VETAGRANDE', 50);
INSERT INTO `municipio` VALUES (2489, 32, 'VILLA DE COS', 51);
INSERT INTO `municipio` VALUES (2490, 32, 'VILLA GARCIA', 52);
INSERT INTO `municipio` VALUES (2491, 32, 'VILLA GONZALEZ ORTEGA', 53);
INSERT INTO `municipio` VALUES (2492, 32, 'VILLA HIDALGO', 54);
INSERT INTO `municipio` VALUES (2493, 32, 'VILLANUEVA', 55);
INSERT INTO `municipio` VALUES (2494, 32, 'ZACATECAS', 56);
INSERT INTO `municipio` VALUES (2495, 32, 'TRANCOSO', 57);
INSERT INTO `municipio` VALUES (2496, 32, 'SANTA MARIA DE LA PAZ', 58);
INSERT INTO `municipio` VALUES (2497, 33, 'Autaga', 1);
INSERT INTO `municipio` VALUES (2498, 33, 'Baldwin', 3);
INSERT INTO `municipio` VALUES (2499, 34, 'Anchorage', 1);
INSERT INTO `municipio` VALUES (2500, 34, 'Juneau', 2);
INSERT INTO `municipio` VALUES (2501, 35, 'Apache', 1);
INSERT INTO `municipio` VALUES (2502, 35, 'Cochise', 2);
INSERT INTO `municipio` VALUES (2503, 36, 'Arkansas', 1);
INSERT INTO `municipio` VALUES (2504, 36, 'Ashley', 2);
INSERT INTO `municipio` VALUES (2505, 33, 'Barbour', 2);
INSERT INTO `municipio` VALUES (2506, 37, 'Alameda', 1);
INSERT INTO `municipio` VALUES (2507, 37, 'Alpine', 2);
INSERT INTO `municipio` VALUES (2508, 38, 'Adams', 1);
INSERT INTO `municipio` VALUES (2509, 38, 'Almosa', 2);
INSERT INTO `municipio` VALUES (2512, 39, 'Fairfield', 1);
INSERT INTO `municipio` VALUES (2513, 39, 'Hartfort', 2);
INSERT INTO `municipio` VALUES (2514, 40, 'Kent', 1);
INSERT INTO `municipio` VALUES (2515, 40, 'New Castle', 2);
INSERT INTO `municipio` VALUES (2516, 43, 'Kalawao', 2);
INSERT INTO `municipio` VALUES (2517, 43, 'Honolulu', 1);
INSERT INTO `municipio` VALUES (2518, 41, 'Alachua', 1);
INSERT INTO `municipio` VALUES (2519, 41, 'Baker', 2);
INSERT INTO `municipio` VALUES (2520, 42, 'Appling', 1);
INSERT INTO `municipio` VALUES (2521, 42, 'Atkinson', 2);
INSERT INTO `municipio` VALUES (2522, 44, 'Ada', 1);
INSERT INTO `municipio` VALUES (2523, 44, 'Bannok', 2);
INSERT INTO `municipio` VALUES (2524, 45, 'Benton', 1);
INSERT INTO `municipio` VALUES (2525, 45, 'Boone', 2);
INSERT INTO `municipio` VALUES (2526, 46, 'Allamakee', 2);
INSERT INTO `municipio` VALUES (2527, 46, 'Audubon', 1);
INSERT INTO `municipio` VALUES (2528, 47, 'Allen', 1);
INSERT INTO `municipio` VALUES (2529, 47, 'Anderson', 2);
INSERT INTO `municipio` VALUES (2530, 48, 'Adair', 1);
INSERT INTO `municipio` VALUES (2531, 48, 'Allen', 2);
INSERT INTO `municipio` VALUES (2532, 49, 'Acadia Parish', 1);
INSERT INTO `municipio` VALUES (2533, 49, 'Allen Parish', 2);
INSERT INTO `municipio` VALUES (2534, 50, 'Androscoggin', 1);
INSERT INTO `municipio` VALUES (2535, 50, 'Aroostook', 2);
INSERT INTO `municipio` VALUES (2536, 51, 'Allegany', 1);
INSERT INTO `municipio` VALUES (2537, 51, 'Anne Arundel', 2);
INSERT INTO `municipio` VALUES (2538, 52, 'Barnstable', 1);
INSERT INTO `municipio` VALUES (2539, 52, 'Berkshire', 2);
INSERT INTO `municipio` VALUES (2540, 53, 'Alcona', 2);
INSERT INTO `municipio` VALUES (2541, 53, 'Alger', 1);
INSERT INTO `municipio` VALUES (2542, 54, 'Aitkin', 1);
INSERT INTO `municipio` VALUES (2543, 54, 'Anoka', 2);
INSERT INTO `municipio` VALUES (2544, 55, 'Adams', 1);
INSERT INTO `municipio` VALUES (2545, 55, 'Alcorn', 2);
INSERT INTO `municipio` VALUES (2546, 56, 'Adair', 1);
INSERT INTO `municipio` VALUES (2547, 56, 'Andrew', 2);
INSERT INTO `municipio` VALUES (2548, 57, 'Beaverhead', 1);
INSERT INTO `municipio` VALUES (2549, 57, 'Big Horn', 2);
INSERT INTO `municipio` VALUES (2550, 58, 'Adams', 1);
INSERT INTO `municipio` VALUES (2551, 58, 'Antelope', 2);
INSERT INTO `municipio` VALUES (2552, 59, 'Carson City', 1);
INSERT INTO `municipio` VALUES (2553, 59, 'Churchill', 2);
INSERT INTO `municipio` VALUES (2554, 60, 'Belknap', 1);
INSERT INTO `municipio` VALUES (2555, 60, 'Carroll', 2);
INSERT INTO `municipio` VALUES (2556, 61, 'Atlantic', 1);
INSERT INTO `municipio` VALUES (2557, 61, 'Bergen', 2);
INSERT INTO `municipio` VALUES (2558, 62, 'Bernalillo ', 2);
INSERT INTO `municipio` VALUES (2559, 62, 'Catron', 1);
INSERT INTO `municipio` VALUES (2560, 63, 'Albany', 1);
INSERT INTO `municipio` VALUES (2561, 63, 'Allegany', 2);
INSERT INTO `municipio` VALUES (2562, 64, 'Alamance', 1);
INSERT INTO `municipio` VALUES (2563, 64, 'Alexander', 2);
INSERT INTO `municipio` VALUES (2564, 65, 'Adams', 1);
INSERT INTO `municipio` VALUES (2565, 65, 'Barnes', 2);
INSERT INTO `municipio` VALUES (2566, 66, 'Allen', 1);
INSERT INTO `municipio` VALUES (2567, 66, 'Adams', 2);
INSERT INTO `municipio` VALUES (2568, 67, 'Adair', 1);
INSERT INTO `municipio` VALUES (2569, 67, 'Alfalfa', 2);
INSERT INTO `municipio` VALUES (2570, 68, 'Baker', 1);
INSERT INTO `municipio` VALUES (2571, 68, 'Benton', 2);
INSERT INTO `municipio` VALUES (2572, 69, 'Allegheny', 1);
INSERT INTO `municipio` VALUES (2573, 69, 'Armstrong', 2);
INSERT INTO `municipio` VALUES (2574, 70, 'Bristol', 1);
INSERT INTO `municipio` VALUES (2575, 70, 'Kent', 2);
INSERT INTO `municipio` VALUES (2576, 71, 'Abbeville', 2);
INSERT INTO `municipio` VALUES (2577, 71, 'Aiken', 1);
INSERT INTO `municipio` VALUES (2578, 72, 'Aurora', 1);
INSERT INTO `municipio` VALUES (2579, 72, 'Beadle', 2);
INSERT INTO `municipio` VALUES (2580, 73, 'Anderson', 1);
INSERT INTO `municipio` VALUES (2581, 73, 'Bedford', 2);
INSERT INTO `municipio` VALUES (2582, 74, 'Anderson', 1);
INSERT INTO `municipio` VALUES (2583, 74, 'Andrews', 2);
INSERT INTO `municipio` VALUES (2584, 75, 'Box Elder', 1);
INSERT INTO `municipio` VALUES (2585, 75, 'Beaver', 2);
INSERT INTO `municipio` VALUES (2586, 76, 'Addison', 1);
INSERT INTO `municipio` VALUES (2587, 76, 'Bennington ', 2);
INSERT INTO `municipio` VALUES (2588, 77, 'Accomack', 1);
INSERT INTO `municipio` VALUES (2589, 77, 'Albemarle', 2);
INSERT INTO `municipio` VALUES (2590, 78, 'Adams', 1);
INSERT INTO `municipio` VALUES (2591, 78, 'Asotin', 2);
INSERT INTO `municipio` VALUES (2592, 79, 'Barbour', 1);
INSERT INTO `municipio` VALUES (2593, 79, 'Berkeley', 2);
INSERT INTO `municipio` VALUES (2594, 80, 'Ashland', 2);
INSERT INTO `municipio` VALUES (2595, 80, 'Adams', 1);
INSERT INTO `municipio` VALUES (2596, 81, 'Albany', 1);
INSERT INTO `municipio` VALUES (2597, 81, 'Big Horn', 2);

-- ----------------------------
-- Table structure for orden_compra
-- ----------------------------
DROP TABLE IF EXISTS `orden_compra`;
CREATE TABLE `orden_compra`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Atributo que representa el identificador de la orden de compra',
  `id_usuario` int(11) NOT NULL COMMENT 'Atributo que representa el identificador del usuario asociado a la compra',
  `id_direccion_envio` int(11) NOT NULL COMMENT 'Atributo que representa la direccion a donde se enviar la mascota',
  `id_paqueteria` int(11) NOT NULL COMMENT 'Atributo que representa el identificador de la paqueteria asociada a la compra',
  `id_metodo_pago` int(11) NOT NULL COMMENT 'Atributo que representa el identificador del mtodo de pago asociada a la compra',
  `id_moneda` int(11) NOT NULL COMMENT 'Atributo que representa el tipo de moneda involucrada en la compra, por ejemplo, pesos, dlllares, etc.',
  `id_anuncio` int(11) NOT NULL COMMENT 'Atributo que representa el identificador del anuncio asociada a la orden de compra',
  `cve_orden_compra` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Atributo que representa la clave alfanumrica que identifica de manera univoca a la orden de compra',
  `importe_total` decimal(10, 2) NOT NULL COMMENT 'Atributo que representa el importe total, es decir, costo de la mascota + costo de paqueteria',
  `fecha_hora_comprar` date NOT NULL COMMENT 'Atributo que representa la fecha y hora en que se realiza la comprar',
  `estado_envio` tinyint(1) NOT NULL COMMENT 'Atributo que representa el estado del envio, los valores validos son 1-En preparacion, 2-En camino, 3-Entregado',
  `recibo` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT 'Atributo que representa el nombre del archivo con el recibo de comprar en pdf',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_orden_compra_usuario`(`id_usuario`) USING BTREE,
  INDEX `fk_orden_compra_direccion_envio`(`id_direccion_envio`) USING BTREE,
  INDEX `fk_orden_compra_paqueteria`(`id_paqueteria`) USING BTREE,
  INDEX `fk_orden_compra_metodo_pago`(`id_metodo_pago`) USING BTREE,
  INDEX `fk_orden_compra_moneda`(`id_moneda`) USING BTREE,
  INDEX `fk_orden_anuncio`(`id_anuncio`) USING BTREE,
  CONSTRAINT `fk_orden_anuncio` FOREIGN KEY (`id_anuncio`) REFERENCES `anuncio` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orden_compra_direccion_envio` FOREIGN KEY (`id_direccion_envio`) REFERENCES `direccion` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orden_compra_metodo_pago` FOREIGN KEY (`id_metodo_pago`) REFERENCES `metodo_pago` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orden_compra_moneda` FOREIGN KEY (`id_moneda`) REFERENCES `moneda` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orden_compra_paqueteria` FOREIGN KEY (`id_paqueteria`) REFERENCES `paqueteria` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_orden_compra_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of orden_compra
-- ----------------------------

-- ----------------------------
-- Table structure for pais
-- ----------------------------
DROP TABLE IF EXISTS `pais`;
CREATE TABLE `pais`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pais
-- ----------------------------
INSERT INTO `pais` VALUES (1, 'Mexico');
INSERT INTO `pais` VALUES (2, 'Estados Unidos');

-- ----------------------------
-- Table structure for paqueteria
-- ----------------------------
DROP TABLE IF EXISTS `paqueteria`;
CREATE TABLE `paqueteria`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `breve_descripcion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `html_descripcion` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `precio` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of paqueteria
-- ----------------------------
INSERT INTO `paqueteria` VALUES (1, 'Aeroméxico Cargo', 'Entrega que va de unas horas al día siguiente', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 950);
INSERT INTO `paqueteria` VALUES (2, 'Estafeta', 'Entrega prioritaria de 1 a 2 días', 'Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 350);
INSERT INTO `paqueteria` VALUES (3, 'DHL', 'Entrega prioritaria al día siguiente', 'Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur.', 450);

-- ----------------------------
-- Table structure for preregistro
-- ----------------------------
DROP TABLE IF EXISTS `preregistro`;
CREATE TABLE `preregistro`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nick` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `correo` varchar(92) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clave_hash` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_nacimiento` date NULL DEFAULT NULL,
  `random_string` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `instante_registro` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_preregistro_random_string`(`random_string`) USING BTREE,
  UNIQUE INDEX `idx_preregistro_correo`(`correo`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of preregistro
-- ----------------------------

-- ----------------------------
-- Table structure for rol
-- ----------------------------
DROP TABLE IF EXISTS `rol`;
CREATE TABLE `rol`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rol
-- ----------------------------
INSERT INTO `rol` VALUES (1, 'admin', 1);
INSERT INTO `rol` VALUES (2, 'normal', 1);
INSERT INTO `rol` VALUES (3, 'operador', 1);

-- ----------------------------
-- Table structure for tipo_direccion
-- ----------------------------
DROP TABLE IF EXISTS `tipo_direccion`;
CREATE TABLE `tipo_direccion`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `activo` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tipo_direccion
-- ----------------------------
INSERT INTO `tipo_direccion` VALUES (1, 'Casa', 1);
INSERT INTO `tipo_direccion` VALUES (2, 'Oficina', 1);

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `correo` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `clave` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'temp',
  `creado` bigint(20) NOT NULL DEFAULT 0,
  `activo` tinyint(1) NOT NULL DEFAULT 0,
  `acceso_negado_contador` int(11) NOT NULL DEFAULT 0,
  `instante_bloqueo` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_acceso` bigint(20) NOT NULL DEFAULT 0,
  `instante_ultimo_cambio_clave` bigint(20) NOT NULL DEFAULT 0,
  `regenera_clave_token` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'NA',
  `regenera_clave_instante` bigint(20) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `idx_usuario_correo`(`correo`) USING BTREE,
  INDEX `idx_usuario_regenera`(`regenera_clave_token`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES (1, 'gustavo_arellano@gmail.com', '399a89d772ebdc27d7dff05af2877b58f87c3a04086cd32db71bcd3b2c1dc5c4', 1618526083301, 1, 0, 0, 1621809436736, 0, 'Kebblar2017', 0);
INSERT INTO `usuario` VALUES (2, 'gustavo-arellano@gmail.com', '3290a9ceb7ea40b7bfcd82298e02a828a08640d7744f9dd193493c0a15eca7c8', 1618526122665, 1, 0, 0, 1621809448232, 0, 'Kebblar2017', 0);
INSERT INTO `usuario` VALUES (3, 'gustavo.arellano@gmail.com', '704f4f853f903b20c57aba43798d6966b4b5a141bb26fe47d6186473c085c6b6', 1618526267651, 1, 0, 0, 1618541768297, 0, 'NA', 0);
INSERT INTO `usuario` VALUES (4, 'arellano@gmail.com', '13021c93c6bae8e351321ddb6f9d1280cf5bc42fb5205b3c7ee463e1ef3ebb45', 1618526343588, 1, 0, 0, 0, 0, 'NA', 0);
INSERT INTO `usuario` VALUES (6, 'gustavo@gmail.com', 'fe8c2458a4a18094721990a4c3e46a5b70d126533c3a0aa1a85d2ebb2b3a3ccc', 1618526363060, 1, 0, 0, 0, 0, 'NA', 0);

-- ----------------------------
-- Table structure for usuario_detalle
-- ----------------------------
DROP TABLE IF EXISTS `usuario_detalle`;
CREATE TABLE `usuario_detalle`  (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellido_paterno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `apellido_materno` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `fecha_nacimiento` date NULL DEFAULT NULL,
  `nick_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telefono_celular` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_usuario`) USING BTREE,
  CONSTRAINT `fk_usuario_detalle_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuario_detalle
-- ----------------------------
INSERT INTO `usuario_detalle` VALUES (1, 'n1', 'ap1', 'ap1', NULL, 'nick1', 'tel1');
INSERT INTO `usuario_detalle` VALUES (2, 'n2', 'ap2', 'ap2', NULL, 'nick2', 'tel2');
INSERT INTO `usuario_detalle` VALUES (3, 'n3', 'ap3', 'ap3', NULL, 'nick3', 'tel3');
INSERT INTO `usuario_detalle` VALUES (4, 'n1', 'ap1', 'ap1', NULL, 'nick1', 'tel1');
INSERT INTO `usuario_detalle` VALUES (6, 'n6', 'ap6', 'ap6', NULL, 'nick6', 'tel6');

-- ----------------------------
-- Table structure for usuario_direccion
-- ----------------------------
DROP TABLE IF EXISTS `usuario_direccion`;
CREATE TABLE `usuario_direccion`  (
  `id_usuario` int(11) NOT NULL,
  `id_direccion` int(11) NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_direccion`) USING BTREE,
  INDEX `fk_id_usuario_dir`(`id_usuario`) USING BTREE,
  INDEX `fk_id_direccion_usr`(`id_direccion`) USING BTREE,
  CONSTRAINT `fk_id_direccion_usr` FOREIGN KEY (`id_direccion`) REFERENCES `direccion` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_id_usuario_dir` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuario_direccion
-- ----------------------------
INSERT INTO `usuario_direccion` VALUES (1, 35);
INSERT INTO `usuario_direccion` VALUES (1, 36);
INSERT INTO `usuario_direccion` VALUES (1, 37);

-- ----------------------------
-- Table structure for usuario_rol
-- ----------------------------
DROP TABLE IF EXISTS `usuario_rol`;
CREATE TABLE `usuario_rol`  (
  `id_usuario` int(11) NOT NULL,
  `id_rol` int(12) NOT NULL,
  PRIMARY KEY (`id_usuario`, `id_rol`) USING BTREE,
  INDEX `fk_rol`(`id_rol`) USING BTREE,
  CONSTRAINT `fk_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of usuario_rol
-- ----------------------------
INSERT INTO `usuario_rol` VALUES (1, 1);
INSERT INTO `usuario_rol` VALUES (1, 2);
INSERT INTO `usuario_rol` VALUES (1, 3);
INSERT INTO `usuario_rol` VALUES (2, 2);
INSERT INTO `usuario_rol` VALUES (3, 2);
INSERT INTO `usuario_rol` VALUES (3, 3);
INSERT INTO `usuario_rol` VALUES (4, 3);
INSERT INTO `usuario_rol` VALUES (6, 2);
INSERT INTO `usuario_rol` VALUES (6, 3);

SET FOREIGN_KEY_CHECKS = 1;

/*
SQLyog Ultimate v9.02 
MySQL - 8.0.18 : Database - interbrain
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`interbrain` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `interbrain`;

/*Table structure for table `horarios` */

DROP TABLE IF EXISTS `horarios`;

CREATE TABLE `horarios` (
  `horarios` datetime NOT NULL,
  PRIMARY KEY (`horarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `horarios` */

insert  into `horarios`(`horarios`) values ('2020-08-17 13:30:00'),('2020-08-17 15:30:00'),('2020-08-17 17:30:00'),('2020-08-17 19:30:00');

/*Table structure for table `obras` */

DROP TABLE IF EXISTS `obras`;

CREATE TABLE `obras` (
  `Nombre_Obra` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Horario_Funcion` datetime DEFAULT NULL,
  `Sala` tinyint(3) NOT NULL,
  `Id` int(4) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Nombre_Obra`),
  UNIQUE KEY `Id` (`Id`),
  KEY `FK_obras` (`Horario_Funcion`),
  CONSTRAINT `FK_obras` FOREIGN KEY (`Horario_Funcion`) REFERENCES `horarios` (`horarios`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `obras` */

insert  into `obras`(`Nombre_Obra`,`Horario_Funcion`,`Sala`,`Id`) values ('El Principito','2020-08-17 17:30:00',65,2),('La bella y la Bestia','2020-08-17 13:30:00',23,1),('Les Miserables','2020-08-17 19:30:00',12,3),('Mario Bros',NULL,22,4);

/*Table structure for table `reserva` */

DROP TABLE IF EXISTS `reserva`;

CREATE TABLE `reserva` (
  `Dni` int(11) NOT NULL,
  `Nombre_Obra` char(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Horario_Funcion` datetime NOT NULL,
  PRIMARY KEY (`Dni`,`Nombre_Obra`),
  UNIQUE KEY `FK_reserva` (`Nombre_Obra`,`Dni`),
  CONSTRAINT `FK_reserva` FOREIGN KEY (`Nombre_Obra`) REFERENCES `obras` (`Nombre_Obra`),
  CONSTRAINT `FK_reserva1` FOREIGN KEY (`Dni`) REFERENCES `usuario` (`Dni`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `reserva` */

/*Table structure for table `usuario` */

DROP TABLE IF EXISTS `usuario`;

CREATE TABLE `usuario` (
  `Nombre` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Apellido` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Dni` int(11) NOT NULL,
  PRIMARY KEY (`Dni`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `usuario` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

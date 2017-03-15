/*
SQLyog Community v12.3.2 (64 bit)
MySQL - 10.1.16-MariaDB : Database - clientes
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`clientes` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `clientes`;

/*Table structure for table `correos_usuarios` */

DROP TABLE IF EXISTS `correos_usuarios`;

CREATE TABLE `correos_usuarios` (
  `id_usuario` int(11) NOT NULL,
  `correo_electronico` varchar(60) NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `correos_usuarios_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `correos_usuarios` */

insert  into `correos_usuarios`(`id_usuario`,`correo_electronico`) values 
(6,'stivenherrera@gmail.com'),
(7,'iasuarez5@misena.edu.co'),
(8,'thrasher7000@gmail.com'),
(9,'thrasher7000@gmail.com');

/*Table structure for table `informacion_clientes` */

DROP TABLE IF EXISTS `informacion_clientes`;

CREATE TABLE `informacion_clientes` (
  `id_usuario` int(11) NOT NULL,
  `nombre_apellidos` varchar(50) NOT NULL,
  `telefono` varchar(30) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  PRIMARY KEY (`id_usuario`),
  CONSTRAINT `informacion_clientes_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `informacion_clientes` */

insert  into `informacion_clientes`(`id_usuario`,`nombre_apellidos`,`telefono`,`direccion`,`fecha_nacimiento`) values 
(6,'Stiven Herrera','3125532846','cr 82 f # 73 f - 84 sur','1998-02-23'),
(7,'Ieshua Ramirez','333333333','cccccccccc','2017-01-01'),
(8,'Miguel','6546132','sadasdsa','1999-07-12'),
(9,'asdsad','65468','asdsad','2017-02-06');

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id_usuario` int(2) NOT NULL AUTO_INCREMENT,
  `tipo_usuario` int(2) DEFAULT NULL,
  `informacion_usuario` int(2) DEFAULT NULL,
  `numero_cedula` varchar(50) DEFAULT NULL,
  `clave` varchar(180) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id_usuario`,`tipo_usuario`,`informacion_usuario`,`numero_cedula`,`clave`) values 
(6,1,NULL,'1019141237','1234'),
(7,2,NULL,'1234567890','fgc9n9d1'),
(8,2,NULL,'213213','bav4mjcm'),
(9,2,NULL,'13212131','A6U5C7H7R0Y1Q0Q5R0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

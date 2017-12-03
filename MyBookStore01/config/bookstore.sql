/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.5.45 : Database - bookstore
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore`;

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `price` double(11,2) NOT NULL,
  `sales` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `img_path` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`id`,`title`,`author`,`price`,`sales`,`stock`,`img_path`) values (1,'解忧杂货店','东野圭吾',27.20,101,2,'static/img/default.jpg'),(2,'边城','沈从文',23.00,103,97,'static/img/default.jpg'),(3,'中国哲学史','冯友兰',44.50,101,99,'static/img/default.jpg'),(4,'忽然七日',' 劳伦',19.33,102,98,'static/img/default.jpg'),(5,'苏东坡传','林语堂',19.30,100,100,'static/img/default.jpg'),(6,'百年孤独','马尔克斯',29.50,100,100,'static/img/default.jpg'),(7,'扶桑','严歌苓',19.80,100,100,'static/img/default.jpg'),(8,'给孩子的诗','北岛',22.20,100,100,'static/img/default.jpg'),(9,'为奴十二年','所罗门',16.50,100,100,'static/img/default.jpg'),(10,'平凡的世界','路遥',55.00,100,100,'static/img/default.jpg'),(11,'悟空传','今何在',14.00,100,100,'static/img/default.jpg'),(12,'硬派健身','斌卡',31.20,100,100,'static/img/default.jpg'),(13,'从晚清到民国','唐德刚',39.90,100,100,'static/img/default.jpg'),(14,'三体','刘慈欣',56.50,100,100,'static/img/default.jpg'),(15,'看见','柴静',19.50,100,100,'static/img/default.jpg'),(16,'活着','余华',11.00,100,100,'static/img/default.jpg'),(17,'小王子','安托万',19.20,100,100,'static/img/default.jpg'),(18,'我们仨','杨绛',11.30,100,100,'static/img/default.jpg'),(19,'生命不息,折腾不止','罗永浩',25.20,100,100,'static/img/default.jpg'),(20,'皮囊','蔡崇达',23.90,100,100,'static/img/default.jpg'),(21,'恰到好处的幸福','毕淑敏',16.40,100,100,'static/img/default.jpg'),(22,'大数据预测','埃里克',37.20,100,100,'static/img/default.jpg'),(23,'人月神话','布鲁克斯',55.90,100,100,'static/img/default.jpg'),(24,'C语言入门经典','霍尔顿',45.00,100,100,'static/img/default.jpg'),(25,'数学之美','吴军',29.90,100,100,'static/img/default.jpg'),(26,'Java编程思想','埃史尔',70.50,100,100,'static/img/default.jpg'),(27,'设计模式之禅','秦小波',20.20,100,100,'static/img/default.jpg'),(28,'图解机器学习','杉山将',33.80,100,100,'static/img/default.jpg'),(29,'艾伦图灵传','安德鲁',47.20,100,100,'static/img/default.jpg'),(30,'教父','马里奥普佐',29.00,100,100,'static/img/default.jpg');

/*Table structure for table `order_items` */

DROP TABLE IF EXISTS `order_items`;

CREATE TABLE `order_items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `COUNT` int(11) NOT NULL,
  `amount` double(11,2) NOT NULL,
  `title` varchar(100) NOT NULL,
  `author` varchar(100) NOT NULL,
  `price` double(11,2) NOT NULL,
  `img_path` varchar(100) NOT NULL,
  `order_id` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `order_items_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `order_items` */

insert  into `order_items`(`id`,`COUNT`,`amount`,`title`,`author`,`price`,`img_path`,`order_id`) values (1,1,44.50,'中国哲学史','冯友兰',44.50,'/static/img/default.jpg','1512265491007-1'),(2,3,69.00,'边城','沈从文',23.00,'/static/img/default.jpg','1512265491007-1'),(3,1,27.20,'解忧杂货店','东野圭吾',27.20,'/static/img/default.jpg','1512265491007-1'),(4,2,38.66,'忽然七日',' 劳伦',19.33,'/static/img/default.jpg','1512265491007-1');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `id` varchar(100) NOT NULL,
  `order_time` datetime NOT NULL,
  `total_count` int(11) NOT NULL,
  `total_amount` double(11,2) NOT NULL,
  `state` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`id`,`order_time`,`total_count`,`total_amount`,`state`,`user_id`) values ('1512265491007-1','2017-12-03 09:44:51',7,179.36,0,1);

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `PASSWORD` varchar(100) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`id`,`username`,`PASSWORD`,`email`) values (1,'admin','123','12345678@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

CREATE TABLE IF NOT EXISTS `factory`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `status` int not null DEFAULT 0,
   `comment` varchar(100),
   `telephone` varchar(100),
   `address` varchar(255),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
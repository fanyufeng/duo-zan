CREATE TABLE IF NOT EXISTS `advertiser`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `comment` VARCHAR(100),
   `address` varchar (100),
   `status` int not null DEFAULT 0,
   `telephone` VARCHAR(100),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
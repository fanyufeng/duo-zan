CREATE TABLE IF NOT EXISTS `withdraw`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `bank_card` VARCHAR(100),
   `alipay` varchar(100),
   `pay` double,
   `comment` varchar(100),
   `user_id` int,
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
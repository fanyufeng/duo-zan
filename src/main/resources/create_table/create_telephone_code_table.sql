CREATE TABLE IF NOT EXISTS `telephone_code`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `telephone` VARCHAR(100),
   `code` varchar(100),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
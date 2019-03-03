CREATE TABLE IF NOT EXISTS `advertise`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `advertise_detail` text,
   `first_title` varchar(100),
   `second_title` varchar(100),
   `head_url` varchar(100),
   `comment` VARCHAR(100),
   `status` int not null DEFAULT 0,
   `advertise_url` VARCHAR(100),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
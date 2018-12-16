CREATE TABLE IF NOT EXISTS `advertise`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `advertiser_id` int,
   `comment` VARCHAR(100),
   `status` int not null DEFAULT 0,
   `advertise_url` VARCHAR(100),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
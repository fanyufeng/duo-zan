drop table user;
CREATE TABLE IF NOT EXISTS `manager`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `telephone` VARCHAR(40),
   `password` varchar(255),
   `status` int not null DEFAULT 0,
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
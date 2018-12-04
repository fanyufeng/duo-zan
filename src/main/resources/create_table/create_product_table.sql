CREATE TABLE IF NOT EXISTS `product`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `status` int not null DEFAULT 0,
   `comment` varchar(100),
   `factory_id` int,
   `create_time` DATE,
   `modify_time` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
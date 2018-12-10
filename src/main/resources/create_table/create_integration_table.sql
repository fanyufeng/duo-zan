CREATE TABLE IF NOT EXISTS `integration`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `user_id` VARCHAR(100) comment '交易人id',
   `integration_elem` int not null DEFAULT 0 comment '交易积分值',
   `comment` VARCHAR(100) '备注',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
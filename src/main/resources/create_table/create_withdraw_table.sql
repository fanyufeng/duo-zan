CREATE TABLE IF NOT EXISTS `withdraw`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `bank_card` VARCHAR(100),
   `alipay` varchar(100),
   `pay` double,
   `status` int not null DEFAULT 0 comment '0 表示已申请，1表示已提现',
   `comment` varchar(100),
   `user_id` int,
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
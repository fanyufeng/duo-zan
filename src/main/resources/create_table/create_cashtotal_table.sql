CREATE TABLE IF NOT EXISTS `cash_total`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `cash_total` double comment '金额总量',
   `comment` varchar(100) comment '备注',
   `user_id` varchar(100) comment '上传人',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
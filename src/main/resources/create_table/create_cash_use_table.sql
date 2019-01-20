CREATE TABLE IF NOT EXISTS `cash_use`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `cash_total_id` int not null DEFAULT 0 comment '分配批次id',
   `cash_num` double  comment '积分金额',
   `status` int not null DEFAULT 0 comment '使用标志位',
   `user_id` int not null DEFAULT 0 comment '使用人id',
   `comment` varchar(100) comment '使用记录',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
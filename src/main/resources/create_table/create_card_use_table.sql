CREATE TABLE IF NOT EXISTS `card_use`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `card_id` int not null DEFAULT 0 comment '卡券id',
   `integration_num` int not null DEFAULT 0 comment '积分金额',
   `num` int not null DEFAULT 0 comment '使用的次数',
   `status` int not null DEFAULT 0 comment '使用标志位',
   `user_id` int not null DEFAULT 0 comment '使用人id',
   `comment` varchar(100) comment '使用记录',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
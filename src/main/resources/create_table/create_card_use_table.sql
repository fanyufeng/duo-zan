CREATE TABLE IF NOT EXISTS `card_use`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `card_id` int not null DEFAULT 0 comment '卡券id',
   `num` int not null DEFAULT 0 comment '使用的次数',
   `status` int not null DEFAULT 0 comment '使用标志位',
   `user_id` int not null DEFAULT 0 comment '使用人id',
   `create_time` DATE,
   `modify_time` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
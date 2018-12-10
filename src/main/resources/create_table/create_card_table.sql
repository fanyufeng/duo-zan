CREATE TABLE IF NOT EXISTS `card`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `product_id` INT comment '产品id',
   `advertise_id` int comment '广告商id',
   `integration_num` int not null DEFAULT 0 comment '积分金额',
   `times` int not null DEFAULT 0 comment '卡券使用次数',
   `unique_id` varchar(100),
   `status` int default 0 comment '0 表示正常，1表示禁用',
   `comment` varchar(100) comment '备注',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE IF NOT EXISTS `cash`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `user_id` VARCHAR(100) comment '交易人id',
   `integration_elem` int,
   `proportion` double,
   `cash_elem` double comment '交易金额',
   `comment` VARCHAR(100) comment '备注',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
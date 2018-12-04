CREATE TABLE IF NOT EXISTS `cash`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `user_id` VARCHAR(100) '交易人id',
   `cash_elem` double not null DEFAULT 0 comment '交易金额',
   `comment` VARCHAR(100) '备注',
   `create_time` DATE,
   `modify_time` DATE,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
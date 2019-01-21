CREATE TABLE IF NOT EXISTS `cash_total`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `cash_total` double comment '金额总量',
   `name` varchar(100) comment '分配名称',
   `comment` varchar(100) comment '备注',
   `status` int default 0 comment '0 表示正常，1表示已分配完',
   `user_id` varchar(100) comment '上传人',
   `deadline` timestamp comment '截止时间',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
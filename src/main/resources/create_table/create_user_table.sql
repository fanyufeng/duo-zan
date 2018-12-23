drop table user;
CREATE TABLE IF NOT EXISTS `user`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `unionid` VARCHAR(100) comment '微信唯一识别标识',
   `openid` VARCHAR(100) comment '微信识别标识',
   `avatar_url` VARCHAR(255) comment '头像地址',
   `gender` VARCHAR(40),
   `telephone` VARCHAR(40),
   `nick_name` VARCHAR(100),
   `session_key` VARCHAR(100),
   `integration` int not null DEFAULT 0,
   `cash` DOUBLE not null DEFAULT 0.0,
   `status` int not null DEFAULT 0,
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
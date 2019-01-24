CREATE TABLE IF NOT EXISTS `file`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `name` VARCHAR(100),
   `status` int not null DEFAULT 0,
   `comment` varchar(100),
   `advertiser_id` int,
   `file_imgUrl` varchar(100),
   `file_videoUrl` varchar(100),
   `imOrVi` int not null DEFAULT 0 comment '1表示图片，2表示视频',
   `link` varchar(100),
   `category` int not null default 0 comment '1表示banner，2表示launch，3表示checkin',
   `frequency` int not null default 0 comment '播放次数',
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
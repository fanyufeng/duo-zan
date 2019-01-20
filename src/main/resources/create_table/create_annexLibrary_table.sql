CREATE TABLE IF NOT EXISTS `annexLibrary`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `manager_name` VARCHAR(100),
   `manager_id` int,
   `category` int not null default 0 comment '0表示扫码文件，1表示banner文件，2表示开机文件，3标签签到文件',
   `choose_status` int not null default 0 comment '0表示为现实，1表示显示',
   `file_name` varchar(100),
   `file_path` varchar(100),
   `status` int,
   `card_id` int,
   `url` varchar(100),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
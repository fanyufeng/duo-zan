CREATE TABLE IF NOT EXISTS `annexLibrary`(
   `id` INT UNSIGNED AUTO_INCREMENT,
   `manager_name` VARCHAR(100),
   `manager_id` int,
   `file_name` varchar(100),
   `file_path` varchar(100),
   `status` int,
   `card_id` int,
   `url` varchar(100),
   `create_time` DATETIME,
   `modify_time` DATETIME,
   PRIMARY KEY ( `id` )
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
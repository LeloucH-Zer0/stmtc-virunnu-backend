CREATE schema virunnu;
USE virunnu;
CREATE TABLE `virunnu`.`food` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(100) NULL,
  `type` INT NULL,
  `count` INT NULL,
  `status` TINYINT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `item_name_UNIQUE` (`item_name` ASC) VISIBLE,
  INDEX `status` (`status` ASC) VISIBLE);

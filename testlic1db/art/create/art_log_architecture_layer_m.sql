DROP TABLE IF EXISTS `art_log_architecture_layer_m`;

CREATE TABLE `art_log_architecture_layer_m` (`id` VARCHAR (64) NOT NULL, `log_config_id` VARCHAR(64) DEFAULT NULL, `layer_id` INT (11) NOT NULL, `layer` VARCHAR (256) NOT NULL, `version_id` INT (11) DEFAULT NULL, `created_by` varchar (64) DEFAULT NULL, `created_date` TIMESTAMP NULL DEFAULT NULL, `updated_by` varchar (64) DEFAULT NULL, `updated_date` DATETIME DEFAULT NULL, `active_status` TINYINT (1) DEFAULT NULL, PRIMARY KEY (`id`));


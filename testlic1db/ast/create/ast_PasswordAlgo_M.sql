DROP TABLE IF EXISTS `ast_PasswordAlgo_M`;

CREATE TABLE `ast_PasswordAlgo_M` ( `algoId` VARCHAR(64) NOT NULL, `algorithm` INT(11) NOT NULL, `algoName` VARCHAR(256) NOT NULL, `algoDescription` VARCHAR(256) NULL DEFAULT NULL, `algoIcon` VARCHAR(64) NULL DEFAULT NULL, `algoHelp` VARCHAR(256) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(11) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(11) NULL DEFAULT NULL, PRIMARY KEY (`algoId`));

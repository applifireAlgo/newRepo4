DROP TABLE IF EXISTS `ast_City_M`;

CREATE TABLE `ast_City_M` ( `cityId` VARCHAR(64) NOT NULL, `countryId` VARCHAR(64) NOT NULL, `stateId` VARCHAR(64) NOT NULL, `cityName` VARCHAR(256) NOT NULL, `cityCodeChar2` VARCHAR(32) NOT NULL, `cityCode` INT(3) NOT NULL, `cityDescription` VARCHAR(128) NULL DEFAULT NULL, `cityFlag` VARCHAR(128) NULL DEFAULT NULL, `cityLatitude` INT(11) NULL DEFAULT NULL, `cityLongitude` INT(11) NULL DEFAULT NULL, `createdBy` VARCHAR(64) NULL DEFAULT '-1', `createdDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `updatedBy` VARCHAR(64) NULL DEFAULT '-1', `updatedDate` TIMESTAMP NULL DEFAULT '2000-01-01 10:10:10', `versionId` INT(10) NULL DEFAULT '-1', `activeStatus` INT(1) NULL DEFAULT '1', `txnAccessCode` INT(10) NULL DEFAULT NULL, PRIMARY KEY (`cityId`));

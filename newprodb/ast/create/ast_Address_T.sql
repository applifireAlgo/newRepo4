CREATE TABLE ast_Address_T ( addressId VARCHAR2(64)  NOT NULL, addressTypeId VARCHAR2(64)  NOT NULL, addressLabel VARCHAR2(11)  DEFAULT NULL, address1 VARCHAR2(256)  DEFAULT NULL, address2 VARCHAR2(256)  DEFAULT NULL, address3 VARCHAR2(256)  DEFAULT NULL, countryId VARCHAR2(64)  NOT NULL, stateId VARCHAR2(64)  NOT NULL, cityId VARCHAR2(64)  NOT NULL, zipcode VARCHAR2(6)  NOT NULL, latitude VARCHAR2(64)  DEFAULT NULL, longitude VARCHAR2(64)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (addressId));

exit;
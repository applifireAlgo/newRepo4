CREATE TABLE ast_Item_T ( itemId VARCHAR2(256)  NOT NULL, itemname VARCHAR2(256)  NOT NULL, brandnm VARCHAR2(256)  NOT NULL, categorynm VARCHAR2(256)  NOT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (itemId));

exit;
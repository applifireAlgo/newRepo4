CREATE TABLE ast_Brand_M ( brandcode VARCHAR2(64)  NOT NULL, branddesc VARCHAR2(64)  NOT NULL, categoryId VARCHAR2(64)  NOT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (brandcode));

exit;
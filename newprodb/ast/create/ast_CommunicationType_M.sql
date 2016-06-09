CREATE TABLE ast_CommunicationType_M ( commType VARCHAR2(64)  NOT NULL, commTypeName VARCHAR2(128)  NOT NULL, commTypeDescription VARCHAR2(256)  DEFAULT NULL, commGroupId VARCHAR2(64)  NOT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (commType));

exit;
CREATE TABLE ast_Login_T ( loginPk VARCHAR2(64)  NOT NULL, loginId VARCHAR2(200)  NOT NULL, serverAuthImage VARCHAR2(64)  DEFAULT NULL, serverAuthText VARCHAR2(32)  DEFAULT NULL, userId VARCHAR2(64)  NOT NULL, contactId VARCHAR2(64)  NOT NULL, failedLoginAttempts NUMBER(11)  DEFAULT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (loginPk));

exit;
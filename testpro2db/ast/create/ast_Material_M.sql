CREATE TABLE ast_Material_M ( materialcode VARCHAR2(64)  NOT NULL, materialdesc VARCHAR2(64)  NOT NULL, brandcode VARCHAR2(64)  NOT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (materialcode));

exit;
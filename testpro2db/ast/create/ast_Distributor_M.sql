CREATE TABLE ast_Distributor_M ( distributorcode VARCHAR2(64)  NOT NULL, distributorname VARCHAR2(64)  NOT NULL, regioncode VARCHAR2(64)  NOT NULL, longitude BINARY_DOUBLE  NOT NULL, lattitude BINARY_DOUBLE  NOT NULL, createdBy VARCHAR2(64)  DEFAULT '-1', createdDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', updatedBy VARCHAR2(64)  DEFAULT '-1', updatedDate TIMESTAMP  DEFAULT '01-Jan-2000 10:10:10', versionId NUMBER(11)  DEFAULT '-1', activeStatus NUMBER(1)  DEFAULT '1', txnAccessCode NUMBER  DEFAULT NULL, PRIMARY KEY (distributorcode));

exit;
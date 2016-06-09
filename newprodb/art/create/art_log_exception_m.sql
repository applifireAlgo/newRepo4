CREATE TABLE art_log_exception_m (id varchar2 (64) NOT NULL, logConfigId varchar2(64) DEFAULT NULL, exceptionId NUMBER (11) NOT NULL, exception varchar2 (256) NOT NULL, rootException varchar2 (256) NOT NULL, exceptionName varchar2 (256) NOT NULL, versionId NUMBER (11) DEFAULT NULL, createdBy varchar2 (64) DEFAULT NULL, createdDate TIMESTAMP (0) DEFAULT NULL, updatedBy varchar2 (64) DEFAULT NULL, updatedDate TIMESTAMP (0) DEFAULT NULL, activeStatus NUMBER (1) DEFAULT NULL, PRIMARY KEY (id));

exit


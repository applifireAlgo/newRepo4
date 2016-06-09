CREATE TABLE art_log_config_m ( logConfigId varchar2(64) NOT NULL, configData clob, versionId NUMBER(10) DEFAULT NULL, createdBy varchar2(64) DEFAULT NULL, createdDate TIMESTAMP(0) DEFAULT NULL, updatedBy varchar2(64) DEFAULT NULL, updatedDate TIMESTAMP(0) DEFAULT NULL, activeStatus NUMBER(3) DEFAULT NULL, PRIMARY KEY (logConfigId) );

exit


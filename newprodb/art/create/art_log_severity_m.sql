CREATE TABLE art_log_severity_m ( severityId varchar2(64) NOT NULL, logConfigId varchar2(64) DEFAULT NULL, severity NUMBER(10) NOT NULL, label VARCHAR2(256) NOT NULL, versionId NUMBER(10) DEFAULT NULL, createdBy NUMBER(10) DEFAULT NULL, createdDate TIMESTAMP(0) DEFAULT NULL NULL, updatedBy NUMBER(10) DEFAULT NULL, updatedDate TIMESTAMP(0) DEFAULT NULL, activeStatus NUMBER(3) DEFAULT NULL, PRIMARY KEY (severityId) ) ;

exit


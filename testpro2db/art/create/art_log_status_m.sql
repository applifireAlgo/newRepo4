CREATE TABLE art_log_status_m (id varchar2 (64) NOT NULL, logConfigId varchar2(64) DEFAULT NULL, statusId NUMBER (11) NOT NULL, status varchar2 (256) NOT NULL, versionId NUMBER (11) DEFAULT NULL, createdBy varchar2 (64) DEFAULT NULL, createdDate TIMESTAMP(0) DEFAULT NULL, updatedBy varchar2 (64) DEFAULT NULL, updatedDate TIMESTAMP (0) DEFAULT NULL, activeStatus NUMBER (1) DEFAULT NULL, PRIMARY KEY (id));

exit


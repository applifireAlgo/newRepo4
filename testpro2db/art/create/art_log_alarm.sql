CREATE TABLE art_log_alarm (loggerPkId varchar2(256) NOT NULL, alarmType NUMBER(10) NOT NULL, alarmData CLOB, alarmVersion NUMBER(10) NOT NULL, created_by varchar2(64) DEFAULT '-1', created_date TIMESTAMP (0) DEFAULT NULL, updated_by varchar2(64) DEFAULT '-1', updated_date TIMESTAMP (0) DEFAULT NULL, version_id NUMBER(11) DEFAULT '-1', active_status NUMBER(1) DEFAULT '1', PRIMARY KEY (loggerPkId));

exit


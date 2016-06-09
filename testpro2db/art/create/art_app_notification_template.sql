CREATE TABLE art_app_notification_template(template_id VARCHAR2(64) NOT NULL, template_name VARCHAR2(256) NOT NULL, template clob, notification_type NUMBER(11) NOT NULL, created_by VARCHAR2(64) DEFAULT '-1', created_date TIMESTAMP(0) DEFAULT NULL, updated_by VARCHAR2(64) DEFAULT '-1', updated_date TIMESTAMP(0) DEFAULT NULL, active_status NUMBER(3) DEFAULT NULL, version_id NUMBER(11) DEFAULT NULL, PRIMARY KEY(template_id) ) ;

exit


CREATE TABLE art_log_architecture_layer_m (id varchar2 (64) NOT NULL, logConfigId varchar2(64) DEFAULT NULL, layerId NUMBER (11) NOT NULL, layer varchar2 (256) NOT NULL, versionId NUMBER (11) DEFAULT NULL, createdBy varchar2 (64) DEFAULT NULL, createdDate TIMESTAMP (0) DEFAULT NULL, updatedBy varchar2 (64) DEFAULT NULL, updatedDate TIMESTAMP (0) DEFAULT NULL, activeStatus NUMBER (10) DEFAULT NULL, PRIMARY KEY (id));

exit


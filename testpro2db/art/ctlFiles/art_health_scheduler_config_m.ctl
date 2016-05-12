load data infile '/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/data/art_health_scheduler_config_m.csv' "str '#appfirenewline#'" into table art_health_scheduler_config_m FIELDS TERMINATED BY '#appfire#' (schedulerId,schedulerkey,refreshTime,refreshUnit,batchSize,enabled,connectorClass,dataModel,schedulerName,threadPoolSize,version_id,created_by,
created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',active_status)


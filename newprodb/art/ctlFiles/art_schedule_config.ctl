load data infile '/tmp/applifire/db/JUOHQ8X5NQR9QK1Q97LHHG/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/data/art_schedule_config.csv' "str '#appfirenewline#'" into table art_schedule_config FIELDS TERMINATED BY '#appfire#' (schedule_id,schedule_name,schedule_job,scheduler_expression,schedule_strategy,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)


load data infile '/tmp/applifire/db/JUOHQ8X5NQR9QK1Q97LHHG/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/data/art_scheduler_details.csv' "str '#appfirenewline#'" into table art_scheduler_details FIELDS TERMINATED BY '#appfire#' (schedulerId,schedulerExpression,jobId,project_id,app_creator_id,project_version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,version_id,active_status)

load data infile '$ART_DATA_PATH/art_app_alarm.csv' "str '#appfirenewline#'" into table art_app_alarm FIELDS TERMINATED BY '#appfire#' (id,alarm_id,severity,connector_order_id,message,diagnose,solution,log_module_id,version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',active_status)


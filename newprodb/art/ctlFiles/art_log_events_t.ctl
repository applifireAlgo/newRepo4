load data infile '$ART_DATA_PATH/art_log_events_t.csv' "str '#appfirenewline#'" into table art_log_events_t FIELDS TERMINATED BY '#appfire#' ( event_id,customer_id,app_name,time_stamp TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',alarm_id,severity,user_id,ip_address,module,class_name,method_name,message,throwable_message CHAR(50000) NULLIF throwable_message = '\\N')

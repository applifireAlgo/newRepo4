load data infile '$ART_DATA_PATH/art_database_aggregate.csv' "str '#appfirenewline#'" into table art_database_aggregate FIELDS TERMINATED BY '#appfire#' (id,name,json,active_status,version_id,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updated_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',created_by)


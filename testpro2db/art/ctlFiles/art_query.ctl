load data infile '/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/data/art_query.csv' "str '#appfirenewline#'" into table art_query FIELDS TERMINATED BY '#appfire#' (query_id,jpql_query char(50000),query_type,query_json char(50000),name,hidden_name,app_creator_id,project_id,project_version_id,created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',version_id,active_status,sql_query)


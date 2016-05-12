load data infile '/tmp/applifire/db/JUOHQ8X5NQR9QK1Q97LHHG/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/data/art_lang_master.csv' "str '#appfirenewline#'" into table art_lang_master FIELDS TERMINATED BY '#appfire#' (lang_id,lang_name,country_code,country_name,updated_by,updated_date DATE 'yyyy-mm-dd hh24:mi:ss',created_by,created_date DATE 'yyyy-mm-dd hh24:mi:ss',version_id,active_status)


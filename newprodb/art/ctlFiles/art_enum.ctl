load data infile '$ART_DATA_PATH/art_enum.csv' "str '#appfirenewline#'" into table art_enum FIELDS TERMINATED BY '#appfire#' (enum_id,enum_code,enum_desc)


load data infile '/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/data/art_log_exception_m.csv' "str '#appfirenewline#'" into table art_log_exception_m FIELDS TERMINATED BY '#appfire#' (id, logConfigId, exceptionId, exception, rootException, exceptionName, versionId,createdBy,createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',updatedBy,updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',activeStatus)

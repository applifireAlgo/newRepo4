load data infile '/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/data/art_password_policy.csv' "str '#appfirenewline#'" into table art_password_policy FIELDS TERMINATED BY '#appfire#' (policyId,policyName,policyDescription,minPwdLength,maxPwdLength,minCapitalLetters,minSmallLetters,minNumericValues,minSpecialLetters,allowedSpecialLetters
,version_id,updated_by,updated_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"',created_by,created_date TIMESTAMP 'yyyy-mm-dd hh24:mi:ss".0"')


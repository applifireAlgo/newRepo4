load data infile '/tmp/applifire/db/JUOHQ8X5NQR9QK1Q97LHHG/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/ast/data/ast_PasswordPolicy_M.csv' APPEND into table ast_PasswordPolicy_M FIELDS TERMINATED BY '#appfire#' (policyId,policyName,policyDescription CHAR(1000) "decode(:policyDescription, '\\N', null, :policyDescription)",maxPwdLength CHAR(1000) "decode(:maxPwdLength, '\\N', null, :maxPwdLength)",minPwdLength,minCapitalLetters CHAR(1000) "decode(:minCapitalLetters, '\\N', null, :minCapitalLetters)",minSmallLetters CHAR(1000) "decode(:minSmallLetters, '\\N', null, :minSmallLetters)",minNumericValues CHAR(1000) "decode(:minNumericValues, '\\N', null, :minNumericValues)",minSpecialLetters CHAR(1000) "decode(:minSpecialLetters, '\\N', null, :minSpecialLetters)",allowedSpecialLetters CHAR(1000) "decode(:allowedSpecialLetters, '\\N', null, :allowedSpecialLetters)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")


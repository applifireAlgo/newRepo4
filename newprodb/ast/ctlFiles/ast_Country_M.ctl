load data infile '/tmp/applifire/db/JUOHQ8X5NQR9QK1Q97LHHG/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/ast/data/Country.csv' into table ast_Country_M FIELDS TERMINATED BY '#appfire#' (countryId,countryName,countryCode1 CHAR(1000) "decode(:countryCode1, '\\N', null, :countryCode1)",countryCode2 CHAR(1000) "decode(:countryCode2, '\\N', null, :countryCode2)",countryFlag CHAR(1000) "decode(:countryFlag, '\\N', null, :countryFlag)",capital CHAR(1000) "decode(:capital, '\\N', null, :capital)",currencyCode CHAR(1000) "decode(:currencyCode, '\\N', null, :currencyCode)",currencyName CHAR(1000) "decode(:currencyName, '\\N', null, :currencyName)",currencySymbol CHAR(1000) "decode(:currencySymbol, '\\N', null, :currencySymbol)",capitalLatitude CHAR(1000) "decode(:capitalLatitude, '\\N', null, :capitalLatitude)",capitalLongitude CHAR(1000) "decode(:capitalLongitude, '\\N', null, :capitalLongitude)",isoNumeric CHAR(1000) "decode(:isoNumeric, '\\N', null, :isoNumeric)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")


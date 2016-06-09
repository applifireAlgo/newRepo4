load data infile '/tmp/applifire/db/JUOHQ8X5NQR9QK1Q97LHHG/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/ast/data/ContactType.csv' into table ast_ContactType_M FIELDS TERMINATED BY '#appfire#' (contactTypeId,contactType,contactTypeDesc CHAR(1000) "decode(:contactTypeDesc, '\\N', null, :contactTypeDesc)",contactTypeIcon CHAR(1000) "decode(:contactTypeIcon, '\\N', null, :contactTypeIcon)",createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")


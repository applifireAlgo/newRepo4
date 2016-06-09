load data infile '/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/ast/data/ast_AppMenus_M.csv' APPEND into table ast_AppMenus_M FIELDS TERMINATED BY '#appfire#' (menuId,menuTreeId,menuIcon CHAR(1000) "decode(:menuIcon, '\\N', null, :menuIcon)",menuAction CHAR(1000) "decode(:menuAction, '\\N', null, :menuAction)",menuCommands CHAR(1000) "decode(:menuCommands, '\\N', null, :menuCommands)",menuDisplay,menuHead,menuLabel,uiType CHAR(1000) "decode(:uiType, '\\N', null, :uiType)",RefObjectId CHAR(1000) "decode(:RefObjectId, '\\N', null, :RefObjectId)",menuAccessRights,appType CHAR(1000) "decode(:appType, '\\N', null, :appType)",appId CHAR(1000) "decode(:appId, '\\N', null, :appId)",autoSave,createdBy CHAR(1000) "decode(:createdBy, '\\N', null, :createdBy)",createdDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',updatedBy CHAR(1000) "decode(:updatedBy, '\\N', null, :updatedBy)",updatedDate TIMESTAMP 'yyyy-mm-dd hh24:mi:ss',versionId CHAR(1000) "decode(:versionId, '\\N', null, :versionId)",activeStatus CHAR(1000) "decode(:activeStatus, '\\N', null, :activeStatus)",txnAccessCode CHAR(1000) "decode(:txnAccessCode, '\\N', null, :txnAccessCode)")


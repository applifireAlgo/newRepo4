

ALTER TABLE ast_UserAccess_M ADD CONSTRAINT fk_548cd974a FOREIGN KEY (region) REFERENCES ast_SalesRegion_M(regioncode);



ALTER TABLE ast_UserAccess_M ADD CONSTRAINT fk_0ae47c620 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
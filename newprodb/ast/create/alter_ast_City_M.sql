

ALTER TABLE ast_City_M ADD CONSTRAINT fk_8d8ebda7c FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_262c0166b FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;
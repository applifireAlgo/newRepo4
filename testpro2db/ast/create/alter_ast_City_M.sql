

ALTER TABLE ast_City_M ADD CONSTRAINT fk_c83da84a5 FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_City_M ADD CONSTRAINT fk_9e57b5449 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;
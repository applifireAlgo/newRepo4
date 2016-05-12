

ALTER TABLE ast_Address_T ADD CONSTRAINT fk_c06e89a0e FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_b641e4a66 FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_d0551a03a FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_16f4e24e6 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;


ALTER TABLE ast_Address_T ADD CONSTRAINT fk_5954d1fcd FOREIGN KEY (countryId) REFERENCES ast_Country_M(countryId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_ac464038c FOREIGN KEY (addressTypeId) REFERENCES ast_AddressType_M(addressTypeId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_bd75aab10 FOREIGN KEY (cityId) REFERENCES ast_City_M(cityId);



ALTER TABLE ast_Address_T ADD CONSTRAINT fk_6738dc1f2 FOREIGN KEY (stateId) REFERENCES ast_State_M(stateId);



exit;
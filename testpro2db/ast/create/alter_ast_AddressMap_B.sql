

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_a59bf77f3 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_8e946978b FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;
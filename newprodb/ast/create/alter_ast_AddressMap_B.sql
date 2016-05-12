

ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_649297e54 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_AddressMap_B ADD CONSTRAINT fk_29df92177 FOREIGN KEY (addressId) REFERENCES ast_Address_T(addressId);



exit;
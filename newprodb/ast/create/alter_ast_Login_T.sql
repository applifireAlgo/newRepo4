

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_e14cfab51 FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_18d41c83a FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
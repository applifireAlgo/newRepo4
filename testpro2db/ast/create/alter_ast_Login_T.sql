

ALTER TABLE ast_Login_T ADD CONSTRAINT fk_486cb17fc FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_Login_T ADD CONSTRAINT fk_fdeb43079 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
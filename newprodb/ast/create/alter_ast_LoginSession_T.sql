

ALTER TABLE ast_LoginSession_T ADD CONSTRAINT fk_d15b09a9c FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
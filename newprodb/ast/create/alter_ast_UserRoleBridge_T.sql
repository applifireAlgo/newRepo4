

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_07dcbecc9 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_54ce41525 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
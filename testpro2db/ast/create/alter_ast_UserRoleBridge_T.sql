

ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_70d70619a FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_UserRoleBridge_T ADD CONSTRAINT fk_262591355 FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
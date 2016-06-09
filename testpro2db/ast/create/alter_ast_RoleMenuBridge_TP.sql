

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_4cf047b49 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_2595b2fb1 FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;
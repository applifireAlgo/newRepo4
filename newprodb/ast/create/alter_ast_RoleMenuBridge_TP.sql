

ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_b6b91d031 FOREIGN KEY (roleId) REFERENCES ast_Roles_T(roleId);



ALTER TABLE ast_RoleMenuBridge_TP ADD CONSTRAINT fk_fe64bd973 FOREIGN KEY (menuId) REFERENCES ast_AppMenus_M(menuId);



exit;
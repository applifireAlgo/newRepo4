

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_ba4e6f5dc FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;
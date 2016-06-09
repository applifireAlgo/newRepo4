

ALTER TABLE ast_UserAppState_T ADD CONSTRAINT fk_ea0683d62 FOREIGN KEY (appSessionId) REFERENCES ast_LoginSession_T(AppSessionId);



exit;
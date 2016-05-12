

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_ecd2ed135 FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_77beac7bf FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
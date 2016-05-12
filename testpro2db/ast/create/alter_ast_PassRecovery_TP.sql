

ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_9910c39cd FOREIGN KEY (questionId) REFERENCES ast_Question_M(questionId);



ALTER TABLE ast_PassRecovery_TP ADD CONSTRAINT fk_1a73bf0ec FOREIGN KEY (userId) REFERENCES ast_User_T(userId);



exit;
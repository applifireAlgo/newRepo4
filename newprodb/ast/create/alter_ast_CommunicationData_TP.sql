

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_48bc5b2bf FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_6d98d07f2 FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;
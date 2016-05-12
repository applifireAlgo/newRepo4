

ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_475180533 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



ALTER TABLE ast_CommunicationData_TP ADD CONSTRAINT fk_a02f27d56 FOREIGN KEY (commType) REFERENCES ast_CommunicationType_M(commType);



exit;
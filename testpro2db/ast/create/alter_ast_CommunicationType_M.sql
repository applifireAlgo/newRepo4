

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_c3888dbd2 FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;
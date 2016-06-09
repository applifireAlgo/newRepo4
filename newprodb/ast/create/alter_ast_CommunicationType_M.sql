

ALTER TABLE ast_CommunicationType_M ADD CONSTRAINT fk_76a48dcca FOREIGN KEY (commGroupId) REFERENCES ast_CommunicationGroup_M(commGroupId);



exit;
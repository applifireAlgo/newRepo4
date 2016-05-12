

ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_14ff171db FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_53b1f1a9c FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;


ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_b9a910aaa FOREIGN KEY (contactId) REFERENCES ast_CoreContacts_T(contactId);



ALTER TABLE ast_CommunicationMap_B ADD CONSTRAINT fk_ceee3ea43 FOREIGN KEY (commDataId) REFERENCES ast_CommunicationData_TP(commDataId);



exit;
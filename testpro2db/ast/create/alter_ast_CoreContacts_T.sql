

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_ecbef862a FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_19235f7b8 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_615f7efab FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_148e53fd8 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;
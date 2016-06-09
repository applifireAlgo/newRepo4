

ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_d0f72d635 FOREIGN KEY (timeZoneId) REFERENCES ast_Timezone_M(timeZoneId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_8a768c368 FOREIGN KEY (genderId) REFERENCES ast_Gender_M(genderId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_fb563333b FOREIGN KEY (titleId) REFERENCES ast_Title_M(titleId);



ALTER TABLE ast_CoreContacts_T ADD CONSTRAINT fk_78b637f46 FOREIGN KEY (nativeLanguageCode) REFERENCES ast_Language_M(languageId);



exit;
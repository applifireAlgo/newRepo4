




ORACLE_HOME=/u01/app/oracle/product/11.2.0/xe
ORACLE_SID=XE
PATH=$PATH:$ORACLE_HOME/bin:$ORACLE_SID
export ORACLE_HOME
export ORACLE_SID
export PATH
DB_PATH=/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0
ART_CREATE_PATH=/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/art/create
AST_CREATE_PATH=/tmp/applifire/db/WO0GMNEJHFAXEJPRCKQRA/93BD41F3-4BEA-4F89-A0C6-2B1FA7A0DCB0/ast/create
APPLFIREUSER=root
APPLFIREPASSWORD=root
APPLFIREHOST=localhost



DB_NAME=pro2
USER=pro2
PASSWORD=pro2
PORT=1521
HOST=localhost


echo 'drop tables starts....'
sqlplus /nolog @$DB_PATH/drop_db.sql;
echo 'drop tables ends....'

echo 'create db starts....'
sqlplus /nolog @$DB_PATH/create_db.sql;
echo 'create db ends....'

echo 'grant previliges to user starts....'
sqlplus /nolog @$DB_PATH/grant_previliges.sql;
echo 'grant previliges to user ends....'

echo 'drop sequence starts....'
sqlplus $USER/$PASSWORD @$DB_PATH/dropSequence.sql;
echo 'drop sequence ends....'

echo 'create ART table process starts...'
sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_query.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_report_ui.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_component_config.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_severity_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_events_t_old.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_chart_json.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_chart_category.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_chart_type.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_chart_data_field_json.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_lang_master.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_chart_properties.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_chart_prop_language.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_chart_template.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_report_builder_details.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_config_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/zen_health.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/zen_health_counter.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/zen_health_gauge.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/zen_health_status.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/zen_request_details.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_loginSession.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_session_data.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_user_last_status.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_password_algorithm.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_password_policy.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_health_scheduler_config_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_health_status_config_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/cloud_drive_file_content_type.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/cloud_drive_tags.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/cloud_drive_files.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/cloud_drive_tags_file.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/cloud_drive_file_versions.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/cloud_drive_tag_shared.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/cloud_drive_file_shared.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_external_integration.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_job_details.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_scheduler_details.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_schedule_config.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_app_notification_template.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_alarm.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_architecture_layer_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_status_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_event_action_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_exception_m.sql;

sqlplus $USER/$PASSWORD @$ART_CREATE_PATH/art_log_events_t.sql;

echo 'create ART table process ends...'

echo 'create AST table process starts...'
sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Timezone_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Language_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Country_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_State_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_City_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_AddressType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Address_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_ContactType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_CommunicationGroup_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_CommunicationType_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Gender_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Title_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_CoreContacts_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_AddressMap_B.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_CommunicationData_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_CommunicationMap_B.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_PasswordAlgo_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_PasswordPolicy_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Question_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_UserAccessLevel_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_UserAccessDomain_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_User_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Login_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_LoginSession_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_UserAppState_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_PassRecovery_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_UserData_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_SessionData_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Roles_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_AppMenus_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_RoleMenuBridge_TP.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_UserRoleBridge_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Channel_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Category_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Brand_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Material_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_SalesRegion_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Distributor_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_Retailer_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_SalesData_T.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_CurrentMonth_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_UserAccess_M.sql; 

sqlplus $USER/$PASSWORD @$AST_CREATE_PATH/ast_TestOne_T.sql; 

echo 'create AST table process ends...'



connect sys/oracle as sysdba
create tablespace pro2 DATAFILE '/u01/app/oracle/oradata/pro2.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='PRO2';
if (userexist = 0) then
execute immediate 'create user pro2 identified by pro2 default tablespace pro2';
end if;
end;
/
ALTER USER "PRO2" DEFAULT TABLESPACE "PRO2" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;
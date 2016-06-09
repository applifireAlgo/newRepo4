
connect sys/oracle as sysdba
create tablespace pro3 DATAFILE '/u01/app/oracle/oradata/pro3.dbf' SIZE 100M EXTENT MANAGEMENT LOCAL AUTOALLOCATE;
declare
userexist integer;
begin
select count(*) into userexist from dba_users where username='PRO3';
if (userexist = 0) then
execute immediate 'create user pro3 identified by pro3 default tablespace pro3';
end if;
end;
/
ALTER USER "PRO3" DEFAULT TABLESPACE "PRO3" TEMPORARY TABLESPACE "TEMP" ACCOUNT UNLOCK ;
exit;
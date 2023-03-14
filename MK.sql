set serveroutput on size 1000000
set feedback off
-- Company, user group and user export
-- Generated 2023.01.28 23:54:45 by MK
-- This script can be run in sqlplus as the owner of the Oracle flows engine.
begin
   wwv_flow_security.g_security_group_id := 721422533292396;
end;
/
----------------
-- W O R K S P A C E
-- Creating a workspace will not create database schemas or objects.
-- This API will cause only meta data inserts.
prompt  Creating workspace MK...
begin
wwv_flow_fnd_user_api.create_company (
  p_id                      => 721703542292403,
  p_provisioning_company_id => 721422533292396,
  p_short_name              => 'MK',
  p_first_schema_provisioned=> 'MK',
  p_company_schemas         => 'MK');
end;
/
----------------
-- G R O U P S
--
prompt  Creating Groups...
----------------
-- U S E R S
-- User repository for use with flows cookie based authenticaion.
--
prompt  Creating Users...
begin
wwv_flow_fnd_user_api.create_fnd_user (
  p_user_id      => '721613002292396',
  p_user_name    => 'MK',
  p_first_name   => '',
  p_last_name    => '',
  p_description  => '',
  p_email_address=> '',
  p_web_password => '202CB962AC59075B964B07152D234B70',
  p_web_password_format => 'HEX_ENCODED_DIGEST',
  p_group_ids    => '',
  p_developer_privs=> 'ADMIN:CREATE:DATA_LOADER:EDIT:HELP:MONITOR:SQL',
  p_default_schema=> 'MK',
  p_allow_access_to_schemas => '');
end;
/
commit;
set feedback on
prompt  ...done

-- Run Below SQL as SYSDBA
alter session set "_ORACLE_SCRIPT"=true;
create user PUB identified by PUB;
grant connect, resource, dba to PUB;
create user CORE identified by CORE;
grant connect, resource, dba to CORE;
create user CATA identified by CATA;
grant connect, resource, dba to CATA;
create user CATB identified by CATB;
grant connect, resource, dba to CATB;

GRANT SELECT ON sys.dba_pending_transactions TO PUB;  
GRANT SELECT ON sys.pending_trans$ TO PUB;  
GRANT SELECT ON sys.dba_2pc_pending TO PUB;  
GRANT EXECUTE ON sys.dbms_xa TO PUB; 
GRANT EXECUTE ON sys.dbms_system TO PUB;
GRANT SELECT ON sys.dba_pending_transactions TO CORE;  
GRANT SELECT ON sys.pending_trans$ TO CORE;  
GRANT SELECT ON sys.dba_2pc_pending TO CORE;  
GRANT EXECUTE ON sys.dbms_xa TO CORE; 
GRANT EXECUTE ON sys.dbms_system TO CORE;
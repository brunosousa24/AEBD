CREATE TABLESPACE work_table
DATAFILE  '\u01\app\oracle\oradata\orcl12\orcl\work_tables_01.dbf'
SIZE 100M


CREATE TEMPORARY TABLESPACE work_temp
TEMPFILE '\u01\app\oracle\oradata\orcl12\orcl\work_temp.dbf'
SIZE 100M
AUTOEXTEND ON 

CREATE USER Work
IDENTIFIED BY work1
DEFAULT TABLESPACE work_table
TEMPORARY TABLESPACE work_temp

GRANT CONNECT TO Work;



--SELECT * FROM dba_users

GRANT CREATE TRIGGER TO Work;
GRANT CREATE sequence TO Work;
GRANT CREATE session TO	Work;
GRANT CREATE table TO	Work;
GRANT CREATE view TO Work;
GRANT CREATE procedure TO Work;
GRANT CREATE synonym TO Work;
GRANT ALTER ANY table TO Work;
GRANT ALTER ANY procedure TO Work;


CREATE TABLESPACE user_table
DATAFILE  '\u01\app\oracle\oradata\orcl12\orcl\user_tables_01.dbf'
SIZE 100M

CREATE TABLESPACE employyes_table
DATAFILE  '\u01\app\oracle\oradata\orcl12\orcl\employyes_tables_01.dbf'
SIZE 100M

CREATE TABLESPACE jobs_table
DATAFILE  '\u01\app\oracle\oradata\orcl12\orcl\jobs_tables_01.dbf'
SIZE 100M

CREATE TABLESPACE departaments_table
DATAFILE  '\u01\app\oracle\oradata\orcl12\orcl\departaments_tables_01.dbf'
SIZE 100M


CREATE USER User1
IDENTIFIED BY User1
DEFAULT TABLESPACE user_table
TEMPORARY TABLESPACE 

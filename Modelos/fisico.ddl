

CREATE TABLE work.datafiles (
    status   VARCHAR2(200 BYTE) NOT NULL,
    sizee    NUMBER NOT NULL,
    used     NUMBER NOT NULL,
    tables   VARCHAR2(200 BYTE) NOT NULL,
    name     VARCHAR2(200 BYTE) NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.datafiles_pk ON
    work.datafiles ( name ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.datafiles
    ADD CONSTRAINT datafiles_pk PRIMARY KEY ( name )
        USING INDEX work.datafiles_pk;

CREATE TABLE work.roles (
    role_name     VARCHAR2(200 BYTE) NOT NULL,
    description   VARCHAR2(200 BYTE) NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.roles_pk ON
    work.roles ( role_name ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.roles
    ADD CONSTRAINT roles_pk PRIMARY KEY ( role_name )
        USING INDEX work.roles_pk;

CREATE TABLE work.tablespaces (
    name        VARCHAR2(20 BYTE) NOT NULL,
    allocated   NUMBER NOT NULL,
    free        NUMBER NOT NULL,
    used        NUMBER NOT NULL,
    max_bytes   NUMBER NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.tablespaces_pk ON
    work.tablespaces ( name ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.tablespaces
    ADD CONSTRAINT tablespaces_pk PRIMARY KEY ( name )
        USING INDEX work.tablespaces_pk;

CREATE TABLE work.users (
    name           VARCHAR2(200 BYTE) NOT NULL,
    status         VARCHAR2(200 BYTE) NOT NULL,
    exp_date       DATE,
    temp_tablesp   VARCHAR2(200 BYTE) NOT NULL,
    created        DATE NOT NULL,
    user_type      VARCHAR2(20 BYTE) NOT NULL,
    tablespace     VARCHAR2(200 BYTE) NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.users_pk ON
    work.users ( name ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.users
    ADD CONSTRAINT users_pk PRIMARY KEY ( name )
        USING INDEX work.users_pk;

CREATE TABLE work.users_roles (
    usern   VARCHAR2(200 BYTE) NOT NULL,
    role    VARCHAR2(200 BYTE) NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.users_roles_pk ON
    work.users_roles (
        usern
    ASC,
        role
    ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_pk PRIMARY KEY ( usern,
    role )
        USING INDEX work.users_roles_pk;

ALTER TABLE work.datafiles
    ADD CONSTRAINT datafiles_fk1 FOREIGN KEY ( tables )
        REFERENCES work.tablespaces ( name )
    NOT DEFERRABLE;

ALTER TABLE work.users
    ADD CONSTRAINT users_fk1 FOREIGN KEY ( tablespace )
        REFERENCES work.tablespaces ( name )
    NOT DEFERRABLE;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_fk1 FOREIGN KEY ( usern )
        REFERENCES work.users ( name )
    NOT DEFERRABLE;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_fk2 FOREIGN KEY ( role )
        REFERENCES work.roles ( role_name )
    NOT DEFERRABLE;


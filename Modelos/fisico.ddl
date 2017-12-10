CREATE TABLE work.datafiles (
    id_data    NUMBER NOT NULL,
    status     VARCHAR2(200 BYTE) NOT NULL,
    sizee      NUMBER NOT NULL,
    used       NUMBER NOT NULL,
    id_table   NUMBER NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.datafiles_pk ON
    work.datafiles ( id_data ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.datafiles
    ADD CONSTRAINT datafiles_pk PRIMARY KEY ( id_data )
        USING INDEX work.datafiles_pk;

CREATE TABLE work.roles (
    id_role       NUMBER NOT NULL,
    description   VARCHAR2(200 BYTE) NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.roles_pk ON
    work.roles ( id_role ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.roles
    ADD CONSTRAINT roles_pk PRIMARY KEY ( id_role )
        USING INDEX work.roles_pk;

CREATE TABLE work.tablespaces (
    id          NUMBER NOT NULL,
    allocated   NUMBER NOT NULL,
    free        NUMBER NOT NULL,
    used        NUMBER NOT NULL,
    max_bytes   NUMBER NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.tablespaces_pk ON
    work.tablespaces ( id ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.tablespaces
    ADD CONSTRAINT tablespaces_pk PRIMARY KEY ( id )
        USING INDEX work.tablespaces_pk;

CREATE TABLE work.users (
    id_user         NUMBER NOT NULL,
    name            VARCHAR2(200 BYTE) NOT NULL,
    status          VARCHAR2(200 BYTE) NOT NULL,
    exp_date        DATE,
    def_tablesp     VARCHAR2(200 BYTE) NOT NULL,
    temp_tablesp    VARCHAR2(200 BYTE) NOT NULL,
    created         DATE NOT NULL,
    user_type       VARCHAR2(20 BYTE) NOT NULL,
    id_tablespace   NUMBER NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.users_pk ON
    work.users ( id_user ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.users
    ADD CONSTRAINT users_pk PRIMARY KEY ( id_user )
        USING INDEX work.users_pk;

CREATE TABLE work.users_roles (
    id_user   NUMBER NOT NULL,
    id_role   NUMBER NOT NULL
)
TABLESPACE work_table LOGGING NO INMEMORY;

CREATE UNIQUE INDEX work.users_roles_pk ON
    work.users_roles (
        id_user
    ASC,
        id_role
    ASC )
        TABLESPACE work_table LOGGING;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_pk PRIMARY KEY ( id_user,
    id_role )
        USING INDEX work.users_roles_pk;

ALTER TABLE work.datafiles
    ADD CONSTRAINT datafiles_fk1 FOREIGN KEY ( id_table )
        REFERENCES work.tablespaces ( id )
    NOT DEFERRABLE;

ALTER TABLE work.users
    ADD CONSTRAINT users_fk1 FOREIGN KEY ( id_tablespace )
        REFERENCES work.tablespaces ( id )
    NOT DEFERRABLE;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_fk1 FOREIGN KEY ( id_user )
        REFERENCES work.users ( id_user )
    NOT DEFERRABLE;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_fk2 FOREIGN KEY ( id_role )
        REFERENCES work.roles ( id_role )
    NOT DEFERRABLE;


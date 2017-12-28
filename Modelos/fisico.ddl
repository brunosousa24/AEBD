CREATE TABLE work.datafiles (
    id_datafile   NUMBER(*,0) NOT NULL,
    name          VARCHAR2(200 BYTE),
    sized         NUMBER(*,0),
    status        VARCHAR2(200 BYTE),
    id_table      NUMBER(*,0) NOT NULL,
    max_bytes     NUMBER
)
PCTFREE 10 PCTUSED 40 TABLESPACE work_table LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX work.datafiles_pk ON
    work.datafiles ( id_datafile ASC )
        TABLESPACE work_table PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE work.datafiles
    ADD CONSTRAINT datafiles_pk PRIMARY KEY ( id_datafile )
        USING INDEX work.datafiles_pk;

CREATE TABLE work.roles (
    id_role   NUMBER(*,0) NOT NULL,
    name      VARCHAR2(200 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE work_table LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX work.roles_pk ON
    work.roles ( id_role ASC )
        TABLESPACE work_table PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE work.roles
    ADD CONSTRAINT roles_pk PRIMARY KEY ( id_role )
        USING INDEX work.roles_pk;

CREATE TABLE work.tablespaces (
    id_tablespace   NUMBER(*,0) NOT NULL,
    name            VARCHAR2(200 BYTE),
    allocated       NUMBER(*,0),
    free            NUMBER(*,0),
    used            NUMBER(*,0),
    contents        VARCHAR2(200 BYTE)
)
PCTFREE 10 PCTUSED 40 TABLESPACE work_table LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX work.tablespaces_pk ON
    work.tablespaces ( id_tablespace ASC )
        TABLESPACE work_table PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE work.tablespaces
    ADD CONSTRAINT tablespaces_pk PRIMARY KEY ( id_tablespace )
        USING INDEX work.tablespaces_pk;

CREATE TABLE work.users (
    id_user           NUMBER(*,0) NOT NULL,
    name              VARCHAR2(200 BYTE),
    status            VARCHAR2(200 BYTE),
    exp_date          DATE,
    temp_tablespace   VARCHAR2(200 BYTE),
    created           DATE,
    id_tablespace     NUMBER(*,0) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE work_table LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX work.users_pk ON
    work.users ( id_user ASC )
        TABLESPACE work_table PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE work.users
    ADD CONSTRAINT users_pk PRIMARY KEY ( id_user )
        USING INDEX work.users_pk;

CREATE TABLE work.users_roles (
    id_ur      NUMBER(*,0) NOT NULL,
    id_user    NUMBER(*,0) NOT NULL,
    id_roles   NUMBER(*,0) NOT NULL
)
PCTFREE 10 PCTUSED 40 TABLESPACE work_table LOGGING
    STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
NO INMEMORY;

CREATE UNIQUE INDEX work.users_roles_pk ON
    work.users_roles ( id_ur ASC )
        TABLESPACE work_table PCTFREE 10
            STORAGE ( PCTINCREASE 0 MINEXTENTS 1 MAXEXTENTS UNLIMITED FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT )
        LOGGING;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_pk PRIMARY KEY ( id_ur )
        USING INDEX work.users_roles_pk;

ALTER TABLE work.datafiles
    ADD CONSTRAINT datafiles_fk1 FOREIGN KEY ( id_table )
        REFERENCES work.tablespaces ( id_tablespace )
    NOT DEFERRABLE;

ALTER TABLE work.users
    ADD CONSTRAINT users_fk1 FOREIGN KEY ( id_tablespace )
        REFERENCES work.tablespaces ( id_tablespace )
    NOT DEFERRABLE;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_fk1 FOREIGN KEY ( id_roles )
        REFERENCES work.roles ( id_role )
    NOT DEFERRABLE;

ALTER TABLE work.users_roles
    ADD CONSTRAINT users_roles_fk2 FOREIGN KEY ( id_user )
        REFERENCES work.users ( id_user )
    NOT DEFERRABLE;



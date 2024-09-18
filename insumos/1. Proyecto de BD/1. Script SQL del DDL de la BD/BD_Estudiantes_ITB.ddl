-- Generado por Oracle SQL Developer Data Modeler 21.2.0.183.1957
--   en:        2022-11-06 11:47:09 COT
--   sitio:      Oracle Database 21c
--   tipo:      Oracle Database 21c



-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE carreras (
    cod_carrera     INTEGER NOT NULL,
    nombre          VARCHAR2(100 CHAR) NOT NULL,
    total_semestres SMALLINT NOT NULL
);

ALTER TABLE carreras ADD CONSTRAINT carreras_pk PRIMARY KEY ( cod_carrera );

CREATE TABLE estudiantes (
    cedula         CHAR(10 CHAR) NOT NULL,
    nombres        VARCHAR2(50 CHAR) NOT NULL,
    apellidos      VARCHAR2(50 CHAR) NOT NULL,
    sexo           CHAR(1 CHAR) NOT NULL,
    si_adeuda      SMALLINT,
    porciento_beca FLOAT(5) NOT NULL
);

ALTER TABLE estudiantes ADD CONSTRAINT estudiantes_pk PRIMARY KEY ( cedula );

CREATE TABLE inscripciones_estudiantes (
    id_inscripcion      INTEGER NOT NULL,
    cedula              CHAR(10 CHAR) NOT NULL,
    cod_carrera         INTEGER NOT NULL,
    cod_paralelo        INTEGER NOT NULL,
    si_pago_inscripcion SMALLINT NOT NULL
);

ALTER TABLE inscripciones_estudiantes
    ADD CONSTRAINT carreras_paralelos_pk PRIMARY KEY ( cedula,
                                                       cod_carrera,
                                                       cod_paralelo,
                                                       id_inscripcion );

CREATE TABLE paralelos (
    cod_paralelo INTEGER NOT NULL,
    nombre       VARCHAR2(10 CHAR) NOT NULL,
    jornada      VARCHAR2(30 CHAR) NOT NULL,
    cod_carrera  INTEGER NOT NULL
);

ALTER TABLE paralelos ADD CONSTRAINT paralelos_pk PRIMARY KEY ( cod_paralelo );

ALTER TABLE paralelos
    ADD CONSTRAINT paralelos_carreras_fk FOREIGN KEY ( cod_carrera )
        REFERENCES carreras ( cod_carrera );

ALTER TABLE inscripciones_estudiantes
    ADD CONSTRAINT paralelos_carreras_fkv1 FOREIGN KEY ( cod_carrera )
        REFERENCES carreras ( cod_carrera );

ALTER TABLE inscripciones_estudiantes
    ADD CONSTRAINT paralelos_estudiantes_fk FOREIGN KEY ( cedula )
        REFERENCES estudiantes ( cedula );

ALTER TABLE inscripciones_estudiantes
    ADD CONSTRAINT paralelos_paralelos_fk FOREIGN KEY ( cod_paralelo )
        REFERENCES paralelos ( cod_paralelo );



-- Informe de Resumen de Oracle SQL Developer Data Modeler: 
-- 
-- CREATE TABLE                             4
-- CREATE INDEX                             0
-- ALTER TABLE                              8
-- CREATE VIEW                              0
-- ALTER VIEW                               0
-- CREATE PACKAGE                           0
-- CREATE PACKAGE BODY                      0
-- CREATE PROCEDURE                         0
-- CREATE FUNCTION                          0
-- CREATE TRIGGER                           0
-- ALTER TRIGGER                            0
-- CREATE COLLECTION TYPE                   0
-- CREATE STRUCTURED TYPE                   0
-- CREATE STRUCTURED TYPE BODY              0
-- CREATE CLUSTER                           0
-- CREATE CONTEXT                           0
-- CREATE DATABASE                          0
-- CREATE DIMENSION                         0
-- CREATE DIRECTORY                         0
-- CREATE DISK GROUP                        0
-- CREATE ROLE                              0
-- CREATE ROLLBACK SEGMENT                  0
-- CREATE SEQUENCE                          0
-- CREATE MATERIALIZED VIEW                 0
-- CREATE MATERIALIZED VIEW LOG             0
-- CREATE SYNONYM                           0
-- CREATE TABLESPACE                        0
-- CREATE USER                              0
-- 
-- DROP TABLESPACE                          0
-- DROP DATABASE                            0
-- 
-- REDACTION POLICY                         0
-- 
-- ORDS DROP SCHEMA                         0
-- ORDS ENABLE SCHEMA                       0
-- ORDS ENABLE OBJECT                       0
-- 
-- ERRORS                                   0
-- WARNINGS                                 0

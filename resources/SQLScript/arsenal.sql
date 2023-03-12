

-- revisar el entorno de trabajo
.version
.database
.show
.tables

DROP TABLE IF EXISTS HJ_ARSENAL;


CREATE TABLE HJ_ARSENAL
(   hj_capacidad_belica   INTEGER PRIMARY KEY AUTOINCREMENT,
    hj_geoposicionamiento VARCHAR(5) NOT NULL,
    hj_tipo_arsenal       VARCHAR(20) NOT NULL,
    hj_fecha_de_hackeo    VARCHAR(20) DEFAULT(datetime('now'))
);
------------------------------------------------------------------------
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS0', 'ab'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS1', 'bc'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS2', 'ac'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS3', 'bcd'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS4', 'acd'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS5', 'bct'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS6', 'act'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS7', 'aaabbct'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS8', 'abbccdt'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (NULL, 'GPS9', 'aaabbcd'); 
--INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
--            VALUES      (NULL, '', ''); 
------------------------------------------------------------------------

SELECT * FROM HJ_ARSENAL;
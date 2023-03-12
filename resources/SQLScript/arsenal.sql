

-- revisar el entorno de trabajo
.version
.database
.show
.tables

DROP TABLE IF EXISTS HJ_ARSENAL;


CREATE TABLE HJ_ARSENAL
(   hj_capacidad_belica   INTEGER (1),
    hj_geoposicionamiento VARCHAR(5) NOT NULL,
    hj_tipo_arsenal       VARCHAR(20) NOT NULL,
    hj_fecha_de_hackeo    VARCHAR(20) DEFAULT(datetime('now'))
);
-----------------------------------------------------------------------------------------------------
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (8, 'GPS8', 'abbccdt');
            INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (8, 'GPS8', 'abbccdt');   
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (9, 'GPS9', 'aaabbcd'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (8, 'GPS8', 'abbccdt'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (3, 'GPS3', 'bcd');             
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (1, 'GPS1', 'bc');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (1, 'GPS1', 'bc');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (2, 'GPS2', 'ac'); 
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (7, 'GPS7', 'aaabbct');            
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (1, 'GPS1', 'bc');
--------------------------------------------------------------------------------------------------------
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (2, 'GPS2', 'ac');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (3, 'GPS3', 'bcd');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (6, 'GPS6', 'act');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (2, 'GPS2', 'ac');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (4, 'GPS4', 'acd');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (2, 'GPS2', 'ac');            
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (4, 'GPS4', 'acd');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (5, 'GPS5', 'bct');
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (7, 'GPS7', 'aaabbct');            
INSERT INTO HJ_ARSENAL   (hj_capacidad_belica, hj_geoposicionamiento, hj_tipo_arsenal )
            VALUES      (1, 'GPS1', 'bc');
--------------------------------------------------------------------------------------------------------
SELECT * FROM HJ_ARSENAL;
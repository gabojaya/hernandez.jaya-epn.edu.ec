DROP TABLE IF EXISTS HJ_USERS;
------------------------------------------------------------------------
CREATE TABLE HJ_USERS (
    hj_username TEXT PRIMARY KEY,
    hj_password TEXT 
);
------------------------------------------------------------------------
INSERT INTO HJ_USERS(hj_username,hj_password) VALUES("gabriel.jaya@epn.edu.ec","1754242632");
INSERT INTO HJ_USERS(hj_username,hj_password) VALUES("cristian.hernandez@epn.edu.ec","2205783218");
INSERT INTO HJ_USERS(hj_username,hj_password) VALUES("profe","123");
------------------------------------------------------------------------
SELECT * FROM HJ_USERS;


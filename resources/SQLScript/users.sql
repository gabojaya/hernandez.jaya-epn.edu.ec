DROP TABLE IF EXISTS HJ_USERS;
------------------------------------------------------------------------
CREATE TABLE HJ_USERS (
    hj_username TEXT PRIMARY KEY,
    hj_password TEXT 
);
------------------------------------------------------------------------
INSERT INTO HJ_USERS(hj_username,hj_password) VALUES("gabriel.jaya@epn.edu.ec","8fb676b09d9bd1f9d805efc9c1e7ec3d");
INSERT INTO HJ_USERS(hj_username,hj_password) VALUES("cristian.hernandez@epn.edu.ec","2565400115e9a00fab8d862d000f9ef0");
INSERT INTO HJ_USERS(hj_username,hj_password) VALUES("profe","81dc9bdb52d04dc20036dbd8313ed055");
------------------------------------------------------------------------
SELECT * FROM HJ_USERS;


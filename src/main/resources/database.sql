DROP SCHEMA termibusDB;
DROP USER 'spq'@'%';

CREATE SCHEMA termibusDB;
CREATE USER 'spq'@'%' IDENTIFIED BY 'spq';
GRANT ALL ON termibusDB.* TO 'spq'@'%';

/* CREATE DATABASE termibusDB;
* USE termibusDB;
* CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
* GRANT ALL ON termibusDB.* TO 'spq'@'localhost';
*/
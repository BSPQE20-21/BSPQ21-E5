CREATE DATABASE termibusDB;
USE termibusDB;
CREATE USER IF NOT EXISTS 'spq'@'localhost' IDENTIFIED BY 'spq';
GRANT ALL ON termibusDB.* TO 'spq'@'localhost';
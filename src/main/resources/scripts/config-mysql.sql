# Run local mysql, connect and run as root user

# Create Database
CREATE DATABASE fs_dev;
CREATE DATABASE fs_prod;

# Create database service accounts
CREATE USER 'fs_dev_user'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'fs_prod_user'@'localhost' IDENTIFIED BY 'password';

# Grant access to users
GRANT SELECT ON fs_dev.* to 'fs_dev_user'@'localhost';
GRANT INSERT ON fs_dev.* to 'fs_dev_user'@'localhost';
GRANT DELETE ON fs_dev.* to 'fs_dev_user'@'localhost';
GRANT UPDATE ON fs_dev.* to 'fs_dev_user'@'localhost';
GRANT SELECT ON fs_prod.* to 'fs_prod_user'@'localhost';
GRANT INSERT ON fs_prod.* to 'fs_prod_user'@'localhost';
GRANT DELETE ON fs_prod.* to 'fs_prod_user'@'localhost';
GRANT UPDATE ON fs_prod.* to 'fs_prod_user'@'localhost';

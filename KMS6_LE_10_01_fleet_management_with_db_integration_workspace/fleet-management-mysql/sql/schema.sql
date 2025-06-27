-- Create the database
CREATE DATABASE fleet_management;

-- Use the newly created database
USE fleet_management;

-- Create the vehicles table
CREATE TABLE vehicles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50),
    license_plate VARCHAR(20) UNIQUE,
    mileage DOUBLE,
    fuel_level DOUBLE,
    specific_attribute VARCHAR(50)
);
CREATE database fleet_data_base;
USE fleet_data_base;

CREATE TABLE IF NOT EXISTS vehicles (
id INT AUTO_INCREMENT PRIMARY KEY,
type VARCHAR(20) NOT NULL,
license_plate VARCHAR(20) NOT NULL UNIQUE,
mileage DOUBLE NOT NULL,
fuel_level DOUBLE NOT NULL,
number_of_doors INT         NULL,
cargo_capacity DOUBLE       NULL,
has_sidecar BOOLEAN         NULL,
is_electric BOOLEAN         NULL
);
SELECT * FROM vehicles;
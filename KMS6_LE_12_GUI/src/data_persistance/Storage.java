package data_persistance;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import models.*;


public class Storage {
    private String JDBC_URL;
    private String JDBC_USER;
    private String JDBC_PASS;

    public Storage() {
        loadCredentials();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
        }
    }

    private void loadCredentials() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("Cannot find db.properties");
            }
            prop.load(input);
            JDBC_URL = prop.getProperty("db.url");
            JDBC_USER = prop.getProperty("db.user");
            JDBC_PASS = prop.getProperty("db.password");
        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB config: " + e.getMessage());
        }
    }

    public List<Vehicle> loadFleetFromDatabase() {
        List<Vehicle> fleet = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String type = rs.getString("type");
                String plate = rs.getString("license_plate");
                double mileage = rs.getDouble("mileage");
                double fuelLevel = rs.getDouble("fuel_level");
                double maxCap = rs.getDouble("max_fuel_capacity");
                Integer doors = (Integer) rs.getObject("number_of_doors");
                Double cargo = (Double) rs.getObject("cargo_capacity");
                Boolean sidecar = (Boolean) rs.getObject("has_sidecar");
                Boolean isElectric = (Boolean) rs.getObject("is_electric");
                switch (type) {
                    case "Car" -> fleet.add(new Car(plate, mileage, fuelLevel, doors != null ? doors : 0, maxCap));
                    case "Truck" -> fleet.add(new Truck(plate, mileage, fuelLevel, cargo != null ? cargo : 0.0, maxCap));
                    case "Motorcycle" -> fleet.add(new Motorcycle(plate, mileage, fuelLevel, sidecar != null && sidecar, maxCap));
                    case "Bicycle" -> fleet.add(new Bicycle(plate, mileage, isElectric != null && isElectric));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error loading fleet: " + e.getMessage());
        }
        return fleet;
    }

    // Save the fleet to the database => truncate the table and insert new data
    public void saveFleetToDatabase(List<Vehicle> fleet) {
        String truncateSql = "TRUNCATE TABLE vehicles";
        String insertSql = "INSERT INTO vehicles " +
                "(type, license_plate, mileage, fuel_level, max_fuel_capacity, number_of_doors, " +
                "cargo_capacity, has_sidecar, is_electric) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
             Statement stmt = conn.createStatement();
             PreparedStatement pstmt = conn.prepareStatement(insertSql)) {
            stmt.execute(truncateSql);
            for (Vehicle v : fleet) {
                pstmt.setString(1, v.getClass().getSimpleName());
                pstmt.setString(2, v.getLicensePlate());
                pstmt.setDouble(3, v.getMileage());
                pstmt.setDouble(4, v.getFuelLevel());
                pstmt.setDouble(5, v.getMaxFuelCapacity());
                pstmt.setObject(6, null);
                pstmt.setObject(7, null);
                pstmt.setObject(8, null);
                pstmt.setObject(9, null);
                if (v instanceof Car) {
                    pstmt.setInt(6, ((Car) v).getNumberOfDoors());
                } else if (v instanceof Truck) {
                    pstmt.setDouble(7, ((Truck) v).getCargoCapacity());
                } else if (v instanceof Motorcycle) {
                    pstmt.setBoolean(8, ((Motorcycle) v).hasSidecar());
                } else if (v instanceof Bicycle) {
                    pstmt.setBoolean(9, ((Bicycle) v).isElectric());
                }
                pstmt.addBatch();
            }
            pstmt.executeBatch();
        } catch (SQLException e) {
            System.out.println("Error saving fleet: " + e.getMessage());
        }
    }
}

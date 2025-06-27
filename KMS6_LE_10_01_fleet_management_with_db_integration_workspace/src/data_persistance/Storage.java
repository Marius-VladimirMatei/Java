package data_persistance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import models.Bicycle;
import models.Car;
import models.Motorcycle;
import models.Truck;
import models.Vehicle;

// Database connection
public class Storage {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/fleet_data_base";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASS = "Matei8138";

    public Storage() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found on classpath.");
        }
    }

    public List<Vehicle> loadFleetFromDatabase() {
        List<Vehicle> fleet = new ArrayList<>();
        String sql = "SELECT * FROM vehicles";

        // Establish a connection to the database => create a statement and execute the
        // query => process the result set
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            // Process the result set and create Vehicle objects based on the type
            while (rs.next()) {
                String type = rs.getString("type");
                String plate = rs.getString("license_plate");
                double mileage = rs.getDouble("mileage");
                double fuelLevel = rs.getDouble("fuel_level");
                Integer doors = (Integer) rs.getObject("number_of_doors");
                Double capacity = (Double) rs.getObject("cargo_capacity");
                Boolean sidecar = (Boolean) rs.getObject("has_sidecar");
                Boolean isElectric = (Boolean) rs.getObject("is_electric");

                switch (type) {
                    case "Car":
                        fleet.add(new Car(plate, mileage, fuelLevel, doors != null ? doors : 0));
                        break;
                    case "Truck":
                        fleet.add(new Truck(plate, mileage, fuelLevel, capacity != null ? capacity : 0.0));
                        break;
                    case "Motorcycle":
                        fleet.add(new Motorcycle(plate, mileage, fuelLevel, sidecar != null && sidecar));
                        break;
                    case "Bicycle":
                        fleet.add(new Bicycle(plate, mileage, isElectric != null && isElectric));
                        break;
                }
            }
            System.out.println("✅ Fleet loaded from database.");
        } catch (SQLException e) {
            System.out.println("Error loading fleet: " + e.getMessage());
        }
        return fleet;
    }

    // Save the fleet to the database => truncate the table and insert new data
    public void saveFleetToDatabase(List<Vehicle> fleet) {
        String truncateSql = "TRUNCATE TABLE vehicles";
        String insertSql = "INSERT INTO vehicles "
                + "(type, license_plate, mileage, fuel_level, number_of_doors, "
                + "cargo_capacity, has_sidecar, is_electric) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)"; // Use ? for prepared statement parameters

        //
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASS);
                Statement stmt = conn.createStatement();
                PreparedStatement pstmt = conn.prepareStatement(insertSql)) { // Prepared statement used to prevent SQL
                                                                              // injection

            stmt.execute(truncateSql);

            for (Vehicle v : fleet) {
                pstmt.setString(1, v.getClass().getSimpleName());
                pstmt.setString(2, v.getLicensePlate());
                pstmt.setDouble(3, v.getMileage());
                pstmt.setDouble(4, v.getFuelLevel());

                // clear subclass columns
                pstmt.setObject(5, null);
                pstmt.setObject(6, null);
                pstmt.setObject(7, null);
                pstmt.setObject(8, null);

                // Use instanceof to check the type of vehicle and set the appropriate column
                if (v instanceof Car) {
                    pstmt.setInt(5, ((Car) v).getNumberOfDoors());
                } else if (v instanceof Truck) {
                    pstmt.setDouble(6, ((Truck) v).getCargoCapacity());
                } else if (v instanceof Motorcycle) {
                    pstmt.setBoolean(7, ((Motorcycle) v).hasSidecar());
                } else if (v instanceof Bicycle) {
                    pstmt.setBoolean(8, ((Bicycle) v).isElectric());
                }
                pstmt.addBatch(); // addBatch() method used to collect multiple statements for batch execution
            }
            pstmt.executeBatch();
            System.out.println(" Fleet saved to database.");
        } catch (SQLException e) {
            System.out.println("Error saving fleet: " + e.getMessage());
        }
    }
}

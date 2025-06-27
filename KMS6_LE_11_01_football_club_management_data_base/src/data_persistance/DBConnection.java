package data_persistance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Simple helper to get a JDBC Connection.
 * Adjust URL, USER and PASSWORD to match your setup.
 */
public class DBConnection {
    private static final String URL =
            "jdbc:mysql://localhost:3306/football_club?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "Matei8138";

    static {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found on classpath");
        }
    }

    /**
     * @return a new Connection; caller should close it when done
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

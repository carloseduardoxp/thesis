import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ODBCConnection {
    public static void main(String[] args) {
        String dsnName = "MySQL_ODBC"; // The DSN name you configured
        String jdbcUrl = "jdbc:odbc:" + dsnName;

        try {
            // Establish the connection
            Connection connection = DriverManager.getConnection(jdbcUrl, "", ""); // No need for user/password here if specified in DSN

            if (connection != null) {
                System.out.println("Successfully connected to MySQL using ODBC!");
                // Perform database operations here
                connection.close();
            } else {
                System.out.println("Failed to establish connection.");
            }

        } catch (SQLException e) {
            System.err.println("SQLException: " + e.getMessage());
        }
    }
}

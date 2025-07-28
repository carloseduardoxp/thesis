import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnectionExample {

    // Database credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/your_database_name"; // Change your_database_name
    static final String USER = "your_username"; // Change your_username
    static final String PASS = "your_password"; // Change your_password

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // STEP 1: Register JDBC driver (for newer versions of JDBC, this is often optional,
            // as the driver is automatically loaded, but it's good practice for older drivers)
            // Class.forName("com.mysql.cj.jdbc.Driver"); // For Connector/J 8.0.x
            // Class.forName("com.mysql.jdbc.Driver"); // For Connector/J 5.x.x and earlier

            System.out.println("Connecting to database...");
            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to database successfully!");

            // STEP 3: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();
            String sql = "SELECT id, name, email FROM users"; // Replace 'users' with your table name
            rs = stmt.executeQuery(sql);

            // STEP 4: Process the ResultSet
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                // Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.println(", Email: " + email);
            }
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // STEP 5: Clean-up environment (close resources in reverse order of creation)
            try {
                if (rs != null) rs.close();
            } catch (SQLException se2) {
                // nothing we can do
            }
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
                // nothing we can do
            }
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
            System.out.println("Goodbye!");
        }
    }
}

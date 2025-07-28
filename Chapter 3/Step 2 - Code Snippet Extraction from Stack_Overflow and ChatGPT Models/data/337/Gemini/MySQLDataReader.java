
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; // For parameterized queries

public class MySQLDataReader {

    // Database connection details
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "your_username"; // Your MySQL username
    private static final String PASS = "your_password"; // Your MySQL password

    public static void main(String[] args) {
        // Option 1: Using Statement (for simple queries)
        readDataWithStatement();

        System.out.println("\n-----------------------------------\n");

        // Option 2: Using PreparedStatement (recommended for security and performance)
        readDataWithPreparedStatement(101); // Example: Get user with ID 101
    }

    public static void readDataWithStatement() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database (Statement)!");

            // 2. Create a statement
            stmt = conn.createStatement();

            // 3. Execute the query
            String sql = "SELECT id, name, email FROM users";
            rs = stmt.executeQuery(sql);

            // 4. Process the ResultSet
            while (rs.next()) {
                // Retrieve by column name or column index
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                // Print out the data
                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close resources in reverse order
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
                System.out.println("Resources closed (Statement).");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    public static void readDataWithPreparedStatement(int userId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            // 1. Establish a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to the database (PreparedStatement)!");

            // 2. Create a PreparedStatement with placeholders (?)
            String sql = "SELECT id, name, email FROM users WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // 3. Set parameters
            pstmt.setInt(1, userId); // Sets the first '?' to userId

            // 4. Execute the query
            rs = pstmt.executeQuery();

            // 5. Process the ResultSet
            if (rs.next()) { // Assuming only one user per ID
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("User found: ID: " + id + ", Name: " + name + ", Email: " + email);
            } else {
                System.out.println("No user found with ID: " + userId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Close resources in reverse order
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
                System.out.println("Resources closed (PreparedStatement).");
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}

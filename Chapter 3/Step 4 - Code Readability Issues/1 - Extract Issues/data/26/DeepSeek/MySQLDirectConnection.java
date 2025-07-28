import java.sql.*;

public class MySQLDirectConnection {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // JDBC connection URL
            String url = "jdbc:mysql://localhost:3306/your_database";
            
            // Connect with username and password
            conn = DriverManager.getConnection(url, "username", "password");
            
            System.out.println("Connected to MySQL directly!");
            
            // Execute a query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM your_table");
            
            // Process results
            while(rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class OdbcConnectionExample {
    public static void main(String[] args) throws Exception {
        String dsnName = "myodbc";
        String user = "root";
        String password = "password";
        
        // Connect to the MySQL database using the DSN
        Connection conn = DriverManager.getConnection("jdbc:odbc:" + dsnName, user, password);
        
        // Execute a query
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");
        
        // Process the results
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id + ", " + name);
        }
        
        // Close the connection
        conn.close();
    }
}

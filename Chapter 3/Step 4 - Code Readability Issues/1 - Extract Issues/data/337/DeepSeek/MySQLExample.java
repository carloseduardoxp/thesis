
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLExample {
    
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_username";
        String password = "your_password";
        
        // SQL query
        String query = "SELECT * FROM your_table";
        
        try {
            // 1. Register JDBC driver (not required since JDBC 4.0)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // 2. Create connection
            Connection connection = DriverManager.getConnection(url, username, password);
            
            // 3. Create statement
            Statement statement = connection.createStatement();
            
            // 4. Execute query
            ResultSet resultSet = statement.executeQuery(query);
            
            // 5. Process results
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // assuming you have an 'id' column
                String name = resultSet.getString("name"); // assuming a 'name' column
                // Add more columns as needed
                
                System.out.println("ID: " + id + ", Name: " + name);
            }
            
            // 6. Clean up
            resultSet.close();
            statement.close();
            connection.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

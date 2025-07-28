import java.sql.*;

public class ArrayToDBMapper {
    public static void main(String[] args) {
        String[] dataArray = {"Item1", "Item2", "Item3", "Item4"};
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourdb", "user", "password")) {
            
            // Create table if not exists
            String createTableSQL = "CREATE TABLE IF NOT EXISTS items (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255))";
            try (Statement stmt = conn.createStatement()) {
                stmt.execute(createTableSQL);
            }
            
            // Insert array elements
            String insertSQL = "INSERT INTO items (name) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
                for (String item : dataArray) {
                    pstmt.setString(1, item);
                    pstmt.executeUpdate();
                }
            }
            
            System.out.println("Array data successfully stored in database.");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

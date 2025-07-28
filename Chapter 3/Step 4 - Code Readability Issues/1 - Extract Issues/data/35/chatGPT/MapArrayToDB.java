import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MapArrayToDB {
    public static void main(String[] args) {
        String[] data = {"John", "Doe", "john.doe@example.com"};

        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO users (first_name, last_name, email) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, data[0]);
            pstmt.setString(2, data[1]);
            pstmt.setString(3, data[2]);
            pstmt.executeUpdate();
            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        }
    }
}

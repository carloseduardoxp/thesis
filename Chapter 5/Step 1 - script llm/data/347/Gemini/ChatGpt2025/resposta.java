import java.sql.*;

public class Gemini {

    public static void main(String[] args) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, username); // 1 for the first placeholder
        pstmt.setString(2, password); // 2 for the second placeholder
        pstmt.executeQuery();
        // Or pstmt.executeUpdate() for INSERT, UPDATE, DELETE

    }

}
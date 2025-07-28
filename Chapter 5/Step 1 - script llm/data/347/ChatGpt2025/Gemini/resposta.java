import java.sql.*;

public class Chat {

    public static void main(String[] args) {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.executeQuery();

    }

}

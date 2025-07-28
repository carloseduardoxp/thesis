import java.sql.*;

public class Teste {
  public static void main(String[] args) {
    String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
    PreparedStatement statement = connection.prepareStatement(sql);
    statement.setString(1, username);
    statement.setString(2, password);
    statement.executeQuery();
  }
}

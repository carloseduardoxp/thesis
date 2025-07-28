import java.sql.*;

public class Example {
  public static void main(String[] args) throws Exception {
    // Establish a connection to the database
    String url = "jdbc:mysql://localhost:3306/mydatabase";
    String username = "root";
    String password = "mypassword";
    Connection connection = DriverManager.getConnection(url, username, password);

    // Execute a simple SQL query
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");
    while (resultSet.next()) {
        System.out.println(resultSet.getString("column1") + " " + resultSet.getString("column2"));
    }

    // Close the connection
    connection.close();
  }
}
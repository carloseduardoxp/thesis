
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ArrayToDB {
    public static void main(String[] args) {
        String[] dataArray = {"apple", "banana", "cherry"};
        String jdbcUrl = "jdbc:your_database_url"; // Replace with your database URL
        String username = "your_username";       // Replace with your database username
        String password = "your_password";       // Replace with your database password

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO array_data (array_index, value) VALUES (?, ?)")) {

            for (int i = 0; i < dataArray.length; i++) {
                preparedStatement.setInt(1, i);
                preparedStatement.setString(2, dataArray[i]);
                preparedStatement.executeUpdate();
            }
            System.out.println("Array data inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

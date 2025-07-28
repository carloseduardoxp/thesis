
import java.sql.Connection;
import java.sql.DriverManager;

public class Teste {

    public static void main(String[] args) {        
        String url = "jdbc:mysql://127.0.0.1:3306/yourdatabase";
        String user = "username";
        String password = "password";
        
        // Load the Connector/J driver
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        // Establish connection to MySQL
        Connection conn = DriverManager.getConnection(url, user, password);
    }
}
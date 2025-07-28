import java.sql.Connection;
import java.sql.DriverManager;

public class Teste {

    public static void main(String[] args) throws Exception {        
        String url = "jdbc:mysql://127.0.0.1:3306/yourdatabase";
        String user = "username";
        String password = "password";
        
        // Establish connection to MySQL
        DriverManager.getConnection(url, user, password);
    }
}
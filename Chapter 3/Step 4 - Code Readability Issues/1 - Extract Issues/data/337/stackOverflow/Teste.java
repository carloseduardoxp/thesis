
import java.sql.*;

public class Teste {

    public static void main(String[] args) {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/DBNAME", "usrname", "pswd");
        Statement stmt = conn.createStatement();
        String query = "select columnname from tablename ;";
        ResultSet rs = stmt.executeQuery(query);

    }
}

import java.sql.*;

public class Teste {

    public static void main(String[] args) throws SQLException {        
        PreparedStatement preparedStatement = con.prepareStatement(
            "SELECT * FROM MY_TABLE WHERE condition1 = ? AND condition2 = ?");
        preparedStatement.setString(1,condition1_value);
        preparedStatement.setString(2,condition2_value);
        preparedStatement.executeQuery();
    }
}

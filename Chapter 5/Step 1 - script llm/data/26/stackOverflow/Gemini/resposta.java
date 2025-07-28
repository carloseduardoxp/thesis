//import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Vector;

public class DataBase {

    private static final String EXCEPTION_MESSAGE = "Exception ";

    // 2.open a data source name by means of the jdbcodbcdriver.
    static void connect() throws SQLException {

        // Connect to the database
        Connection con = DriverManager.getConnection("jdbc:mysql:host/databasename", "root", "admin");
        Statement stmt = con.createStatement();
        // Shut off autocommit
        con.setAutoCommit(false);

        System.out.println("1.Insert 2.Delete 3.Update 4.Select");
        Scanner s = new Scanner(System.in);
        int x;
        x = s.nextInt();

        String query; // SQL select string
        ResultSet rs; // SQL query results
        boolean more; // "more rows found" switch
        String v1;
        String v2; // Temporary storage results

        Vector<Object> results = new Vector<>(10);

        if (x == 1) {

            try {
                stmt.executeUpdate("INSERT INTO employee( emp_id,emp_name ) VALUES ( '122','shiva' ) ");
            } catch (Exception e) {
                System.out.println(EXCEPTION_MESSAGE + e);
                e.printStackTrace();
            }
        }

        if (x == 2) {

            try {
                stmt.executeUpdate("DELETE from employee where emp_id='102' ");
            } catch (Exception e) {
                System.out.println(EXCEPTION_MESSAGE + e);
                e.printStackTrace();
            }
        }

        if (x == 3) {

            try {
                stmt
                        .executeUpdate("UPDATE employee SET emp_name = 'madavan' where emp_id='20'; ");
            } catch (Exception e) {
                System.out.println(EXCEPTION_MESSAGE + e);
                e.printStackTrace();
            }
        }

        query = "SELECT * FROM employee ";
        try {
            rs = stmt.executeQuery(query);
            // Check to see if any rows were read
            more = rs.next();
            if (!more) {

                System.out.println("No rows found.");
                return;
            }

            // Loop through the rows retrieved from the query
            while (more) {

                v1 = "ID: " + rs.getInt("emp_id");
                v2 = "Name: " + rs.getString("emp_name");

                System.out.println(v1);
                System.out.println(v2);
                System.out.println("");

                results.addElement(v1 + "\n" + v2 + "\n");

                more = rs.next();
            }
            rs.close();

        } catch (SQLException e) {
            System.out.println("" + results.size() + "results where found.");
        } finally {
            stmt.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        String str;
        do {
            DataBase.connect();
            Scanner sc = new Scanner(System.in);
            System.out.println("DO u Want to PROCEED TO QUERY : ");
            str = sc.next();
        } while (!"n".equals(str));
    }

}

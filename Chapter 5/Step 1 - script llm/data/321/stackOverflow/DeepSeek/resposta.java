import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class CTestDriver {
    private static void doSshTunnel(String strSshUser, String strSshPassword, String strSshHost,
            String strRemoteHost, int nLocalPort, int nRemotePort) throws JSchException {
        final JSch jsch = new JSch();
        Session session = jsch.getSession(strSshUser, strSshHost, 22);
        session.setPassword(strSshPassword);

        final Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect();
        session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
    }

    public static void main(String[] args) {
        try {
            String strSshUser = "ssh_user_name"; // SSH loging username
            String strSshPassword = "abcd1234"; // SSH login password
            String strSshHost = "your.ssh.hostname.com"; // hostname or ip or SSH server
            String strRemoteHost = "your.database.hostname.com"; // hostname or ip of your database server
            int nLocalPort = 3366; // local port number use to bind SSH tunnel
            int nRemotePort = 3306; // remote port number of your database
            String strDbUser = "db_user_name"; // database loging username
            String strDbPassword = "4321dcba"; // database login password

            CTestDriver.doSshTunnel(strSshUser, strSshPassword, strSshHost, strRemoteHost, nLocalPort,
                    nRemotePort);

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:" + nLocalPort, strDbUser,
                    strDbPassword);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.exit(0);
        }
    }
}

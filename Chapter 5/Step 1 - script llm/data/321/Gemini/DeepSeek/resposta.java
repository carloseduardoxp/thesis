import com.jcraft.jsch.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.Properties;

public class SshConnectionExample {

    public static void main(String[] args) {
        String host = "your_ssh_server_ip_or_hostname";
        String user = "your_username";
        String password = "your_password";
        int port = 22; // Default SSH port

        Session session = null;
        ChannelExec channelExec = null;

        try {
            JSch jsch = new JSch();

            session = jsch.getSession(user, host, port);
            session.setPassword(password);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            System.out.println("Connecting to " + user + "@" + host + ":" + port + "...");
            session.connect();
            System.out.println("Connected successfully!");

            String command = "ls -l";
            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);

            try (InputStream in = channelExec.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                channelExec.connect();

                System.out.println("Command output:");
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }

                int exitStatus = channelExec.getExitStatus();
                System.out.println("Command exited with status: " + exitStatus);
            }

        } catch (JSchException e) {
            System.err.println("SSH Connection Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error during command execution: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (channelExec != null) {
                channelExec.disconnect();
            }
            if (session != null) {
                session.disconnect();
            }
            System.out.println("Disconnected.");
        }
    }
}

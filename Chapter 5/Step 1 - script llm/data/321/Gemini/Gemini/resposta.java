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

            // Important for security:
            // For production environments, you should handle host key checking properly.
            // "yes" will check against known_hosts. "no" will bypass checking (less secure).
            // "ask" will prompt the user (not suitable for automated scripts).
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no"); // Use "yes" for production after adding host to known_hosts
            session.setConfig(config);

            System.out.println("Connecting to " + user + "@" + host + ":" + port + "...");
            session.connect();
            System.out.println("Connected successfully!");

            // Open an 'exec' channel for executing commands
            String command = "ls -l"; // The command you want to execute on the remote server
            channelExec = (ChannelExec) session.openChannel("exec");
            channelExec.setCommand(command);
            channelExec.connect(); // Connect the channel

            // Use try-with-resources to automatically close the input stream and reader
            try (InputStream in = channelExec.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                String line;
                System.out.println("Command output:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Check exit status of the command
            int exitStatus = channelExec.getExitStatus();
            System.out.println("Command exited with status: " + exitStatus);

        } catch (JSchException e) {
            System.err.println("SSH Connection Error: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error during command execution: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close non-AutoCloseable resources
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

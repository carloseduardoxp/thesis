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

        try (
            SshSessionResources resources = new SshSessionResources(user, host, port, password)
        ) {
            Session session = resources.getSession();

            System.out.println("Connecting to " + user + "@" + host + ":" + port + "...");
            session.connect();
            System.out.println("Connected successfully!");

            String command = "ls -l"; // The command you want to execute on the remote server
            try (
                ChannelExec channelExec = (ChannelExec) session.openChannel("exec");
                InputStream in = channelExec.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in))
            ) {
                channelExec.setCommand(command);
                channelExec.connect();

                String line;
                System.out.println("Command output:");
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
            System.out.println("Disconnected.");
        }
    }

    // Helper class to manage Session resource with try-with-resources
    static class SshSessionResources implements AutoCloseable {
        private final Session session;

        public SshSessionResources(String user, String host, int port, String password) throws JSchException {
            JSch jsch = new JSch();
            session = jsch.getSession(user, host, port);
            session.setPassword(password);

            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
        }

        public Session getSession() {
            return session;
        }

        @Override
        public void close() {
            if (session != null && session.isConnected()) {
                session.disconnect();
            }
        }
    }
}

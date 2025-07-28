import com.jcraft.jsch.*;

public class SSHConnector {
    public static void main(String[] args) {
        String host = "your.server.com";
        String user = "username";
        String password = "password";
        int port = 22;

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            
            // Avoid asking for key confirmation
            session.setConfig("StrictHostKeyChecking", "no");
            
            session.connect();
            System.out.println("Connected successfully!");
            
            // Execute a command
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("ls -l");
            channel.connect();
            
            // Read the output
            InputStream in = channel.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            // Disconnect
            channel.disconnect();
            session.disconnect();
        } catch (JSchException | IOException e) {
            e.printStackTrace();
        }
    }
}

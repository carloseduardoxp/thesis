import com.jcraft.jsch.*;

public class SSHExample {
    public static void main(String[] args) {
        String host = "your_ssh_server_ip";
        String user = "your_username";
        String password = "your_password";

        try {
            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, 22);
            session.setPassword(password);

            // Disable host key checking (not secure for production)
            session.setConfig("StrictHostKeyChecking", "no");

            session.connect();
            System.out.println("Connected to SSH");

            // Execute a command
            ChannelExec channel = (ChannelExec) session.openChannel("exec");
            channel.setCommand("ls -l"); // Replace with your command
            channel.setErrStream(System.err);
            channel.setInputStream(null);

            java.io.InputStream input = channel.getInputStream();
            channel.connect();

            byte[] tmp = new byte[1024];
            while (true) {
                while (input.available() > 0) {
                    int i = input.read(tmp, 0, 1024);
                    if (i < 0) break;
                    System.out.print(new String(tmp, 0, i));
                }
                if (channel.isClosed()) break;
                Thread.sleep(100);
            }

            channel.disconnect();
            session.disconnect();
            System.out.println("Disconnected from SSH");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

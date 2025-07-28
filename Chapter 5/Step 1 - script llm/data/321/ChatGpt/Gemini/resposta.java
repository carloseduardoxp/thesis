import com.jcraft.jsch.*;

public class SSHConnectionExample {
    public static void main(String[] args) throws Exception {
        String host = "example.com";
        String username = "username";
        String password = "password";
        int port = 22;

        JSch jsch = new JSch();
        Session session = jsch.getSession(username, host, port);
        session.setPassword(password);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();

        String command = "ls -l";
        ChannelExec channel = (ChannelExec) session.openChannel("exec");
        channel.setCommand(command);

        channel.setInputStream(null);
        channel.setErrStream(System.err);

        java.io.InputStream in = channel.getInputStream();
        channel.connect();

        byte[] tmp = new byte[1024];
        while (!channel.isClosed() || in.available() > 0) {
            while (in.available() > 0) {
                int i = in.read(tmp, 0, 1024);
                if (i < 0) {
                    break;
                }
                System.out.print(new String(tmp, 0, i));
            }
            if (!channel.isClosed()) {
                Thread.sleep(1000);
            }
        }
        System.out.println("exit-status: " + channel.getExitStatus());
        channel.disconnect();
        session.disconnect();
    }
}

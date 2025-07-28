import javax.net.ssl.*;
import java.io.*;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.net.*;

public class SslRmiSocketFactory implements RMIClientSocketFactory, RMIServerSocketFactory, Serializable {

    public Socket createSocket(String host, int port) throws IOException {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            return factory.createSocket(host, port);
        } catch (IOException e) {
            throw new IOException("Failed to create SSL socket", e);
        }
    }

    public ServerSocket createServerSocket(int port) throws IOException {
        try {
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            return factory.createServerSocket(port);
        } catch (IOException e) {
            throw new IOException("Failed to create SSL server socket", e);
        }
    }
}

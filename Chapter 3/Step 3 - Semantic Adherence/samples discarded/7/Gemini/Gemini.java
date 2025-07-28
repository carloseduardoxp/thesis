import javax.net.ServerSocketFactory;
import javax.net.SocketFactory;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;

public class SSLRMIClientSocketFactory implements RMIClientSocketFactory {
    @Override
    public Socket createSocket(String host, int port) throws IOException {
        SSLSocketFactory sf = (SSLSocketFactory) SSLSocketFactory.getDefault();
        return sf.createSocket(host, port);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null && obj.getClass().equals(this.getClass()));
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}

public class SSLRMIServerSocketFactory implements RMIServerSocketFactory {
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        SSLServerSocketFactory ssf = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        return ssf.createServerSocket(port);
    }

    @Override
    public boolean equals(Object obj) {
        return (obj != null && obj.getClass().equals(this.getClass()));
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}

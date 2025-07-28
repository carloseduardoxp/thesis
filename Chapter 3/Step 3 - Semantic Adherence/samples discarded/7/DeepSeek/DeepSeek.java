import javax.net.ssl.*;
import java.rmi.*;
import java.rmi.server.*;
import java.security.KeyStore;
import java.io.FileInputStream;

public class RMIServer {
    public static void main(String[] args) {
        try {
            // Set SSL properties for server
            System.setProperty("javax.net.ssl.keyStore", "server_keystore.jks");
            System.setProperty("javax.net.ssl.keyStorePassword", "password");
            
            // Create SSL context
            SSLContext sslContext = SSLContext.getInstance("TLS");
            
            // Initialize KeyManagerFactory
            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
            KeyStore keyStore = KeyStore.getInstance("JKS");
            keyStore.load(new FileInputStream("server_keystore.jks"), "password".toCharArray());
            keyManagerFactory.init(keyStore, "password".toCharArray());
            
            // Initialize SSLContext
            sslContext.init(keyManagerFactory.getKeyManagers(), null, null);
            
            // Create custom socket factory
            RMIServerSocketFactory serverSocketFactory = new RMISSLServerSocketFactory(sslContext);
            
            // Create remote object
            RemoteService service = new RemoteServiceImpl();
            
            // Bind with SSL
            LocateRegistry.createRegistry(1099, null, serverSocketFactory);
            Naming.rebind("//localhost/RemoteService", service);
            
            System.out.println("Server ready with SSL");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class RMISSLServerSocketFactory implements RMIServerSocketFactory {
    private final SSLContext sslContext;
    
    public RMISSLServerSocketFactory(SSLContext sslContext) {
        this.sslContext = sslContext;
    }
    
    @Override
    public ServerSocket createServerSocket(int port) throws IOException {
        SSLServerSocketFactory ssf = sslContext.getServerSocketFactory();
        return ssf.createServerSocket(port);
    }
}

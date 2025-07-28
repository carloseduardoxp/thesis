import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;

public class SecureServer {

    public static void main(String[] args) throws Exception {
        // Set system properties for keystore and truststore (optional, but common)
        // If not set here, you'll need to configure them programmatically
        System.setProperty("javax.net.ssl.keyStore", "server.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", "your_keystore_password");
        // For mutual authentication, also set server's truststore
        // System.setProperty("javax.net.ssl.trustStore", "server_truststore.jks");
        // System.setProperty("javax.net.ssl.trustStorePassword", "server_truststore_password");

        // Create SSLContext
        SSLContext sslContext = SSLContext.getInstance("TLS");

        // Initialize KeyManager to manage server's private key and certificate
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        KeyStore ks = KeyStore.getInstance("JKS");
        try (InputStream ksIs = new FileInputStream("server.jks")) {
            ks.load(ksIs, "your_keystore_password".toCharArray());
        }
        kmf.init(ks, "your_keystore_password".toCharArray());

        // Initialize TrustManager (for server to trust client certificates in mutual auth)
        // Only needed if client authentication is required
        // TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        // KeyStore ts = KeyStore.getInstance("JKS");
        // try (InputStream tsIs = new FileInputStream("server_truststore.jks")) {
        //     ts.load(tsIs, "server_truststore_password".toCharArray());
        // }
        // tmf.init(ts);

        // Initialize SSLContext with KeyManagers and TrustManagers
        // For one-way SSL (server authenticates to client):
        sslContext.init(kmf.getKeyManagers(), null, null);
        // For two-way SSL (mutual authentication):
        // sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);


        // Create SSLServerSocketFactory
        SSLServerSocketFactory ssf = sslContext.getServerSocketFactory();
        SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(8443);

        // Enable client authentication (for mutual authentication)
        // serverSocket.setNeedClientAuth(true); // Requires client to present a certificate

        System.out.println("Secure Server listening on port 8443...");

        while (true) {
            // Handle incoming connections
            SSLServerSocket socket = (SSLServerSocket) serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());
            // ... (handle client communication over the secure socket)
            socket.close();
        }
    }
}

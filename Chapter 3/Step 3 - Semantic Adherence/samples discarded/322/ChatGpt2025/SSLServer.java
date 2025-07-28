import javax.net.ssl.*;
import java.io.*;
import java.security.KeyStore;

public class SSLServer {
    public static void main(String[] args) throws Exception {
        // Load the keystore
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(new FileInputStream("keystore.jks"), "changeit".toCharArray());

        // Set up key manager
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        kmf.init(ks, "changeit".toCharArray());

        // Set up SSL context
        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(kmf.getKeyManagers(), null, null);

        // Create SSL server socket
        SSLServerSocketFactory ssf = sc.getServerSocketFactory();
        SSLServerSocket s = (SSLServerSocket) ssf.createServerSocket(8443);

        System.out.println("SSL Server started on port 8443");
        SSLSocket c = (SSLSocket) s.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
        PrintWriter out = new PrintWriter(c.getOutputStream(), true);
        out.println("Hello Secure World");
        System.out.println("Client connected and greeted.");
        c.close();
        s.close();
    }
}

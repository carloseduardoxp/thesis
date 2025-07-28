import java.util.Arrays;
import javax.net.ssl.SSLContext;

public class DisableTLSv13Example {
    public static void main(String[] args) throws Exception {
        // Disable TLSv1.3
        System.setProperty("jdk.tls.disabledAlgorithms", "TLSv1.3");

        // Create an SSL context with the default protocol
        SSLContext sslContext = SSLContext.getDefault();
        
        // Get the supported protocols
        String[] supportedProtocols = sslContext.getSupportedSSLParameters().getProtocols();
        System.out.println("Supported protocols: " + Arrays.toString(supportedProtocols));
    }
}

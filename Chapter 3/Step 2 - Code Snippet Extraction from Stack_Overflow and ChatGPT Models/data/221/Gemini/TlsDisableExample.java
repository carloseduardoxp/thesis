import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLParameters;

public class TlsDisableExample {
    public static void main(String[] args) throws Exception {
        // Option 1: Create an SSLContext that only supports TLSv1.2
        SSLContext context = SSLContext.getInstance("TLSv1.2");
        context.init(null, null, null); // Use default KeyManager and TrustManager

        // When creating SSLSockets or SSLEngines from this context,
        // they will default to TLSv1.2.
        SSLSocket socket = (SSLSocket) context.getSocketFactory().createSocket("example.com", 443);
        // Or for SSLEngine:
        // SSLEngine engine = context.createSSLEngine("example.com", 443);

        // Option 2: Explicitly set enabled protocols on an existing SSLSocket/SSLEngine
        // (if you didn't create it with a specific SSLContext)
        SSLSocket anotherSocket = new SSLSocket(); // Or get from an existing connection
        anotherSocket.setEnabledProtocols(new String[]{"TLSv1.2"});

        // Option 3: Using SSLParameters
        SSLParameters sslParameters = new SSLParameters();
        sslParameters.setProtocols(new String[]{"TLSv1.2"});
        anotherSocket.setSSLParameters(sslParameters);
    }
}

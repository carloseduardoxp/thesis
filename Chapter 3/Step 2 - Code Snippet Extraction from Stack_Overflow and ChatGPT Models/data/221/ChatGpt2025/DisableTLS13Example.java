import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class DisableTLS13Example {
    public static void main(String[] args) throws Exception {
        SSLContext context = SSLContext.getInstance("TLS");
        context.init(null, null, null);
        
        SSLSocketFactory factory = context.getSocketFactory();
        SSLSocket socket = (SSLSocket) factory.createSocket("example.com", 443);

        // Enable only TLSv1.2
        socket.setEnabledProtocols(new String[] {"TLSv1.2"});

        socket.startHandshake();

        System.out.println("Connected with protocol: " + socket.getSession().getProtocol());
    }
}

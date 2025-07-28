import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.util.HashMap;
import java.util.Map;

public class SoapClientWithSignature {

    public static void main(String[] args) {
        // Create your service and port (example)
        YourService service = new YourService();
        YourPortType port = service.getYourPort();
        
        // Get CXF client
        Client client = ClientProxy.getClient(port);
        
        // Configure WS-Security for signing
        Map<String, Object> outProps = new HashMap<>();
        
        // Action to perform (sign)
        outProps.put(WSHandlerConstants.ACTION, WSHandlerConstants.SIGNATURE);
        
        // User with private key for signing
        outProps.put(WSHandlerConstants.USER, "clientkey");
        
        // Password for private key
        outProps.put(WSHandlerConstants.PW_CALLBACK_CLASS, ClientKeystorePasswordCallback.class.getName());
        
        // Signature properties file
        outProps.put(WSHandlerConstants.SIG_PROP_FILE, "client_sign.properties");
        
        // Signature algorithm
        outProps.put(WSHandlerConstants.SIG_KEY_ID, "DirectReference");
        outProps.put(WSHandlerConstants.SIG_ALGO, WSConstants.RSA_SHA1);
        
        // Digest algorithm
        outProps.put(WSHandlerConstants.SIG_DIGEST_ALGO, WSConstants.SHA1);
        
        // Add the interceptor
        client.getOutInterceptors().add(new WSS4JOutInterceptor(outProps));
        
        // Call your service
        port.yourMethod(...);
    }
}

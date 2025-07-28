
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;

import java.util.HashMap;
import java.util.Map;
import javax.xml.ws.Service;
import javax.xml.namespace.QName;

public class SoapClient {
    public static void main(String[] args) {
        // Replace with your service WSDL and QName
        QName serviceName = new QName("http://example.com/namespace", "MyService");
        QName portName = new QName("http://example.com/namespace", "MyPort");
        Service service = Service.create(null, serviceName);
        // Replace with the actual endpoint address
        YourServiceInterface client = service.getPort(portName, YourServiceInterface.class);
        Client clientProxy = ClientProxy.getClient(client);

        Map<String, Object> outProps = new HashMap<>();
        outProps.put(ConfigurationConstants.ACTION, ConfigurationConstants.SIGNATURE);
        outProps.put(ConfigurationConstants.USER, "your_alias"); // Alias of the key in the KeyStore
        outProps.put(ConfigurationConstants.PASSWORD, "your_password"); // Password for the private key
        outProps.put(ConfigurationConstants.SIG_PROP_FILE, "clientKeystore.properties"); // Path to your KeyStore properties file
        outProps.put(ConfigurationConstants.SIGNATURE_PARTS, "{Element}{http://schemas.xmlsoap.org/soap/envelope/}Body;{Element}{http://example.com/namespace}YourOperation"); // Parts to sign (optional, but recommended)
        outProps.put(ConfigurationConstants.SIG_DIGEST_ALGO, WSConstants.SHA256); // Optional: Specify digest algorithm
        outProps.put(ConfigurationConstants.SIG_ALGO, WSConstants.RSA_SHA256); // Optional: Specify signature algorithm

        WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(outProps);
        clientProxy.getOutInterceptors().add(new LoggingOutInterceptor());
        clientProxy.getOutInterceptors().add(wssOut);
        clientProxy.getInInterceptors().add(new LoggingInInterceptor());

        // Now you can make your SOAP calls using the 'client' object
        try {
            // ... your service call ...
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

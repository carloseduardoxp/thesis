public class Example {

    public static void main(String[] args) throws Exception {
        SoapMessage soapMessage = null;
        soapMessage = MySOAPConnection.call();
        soapMessage.getSOAPPart().getEnvelope().getBody().getFault().getFaultCode();

    }
}

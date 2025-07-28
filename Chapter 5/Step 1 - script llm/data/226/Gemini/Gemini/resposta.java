import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.StringReader;
import java.io.IOException;

public class SecureDomParser {

    public static class XmlParsingException extends Exception {
        public XmlParsingException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static Document parseXml(String xmlString) throws XmlParsingException {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // 1. Disable DTDs entirely (most effective)
            dbf.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

            // 2. Disable external general and parameter entities (if DTDs cannot be fully disabled)
            dbf.setFeature("http://xml.org/sax/features/external-general-entities", false);
            dbf.setFeature("http://xml.org/sax/features/external-parameter-entities", false);

            // 3. Enable secure processing (limits recursion, prevents external resource access)
            dbf.setFeature(javax.xml.XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // Optional: Disable XInclude (if not needed)
            dbf.setXIncludeAware(false);
            dbf.setExpandEntityReferences(false); // Prevents expansion of internal entities, which can sometimes be exploited for DoS

            DocumentBuilder db = dbf.newDocumentBuilder();
            return db.parse(new InputSource(new StringReader(xmlString)));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new XmlParsingException("Failed to parse XML string.", e);
        }
    }

    public static void main(String[] args) {
        String safeXml = "<?xml version=\"1.0\"?><data><item>Hello</item></data>";
        String vulnerableXml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +
                               "<!DOCTYPE foo [<!ENTITY xxe SYSTEM \"file:///etc/passwd\">]>" +
                               "<foo>&xxe;</foo>";

        try {
            System.out.println("Parsing safe XML:");
            Document doc = parseXml(safeXml);
            System.out.println("Parsed successfully: " + doc.getDocumentElement().getNodeName());

            System.out.println("\nAttempting to parse vulnerable XML (should throw an exception):");
            Document vulnerableDoc = parseXml(vulnerableXml);
            // This line should ideally not be reached if security features are effective
            System.out.println("Parsed vulnerable XML (unexpected): " + vulnerableDoc.getDocumentElement().getNodeName());

        } catch (XmlParsingException e) {
            System.err.println("Error parsing XML: " + e.getMessage());
        }
    }
}

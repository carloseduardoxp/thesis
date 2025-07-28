import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class SecureDomParser {

    public static Document parseXml(String xmlString) throws Exception {
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

        } catch (Exception e) {
            System.err.println("Error parsing XML: " + e.getMessage());
        }
    }
}

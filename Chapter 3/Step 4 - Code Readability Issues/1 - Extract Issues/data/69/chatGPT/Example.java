import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Example {
    public static void main(String[] args) throws Exception {
        // Parse the XML file into a DOM document
        File file = new File("example.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(file);

        // Create an XPath object
        XPathFactory xpf = XPathFactory.newInstance();
        XPath xpath = xpf.newXPath();

        // Select the first "title" element in the document
        Node title = (Node) xpath.evaluate("//title[1]", doc, XPathConstants.NODE);

        // Print the text content of the title element
        System.out.println(title.getTextContent());
    }
}

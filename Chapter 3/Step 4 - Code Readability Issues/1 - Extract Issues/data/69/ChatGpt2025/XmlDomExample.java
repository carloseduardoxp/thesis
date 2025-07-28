import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;

public class XmlDomExample {
    public static void main(String[] args) throws Exception {
        // Load XML file
        File inputFile = new File("example.xml");

        // Create DocumentBuilder
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        // Parse XML document
        Document doc = builder.parse(inputFile);

        // Normalize the XML structure
        doc.getDocumentElement().normalize();

        // Get NodeList by tag name
        NodeList nodeList = doc.getElementsByTagName("yourNodeName");

        // Iterate through nodes
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Node name: " + node.getNodeName());
            System.out.println("Node value: " + node.getTextContent());
        }
    }
}

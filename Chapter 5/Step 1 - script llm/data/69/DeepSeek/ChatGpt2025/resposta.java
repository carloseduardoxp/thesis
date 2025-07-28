import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class DomXmlParser {
    public static void main(String[] args) throws Exception {
        // Parse XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse("file.xml");
        
        // Select all nodes with a specific tag name
        NodeList nodeList = document.getElementsByTagName("book");
        
        // Iterate through selected nodes
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            System.out.println("Node name: " + node.getNodeName());
            System.out.println("Node value: " + node.getTextContent());
        }
        
        // Select a single node by ID (if DTD or schema defines IDs)
        document.getElementById("book123");
    }
}
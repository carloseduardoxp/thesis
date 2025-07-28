import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.File;

public class SelectNodeDOM {
    public static void main(String[] args) {
        try {
            File xmlFile = new File("your_file.xml"); // Replace with your XML file
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Select all elements with a specific tag name
            NodeList nodeList = doc.getElementsByTagName("book");
            System.out.println("Number of 'book' elements: " + nodeList.getLength());
            for (int i = 0; i < nodeList.getLength(); i++) {
                Element book = (Element) nodeList.item(i);
                System.out.println("Book title: " + book.getElementsByTagName("title").item(0).getTextContent());
            }

            // Select an element by its ID (if the XML has IDs defined)
            Element specificBook = doc.getElementById("book123"); // Assuming an element has id="book123"
            if (specificBook != null) {
                System.out.println("Specific book title: " + specificBook.getElementsByTagName("title").item(0).getTextContent());
            }

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}

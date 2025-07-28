import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public class DomToStringConverter {
    public static void main(String[] args) {
        // Create a Document object
        Document document = createDocument();

        // Convert the Document to a string
        String xmlString = convertDocumentToString(document);

        // Print the XML string
        System.out.println(xmlString);
    }

    public static String convertDocumentToString(Document document) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();
        } catch (TransformerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Document createDocument() {
        // Create a new Document object
        // ...
        return document;
    }
}

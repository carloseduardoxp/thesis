import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

public class DomToStringConverter {

    public static void main(String[] args) {
        try {
            // 1. Create a sample DOM Document (for demonstration purposes)
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("Company");
            doc.appendChild(rootElement);

            Element staff = doc.createElement("Staff");
            rootElement.appendChild(staff);

            Element name = doc.createElement("Name");
            name.appendChild(doc.createTextNode("John Doe"));
            staff.appendChild(name);

            Element age = doc.createElement("Age");
            age.appendChild(doc.createTextNode("30"));
            staff.appendChild(age);

            // 2. Convert the DOM Document to a String
            String xmlString = convertDocumentToString(doc);
            System.out.println("Converted XML String (with indentation):");
            System.out.println(xmlString);

            // 3. Convert the DOM Document to a String without XML declaration and indentation
            String xmlStringNoDecl = convertDocumentToString(doc, true, false);
            System.out.println("\nConverted XML String (without XML declaration and no indentation):");
            System.out.println(xmlStringNoDecl);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts a org.w3c.dom.Document to a String with default indentation and XML declaration.
     *
     * @param doc The Document to convert.
     * @return The XML content as a String.
     * @throws XmlConversionException If an error occurs during transformation.
     */
    public static String convertDocumentToString(Document doc) throws XmlConversionException {
        return convertDocumentToString(doc, false, true); // Default: include XML declaration, indent
    }

    /**
     * Converts a org.w3c.dom.Document to a String with customizable options.
     *
     * @param doc                The Document to convert.
     * @param omitXmlDeclaration If true, the XML declaration (<?xml ...?>) will be omitted.
     * @param indent             If true, the output XML will be indented for readability.
     * @return The XML content as a String.
     * @throws XmlConversionException If an error occurs during transformation.
     */
    public static String convertDocumentToString(Document doc, boolean omitXmlDeclaration, boolean indent) throws XmlConversionException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer();

            // Set output properties
            if (omitXmlDeclaration) {
                transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            }
            if (indent) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4"); // For specific indentation
            }

            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            return writer.getBuffer().toString();
        } catch (Exception e) {
            throw new XmlConversionException("Error converting DOM Document to String", e);
        }
    }
}

class XmlConversionException extends Exception {
    public XmlConversionException(String message) {
        super(message);
    }

    public XmlConversionException(String message, Throwable cause) {
        super(message, cause);
    }
}
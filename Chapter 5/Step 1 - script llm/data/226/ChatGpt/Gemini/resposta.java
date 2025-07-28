import java.io.File;
import java.io.StringReader;
import java.util.Arrays;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

public class Teste {
  public static void main(String[] args) throws Exception {
    DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    documentBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(new File("schema.xsd"));
    Validator validator = schema.newValidator();
    validator.validate(new StreamSource(new File("input.xml")));
    
    XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
    xmlInputFactory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
    XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(new StringReader("<!DOCTYPE foo [<!ENTITY bar \"baz\">]><foo>&bar;</foo>"));
    while (reader.hasNext()) {
        int event = reader.next();
        if (event == XMLStreamConstants.ENTITY_REFERENCE && !Arrays.asList("bar").contains(reader.getLocalName())) {
            throw new XMLStreamException("Invalid entity");
        }
    }
  }
}

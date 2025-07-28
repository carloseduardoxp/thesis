public class Teste {
  public static void main(String[] args) {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);

    SAXParserFactory factory = SAXParserFactory.newInstance();
    factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
    SAXParser parser = factory.newSAXParser();

    SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = factory.newSchema(new File("schema.xsd"));
    Validator validator = schema.newValidator();
    validator.validate(new StreamSource(new File("input.xml")));
    XMLInputFactory factory = XMLInputFactory.newInstance();
    factory.setProperty(XMLInputFactory.SUPPORT_DTD, false);
    XMLStreamReader reader = factory.createXMLStreamReader(new StringReader("<!DOCTYPE foo [<!ENTITY bar \"baz\">]><foo>&bar;</foo>"));
    while (reader.hasNext()) {
        int event = reader.next();
        if (event == XMLStreamConstants.ENTITY_REFERENCE) {
            if (!Arrays.asList("bar").contains(reader.getLocalName())) {
                throw new Exception("Invalid entity");
            }
        }
}


  }
}

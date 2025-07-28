import javax.lang.model.element.Element;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.NodeList;

public class Teste {

    
    public static void main(String[] args) {
        XPath xp = XPathFactory.newInstance().newXPath();

        // Select the first child of the root element
        Element c1 = (Element) xp.evaluate("/parent/*[1]", doc,
                XPathConstants.NODE);

        // Select the siblings of the first child
        NodeList siblings = (NodeList) xp.evaluate("following-sibling::*", c1,
                XPathConstants.NODESET);
        for (int i = 0; i < siblings.getLength(); ++i) {
            System.out.println(siblings.item(i));
        }
    }
    
}
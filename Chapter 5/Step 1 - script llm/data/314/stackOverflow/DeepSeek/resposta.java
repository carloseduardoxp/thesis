import java.io.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class HtmlParseDemo {
   public static void main(String [] args) throws Exception {
       Reader reader = new StringReader("<table><tr><td>Hello</td><td>World!</td></tr></table>");
       HTMLEditorKit.Parser parser = new ParserDelegator();
       parser.parse(reader, new HTMLTableParser(), true);
       reader.close();
   }
}

class HTMLTableParser extends HTMLEditorKit.ParserCallback {

    private boolean encounteredATableRow = false;

    @Override
    public void handleText(char[] data, int pos) {
        if(encounteredATableRow) System.out.println(new String(data));
    }

    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if(t == HTML.Tag.TR) encounteredATableRow = true;
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if(t == HTML.Tag.TR) encounteredATableRow = false;
    }
}

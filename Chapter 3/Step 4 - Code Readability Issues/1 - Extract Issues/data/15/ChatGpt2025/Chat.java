import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlIngestExample {
    public static void main(String[] args) {
        String html = "<html><body><h1>Welcome</h1><p>This is a paragraph.</p></body></html>";

        // Parse HTML
        Document doc = Jsoup.parse(html);

        // Get the <h1> element
        Element h1 = doc.selectFirst("h1");
        System.out.println("Header: " + h1.text());

        // Get all <p> elements
        Elements paragraphs = doc.select("p");
        for (Element p : paragraphs) {
            System.out.println("Paragraph: " + p.text());
        }
    }
}

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParser {
    public static void main(String[] args) throws Exception {
        // Parse HTML from String
        String html = "<html><head><title>Test</title></head>"
                     + "<body><p>Hello World</p></body></html>";
        Document doc = Jsoup.parse(html);
        
        // Parse HTML from URL
        Jsoup.connect("http://example.com").get();
        
        // Extract data
        String title = doc.title();
        System.out.println("Title: " + title);
        
        Elements paragraphs = doc.select("p");
        for (Element p : paragraphs) {
            System.out.println("Paragraph: " + p.text());
        }
    }
}

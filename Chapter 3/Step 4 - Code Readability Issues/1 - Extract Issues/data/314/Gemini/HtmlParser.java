import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class HtmlParser {
    public static void main(String[] args) {
        String html = "<html><head><title>My Title</title></head>"
                    + "<body><p>This is a paragraph.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.title()); // Output: My Title
    }
}

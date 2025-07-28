import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlParserExample {
    public static void main(String[] args) {
        String html = "<html><head><title>My Title</title></head>"
                    + "<body><p>Hello, world!</p><a href='https://example.com'>Example</a></body></html>";

        Document doc = Jsoup.parse(html);

        // Get the title
        String title = doc.title();
        System.out.println("Title: " + title);

        // Get paragraph text
        Element paragraph = doc.select("p").first();
        System.out.println("Paragraph: " + paragraph.text());

        // Get hyperlink
        Element link = doc.select("a").first();
        System.out.println("Link text: " + link.text());
        System.out.println("Link href: " + link.attr("href"));
    }
}

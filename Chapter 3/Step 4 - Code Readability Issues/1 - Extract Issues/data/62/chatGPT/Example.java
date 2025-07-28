import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class Example {
    public static void main(String[] args) {
        String html = "<html><body><h1>Hello, world!</h1><p>This is a paragraph.</p></body></html>";
        Document doc = Jsoup.parse(html);
        String text = doc.body().text();
        System.out.println(text);
    }
}

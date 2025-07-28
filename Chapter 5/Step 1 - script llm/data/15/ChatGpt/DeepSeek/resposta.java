import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;

public class TextFileWriter {
    public static void main(String[] args) throws IOException {
        String html = "<html><body><h1>Hello World</h1></body></html>";
        Document document = Jsoup.parse(html);

        document.body().append("<p>This is a paragraph</p>"); // Add a new paragraph to the body
    }
}

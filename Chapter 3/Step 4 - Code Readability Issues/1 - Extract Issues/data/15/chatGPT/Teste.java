import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;


public class TextFileWriter {
    public static void main(String[] args) throws IOException {
        String html = "<html><body><h1>Hello World</h1></body></html>";
        Document document = Jsoup.parse(html);

        String title = document.getElementById("title").text(); // Get text content of an element with ID "title"
        String heading = document.getElementsByTag("h1").text(); // Get text content of all h1 elements

        document.body().append("<p>This is a paragraph</p>"); // Add a new paragraph to the body

    }
}

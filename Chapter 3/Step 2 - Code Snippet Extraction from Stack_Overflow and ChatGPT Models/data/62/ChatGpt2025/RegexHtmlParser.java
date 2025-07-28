import java.util.regex.*;
import java.util.*;

public class RegexHtmlParser {
    public static void main(String[] args) {
        String html = "<html><body>"
                    + "<a href=\"https://example.com\">Example</a>"
                    + "<a href=\"https://openai.com\">OpenAI</a>"
                    + "</body></html>";

        String regex = "<a\\s+[^>]*href\\s*=\\s*\"([^\"]*)\"[^>]*>";
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(html);

        List<String> links = new ArrayList<>();

        while (matcher.find()) {
            links.add(matcher.group(1));
        }

        for (String link : links) {
            System.out.println("Found link: " + link);
        }
    }
}

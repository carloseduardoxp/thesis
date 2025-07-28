import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlRegexParser {
    public static void main(String[] args) {
        String html = "<html><body><h1>Title</h1><p>Paragraph <a href=\"link.html\">with link</a></p></body></html>";
        
        // Extract all anchor tags - VERY FRAGILE APPROACH
        Pattern tagPattern = Pattern.compile("<a\\s+([^>]+)>([^<]+)</a>");
        Matcher matcher = tagPattern.matcher(html);
        
        while (matcher.find()) {
            System.out.println("Link attributes: " + matcher.group(1));
            System.out.println("Link text: " + matcher.group(2));
        }
        
        // Extract text content (naive approach)
        Pattern textPattern = Pattern.compile(">([^<]+)<");
        Matcher textMatcher = textPattern.matcher(html);
        
        while (textMatcher.find()) {
            System.out.println("Text content: " + textMatcher.group(1).trim());
        }
    }
}

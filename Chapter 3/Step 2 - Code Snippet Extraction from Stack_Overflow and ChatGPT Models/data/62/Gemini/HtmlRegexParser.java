import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlRegexParser {

    public static void main(String[] args) {
        String html = "<div class=\"item\"><span>Hello</span> <strong>World</strong></div>";

        // Example 1: Extracting text within <span> tags
        String spanRegex = "<span[^>]*>(.*?)</span>";
        Pattern spanPattern = Pattern.compile(spanRegex);
        Matcher spanMatcher = spanPattern.matcher(html);

        System.out.println("Text within <span> tags:");
        while (spanMatcher.find()) {
            System.out.println(spanMatcher.group(1));
        }

        System.out.println("---");

        // Example 2: Extracting the class attribute of a <div> tag
        String divClassRegex = "<div\\s+class=\"(.*?)\"";
        Pattern divClassPattern = Pattern.compile(divClassRegex);
        Matcher divClassMatcher = divClassPattern.matcher(html);

        System.out.println("Class attribute of <div> tag:");
        if (divClassMatcher.find()) {
            System.out.println(divClassMatcher.group(1));
        }

        System.out.println("---");

        // Example 3: Extracting content within <strong> tags
        String strongRegex = "<strong[^>]*>(.*?)</strong>";
        Pattern strongPattern = Pattern.compile(strongRegex);
        Matcher strongMatcher = strongPattern.matcher(html);

        System.out.println("Text within <strong> tags:");
        while (strongMatcher.find()) {
            System.out.println(strongMatcher.group(1));
        }
    }
}

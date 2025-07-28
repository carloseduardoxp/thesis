import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;

public class DateExtractor {
    public static void main(String[] args) {
        String text = "The date is 2023-04-02.";
        Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
        Matcher matcher = pattern.matcher(text);

        if (matcher.find()) {
            String dateString = matcher.group();
            LocalDate date = LocalDate.parse(dateString);
            System.out.println(date); // Output: 2023-04-02
        }
    }
}

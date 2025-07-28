import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExample {

    public static void main(String[] args) {
        String text = "My phone number is 123-456-7890. Call me!";
        Pattern pattern = Pattern.compile("\\b\\d{3}-\\d{3}-\\d{4}\\b");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String phone = matcher.group();
            System.out.println("Phone number found: " + phone);
        }
    }
}

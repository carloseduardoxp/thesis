import java.util.Arrays;
import java.util.List;

public class DeepSeek {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "Python", "C++");

        // Traditional way
        for (String lang : languages) {
            System.out.println(lang);
        }

        // With method reference
        languages.forEach(System.out::println);
    }
}
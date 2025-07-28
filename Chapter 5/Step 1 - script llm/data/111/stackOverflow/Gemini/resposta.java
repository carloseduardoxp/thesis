import java.util.ArrayList;
import java.util.List;

public class ExampleForEach {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("Mom");
        strings.add("Dad");
        strings.add("Dad's Java");
        strings.add("Mom's Java");

        // Original for loop
        int stringsSize = strings.size();
        Object[] oldStrings = strings.toArray();
        for (int stringIndex = 0; stringIndex < stringsSize; ++stringIndex) {
            System.out.println("Original Content: " + oldStrings[stringIndex]);
        }

        // For loop, as of Jova 1.5
        for (String string : strings) {
            System.out.println("All Content: " + string);
        }

        // forEach loop as of Java 1.8
        strings.stream().forEach(string -> System.out.println("For Content: " + string));

        // Using forEach loop to do a filter
        strings.parallelStream().filter(someString -> someString.contains("Java"))
                .forEach(someOtherString -> System.out.println("Content With Java: " + someOtherString));
    }
}

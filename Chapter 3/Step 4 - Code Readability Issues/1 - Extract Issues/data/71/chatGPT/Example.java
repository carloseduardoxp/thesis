import java.util.Arrays;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "orange", "pear", "kiwi"};
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
    }
}

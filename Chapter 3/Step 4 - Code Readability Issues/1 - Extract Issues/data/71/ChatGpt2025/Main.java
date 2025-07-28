import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String[] names = {"Alice", "Bob", "Charlie"};

        Stream<String> nameStream = Arrays.stream(names);

        nameStream.forEach(System.out::println);
    }
}

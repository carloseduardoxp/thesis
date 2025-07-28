import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream()                       // Create a stream
               .filter(n -> n % 2 == 0)        // Filter even numbers
               .forEach(System.out::println);  // Iterate (terminal operation)
    }
}

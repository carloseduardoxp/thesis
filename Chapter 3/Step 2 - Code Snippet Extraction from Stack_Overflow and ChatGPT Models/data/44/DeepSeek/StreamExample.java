import java.util.List;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Charlie", "David", "Eve");
        
        // Create a stream, filter, and iterate
        names.stream()
             .filter(name -> name.length() > 3)  // Filter condition
             .forEach(System.out::println);      // Iterate and print
    }
}

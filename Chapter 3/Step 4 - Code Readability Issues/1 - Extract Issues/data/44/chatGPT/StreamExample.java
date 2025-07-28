import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");

        // Use the stream() method to create a Stream from the List
        List<String> filteredFruits = fruits.stream()
                // Apply a filter to keep only the fruits starting with 'a' or 'c'
                .filter(fruit -> fruit.startsWith("a") || fruit.startsWith("c"))
                // Collect the filtered elements into a new List
                .collect(Collectors.toList());

        // Print the filtered List of fruits
        System.out.println(filteredFruits);
    }
}

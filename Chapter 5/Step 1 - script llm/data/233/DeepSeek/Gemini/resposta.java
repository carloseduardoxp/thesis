import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Using method reference is preferred over a lambda for this operation
        numbers.forEach(System.out::println);
    }
}

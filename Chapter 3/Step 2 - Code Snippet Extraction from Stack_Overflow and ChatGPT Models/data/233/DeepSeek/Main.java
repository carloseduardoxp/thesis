import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        
        // Using lambda
        numbers.forEach(x -> System.out.println(x));
        
        // Using method reference (static method)
        numbers.forEach(System.out::println);
    }
}
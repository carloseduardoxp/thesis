import java.util.Arrays;
import java.util.List;

public class MethodReferenceExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Anna", "Bob", "Charlie");

        // Pass a method reference to forEach
        names.forEach(System.out::println);  // prints each name
    }
}

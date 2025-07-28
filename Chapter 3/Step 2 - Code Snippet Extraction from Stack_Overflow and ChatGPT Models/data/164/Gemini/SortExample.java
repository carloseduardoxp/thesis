import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Bob");
        names.add("David");

        System.out.println("Original list: " + names);

        Collections.sort(names); // Sorts in natural ascending order

        System.out.println("Sorted list (natural): " + names);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(8);
        numbers.add(2);

        System.out.println("Original numbers: " + numbers);

        Collections.sort(numbers);

        System.out.println("Sorted numbers (natural): " + numbers);
    }
}

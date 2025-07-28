import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReverseSortExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // Create a custom comparator that sorts the list in reverse order
        Comparator<String> reverseComparator = Comparator.reverseOrder();

        // Sort the list using the custom comparator
        Collections.sort(names, reverseComparator);

        // Print the sorted list
        System.out.println(names);
    }
}

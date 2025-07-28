import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseSortNames {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Zoe");
        names.add("Eve");

        System.out.println("Original List: " + names);

        // Sort in reverse alphabetical order
        Collections.sort(names, Collections.reverseOrder());

        System.out.println("Reverse Sorted List: " + names);
    }
}

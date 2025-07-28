import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveDuplicatesExample {
    public static void main(String[] args) {
        List<Integer> listWithDuplicates = new ArrayList<>();
        listWithDuplicates.add(1);
        listWithDuplicates.add(2);
        listWithDuplicates.add(3);
        listWithDuplicates.add(1);
        listWithDuplicates.add(4);
        listWithDuplicates.add(2);
        listWithDuplicates.add(5);

        System.out.println("Original List: " + listWithDuplicates); // Output: [1, 2, 3, 1, 4, 2, 5]

        // Create a HashSet from the ArrayList
        Set<Integer> uniqueElements = new HashSet<>(listWithDuplicates);

        // Convert the HashSet back to an ArrayList (if needed)
        List<Integer> listWithoutDuplicates = new ArrayList<>(uniqueElements);

        System.out.println("List without Duplicates (HashSet): " + listWithoutDuplicates); // Output: [1, 2, 3, 4, 5] (order not guaranteed)
    }
}

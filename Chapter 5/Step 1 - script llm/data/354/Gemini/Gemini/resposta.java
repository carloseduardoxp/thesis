import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet; // For demonstration of an unsorted Set

public class SortedSetExample {
    private static final String APPLE = "apple";

    public static void main(String[] args) {
        // 1. Using HashSet (no guaranteed order)
        Set<String> unsortedSet = new HashSet<>();
        unsortedSet.add("banana");
        unsortedSet.add(APPLE);
        unsortedSet.add("grape");
        unsortedSet.add("orange");
        unsortedSet.add(APPLE); // Duplicates are not added to a Set

        System.out.println("Unsorted Set (HashSet): " + unsortedSet); 
        // Output will vary, e.g., [apple, orange, banana, grape] - no specific order

        System.out.println("-------------------------");

        // 2. Using TreeSet (automatically sorted alphabetically)
        Set<String> sortedSet = new TreeSet<>();
        sortedSet.add("banana");
        sortedSet.add(APPLE);
        sortedSet.add("grape");
        sortedSet.add("orange");
        sortedSet.add(APPLE); // Still only one "apple"

        System.out.println("Sorted Set (TreeSet): " + sortedSet);
        // Output: [apple, banana, grape, orange] - automatically sorted
        
        System.out.println("-------------------------");

        // 3. Converting an existing Set to a TreeSet for sorting
        Set<String> anotherUnsortedSet = new HashSet<>();
        anotherUnsortedSet.add("zebra");
        anotherUnsortedSet.add("cat");
        anotherUnsortedSet.add("dog");

        System.out.println("Another Unsorted Set (HashSet): " + anotherUnsortedSet);

        Set<String> newlySortedSet = new TreeSet<>(anotherUnsortedSet);
        System.out.println("Newly Sorted Set (from HashSet to TreeSet): " + newlySortedSet);
        // Output: [cat, dog, zebra]
    }
}

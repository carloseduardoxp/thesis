import java.util.SortedSet;
import java.util.TreeSet;
import java.util.Comparator;

public class SortedSetExample {
    public static void main(String[] args) {
        // Using natural ordering (for Strings)
        SortedSet<String> naturalOrderSet = new TreeSet<>();
        naturalOrderSet.add("banana");
        naturalOrderSet.add("apple");
        naturalOrderSet.add("orange");
        naturalOrderSet.add("banana"); // Duplicate, won't be added
        System.out.println("Natural Order Set: " + naturalOrderSet); // Output: [apple, banana, orange]

        // Using a custom Comparator (to sort by string length)
        Comparator<String> lengthComparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        SortedSet<String> customOrderSet = new TreeSet<>(lengthComparator);
        customOrderSet.add("cat");
        customOrderSet.add("elephant");
        customOrderSet.add("dog");
        customOrderSet.add("zebra");
        System.out.println("Custom Order Set (by length): " + customOrderSet); // Output might vary based on tie-breaking, but lengths will be sorted. Example: [cat, dog, zebra, elephant]
    }
}

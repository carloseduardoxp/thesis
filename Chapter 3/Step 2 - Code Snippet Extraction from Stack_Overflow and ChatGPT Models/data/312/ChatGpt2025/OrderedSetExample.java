import java.util.LinkedHashSet;
import java.util.Set;

public class OrderedSetExample {
    public static void main(String[] args) {
        Set<String> orderedSet = new LinkedHashSet<>();
        orderedSet.add("Apple");
        orderedSet.add("Banana");
        orderedSet.add("Cherry");
        orderedSet.add("Banana"); // Duplicate, won't be added

        for (String fruit : orderedSet) {
            System.out.println(fruit);
        }
        // Output:
        // Apple
        // Banana
        // Cherry
    }
}

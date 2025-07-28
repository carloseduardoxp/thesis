import java.util.*;

public class SortSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Banana");
        set.add("Apple");
        set.add("Orange");
        set.add("Mango");

        // Convert Set to List
        List<String> list = new ArrayList<>(set);

        // Sort the list alphabetically
        Collections.sort(list);

        // If you want a sorted set, you can use LinkedHashSet to preserve order
        Set<String> sortedSet = new LinkedHashSet<>(list);

        // Print sorted elements
        for (String fruit : sortedSet) {
            System.out.println(fruit);
        }
    }
}

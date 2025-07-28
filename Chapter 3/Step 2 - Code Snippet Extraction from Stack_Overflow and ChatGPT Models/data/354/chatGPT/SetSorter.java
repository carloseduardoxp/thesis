import java.util.*;

public class SetSorter {
    public static void main(String[] args) {
        // Create a Set of strings
        Set<String> set = new HashSet<>();
        set.add("banana");
        set.add("apple");
        set.add("cherry");

        // Convert the Set to a List
        List<String> list = new ArrayList<>(set);

        // Sort the List alphabetically
        Collections.sort(list);

        // Print the sorted List
        System.out.println(list);
    }
}

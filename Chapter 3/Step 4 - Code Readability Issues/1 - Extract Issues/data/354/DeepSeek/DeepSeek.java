import java.util.*;

public class DeepSeek {

    public static void main(String[] args) {

        Set<String> unsortedSet = new HashSet<>();
        unsortedSet.add("banana");
        unsortedSet.add("apple");
        unsortedSet.add("cherry");

// Convert to TreeSet for automatic sorting
        Set<String> sortedSet = new TreeSet<>(unsortedSet);

        System.out.println(sortedSet); // [apple, banana, cherry]

    }

}

import java.util.*;

public class SortExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Banana");
        list.add("Apple");
        list.add("Orange");

        Collections.sort(list);  // Sorts in natural (alphabetical) order

        System.out.println(list); // Output: [Apple, Banana, Orange]
    }
}

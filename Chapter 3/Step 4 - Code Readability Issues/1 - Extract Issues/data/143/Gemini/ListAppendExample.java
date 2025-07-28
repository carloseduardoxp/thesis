import java.util.ArrayList;
import java.util.List;

public class ListAppendExample {
    public static void main(String[] args) {
        // Create the first list
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        // Create the second list
        List<String> list2 = new ArrayList<>();
        list2.add("Cherry");
        list2.add("Date");

        System.out.println("List 1 before appending: " + list1); // Output: [Apple, Banana]
        System.out.println("List 2: " + list2);               // Output: [Cherry, Date]

        // Append list2 to list1
        list1.addAll(list2);

        System.out.println("List 1 after appending: " + list1);  // Output: [Apple, Banana, Cherry, Date]
    }
}

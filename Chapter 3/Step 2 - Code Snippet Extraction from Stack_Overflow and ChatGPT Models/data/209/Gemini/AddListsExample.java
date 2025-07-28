import java.util.ArrayList;
import java.util.List;

public class AddListsExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        List<String> list2 = new ArrayList<>();
        list2.add("Cherry");
        list2.add("Date");

        System.out.println("List 1 before adding: " + list1); // Output: [Apple, Banana]
        System.out.println("List 2: " + list2);             // Output: [Cherry, Date]

        // Add all elements from list2 to list1
        list1.addAll(list2);

        System.out.println("List 1 after adding: " + list1);  // Output: [Apple, Banana, Cherry, Date]
    }
}

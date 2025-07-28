import java.util.ArrayList;
import java.util.List;

public class InsertExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        // Add some initial elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Insert "Orange" at index 1
        list.add(1, "Orange");

        // Print the list
        System.out.println(list);
    }
}

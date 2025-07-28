import java.util.ArrayList;
import java.util.List;

public class InsertIntoList {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");    // Index 0
        fruits.add("Banana");   // Index 1
        fruits.add("Orange");   // Index 2

        System.out.println("Original list: " + fruits); // Output: [Apple, Banana, Orange]

        // Insert "Grape" at index 1
        fruits.add(1, "Grape");

        System.out.println("List after inserting Grape at index 1: " + fruits); // Output: [Apple, Grape, Banana, Orange]

        // Insert "Kiwi" at the beginning (index 0)
        fruits.add(0, "Kiwi");

        System.out.println("List after inserting Kiwi at index 0: " + fruits); // Output: [Kiwi, Apple, Grape, Banana, Orange]

        // Insert "Mango" at the end (index equals to current size)
        fruits.add(fruits.size(), "Mango");

        System.out.println("List after inserting Mango at the end: " + fruits); // Output: [Kiwi, Apple, Grape, Banana, Orange, Mango]

        try {
            // Attempt to insert at an invalid index (out of bounds)
            fruits.add(10, "Invalid Fruit");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage()); // Output: Error: Index: 10, Size: 6
        }
    }
}

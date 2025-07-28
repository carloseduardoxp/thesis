import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Date");

        // Obtain an Iterator from the list
        Iterator<String> iterator = fruits.iterator();

        System.out.println("Iterating through fruits:");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.println(fruit);

            // Example of removing an element during iteration
            if (fruit.equals("Banana")) {
                iterator.remove(); // Safely removes "Banana"
            }
        }

        System.out.println("\nFruits after removal:");
        // After iteration, you can see the modified list
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}

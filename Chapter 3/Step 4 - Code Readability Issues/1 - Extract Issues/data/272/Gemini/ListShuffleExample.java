import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListShuffleExample {
    public static void main(String[] args) {
        // Create a List
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");
        fruits.add("Mango");

        System.out.println("Original List: " + fruits);

        // Shuffle the list
        Collections.shuffle(fruits);

        System.out.println("Shuffled List: " + fruits);
    }
}

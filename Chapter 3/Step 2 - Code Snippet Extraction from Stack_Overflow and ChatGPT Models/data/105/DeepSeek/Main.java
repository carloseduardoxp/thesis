import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        System.out.println("Original list: " + fruits);
        
        // Insert "Mango" at index 1
        fruits.add(1, "Mango");
        
        System.out.println("After insertion: " + fruits);
    }
}

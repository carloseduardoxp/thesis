import java.util.ArrayList; // Import the ArrayList class

public class Main {
    public static void main(String[] args) {
        // Create an ArrayList of Strings
        ArrayList<String> fruits = new ArrayList<>();
        
        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        
        // Access elements
        System.out.println(fruits.get(0)); // Output: Apple
        
        // Remove elements
        fruits.remove("Banana");
        
        // Get size
        System.out.println(fruits.size()); // Output: 2
    }
}

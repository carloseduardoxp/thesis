import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapToArrayKeys {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("Apple", 1);
        myMap.put("Banana", 2);
        myMap.put("Cherry", 3);

        // --- Method 1: Using toArray() with a new array of the correct size ---
        String[] keysArray1 = myMap.keySet().toArray(new String[0]); // Using new String[0] is often preferred for type inference and efficiency

        System.out.println("Keys Array (Method 1):");
        for (String key : keysArray1) {
            System.out.println(key);
        }

        // --- Method 2: Using toArray() with the size of the set ---
        String[] keysArray2 = myMap.keySet().toArray(new String[myMap.keySet().size()]);

        System.out.println("\nKeys Array (Method 2):");
        for (String key : keysArray2) {
            System.out.println(key);
        }
    }
}

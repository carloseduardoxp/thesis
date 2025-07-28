import java.util.HashMap;

public class Example {
    public static void main(String[] args) {
        // Create a HashMap with Integer keys and String values
        HashMap<Integer, String> map = new HashMap<>();

        // Add key-value pairs to the map
        map.put(1, "Apple");
        map.put(2, "Banana");
        map.put(3, "Orange");

        // Access a value using its key
        String fruit = map.get(2);  // Returns "Banana"
        System.out.println("Value for key 2: " + fruit);

        // Check if a key exists
        if (map.containsKey(3)) {
            System.out.println("Key 3 is present.");
        }

        // Iterate over the HashMap
        for (Integer key : map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + map.get(key));
        }
    }
}

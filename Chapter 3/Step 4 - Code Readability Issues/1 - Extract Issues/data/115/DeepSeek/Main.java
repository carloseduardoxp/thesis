import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        // Create a HashMap with String keys and Integer values
        HashMap<String, Integer> map = new HashMap<>();
        
        // Add elements to the HashMap
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Charlie", 28);
        
        // Access a value
        System.out.println("Bob's age: " + map.get("Bob")); // Output: 30
        
        // Check if a key exists
        System.out.println("Contains Alice? " + map.containsKey("Alice")); // Output: true
        
        // Remove an entry
        map.remove("Charlie");
        
        // Iterate through the HashMap
        for (String name : map.keySet()) {
            System.out.println(name + ": " + map.get(name));
        }
    }
}

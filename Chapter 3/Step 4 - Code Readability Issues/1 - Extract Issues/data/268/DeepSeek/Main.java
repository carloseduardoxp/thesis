import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("orange", 3);
        
        // Get all keys
        Set<String> keys = map.keySet();
        
        // Print all keys
        for (String key : keys) {
            System.out.println(key);
        }
        
        // Or using Java 8+ forEach
        keys.forEach(System.out::println);
    }
}

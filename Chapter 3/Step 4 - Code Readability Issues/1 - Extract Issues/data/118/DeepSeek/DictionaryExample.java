import java.util.HashMap;
import java.util.Map;

public class DictionaryExample {
    public static void main(String[] args) {
        // Create a dictionary using HashMap
        Map<String, String> dictionary = new HashMap<>();
        
        // Add key-value pairs
        dictionary.put("apple", "a fruit that grows on trees");
        dictionary.put("computer", "an electronic device for processing data");
        dictionary.put("book", "a written or printed work consisting of pages");
        
        // Access values
        System.out.println("Definition of apple: " + dictionary.get("apple"));
        
        // Check if key exists
        if (dictionary.containsKey("computer")) {
            System.out.println("Computer is in the dictionary");
        }
        
        // Iterate through dictionary
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

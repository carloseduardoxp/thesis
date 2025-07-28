import java.util.HashMap;
import java.util.Map;

public class DictionaryExample {
    public static void main(String[] args) {
        // Create a dictionary (HashMap) where the key is a String and the value is also a String
        Map<String, String> dictionary = new HashMap<>();

        // Add some key-value pairs to the dictionary
        dictionary.put("apple", "A fruit that is red, green, or yellow");
        dictionary.put("java", "A popular programming language");
        dictionary.put("book", "A collection of written or printed pages");

        // Access a value by key
        String definition = dictionary.get("java");
        System.out.println("Definition of java: " + definition);

        // Check if a key exists
        if (dictionary.containsKey("apple")) {
            System.out.println("Apple is in the dictionary.");
        }

        // Iterate over all entries
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

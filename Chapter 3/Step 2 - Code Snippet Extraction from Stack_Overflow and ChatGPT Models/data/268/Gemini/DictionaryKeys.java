import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DictionaryKeys {
    public static void main(String[] args) {
        // 1. Create a Map (HashMap is a common implementation)
        Map<String, Integer> studentScores = new HashMap<>();

        // 2. Add some key-value pairs
        studentScores.put("Alice", 95);
        studentScores.put("Bob", 88);
        studentScores.put("Charlie", 72);
        studentScores.put("David", 91);

        // 3. Get all the keys using keySet()
        Set<String> keys = studentScores.keySet();

        // 4. Iterate over the keys (common ways)

        // a) Using a for-each loop (most common and readable)
        System.out.println("Keys using for-each loop:");
        for (String key : keys) {
            System.out.println(key);
        }

        // b) Using an Iterator
        System.out.println("\nKeys using Iterator:");
        java.util.Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // c) Using Java 8 Streams (more concise for some operations)
        System.out.println("\nKeys using Java 8 Streams:");
        keys.forEach(System.out::println);
    }
}

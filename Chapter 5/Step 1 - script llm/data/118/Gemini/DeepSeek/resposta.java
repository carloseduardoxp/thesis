import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A simple dictionary implementation in Java using a HashMap.
 * This class allows storing and retrieving key-value pairs.
 */
public class Dictionary<K, V> {
    private static final String ALICE = "Alice";
    private static final String KEY_VALUE_FORMAT = "Key = %s, Value = %s";
    private static final String KEY_NOT_FOUND_FORMAT = "Key '%s' not found in dictionary.";
    
    private Map<K, V> map;

    public Dictionary() {
        this.map = new HashMap<>();
    }

    public void add(K key, V value) {
        map.put(key, value);
        System.out.println("Added/Updated: " + String.format(KEY_VALUE_FORMAT, key, value));
    }

    public V get(K key) {
        V value = map.get(key);
        if (value != null) {
            System.out.println("Retrieved: " + String.format(KEY_VALUE_FORMAT, key, value));
        } else {
            System.out.println(String.format(KEY_NOT_FOUND_FORMAT, key));
        }
        return value;
    }

    public V remove(K key) {
        V removedValue = map.remove(key);
        if (removedValue != null) {
            System.out.println("Removed: " + String.format(KEY_VALUE_FORMAT, key, removedValue));
        } else {
            System.out.println("Cannot remove: " + String.format(KEY_NOT_FOUND_FORMAT, key));
        }
        return removedValue;
    }

    public boolean containsKey(K key) {
        boolean contains = map.containsKey(key);
        System.out.println("Contains key '" + key + "': " + contains);
        return contains;
    }

    public int size() {
        int currentSize = map.size();
        System.out.println("Current dictionary size: " + currentSize);
        return currentSize;
    }

    public boolean isEmpty() {
        boolean empty = map.isEmpty();
        System.out.println("Is dictionary empty: " + empty);
        return empty;
    }

    public Set<K> keySet() {
        System.out.println("Keys in dictionary: " + map.keySet());
        return map.keySet();
    }

    public void clear() {
        map.clear();
        System.out.println("Dictionary cleared.");
    }

    public static void main(String[] args) {
        Dictionary<String, Integer> studentAges = new Dictionary<>();

        System.out.println("\n--- Adding elements ---");
        studentAges.add(ALICE, 20);
        studentAges.add("Bob", 22);
        studentAges.add("Charlie", 21);
        studentAges.size();

        System.out.println("\n--- Retrieving elements ---");
        studentAges.get(ALICE);
        studentAges.get("David");

        System.out.println("\n--- Updating an element ---");
        studentAges.add(ALICE, 21);
        studentAges.get(ALICE);

        System.out.println("\n--- Checking for keys ---");
        studentAges.containsKey("Bob");
        studentAges.containsKey("Eve");

        System.out.println("\n--- Removing elements ---");
        studentAges.remove("Bob");
        studentAges.remove("Frank");
        studentAges.size();

        System.out.println("\n--- Iterating through keys ---");
        studentAges.keySet();

        System.out.println("\n--- Clearing the dictionary ---");
        studentAges.clear();
        studentAges.isEmpty();
        studentAges.size();
    }
}
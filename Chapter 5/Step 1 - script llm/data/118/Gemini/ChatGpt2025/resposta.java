import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * A simple dictionary implementation in Java using a HashMap.
 * This class allows storing and retrieving key-value pairs.
 */
public class Dictionary<K, V> {

    // The internal HashMap to store the key-value pairs.
    private Map<K, V> map;

    // Constants for duplicated string literals
    private static final String ALICE = "Alice";
    private static final String COMMA = ",";

    /**
     * Constructs a new, empty Dictionary.
     */
    public Dictionary() {
        this.map = new HashMap<>();
    }

    /**
     * Adds a new key-value pair to the dictionary.
     * If the key already exists, its associated value will be updated.
     *
     * @param key   The key to be added or updated.
     * @param value The value associated with the key.
     */
    public void add(K key, V value) {
        map.put(key, value);
        System.out.println("Added/Updated: Key = " + key + COMMA + " Value = " + value);
    }

    /**
     * Retrieves the value associated with the specified key.
     *
     * @param key The key whose associated value is to be returned.
     * @return The value to which the specified key is mapped, or null if this dictionary contains no mapping for the key.
     */
    public V get(K key) {
        V value = map.get(key);
        if (value != null) {
            System.out.println("Retrieved: Key = " + key + COMMA + " Value = " + value);
        } else {
            System.out.println("Key '" + key + "' not found in dictionary.");
        }
        return value;
    }

    /**
     * Removes the mapping for a key from this dictionary if it is present.
     *
     * @param key The key whose mapping is to be removed from the dictionary.
     * @return The previous value associated with key, or null if there was no mapping for key.
     */
    public V remove(K key) {
        V removedValue = map.remove(key);
        if (removedValue != null) {
            System.out.println("Removed: Key = " + key + COMMA + " Value = " + removedValue);
        } else {
            System.out.println("Cannot remove: Key '" + key + "' not found in dictionary.");
        }
        return removedValue;
    }

    /**
     * Checks if the dictionary contains a mapping for the specified key.
     *
     * @param key The key whose presence in this dictionary is to be tested.
     * @return true if this dictionary contains a mapping for the specified key.
     */
    public boolean containsKey(K key) {
        boolean contains = map.containsKey(key);
        System.out.println("Contains key '" + key + "': " + contains);
        return contains;
    }

    /**
     * Returns the number of key-value mappings in this dictionary.
     *
     * @return The number of key-value mappings in this dictionary.
     */
    public int size() {
        int currentSize = map.size();
        System.out.println("Current dictionary size: " + currentSize);
        return currentSize;
    }

    /**
     * Checks if this dictionary contains no key-value mappings.
     *
     * @return true if this dictionary contains no key-value mappings.
     */
    public boolean isEmpty() {
        boolean empty = map.isEmpty();
        System.out.println("Is dictionary empty: " + empty);
        return empty;
    }

    /**
     * Returns a Set view of the keys contained in this dictionary.
     *
     * @return A set view of the keys contained in this dictionary.
     */
    public Set<K> keySet() {
        System.out.println("Keys in dictionary: " + map.keySet());
        return map.keySet();
    }

    /**
     * Clears all mappings from this dictionary.
     * The dictionary will be empty after this call returns.
     */
    public void clear() {
        map.clear();
        System.out.println("Dictionary cleared.");
    }

    /**
     * Main method to demonstrate the usage of the Dictionary class.
     */
    public static void main(String[] args) {
        // Create a dictionary with String keys and Integer values
        Dictionary<String, Integer> studentAges = new Dictionary<>();

        System.out.println("\n--- Adding elements ---");
        studentAges.add(ALICE, 20);
        studentAges.add("Bob", 22);
        studentAges.add("Charlie", 21);
        studentAges.size();

        System.out.println("\n--- Retrieving elements ---");
        studentAges.get(ALICE);
        studentAges.get("David"); // Key not found

        System.out.println("\n--- Updating an element ---");
        studentAges.add(ALICE, 21); // Update Alice's age
        studentAges.get(ALICE);

        System.out.println("\n--- Checking for keys ---");
        studentAges.containsKey("Bob");
        studentAges.containsKey("Eve");

        System.out.println("\n--- Removing elements ---");
        studentAges.remove("Bob");
        studentAges.remove("Frank"); // Key not found
        studentAges.size();

        System.out.println("\n--- Iterating through keys ---");
        studentAges.keySet();

        System.out.println("\n--- Clearing the dictionary ---");
        studentAges.clear();
        studentAges.isEmpty();
        studentAges.size();
    }
}

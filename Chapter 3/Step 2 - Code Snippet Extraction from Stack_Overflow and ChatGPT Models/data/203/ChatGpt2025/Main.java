import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        String[] keys = map.keySet().toArray(new String[0]);

        System.out.println(Arrays.toString(keys));  // Output: [apple, banana, cherry]
    }
}

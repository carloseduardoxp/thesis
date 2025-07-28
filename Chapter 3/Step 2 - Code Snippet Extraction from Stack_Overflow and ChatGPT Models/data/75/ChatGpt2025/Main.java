import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("apple", 1);
        map.put("banana", 2);
        map.put("cherry", 3);

        // Convert keys to a List
        List<String> keysList = new ArrayList<>(map.keySet());

        System.out.println(keysList); // Output: [apple, banana, cherry]
    }
}

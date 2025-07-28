import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        
        // Convert keys to array
        String[] keysArray = map.keySet().toArray(new String[0]);
        System.out.println(Arrays.toString(keysArray));
    }
}

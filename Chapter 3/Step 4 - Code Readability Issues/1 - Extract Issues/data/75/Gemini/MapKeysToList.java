import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapKeysToList {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();
        myMap.put("Apple", 1);
        myMap.put("Banana", 2);
        myMap.put("Orange", 3);

        // Using streams (Java 8+)
        List<String> keysListStream = myMap.keySet().stream()
                                            .collect(Collectors.toList());

        System.out.println("Keys (Stream): " + keysListStream);
    }
}

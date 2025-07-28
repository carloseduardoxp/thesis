import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapKeysExample {
   public static void main(String[] args) {
      // Create a new Map object
      Map<String, Integer> map = new HashMap<>();
      map.put("John", 30);
      map.put("Jane", 25);
      map.put("Bob", 35);

      // Get all the keys in the map
      Set<String> keys = map.keySet();

      // Print all the keys
      for (String key : keys) {
         System.out.println(key);
      }
   }
}

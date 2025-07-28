import java.util.*;

public class Teste {
  public static void main(String[] args) {
    List<String> list = Arrays.asList("A", "B", "C", "A", "B", "D");
    Map<String, Boolean> map = new LinkedHashMap<>();
    for (String item : list) {
        map.put(item, !map.containsKey(item));
    }


  }
}

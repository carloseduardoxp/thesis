
import java.util.ArrayList;
import java.util.Optional;

public class Teste {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    list.add("apple");
    list.add("banana");
    list.add("orange");
    System.out.println(list.indexOf("banana")); // 1
    System.out.println(list.indexOf("grape")); // -1

    System.out.println(list.lastIndexOf("banana")); // 3
    System.out.println(list.lastIndexOf("grape")); // -1

    Optional<String> result = list.stream().filter(e -> e.startsWith("b")).findFirst();
    if (result.isPresent()) {
        System.out.println(result.get()); // "banana"
    } else {
        System.out.println("No element found.");
    }

  }
}

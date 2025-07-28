import java.util.ArrayList;
import java.util.List;

public class ExampleInsertItem {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("apple");
    list.add("banana");
    list.add("orange");
    
    System.out.println("Original list: " + list);
    
    // Insert an item at index 1
    list.add(1, "grape");
    
    System.out.println("Modified list: " + list);
  }
}

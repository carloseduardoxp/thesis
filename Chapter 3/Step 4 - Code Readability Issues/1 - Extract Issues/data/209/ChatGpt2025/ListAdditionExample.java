import java.util.ArrayList;
import java.util.List;

public class ListAdditionExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        List<String> list2 = new ArrayList<>();
        list2.add("Orange");
        list2.add("Grapes");

        // Add all elements from list2 to list1
        list1.addAll(list2);

        System.out.println("Combined List: " + list1);
    }
}

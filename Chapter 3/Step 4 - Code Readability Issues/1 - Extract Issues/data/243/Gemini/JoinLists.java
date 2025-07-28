import java.util.ArrayList;
import java.util.List;

public class JoinLists {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Apple");
        list1.add("Banana");

        List<String> list2 = new ArrayList<>();
        list2.add("Orange");
        list2.add("Grape");

        // Join list2 into list1
        list1.addAll(list2);

        System.out.println("Joined list (using addAll): " + list1);
        // Output: Joined list (using addAll): [Apple, Banana, Orange, Grape]
    }
}

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");

        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("D");

        // Append list2 to list1
        list1.addAll(list2);

        System.out.println(list1); // Output: [A, B, C, D]
    }
}

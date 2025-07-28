
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DeepSeek {

    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        List<String> list2 = new ArrayList<>(Arrays.asList("D", "E", "F"));

        list1.addAll(list2); // Adds all elements of list2 to list1
        System.out.println(list1); // [A, B, C, D, E, F]

    }

}

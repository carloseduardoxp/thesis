import java.util.ArrayList;
import java.util.List;

public class ListJoinExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");

        List<String> list2 = new ArrayList<>();
        list2.add("C");
        list2.add("D");

        list1.addAll(list2);

        System.out.println(list1);

        List<String> newList = Stream.concat(list1.stream(), list2.stream())
                             .collect(Collectors.toList());

    }
}

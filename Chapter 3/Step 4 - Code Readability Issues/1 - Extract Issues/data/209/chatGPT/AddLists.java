import java.util.*;

public class AddLists {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> sum = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            sum.add(list1.get(i) + list2.get(i));
        }
        System.out.println("The sum of the lists is " + sum);
    }
}

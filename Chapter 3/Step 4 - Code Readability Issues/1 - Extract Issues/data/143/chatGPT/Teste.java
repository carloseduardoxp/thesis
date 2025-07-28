
import java.util.ArrayList;
import java.util.List;

public class Teste {
  public static void main(String[] args) {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);

    List<Integer> list2 = new ArrayList<>();
    list2.add(4);
    list2.add(5);
    list2.add(6);

    list1.addAll(list2);

    System.out.println(list1); // Output: [1, 2, 3, 4, 5, 6]

  }
}

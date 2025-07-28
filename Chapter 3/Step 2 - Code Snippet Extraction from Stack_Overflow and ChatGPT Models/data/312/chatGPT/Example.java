import java.util.TreeSet;

public class Example {
  public static void main(String[] args) {
    TreeSet<Integer> set = new TreeSet<>();
    set.add(5);
    set.add(2);
    set.add(7);
    set.add(1);
    set.add(9);

    System.out.println(set); // Output: [1, 2, 5, 7, 9]
  }
}

import java.util.*;

public class ReverseSortExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(Arrays.asList("Alice", "Bob", "Charlie", "David"));

        // Sort in reverse alphabetical order
        Collections.sort(names, Collections.reverseOrder());

        System.out.println(names);
    }
}

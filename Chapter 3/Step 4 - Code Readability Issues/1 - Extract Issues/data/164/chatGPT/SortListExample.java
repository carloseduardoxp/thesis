import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortListExample {
    public static void main(String[] args) {
        // create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(1);
        numbers.add(4);
        numbers.add(2);
        numbers.add(5);

        // sort the list in ascending order
        Collections.sort(numbers);

        // print the sorted list
        System.out.println(numbers);
    }
}


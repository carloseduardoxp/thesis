import java.util.Arrays;
import java.util.Collections;

public class SortDescending {
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 8, 1, 9, 4};

        // Sort in natural (ascending) order, then reverse
        Arrays.sort(numbers, Collections.reverseOrder());

        System.out.println("Sorted (highest to lowest): " + Arrays.toString(numbers)); // Output: [9, 8, 5, 4, 2, 1]
    }
}

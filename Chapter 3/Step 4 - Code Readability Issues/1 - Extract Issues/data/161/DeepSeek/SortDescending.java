import java.util.Arrays;
import java.util.Collections;

public class SortDescending {
    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 5, 6};
        
        // Sort in descending order
        Arrays.sort(numbers, Collections.reverseOrder());
        
        System.out.println(Arrays.toString(numbers)); // [9, 6, 5, 5, 2, 1]
    }
}

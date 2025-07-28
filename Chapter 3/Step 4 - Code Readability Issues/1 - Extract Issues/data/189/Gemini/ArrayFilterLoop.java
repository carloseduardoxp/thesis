import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayFilterLoop {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> filteredList = new ArrayList<>();

        for (int element : originalArray) {
            if (element % 2 == 0) { // Condition: element is even
                filteredList.add(element);
            }
        }

        // If you need an array as the final result:
        int[] filteredArray = filteredList.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Filtered List (Even Numbers): " + filteredList);
        System.out.println("Filtered Array (Even Numbers): " + Arrays.toString(filteredArray));
    }
}


import java.util.*;


public class Chat {

    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5, 6};
        int threshold = 3;

        List<Integer> filtered = new ArrayList<>();
        for (int num : numbers) {
            if (num > threshold) {
                filtered.add(num);
            }
        }

// If you want the result as an array:
        int[] filteredArray = filtered.stream().mapToInt(i -> i).toArray();

// Print filtered array
        System.out.println(Arrays.toString(filteredArray));

    }

}

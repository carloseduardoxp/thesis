import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 2, 4, 1, 5};

        // Step 1: Convert array to a Set to remove duplicates
        Set<Integer> set = new LinkedHashSet<>();
        for (int num : originalArray) {
            set.add(num);
        }

        // Step 2: Convert Set back to array
        int[] resultArray = new int[set.size()];
        int i = 0;
        for (int num : set) {
            resultArray[i++] = num;
        }

        // Step 3: Print the result
        System.out.println("Array without duplicates: " + Arrays.toString(resultArray));
    }
}

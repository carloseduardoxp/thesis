import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 4, 1, 5};

        // Convert to Set to remove duplicates
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        // Convert back to array (optional)
        Integer[] uniqueArray = set.toArray(new Integer[0]);

        System.out.println(Arrays.toString(uniqueArray));
    }
}

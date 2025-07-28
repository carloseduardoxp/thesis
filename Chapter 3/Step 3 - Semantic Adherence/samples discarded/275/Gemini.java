import java.util.HashSet;
import java.util.Arrays;

public class RemoveDuplicatesHashSet {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 4, 5, 1, 6};

        // Convert array to a HashSet to remove duplicates
        HashSet<Integer> uniqueElements = new HashSet<>(Arrays.asList(arr));

        // Convert the HashSet back to an array (if needed)
        Integer[] uniqueArr = uniqueElements.toArray(new Integer[0]);

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Array without duplicates (order not preserved): " + Arrays.toString(uniqueArr));
    }
}

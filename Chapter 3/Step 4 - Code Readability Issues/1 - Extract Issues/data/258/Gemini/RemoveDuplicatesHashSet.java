import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesHashSet {

    public static int[] removeDuplicates(int[] arr) {
        // Create a HashSet to store unique elements
        Set<Integer> uniqueElements = new HashSet<>();

        // Add all elements from the array to the HashSet
        for (int element : arr) {
            uniqueElements.add(element);
        }

        // Convert the HashSet back to an array
        int[] result = new int[uniqueElements.size()];
        int i = 0;
        for (int element : uniqueElements) {
            result[i++] = element;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] originalArray = {1, 2, 2, 3, 4, 4, 5, 1, 6};
        System.out.println("Original array: " + Arrays.toString(originalArray));

        int[] arrayWithoutDuplicates = removeDuplicates(originalArray);
        System.out.println("Array without duplicates: " + Arrays.toString(arrayWithoutDuplicates));
    }
}

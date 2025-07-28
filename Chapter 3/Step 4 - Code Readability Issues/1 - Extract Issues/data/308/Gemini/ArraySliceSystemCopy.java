import java.util.Arrays;

public class ArraySliceSystemCopy {
    public static void main(String[] args) {
        int[] originalArray = {10, 20, 30, 40, 50, 60, 70, 80};

        // Slice from index 2 (inclusive) to index 5 (exclusive)
        // This means elements at index 2, 3, 4
        int startIndex = 2; // Inclusive
        int endIndex = 5;   // Exclusive

        // Calculate the length of the slice
        int sliceLength = endIndex - startIndex;

        if (startIndex < 0 || endIndex > originalArray.length || startIndex > endIndex) {
            System.out.println("Invalid slice indices.");
            return;
        }

        int[] slicedArray = new int[sliceLength];

        System.arraycopy(originalArray, startIndex, slicedArray, 0, sliceLength);

        System.out.println("Original array: " + Arrays.toString(originalArray));
        System.out.println("Sliced array (using System.arraycopy): " + Arrays.toString(slicedArray));
        // Output: [30, 40, 50]
    }
}
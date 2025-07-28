import java.util.Arrays;

public class ArrayExtension {
    public static void main(String[] args) {
        // Original array
        int[] originalArray = {1, 2, 3};
        System.out.println("Original Array: " + Arrays.toString(originalArray)); // Output: [1, 2, 3]

        // 1. Define the new desired size
        int newSize = originalArray.length + 2; // Extend by 2 elements, for example

        // 2. Create a new array with the larger size and copy elements
        int[] newArray = Arrays.copyOf(originalArray, newSize);

        // Now newArray contains {1, 2, 3, 0, 0} (0s are default values for int)
        System.out.println("Extended Array (manual copy): " + Arrays.toString(newArray));

        // You can now add new elements
        newArray[originalArray.length] = 4;
        newArray[originalArray.length + 1] = 5;
        System.out.println("Extended Array (after adding elements): " + Arrays.toString(newArray));

        // If you want originalArray to refer to the new array:
        originalArray = newArray;
        System.out.println("Original Array (now refers to newArray): " + Arrays.toString(originalArray));
    }
}

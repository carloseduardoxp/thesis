
import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        // Create a new array of integers
        int[] arr = {2, 3, 4, 5};

        // Create a new array with a size one larger than the original array
        int[] newArr = new int[arr.length + 1];

        // Copy the elements of the original array into the new array starting from index 1
        System.arraycopy(arr, 0, newArr, 1, arr.length);

        // Add the new element at the beginning of the new array
        newArr[0] = 1;

        // Print the new array
        System.out.println(Arrays.toString(newArr));

    }
}

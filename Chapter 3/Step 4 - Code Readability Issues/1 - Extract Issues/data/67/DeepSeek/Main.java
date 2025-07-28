import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] originalArray = {2, 3, 4, 5};
        int newElement = 1;

        // Create a new array with size = originalArray.length + 1
        int[] newArray = new int[originalArray.length + 1];

        // Add the new element at the beginning
        newArray[0] = newElement;

        // Copy the original array into the new array starting from index 1
        System.arraycopy(originalArray, 0, newArray, 1, originalArray.length);

        System.out.println(Arrays.toString(newArray)); // Output: [1, 2, 3, 4, 5]
    }
}

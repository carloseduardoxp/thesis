import java.util.Arrays;

public class Gemini {
    public static void main(String[] args) {
        int[] numbers = {5, 2, 9, 1, 5, 6};

        // Using Arrays.sort() for ascending order
        Arrays.sort(numbers);
        System.out.println("Sorted array (ascending): " + Arrays.toString(numbers));

        // To sort in descending order, you can sort in ascending order first
        // and then reverse the array.
        // Alternatively, for non-primitive types (like Integer), you can use
        // Collections.reverseOrder() with Arrays.sort().

        // Example of sorting in descending order (for primitive int array):
        int[] numbersDescending = {5, 2, 9, 1, 5, 6};
        Arrays.sort(numbersDescending);
        reverseArray(numbersDescending);
        System.out.println("Sorted array (descending): " + Arrays.toString(numbersDescending));

        // Example of sorting in descending order (for Integer array):
        Integer[] numbersObject = {5, 2, 9, 1, 5, 6};
        Arrays.sort(numbersObject, java.util.Collections.reverseOrder());
        System.out.println("Sorted Integer array (descending): " + Arrays.toString(numbersObject));
    }

    // Helper function to reverse an array
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}

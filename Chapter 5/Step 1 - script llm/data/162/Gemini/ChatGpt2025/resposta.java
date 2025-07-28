import java.util.Arrays;

public class ArrayInsertion {

    public static int[] insertElement(int[] originalArray, int elementToInsert, int position) {
        if (position < 0 || position > originalArray.length) {
            System.out.println("Invalid position for insertion.");
            return originalArray; // Or throw an exception
        }

        int[] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);

        // Shift elements after the insertion point
        for (int i = newArray.length - 1; i > position; i--) {
            newArray[i] = newArray[i - 1];
        }

        // Insert the new element
        newArray[position] = elementToInsert;

        return newArray;
    }

    public static void main(String[] args) {
        int[] myArray = {10, 20, 30, 40, 50};
        int element = 25;
        int position = 2; // Insert at index 2 (between 20 and 30)

        System.out.println("Original Array: " + Arrays.toString(myArray));

        int[] updatedArray = insertElement(myArray, element, position);

        System.out.println("Updated Array: " + Arrays.toString(updatedArray));

        // Example with invalid position
        updatedArray = insertElement(myArray, 99, 10);
        System.out.println("Array after invalid insertion attempt: " + Arrays.toString(updatedArray));
    }
}

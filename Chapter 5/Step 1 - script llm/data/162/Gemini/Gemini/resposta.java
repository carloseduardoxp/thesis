import java.util.Arrays;

public class ArrayInsertion {

    public static int[] insertElement(int[] originalArray, int elementToInsert, int position) {
        if (position < 0 || position > originalArray.length) {
            System.out.println("Invalid position for insertion.");
            return originalArray; // Or throw an exception
        }

        int[] newArray = new int[originalArray.length + 1];

        // Copy elements from the original array up to the insertion point
        System.arraycopy(originalArray, 0, newArray, 0, position);

        // Insert the new element
        newArray[position] = elementToInsert;

        // Copy the remaining elements from the original array, shifting them one position to the right
        System.arraycopy(originalArray, position, newArray, position + 1, originalArray.length - position);

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

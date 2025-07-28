import java.util.Arrays;

public class InsertElement {
    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};
        int elementToInsert = 25;
        int position = 2; // Insert at index 2 (between 20 and 30)

        int[] newArray = new int[original.length + 1];

        // Copy elements before the position
        for (int i = 0; i < position; i++) {
            newArray[i] = original[i];
        }

        // Insert the new element
        newArray[position] = elementToInsert;

        // Copy the rest of the original array
        for (int i = position; i < original.length; i++) {
            newArray[i + 1] = original[i];
        }

        // Print the new array
        System.out.println("New Array: " + Arrays.toString(newArray));
    }
}

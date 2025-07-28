import java.util.Arrays;

public class InsertElement {
    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};
        int elementToInsert = 25;
        int position = 2; // Insert at index 2 (between 20 and 30)

        int[] newArray = new int[original.length + 1];

        // Copy elements from original before the insertion point
        System.arraycopy(original, 0, newArray, 0, position);

        // Insert the new element
        newArray[position] = elementToInsert;

        // Copy elements from original after the insertion point
        System.arraycopy(original, position, newArray, position + 1, original.length - position);

        // Print the new array
        System.out.println("New Array: " + Arrays.toString(newArray));
    }
}

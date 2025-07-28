import java.util.Arrays;

public class InsertElement {
    public static void main(String[] args) {
        int[] original = {10, 20, 30, 40, 50};
        int elementToInsert = 25;
        int position = 2; // Insert at index 2 (between 20 and 30)

        int[] newArray = Arrays.copyOf(original, original.length + 1);

        // Shift elements to make space for the new element
        System.arraycopy(original, position, newArray, position + 1, original.length - position);

        // Insert the new element
        newArray[position] = elementToInsert;

        // Print the new array
        System.out.println("New Array: " + Arrays.toString(newArray));
    }
}

import java.util.Arrays;

public class InsertInArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 4, 5};
        int insertPos = 2; // position to insert (0-based index)
        int newValue = 3;

        // Step 1: Create a new array with size + 1 using Arrays.copyOf
        int[] newArray = Arrays.copyOf(original, original.length + 1);

        // Step 2: Shift elements after the insert position
        for (int i = newArray.length - 1; i > insertPos; i--) {
            newArray[i] = newArray[i - 1];
        }

        // Step 3: Insert the new element
        newArray[insertPos] = newValue;

        // Print result
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}

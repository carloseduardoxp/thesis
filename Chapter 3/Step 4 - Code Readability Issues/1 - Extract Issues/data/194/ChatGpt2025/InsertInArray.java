public class InsertInArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 4, 5};
        int insertPos = 2; // position to insert (0-based index)
        int newValue = 3;

        // Step 1: Create a new array with size + 1
        int[] newArray = new int[original.length + 1];

        // Step 2: Copy elements before the insert position
        for (int i = 0; i < insertPos; i++) {
            newArray[i] = original[i];
        }

        // Step 3: Insert the new element
        newArray[insertPos] = newValue;

        // Step 4: Copy the rest of the original array
        for (int i = insertPos; i < original.length; i++) {
            newArray[i + 1] = original[i];
        }

        // Print result
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}

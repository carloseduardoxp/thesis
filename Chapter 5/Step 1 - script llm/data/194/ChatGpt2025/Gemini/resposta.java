public class InsertInArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 4, 5};
        int insertPos = 2; // position to insert (0-based index)
        int newValue = 3;

        int[] newArray = new int[original.length + 1];

        // Copy elements before the insert position
        System.arraycopy(original, 0, newArray, 0, insertPos);

        // Insert the new element
        newArray[insertPos] = newValue;

        // Copy the rest of the original array, shifting them one position to the right
        System.arraycopy(original, insertPos, newArray, insertPos + 1, original.length - insertPos);

        // Print result
        for (int num : newArray) {
            System.out.print(num + " ");
        }
    }
}

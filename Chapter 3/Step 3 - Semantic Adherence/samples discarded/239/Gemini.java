public class ArrayAddition {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3};
        int newValue = 4;

        // 1. Create a new array with a larger size
        int[] newArray = new int[originalArray.length + 1];

        // 2. Copy elements from the original array to the new array
        for (int i = 0; i < originalArray.length; i++) {
            newArray[i] = originalArray[i];
        }

        // 3. Add the new element
        newArray[newArray.length - 1] = newValue; // Add to the end

        // Or, to insert at a specific position (e.g., index 1)
        // int insertIndex = 1;
        // for (int i = 0; i < insertIndex; i++) {
        //     newArray[i] = originalArray[i];
        // }
        // newArray[insertIndex] = newValue;
        // for (int i = insertIndex; i < originalArray.length; i++) {
        //     newArray[i + 1] = originalArray[i];
        // }


        System.out.println("Original Array:");
        for (int i : originalArray) {
            System.out.print(i + " ");
        }
        System.out.println("\nNew Array (with added element):");
        for (int i : newArray) {
            System.out.print(i + " ");
        }
    }
}

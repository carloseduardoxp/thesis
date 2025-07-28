import java.util.Arrays;

public class ArrayInsertion {

    public static void main(String[] args) {
        int[] originalArray = {10, 20, 40, 50};
        int elementToInsert = 30;
        int insertIndex = 2; // Index where you want to insert (0-based)

        // 1. Create a new array with a size one greater than the original
        int[] newArray = new int[originalArray.length + 1];

        // 2. Copy elements from the original array up to the insert index
        System.arraycopy(originalArray, 0, newArray, 0, insertIndex);

        // 3. Insert the new element
        newArray[insertIndex] = elementToInsert;

        // 4. Copy the remaining elements from the original array (shifting them)
        System.arraycopy(originalArray, insertIndex, newArray, insertIndex + 1, originalArray.length - insertIndex);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Array after insertion: " + Arrays.toString(newArray));

        // Example: Inserting at the beginning
        int[] arr1 = {1, 2, 3};
        int newElement1 = 0;
        int insertIndex1 = 0;
        int[] newArr1 = new int[arr1.length + 1];
        newArr1[insertIndex1] = newElement1;
        System.arraycopy(arr1, 0, newArr1, 1, arr1.length);
        System.out.println("Insert at beginning: " + Arrays.toString(newArr1));

        // Example: Inserting at the end (can just assign directly if there's space)
        int[] arr2 = {1, 2, 3};
        int newElement2 = 4;
        int insertIndex2 = arr2.length; // Insert at the end
        int[] newArr2 = Arrays.copyOf(arr2, arr2.length + 1);
        newArr2[insertIndex2] = newElement2;
        System.out.println("Insert at end: " + Arrays.toString(newArr2));
    }
}

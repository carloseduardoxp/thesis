public class RemoveDuplicates {

    public static int removeDuplicates(int[] arr) {
        if (arr.length == 0 || arr.length == 1) {
            return arr.length; // No duplicates to remove or already unique
        }

        int i = 0; // Slow pointer, points to the last unique element
        for (int j = 1; j < arr.length; j++) { // Fast pointer
            if (arr[j] != arr[i]) {
                i++; // Move slow pointer to the next position
                arr[i] = arr[j]; // Copy the unique element
            }
        }
        return i + 1; // The new length of the array with unique elements
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 2, 3, 4, 4, 5};
        System.out.println("Original array 1: " + java.util.Arrays.toString(arr1));
        int newLength1 = removeDuplicates(arr1);
        System.out.println("Array 1 after removing duplicates (logical length " + newLength1 + "): " + java.util.Arrays.toString(java.util.Arrays.copyOf(arr1, newLength1)));

        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println("\nOriginal array 2: " + java.util.Arrays.toString(arr2));
        int newLength2 = removeDuplicates(arr2);
        System.out.println("Array 2 after removing duplicates (logical length " + newLength2 + "): " + java.util.Arrays.toString(java.util.Arrays.copyOf(arr2, newLength2)));

        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println("\nOriginal array 3: " + java.util.Arrays.toString(arr3));
        int newLength3 = removeDuplicates(arr3);
        System.out.println("Array 3 after removing duplicates (logical length " + newLength3 + "): " + java.util.Arrays.toString(java.util.Arrays.copyOf(arr3, newLength3)));
    }
}

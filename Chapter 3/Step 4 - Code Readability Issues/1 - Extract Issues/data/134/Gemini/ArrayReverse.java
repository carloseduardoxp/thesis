public class ArrayReverse {

    public static int[] reverseArray(int[] originalArray) {
        int[] reversedArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] reversed = reverseArray(original);
        System.out.print("Original Array: ");
        for (int num : original) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.print("Reversed Array: ");
        for (int num : reversed) {
            System.out.print(num + " ");
        }
        // Output:
        // Original Array: 1 2 3 4 5 
        // Reversed Array: 5 4 3 2 1 
    }
}

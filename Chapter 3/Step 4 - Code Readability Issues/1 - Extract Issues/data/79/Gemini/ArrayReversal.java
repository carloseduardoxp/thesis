import java.util.Arrays;

public class ArrayReversal {

    public static int[] reverseArrayCopy(int[] originalArray) {
        int[] reversedArray = new int[originalArray.length];
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }
        return reversedArray;
    }

    public static void main(String[] args) {
        int[] myArray = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(myArray));

        int[] reversedCopy = reverseArrayCopy(myArray);
        System.out.println("Reversed Copy: " + Arrays.toString(reversedCopy));
        System.out.println("Original Array (unchanged): " + Arrays.toString(myArray)); // Original is untouched
    }
}

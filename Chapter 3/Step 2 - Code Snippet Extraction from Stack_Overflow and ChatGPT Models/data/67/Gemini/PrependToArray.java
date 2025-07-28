import java.util.Arrays;

public class PrependToArray {
    public static void main(String[] args) {
        int[] originalArray = {2, 3, 4};
        int newElement = 1;

        int[] newArray = new int[originalArray.length + 1];
        newArray[0] = newElement;
        System.arraycopy(originalArray, 0, newArray, 1, originalArray.length);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("New Array with prepended element: " + Arrays.toString(newArray));
    }
}

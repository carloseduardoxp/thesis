import java.util.Arrays;

public class IncreaseArraySize {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3};
        int newSize = 5;

        // 1. Create a new array with the desired size and copy elements using Arrays.copyOf
        originalArray = Arrays.copyOf(originalArray, newSize);

        System.out.println(Arrays.toString(originalArray)); // Output: [1, 2, 3, 0, 0]

        // You can now add more elements to the 'originalArray' (which is now the newArray)
        originalArray[3] = 4;
        originalArray[4] = 5;

        System.out.println(Arrays.toString(originalArray)); // Output: [1, 2, 3, 4, 5]
    }
}

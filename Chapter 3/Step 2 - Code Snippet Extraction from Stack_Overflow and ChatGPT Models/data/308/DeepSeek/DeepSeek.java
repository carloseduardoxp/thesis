import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        // Slice from index 2 (inclusive) to index 6 (exclusive)
        int[] slicedArray = Arrays.copyOfRange(originalArray, 2, 6);
        
        System.out.println(Arrays.toString(slicedArray)); // [3, 4, 5, 6]
    }
}

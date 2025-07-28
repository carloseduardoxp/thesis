import java.util.Arrays;

public class ArraySliceExample {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5, 6};

        // Slice from index 2 (inclusive) to 5 (exclusive)
        int[] slice = Arrays.copyOfRange(original, 2, 5);

        System.out.println(Arrays.toString(slice));  // Output: [3, 4, 5]
    }
}

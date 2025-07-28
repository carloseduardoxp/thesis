import java.util.Arrays;

public class ExtendArrayExample {
    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        
        // Create a new array with larger size
        int newSize = 6;
        int[] extended = new int[newSize];

        // Copy elements from original to extended
        for (int i = 0; i < original.length; i++) {
            extended[i] = original[i];
        }

        // Or use built-in method:
        // int[] extended = Arrays.copyOf(original, newSize);

        // Print result
        System.out.println(Arrays.toString(extended));  // Output: [1, 2, 3, 0, 0, 0]
    }
}

import java.util.Arrays;

public class ExtendArrayExample {
    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        
        int newSize = 6;
        int[] extended = Arrays.copyOf(original, newSize);

        System.out.println(Arrays.toString(extended));  // Output: [1, 2, 3, 0, 0, 0]
    }
}
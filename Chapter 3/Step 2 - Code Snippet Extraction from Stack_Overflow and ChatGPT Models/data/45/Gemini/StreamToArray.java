import java.util.stream.IntStream;
import java.util.Arrays;

public class StreamToArray {
    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5);
        int[] intArray = intStream.toArray();
        System.out.println(Arrays.toString(intArray)); // Output: [1, 2, 3, 4, 5]
    }
}

import java.util.stream.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);

        int[] intArray = integerStream.mapToInt(Integer::intValue).toArray();

        // Print the result
        System.out.println(Arrays.toString(intArray));
    }
}

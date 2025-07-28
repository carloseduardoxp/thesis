import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayFlattening {

    public static void main(String[] args) {
        String[][] multiDimensionalArray = {
            {"apple", "banana"},
            {"cherry", "date", "elderberry"},
            {"fig"}
        };

        // Flattening using flatMap
        String[] flattenedArray = Arrays.stream(multiDimensionalArray) // Stream<String[]>
                                        .flatMap(Arrays::stream)       // Stream<String>
                                        .toArray(String[]::new);       // String[]

        System.out.println(Arrays.toString(flattenedArray));
        // Output: [apple, banana, cherry, date, elderberry, fig]

        Integer[][] intMultiDimensionalArray = {
            {1, 2},
            {3, 4, 5},
            {6}
        };

        Integer[] flattenedIntArray = Arrays.stream(intMultiDimensionalArray)
                                            .flatMap(Arrays::stream)
                                            .toArray(Integer[]::new);

        System.out.println(Arrays.toString(flattenedIntArray));
        // Output: [1, 2, 3, 4, 5, 6]
    }
}

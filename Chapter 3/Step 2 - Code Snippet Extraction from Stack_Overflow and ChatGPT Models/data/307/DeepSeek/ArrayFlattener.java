import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayFlattener {
    public static Object[] flatten(Object[] array) {
        return Arrays.stream(array)
                .flatMap(o -> o instanceof Object[] ? 
                    Arrays.stream(flatten((Object[]) o)) : 
                    Stream.of(o))
                .toArray();
    }
    
    public static void main(String[] args) {
        Object[] nestedArray = {1, 2, new Object[]{3, 4, new Object[]{5}}, 6};
        Object[] flatArray = flatten(nestedArray);
        System.out.println(Arrays.toString(flatArray)); // [1, 2, 3, 4, 5, 6]
    }
}

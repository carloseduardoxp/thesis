import java.util.Arrays;
import java.util.stream.Stream;

public class ArrayToStream {
    public static void main(String[] args) {
        String[] array = {"Java", "Python", "JavaScript", "C++"};
        
        // Create a stream from the array
        Stream<String> stream = Arrays.stream(array);
        
        // Use the stream
        stream.forEach(System.out::println);
    }
}

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Example {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "banana", "orange");
        Stream<String> stream1 = list.stream();
        
        Stream<String> stream2 = Stream.of("grape");
        
        Stream<String> concatenatedStream = Stream.concat(stream1, stream2);
        
        concatenatedStream.forEach(System.out::println);
    }
}

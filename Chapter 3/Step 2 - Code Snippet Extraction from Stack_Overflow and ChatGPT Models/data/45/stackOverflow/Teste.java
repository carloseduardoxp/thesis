
import java.util.stream.Stream;

public class Teste {

    public static void main(String[] args) {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //or use this to create our stream 
        //Stream<Integer> stream = IntStream.rangeClosed(1, 10).boxed();
        int[] array = stream.mapToInt(x -> x).toArray();
    }

}

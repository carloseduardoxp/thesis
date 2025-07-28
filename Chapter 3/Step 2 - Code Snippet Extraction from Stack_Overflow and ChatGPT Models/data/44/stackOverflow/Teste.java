
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Teste {

    
    public static void main(String[] args) {
        List<Integer> numbers = Stream.iterate(0, x -> x+3)
                                        .limit(34)
                                        .filter(x -> x>10 && x<100).peek(System.out::println)
                                        .collect(Collectors.toList());
        numbers.forEach(System.out::println);
    }
    
}
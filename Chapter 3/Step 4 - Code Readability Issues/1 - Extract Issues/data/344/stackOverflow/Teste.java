
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Teste {

    public static void main(String[] args) {        
        List<String> input = Arrays.asList("one", "two");
        IntStream.range(0, input.size())
             .mapToObj(i -> input.get(i) + i)
             .collect(Collectors.toList()); // [one0, two1]
    }
}
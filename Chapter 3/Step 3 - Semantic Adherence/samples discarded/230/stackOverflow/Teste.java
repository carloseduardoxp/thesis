
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Teste {

    public static void main(String[] args) {        
        Function<Person, List<Object>> key = p -> Arrays.asList(p.name, p.lastName);
        final Map<List<Object>, Integer> collect = people.stream()
            .collect(Collectors.groupingBy(key, Collectors.summingInt(p -> p.amount)));
        System.out.println(collect);
    }
}
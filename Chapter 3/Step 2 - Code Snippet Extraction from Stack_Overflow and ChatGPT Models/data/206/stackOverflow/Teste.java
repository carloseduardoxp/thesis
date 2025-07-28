import java.util.*;
import java.util.stream.IntStream;

public class Teste {

    public static Map<String, List<Integer>> fizzBuzz(int n) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> fizz = new ArrayList<>(), //
                buzz = new ArrayList<>(), //
                fizzbuzz = new ArrayList<>();
        IntStream.rangeClosed(1, n).forEachOrdered(i -> {
            boolean f = i % 3 == 0, b = i % 5 == 0;
            if (f && b) {
                fizzbuzz.add(i);
            } else if (f) {
                fizz.add(i);
            } else if (b) {
                buzz.add(i);
            }
        });
        map.put("Fizz", fizz);
        map.put("Buzz", buzz);
        map.put("FizzBuzz", fizzbuzz);
        return map;
    }
}

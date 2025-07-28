
import java.util.*;

public class Teste {

    static Set<String> f() {
        System.out.println("  f() called");
        return new HashSet<>();
    }

    public static void main(String[] args) {
        List<String> empty = Collections.emptyList();
        List<String> strings = Arrays.asList("foo", "bar");

        System.out.println("method reference, no invocations");
        empty.forEach(f()::add);

        System.out.println("method reference, 2 invocations");
        strings.forEach(f()::add);

        System.out.println("lambda, no invocations");
        empty.forEach(str -> f().add(str));

        System.out.println("lambda, 2 invocations");
        strings.forEach(str -> f().add(str));
    }
}

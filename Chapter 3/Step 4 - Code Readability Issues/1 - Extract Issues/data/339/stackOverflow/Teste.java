
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teste {

    static <T> Collection<T> intersection(Collection<T> c1, Collection<T> c2) {
        if (c1.size() < c2.size()) {
            return intersection(c2, c1);
        }
        Set<T> c2set = new HashSet<>(c2);
        return c1.stream().filter(c2set::contains).distinct().collect(Collectors.toSet());
    }
}

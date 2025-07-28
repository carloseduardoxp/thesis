import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teste {

    static <T> Collection<T> intersection(Collection<T> c1, Collection<T> c2) {
        Collection<T> smaller;
        Collection<T> larger;

        if (c1.size() < c2.size()) {
            smaller = c1;
            larger = c2;
        } else {
            smaller = c2;
            larger = c1;
        }

        Set<T> smallerSet = new HashSet<>(smaller);
        return larger.stream().filter(smallerSet::contains).distinct().collect(Collectors.toSet());
    }
}

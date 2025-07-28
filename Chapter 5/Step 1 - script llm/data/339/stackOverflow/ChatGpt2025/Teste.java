import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teste {

    static <T> Collection<T> intersection(Collection<T> first, Collection<T> second) {
        if (first.size() < second.size()) {
            return intersection(second, first);
        }
        Set<T> secondSet = new HashSet<>(second);
        return first.stream().filter(secondSet::contains).distinct().collect(Collectors.toSet());
    }
}
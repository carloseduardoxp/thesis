import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Teste {

    static <T> Collection<T> intersection(Collection<T> firstCollection, Collection<T> secondCollection) {
        if (firstCollection.size() < secondCollection.size()) {
            return intersection(secondCollection, firstCollection);
        }
        Set<T> secondSet = new HashSet<>(secondCollection);
        return firstCollection.stream().filter(secondSet::contains).distinct().collect(Collectors.toSet());
    }
}


import java.util.*;

final class MapValueComparator<K,V extends Comparable<V>> implements Comparator<K> {
    private final Map<K,V> map;
    
    private MapValueComparator() {
        super();
    }
    
    public MapValueComparator(Map<K,V> map) {
        this();
        this.map = map;
    }
        
    public int compare(K o1, K o2) {
        return map.get(o1).compareTo(map.get(o2));
    }
}
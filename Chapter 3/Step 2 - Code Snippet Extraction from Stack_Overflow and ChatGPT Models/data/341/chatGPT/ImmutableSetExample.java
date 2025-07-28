import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetExample {
    public static void main(String[] args) {
        Set<String> mutableSet = new HashSet<>();
        mutableSet.add("apple");
        mutableSet.add("banana");
        mutableSet.add("cherry");
        
        Set<String> immutableSet = Collections.unmodifiableSet(mutableSet);
        
        // This will throw an UnsupportedOperationException
        immutableSet.add("date");
    }
}

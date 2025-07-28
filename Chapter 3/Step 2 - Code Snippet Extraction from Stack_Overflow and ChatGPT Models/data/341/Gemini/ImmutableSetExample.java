
import java.util.Set;

public class ImmutableSetExample {
    public static void main(String[] args) {
        Set<String> emptyImmutableSet = Set.of();
        System.out.println("Empty Immutable Set: " + emptyImmutableSet);
        // emptyImmutableSet.add("something"); // Throws UnsupportedOperationException
    }
}

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class DeepSeek {

    public static void main(String[] args) {
        Set<String> mutableSet = new HashSet<>();
        mutableSet.add("Apple");
        mutableSet.add("Banana");
        mutableSet.add("Cherry");

        Collections.unmodifiableSet(mutableSet);
    }
}
import java.util.*;

public class DeepSeek {
    public static void main(String[] args) {
        List<Integer> listWithDuplicates = Arrays.asList(1, 2, 3, 1, 2, 4);
        new ArrayList<>(new HashSet<>(listWithDuplicates));
    }
}

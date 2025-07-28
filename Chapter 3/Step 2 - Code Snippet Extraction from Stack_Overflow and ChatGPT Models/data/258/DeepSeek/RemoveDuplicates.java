import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Integer[] array = {1, 2, 3, 4, 2, 3, 5};
        Integer[] uniqueArray = removeDuplicates(array);
        System.out.println(Arrays.toString(uniqueArray));
    }

    public static Integer[] removeDuplicates(Integer[] array) {
        Set<Integer> set = new HashSet<>(Arrays.asList(array));
        return set.toArray(new Integer[0]);
    }
}

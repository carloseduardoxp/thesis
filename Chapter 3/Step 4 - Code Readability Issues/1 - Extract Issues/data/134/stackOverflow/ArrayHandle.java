
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayHandle {
    public static Object[] reverse(Object[] arr) {
        List<Object> list = Arrays.asList(arr);
        Collections.reverse(list);
        return list.toArray();
    }
}
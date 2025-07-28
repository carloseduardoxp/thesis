import java.util.*;

public class ArrayFlattener {
    public static void main(String[] args) {
        Object[] array = {1, 2, new Object[]{3, 4, new Object[]{5, 6}}, 7};

        List<Object> flattened = flatten(array);

        System.out.println(flattened);
    }

    public static List<Object> flatten(Object[] array) {
        List<Object> flattened = new ArrayList<>();

        for (Object element : array) {
            if (element instanceof Object[]) {
                flattened.addAll(flatten((Object[]) element));
            } else {
                flattened.add(element);
            }
        }

        return flattened;
    }
}

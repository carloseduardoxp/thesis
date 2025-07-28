import java.util.Arrays;

public class ArrayHelper {

    public static void main(String[] args) {
        String[] items = new String[]{"a", "b", "c"};

        items = ArrayHelper.push(items, "d");
        items = ArrayHelper.push(items, "e");

        ArrayHelper.pop(items);
    }
    
    public static <T> T[] push(T[] arr, T item) {
        return Arrays.copyOf(arr, arr.length + 1);
    }

    public static <T> T[] pop(T[] arr) {
        return Arrays.copyOf(arr, arr.length - 1);
    }
}
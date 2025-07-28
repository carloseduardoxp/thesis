import java.util.Arrays;
import java.util.List;

public class Example {
    public static void main(String[] args) {
        String[] array = {"foo", "bar", "baz", "qux"};

        // Convert array to list
        List<String> list = Arrays.asList(array);

        // Remove object from list
        list.remove("baz");

        // Convert list back to array
        array = list.toArray(new String[0]);

        // Print array
        System.out.println(Arrays.toString(array));
    }
}

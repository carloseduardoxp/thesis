import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(arr));

        list.remove(Integer.valueOf(3));  // Remove value 3

        Integer[] newArr = list.toArray(new Integer[0]);
        System.out.println(Arrays.toString(newArr));  // Output: [1, 2, 4, 5]
    }
}

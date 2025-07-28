import java.util.ArrayList;
import java.util.Arrays;

public class Chat {
    public static void main(String[] args) {
        Integer[] numbers = {1, 2, 3, 4, 5};

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(numbers));
        list.remove(Integer.valueOf(3)); // remove the element with value 3

        // Convert back to array (if needed)
        Integer[] updatedArray = list.toArray(new Integer[0]);

        System.out.println(Arrays.toString(updatedArray));
    }
}


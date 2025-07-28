import java.util.Arrays;

public class ArraySlicer {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};

        int[] sliced = Arrays.copyOfRange(array, 1, 4);

        System.out.println(Arrays.toString(sliced));
    }
}

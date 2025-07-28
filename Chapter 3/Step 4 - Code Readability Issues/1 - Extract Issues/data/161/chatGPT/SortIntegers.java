import java.util.Arrays;

public class SortIntegers {

    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 2, 1, 9 };
        Arrays.sort(arr);

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}

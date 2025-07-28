
import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        int a[] = {1, 2, 6, 7, 2};
        int b[] = {2, 44, 55, 2};
        int c[] = {2, 44, 511, 33};

        int originalArray[][] = new int[][]{a, b, c};

        int[] flatArray = Arrays.stream(originalArray)
                .flatMapToInt(Arrays::stream)
                .toArray();
    }
}

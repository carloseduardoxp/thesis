import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        int[] originalArray = {1, 2, 3, 4, 5};
        int element = 6;
        insertElement(originalArray, element);
    }

    public static int[] insertElement(int[] originalArray, int element) {
        int[] newArray = Arrays.copyOf(originalArray, originalArray.length + 1);
        newArray[newArray.length - 1] = element;
        return newArray;
    }
}

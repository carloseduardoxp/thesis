import java.util.*;

public class Teste {

    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(array));
        array = Arrays.copyOf(array, array.length + 1); //create new array from old array and allocate one more element
        array[array.length - 1] = 4;
        System.out.println(Arrays.toString(array));
    }
}
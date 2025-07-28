
import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {        
        int [] tab2 = new int[]{1,5,0,-2};
        Arrays.sort(tab2);
        ArrayUtils.reverse(tab2);
        System.out.print(Arrays.toString(tab2));
    }
}

class ArrayUtils {
    public static void reverse(int[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }
}
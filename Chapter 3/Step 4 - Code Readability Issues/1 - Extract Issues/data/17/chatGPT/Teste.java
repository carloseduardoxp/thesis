
import java.util.Arrays;

public class Teste {
   
    public static void main(String[] args) {
        int[] numbers = {5, 3, 1, 4, 2};
        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        
    }
}

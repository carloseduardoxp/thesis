
import java.util.Arrays;

public class SumInterval {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] a = {1, 2, 3, 4, 5};
        // entre index 
        int sum = Arrays.stream(a, 0, 2).sum();
        System.out.println("The sum is " + sum);
    }

}

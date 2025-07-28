
import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {        
        String[] arr = {"One", "Two", "Three", "Four", "Five"};

        String[] arr2 = Arrays.copyOfRange(arr, 2, arr.length); 
        //Note third param is exclusive
    }
}
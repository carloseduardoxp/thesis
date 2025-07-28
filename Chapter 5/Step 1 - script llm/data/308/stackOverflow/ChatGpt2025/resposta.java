import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {        
        String[] arr = {"One", "Two", "Three", "Four", "Five"};

        Arrays.copyOfRange(arr, 2, arr.length); 
        //Note third param is exclusive
    }
}
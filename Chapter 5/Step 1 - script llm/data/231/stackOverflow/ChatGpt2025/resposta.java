import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        String[] originalArray = new String[3000];

        String[] copiedArray = Arrays.copyOf(originalArray, originalArray.length);
        System.out.println("O array length : " + copiedArray.length);  // I am just printing length
    }

}

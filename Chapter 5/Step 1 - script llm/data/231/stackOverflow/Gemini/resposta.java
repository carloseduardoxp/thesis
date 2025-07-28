import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        String[] sourceArray = new String[3000];

        String[] destinationArray = Arrays.copyOf(sourceArray, sourceArray.length);
        System.out.println("destinationArray array length : " + destinationArray.length);  // I am just printing length
    }

}

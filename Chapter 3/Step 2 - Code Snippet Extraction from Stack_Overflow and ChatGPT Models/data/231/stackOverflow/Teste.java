
import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        String[] O = {};
        String[] Ox = new String[3000];

        O = Arrays.copyOf(Ox, Ox.length);
        System.out.println("O array length : " + O.length);  // I am just printing length
    }

}

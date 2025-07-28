import java.util.Arrays;

public class Teste {

    public static void main(String[] args) {
        String[] ox = new String[3000];
        String[] o = Arrays.copyOf(ox, ox.length);
        System.out.println("O array length : " + o.length);
    }

}

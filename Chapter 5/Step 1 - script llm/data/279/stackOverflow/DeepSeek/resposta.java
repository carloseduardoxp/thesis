import java.util.Arrays;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        int[] values = new int[16];
        List<Integer> list = Arrays.asList(values);
        list.forEach(System.out::println);
    }
}
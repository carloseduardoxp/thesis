import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {

    public static void main(String[] args) {
        List<String> temp = new ArrayList<>(Arrays.asList("hi", "hi2"));
        temp.add(0, "h3");
        temp.toArray(new String[0]);
    }

}
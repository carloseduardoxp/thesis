import java.util.ArrayList;
import java.util.Collections;

public class Teste {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        Collections.sort(list, (a, b) -> {
            // Your string ordering logic here. (I won't write that for you.)
            return 0;
        });
    }
}

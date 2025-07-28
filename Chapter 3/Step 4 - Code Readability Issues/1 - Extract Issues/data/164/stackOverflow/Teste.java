
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Teste {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();

        Collections.sort(list, new Comparator<String>() {
            public int compare(String a, String b) {
                // Your string ordering logic here. (I won't write that for you.)
            }
        });
    }
}


import java.util.ArrayList;
import java.util.HashSet;

public class Teste {

    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<String>();
        values.add("s");
        values.add("n");
        values.add("a");
        values.add("s");

        HashSet hs = new HashSet();

        hs.addAll(values); // demoArrayList= name of arrayList from which u want to remove duplicates 

        values.clear();
        values.addAll(hs);
    }
}


import java.util.*;

public class Teste {

    public static void main(String[] args) {
        TreeSet<Map.Entry<String, String>> ts
                = new TreeSet<Map.Entry<String, String>>(new Comparator<Map.Entry<String, String>>() {
                    @Override
                    public int compare(Map.Entry<String, String> entry1, Map.Entry<String, String> entry2) {
                        return entry1.getKey().compareTo(entry2.getKey());
                    }
                });

        ts.addAll(set);

        for (Map.Entry<String, String> entry : ts) {
            System.out.println(entry.getKey());
        }

    }
}
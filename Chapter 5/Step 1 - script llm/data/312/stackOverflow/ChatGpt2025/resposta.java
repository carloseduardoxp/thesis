import java.util.*;

public class Teste {

    public static void main(String[] args) {
        TreeSet<Map.Entry<String, String>> ts = new TreeSet<>(Comparator.comparing(Map.Entry::getKey));

        ts.addAll(set);

        for (Map.Entry<String, String> entry : ts) {
            System.out.println(entry.getKey());
        }

    }
}
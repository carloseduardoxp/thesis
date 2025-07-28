
import java.util.*;

public class Teste {

    public static void main(String[] args) {   
        HashMap<String, HashMap<String, Integer>> record= new HashMap<>();

        HashMap<String, Integer> map = new HashMap<>();
        map.put("key", 1);

        record.put("John", map);
    }
}
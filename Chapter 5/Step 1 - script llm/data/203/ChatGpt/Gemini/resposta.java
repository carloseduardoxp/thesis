import java.util.Collections;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class DictionaryToArray {
    public static void main(String[] args) {
        Dictionary<String, Integer> dict = new Hashtable<>();
        dict.put("one", 1);
        dict.put("two", 2);
        dict.put("three", 3);
        
        List<Integer> values = Collections.list(dict.elements());
        Integer[] arr = new Integer[values.size()];
        arr = values.toArray(arr);
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

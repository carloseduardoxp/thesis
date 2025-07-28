
import java.util.HashMap;
import java.util.Map;

public class Teste {

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<String, String>();
        dictionary.put("key", "value");
        String value = dictionary.get("key");
    }
}

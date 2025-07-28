
import java.util.HashMap;
import java.util.Map;

public class Teste {

    public void main() {
        Map<String, Object> map = new HashMap<String, Object>();
//...

        for (String key : map.keySet()) {
        }

        for (Object value : map.values()) {
        }

        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
        }
    }
}

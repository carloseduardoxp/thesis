import org.json.JSONObject;
import org.json.JSONArray;

public class StringToJson {
    public static void main(String[] args) {
        // JSON object string
        String jsonString = "{\"name\":\"John\", \"age\":30, \"city\":\"New York\"}";
        
        // Convert string to JSONObject
        JSONObject jsonObject = new JSONObject(jsonString);
        System.out.println(jsonObject);
        
        // For JSON array string
        String arrayString = "[\"apple\", \"banana\", \"orange\"]";
        JSONArray jsonArray = new JSONArray(arrayString);
        System.out.println(jsonArray);
    }
}

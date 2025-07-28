import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        String jsonString = "{\"name\":\"Alice\", \"age\":30}";
        JSONObject jsonObject = new JSONObject(jsonString);
        
        System.out.println(jsonObject.getString("name"));  // Output: Alice
        System.out.println(jsonObject.getInt("age"));      // Output: 30
    }
}

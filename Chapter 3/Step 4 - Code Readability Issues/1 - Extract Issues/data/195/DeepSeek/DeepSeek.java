import org.json.JSONObject;

public class DeepSeek {

    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "John \"Doe\"");
        String jsonString = obj.toString();

    }

}
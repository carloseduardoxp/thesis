import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public class StringToJsonGson {

    public static void main(String[] args) {
        String jsonString = "{\"name\":\"John Doe\", \"age\":30, \"city\":\"New York\"}";
        String invalidJsonString = "{\"name\":\"Jane Doe\", \"age\":25, \"city\":\"London\""; // Missing brace

        // 1. Parse into a generic JsonObject (if you don't have a specific POJO)
        try {
            Gson gson = new Gson();
            JsonObject jsonObject = gson.fromJson(jsonString, JsonObject.class);
            System.out.println("Parsed JsonObject:");
            System.out.println("Name: " + jsonObject.get("name").getAsString());
            System.out.println("Age: " + jsonObject.get("age").getAsInt());
            System.out.println("City: " + jsonObject.get("city").getAsString());
        } catch (JsonSyntaxException e) {
            System.err.println("Error parsing JSON string with Gson (JsonObject): " + e.getMessage());
        }

        System.out.println("--------------------");

        // 2. Parse into a Java Map (flexible for unknown structures)
        try {
            Gson gson = new Gson();
            Type type = new TypeToken<Map<String, Object>>(){}.getType();
            Map<String, Object> map = gson.fromJson(jsonString, type);
            System.out.println("Parsed Map:");
            map.forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (JsonSyntaxException e) {
            System.err.println("Error parsing JSON string with Gson (Map): " + e.getMessage());
        }

        System.out.println("--------------------");

        // 3. Handling invalid JSON
        try {
            Gson gson = new Gson();
            gson.fromJson(invalidJsonString, JsonObject.class);
            System.out.println("This won't be printed if an exception occurs.");
        } catch (JsonSyntaxException e) {
            System.err.println("Error parsing invalid JSON string with Gson: " + e.getMessage());
        }
    }
}
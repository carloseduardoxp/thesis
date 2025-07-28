import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class JsonArrayExample {
    public static void main(String[] args) {
        // create a JsonArrayBuilder
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();

        // create a JsonObjectBuilder
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        objectBuilder.add("name", "John");
        objectBuilder.add("age", 30);
        JsonObject jsonObject = objectBuilder.build();

        // add the JsonObject to the JsonArray
        arrayBuilder.add(jsonObject);

        // create the JsonArray
        JsonArray jsonArray = arrayBuilder.build();

        // print the JsonArray
        System.out.println(jsonArray);
    }
}

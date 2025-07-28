import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

public class JsonArrayExample {
    public static void main(String[] args) {
        // Create a JSON object
        JsonObject person1 = Json.createObjectBuilder()
                .add("name", "John Doe")
                .add("age", 30)
                .add("email", "john@example.com")
                .build();
        
        // Create a JSON array and add the object
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add(person1);
        
        // Add another object directly
        arrayBuilder.add(Json.createObjectBuilder()
                .add("name", "Jane Smith")
                .add("age", 25)
                .add("email", "jane@example.com"));
        
        JsonArray people = arrayBuilder.build();
        
        System.out.println(people);
    }
}

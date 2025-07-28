import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

public class JsonArrayAddJsonObject {

    public static void main(String[] args) {
        // 1. Create an initial JsonArray (optional, for demonstration)
        JsonArray originalJsonArray = Json.createArrayBuilder()
                .add("value1")
                .add(123)
                .build();

        System.out.println("Original JsonArray: " + originalJsonArray);

        // 2. Create the JsonObject you want to add
        JsonObject newJsonObject = Json.createObjectBuilder()
                .add("name", "Alice")
                .add("age", 30)
                .build();

        System.out.println("JsonObject to add: " + newJsonObject);

        // 3. Create a JsonArrayBuilder from the original JsonArray
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder(originalJsonArray);

        // 4. Add the new JsonObject to the builder
        arrayBuilder.add(newJsonObject);

        // 5. Build the new JsonArray
        JsonArray updatedJsonArray = arrayBuilder.build();

        System.out.println("Updated JsonArray: " + updatedJsonArray);

        // --- Example with an empty initial JsonArray ---
        System.out.println("\n--- Adding to an initially empty JsonArray ---");

        JsonArray emptyArray = Json.createArrayBuilder().build();
        System.out.println("Empty JsonArray: " + emptyArray);

        JsonObject anotherJsonObject = Json.createObjectBuilder()
                .add("product", "Laptop")
                .add("price", 1200.00)
                .build();

        JsonArray newArrayFromEmpty = Json.createArrayBuilder(emptyArray)
                .add(anotherJsonObject)
                .build();

        System.out.println("New array from empty: " + newArrayFromEmpty);
    }
}

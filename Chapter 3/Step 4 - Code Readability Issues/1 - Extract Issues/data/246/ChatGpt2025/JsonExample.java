import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;

public class JsonExample {
    public static void main(String[] args) {
        // Criar um JSONObject
        JsonObject jsonObject = Json.createObjectBuilder()
            .add("nome", "João")
            .add("idade", 30)
            .build();

        // Criar um JsonArrayBuilder e adicionar o JSONObject
        JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
        arrayBuilder.add(jsonObject);

        // Construir o JsonArray final
        JsonArray jsonArray = arrayBuilder.build();

        // Exibir o array JSON
        System.out.println(jsonArray.toString());
    }
}

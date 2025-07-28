import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

public class ExampleStringToJson {
  public static void main(String[] args) throws Exception {
    String jsonString = "{\"name\": \"John\", \"age\": 30}";
    
    // Create an ObjectMapper object
    ObjectMapper mapper = new ObjectMapper();
    
    // Convert the string to a JsonNode object
    JsonNode jsonNode = mapper.readTree(jsonString);
    
    // Display the JsonNode object
    System.out.println("JsonNode: " + jsonNode);
  }
}

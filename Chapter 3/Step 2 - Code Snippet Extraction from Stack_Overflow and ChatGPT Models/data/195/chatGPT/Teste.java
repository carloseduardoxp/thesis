import org.apache.commons.text.StringEscapeUtils;



public class Teste {
  public static void main(String[] args) {
    String jsonString = "{\"name\":\"John\", \"message\":\"Hello\\nworld!\"}";
    String escapedJsonString = StringEscapeUtils.escapeJson(jsonString);
    System.out.println(escapedJsonString);
        
  }
}

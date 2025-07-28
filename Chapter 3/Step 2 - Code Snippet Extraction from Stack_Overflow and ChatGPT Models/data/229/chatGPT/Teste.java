import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Teste {
  
  public static String readFileAsString(String filePath) throws Exception {
      String content = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
      return content;
  }
  
}

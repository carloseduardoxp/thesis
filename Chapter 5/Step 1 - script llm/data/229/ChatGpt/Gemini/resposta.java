import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Teste {
  
  public static String readFileAsString(String filePath) throws IOException {
      return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
  }
  
}

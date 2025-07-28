import java.util.Scanner;

public class Teste {

    public String loadResourceAsString(String fileName) {
        Scanner scanner = new Scanner(getClass().getClassLoader().getResourceAsStream(fileName));
        String contents = scanner.useDelimiter("\\A").next();
        scanner.close();
        return contents;
    }
}
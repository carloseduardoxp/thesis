import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

class A {
    private B[] b;
    public B[] getB() { return b; }
    public void setB(B[] b) { this.b = b; }
}

class B {
    private String id;
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}

public class Teste {
    public static void main(String[] args) {
        Stream<String> lines = Files.lines(Paths.get("file.json"));
        lines.map(x -> (A) gson.fromJson(x, type)).flatMap(a -> Arrays.stream(a.getB()))
                .map(B::getId)
                .collect(Collectors.toList());
    }
}

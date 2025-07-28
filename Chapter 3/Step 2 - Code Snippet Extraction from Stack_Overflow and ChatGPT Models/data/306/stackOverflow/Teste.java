
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

class A {

    private B[] b;
    //getter setter
}

class B {

    private String id;
    //getter setter
}

public class Teste {

    public static void main(String[] args) {
        Stream<String> lines = Files.lines(Paths.get("file.json"));
        lines.map(x -> (A) gson.fromJson(x, type)).flatMap(a -> Arrays.stream(a.getB())
                .map(B::getId)
                .collect(Collectors.toList());
    }
}

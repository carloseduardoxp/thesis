import java.nio.charset.StandardCharsets;

public class Teste {

    private static final String LETTERS_PATTERN = "\\p{L}+";

    public static void main(String[] args) {
        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTERS_PATTERN));

        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTERS_PATTERN));

        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTERS_PATTERN));

        System.out.println("".matches("[\\pL\\pM]+"));
    }
}
import java.nio.charset.StandardCharsets;

public class Teste {

    private static final String LETTER_REGEX = "\\p{L}+";

    public static void main(String[] args) {
        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTER_REGEX));

        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTER_REGEX));

        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTER_REGEX));

        System.out.println("".matches("[\\pL\\pM]+"));
    }
}

import java.nio.charset.StandardCharsets;

public class Teste {
    private static final String UTF_8 = "UTF-8";
    private static final String LETTER_PATTERN = "\\p{L}+";
    private static final String LETTER_OR_MARK_PATTERN = "[\\pL\\pM]+";

    public static void main(String[] args) {
        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTER_PATTERN));

        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTER_PATTERN));

        System.out.println(StandardCharsets.UTF_8.encode("")
                .asCharBuffer().toString().matches(LETTER_PATTERN));

        System.out.println("".matches(LETTER_OR_MARK_PATTERN));
    }
}


import java.util.function.Function;

public class Teste {

    public static String joinWithChar(final Iterable<String> items,
            final char joinChar) {
        final CharMatcher joinCharMatcher = CharMatcher.is(joinChar);
        return Joiner.on('/').join(
                Iterables.transform(items, new Function<String, String>() {

                    @Override
                    public String apply(final String input) {
                        return joinCharMatcher.trimFrom(input);
                    }
                }));
    }

}

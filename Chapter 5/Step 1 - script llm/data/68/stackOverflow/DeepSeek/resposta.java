import java.util.function.Function;

public class Teste {

    public static String joinWithChar(final Iterable<String> items,
            final char joinChar) {
        final CharMatcher joinCharMatcher = CharMatcher.is(joinChar);
        return Joiner.on('/').join(
                Iterables.transform(items, input -> joinCharMatcher.trimFrom(input)));
    }

}

import java.util.Objects;
import java.util.stream.Collectors;

public class IndexedValue {

    public static void main(String[] args) {
        tourists.stream().filter(Objects::nonNull).collect(Collectors.toList());
    }
}
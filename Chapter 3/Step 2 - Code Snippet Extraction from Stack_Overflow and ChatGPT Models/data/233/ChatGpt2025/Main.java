
import java.util.function.Function;

class MathOperations {
    public static int square(int x) {
        return x * x;
    }
}

public class Main {
    public static void main(String[] args) {
        // Using method reference to call a static method
        Function<Integer, Integer> func = MathOperations::square;
        System.out.println(func.apply(5));  // Output: 25
    }
}


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Teste {
  public static void main(String[] args) {
    // reference to a static method
    Function<String, Integer> parseInt = Integer::parseInt;

    // reference to an instance method of an object of a particular type
    List<String> list = Arrays.asList("foo", "bar");
    Function<List<String>, Integer> size = List::size;

    // reference to an instance method of an arbitrary object of a particular type
    Function<String, Integer> length = String::length;

    // reference to a constructor
    Supplier<ArrayList<String>> arrayListSupplier = ArrayList::new;

  }
}

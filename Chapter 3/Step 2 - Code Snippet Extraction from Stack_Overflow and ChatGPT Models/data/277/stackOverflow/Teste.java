
import java.nio.charset.Charset;

public class Teste {

    public static void main(String[] args) {
        System.out.println(Charset.forName("UTF-8").encode("అనువాద")
                .asCharBuffer().toString().matches("\\p{L}+"));

        System.out.println(Charset.forName("UTF-8").encode("स्वागत")
                .asCharBuffer().toString().matches("\\p{L}+"));

        System.out.println(Charset.forName("UTF-8").encode("நல்வரவு")
                .asCharBuffer().toString().matches("\\p{L}+"));

        System.out.println("स्वागत".matches("[\\pL\\pM]+"));
    }
}


import java.nio.charset.Charset;

public class Teste {

    public static void main(String[] args) {
        System.out.println(Charset.forName("UTF-8").encode("")
                .asCharBuffer().toString().matches("\\p{L}+"));

        System.out.println(Charset.forName("UTF-8").encode("")
                .asCharBuffer().toString().matches("\\p{L}+"));

        System.out.println(Charset.forName("UTF-8").encode("")
                .asCharBuffer().toString().matches("\\p{L}+"));

        System.out.println("".matches("[\\pL\\pM]+"));
    }
}

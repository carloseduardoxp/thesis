import java.text.Collator;
import java.util.*;

public class Teste {

    public static void main(String[] args) {        
        List<String> countries = Arrays.asList("Slovensko", "Švédsko", "Turecko");

        Collections.sort(countries);
        System.out.println(countries); // outputs [Slovensko, Turecko, Švédsko]
        
        Collections.sort(countries, Collator.getInstance(new Locale("sk")));
        System.out.println(countries); // outputs [Slovensko, Švédsko, Turecko]
    }
}
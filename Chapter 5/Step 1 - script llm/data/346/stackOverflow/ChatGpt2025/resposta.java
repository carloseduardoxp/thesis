import java.util.StringJoiner;

public class Teste {

    public static void main(String[] args) {        
        StringJoiner sj1 = new StringJoiner(", ");
        String joined = sj1.add("one").add("two").toString();
        System.out.println(joined);
        
        StringJoiner sj2 = new StringJoiner(", ","{", "}");
        String joined2 = sj2.add("Jake").add("John").add("Carl").toString();
        System.out.println(joined2);
    }
}
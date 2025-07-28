
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;

public class Teste {

    public static void main(String[] args) {  
        ArrayList<String> sort = new ArrayList<>();

        sort.add("/etc/fest/gerts.png");
        sort.add("/etc/fest/ase.png");
        sort.add("/etc/test/zer.png");
        sort.add("/etc/fest/dse.png");
              
        sort.sort(Comparator.comparing(o -> new File(o).getName().toUpperCase()));
        sort.forEach(System.out::println);
    }
}
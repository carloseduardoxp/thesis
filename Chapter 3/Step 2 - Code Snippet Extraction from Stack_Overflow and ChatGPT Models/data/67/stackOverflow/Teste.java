
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teste {

    
    public static void main(String[] args) {
        String[] myArray= {"hi","hi2"};
        List<String> temp = new ArrayList<String>(Arrays.asList(prova));
        temp.add(0, "h3");
        myArray = temp.toArray(new String[temp.size()]);
    }
    
}
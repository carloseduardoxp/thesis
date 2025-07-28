
import java.util.HashMap;
import java.util.Set;

public class Teste {

    public static void main(String[] args) {
        HashMap m = request.getParameterMap();
        Set k = m.keySet();
        Set v = m.entrySet();
        Object o[] = m.entrySet().toArray();
    }

}

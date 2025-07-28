import java.util.ArrayList;
import java.util.List;

public class Teste {

    public static void main(String[] args) {        
        List<Object> copy = new ArrayList<>(inputList.size());
        for (Object item : inputList) {
           copy.add(item.clone());
        }
    }
}
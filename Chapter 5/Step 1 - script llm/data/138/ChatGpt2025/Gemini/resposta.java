import java.util.*;

public class Chat {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> toAdd = Arrays.asList("A", "B", "C");

// Adicionando cada elemento da lista toAdd em list usando lambda
        toAdd.forEach(list::add);

// Agora list contém: ["A", "B", "C"]
    }

}

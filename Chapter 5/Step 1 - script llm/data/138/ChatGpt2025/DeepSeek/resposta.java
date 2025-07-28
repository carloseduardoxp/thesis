import java.util.*;

public class Chat {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        List<String> toAdd = Arrays.asList("A", "B", "C");

        toAdd.forEach(list::add);

// Agora list contém: ["A", "B", "C"]
    }

}
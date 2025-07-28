
import java.util.List;


public class DeepSeek {

    public static void main(String[] args) {

        List<SomeObject> objects; // your list of objects
        List<Long> ids = objects.stream()
                .map(SomeObject::getId) // assuming getId() returns the ID
                .collect(Collectors.toList());

    }
}

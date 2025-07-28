import java.util.List;

public class DeepSeek {

    public static void main(String[] args) {

        List<SomeObject> objects; // your list of objects
        objects.stream()
                .map(SomeObject::getId) // assuming getId() returns the ID
                .collect(java.util.stream.Collectors.toList());

    }
}
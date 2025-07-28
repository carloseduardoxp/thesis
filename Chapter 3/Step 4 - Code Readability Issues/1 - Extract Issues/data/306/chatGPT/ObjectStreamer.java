import java.util.*;
import java.util.stream.*;

public class ObjectStreamer {
    public static void main(String[] args) {
        // Create a list of objects with ids
        List<MyObject> objects = Arrays.asList(
                new MyObject(1, "Object 1"),
                new MyObject(2, "Object 2"),
                new MyObject(3, "Object 3"));

        // Stream the objects to a map with their ids as keys
        Map<Integer, MyObject> objectMap = objects.stream()
                .collect(Collectors.toMap(MyObject::getId, obj -> obj));

        // Print the map
        objectMap.forEach((id, obj) -> System.out.println(id + " -> " + obj.getName()));
    }
}

class MyObject {
    private int id;
    private String name;

    public MyObject(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

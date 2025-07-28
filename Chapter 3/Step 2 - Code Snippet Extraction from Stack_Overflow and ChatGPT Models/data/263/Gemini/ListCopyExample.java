import java.util.ArrayList;
import java.util.List;

public class ListCopyExample {
    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("Apple");
        originalList.add("Banana");
        originalList.add("Cherry");

        // Using the constructor for a shallow copy
        List<String> copiedList = new ArrayList<>(originalList);

        System.out.println("Original List: " + originalList); // [Apple, Banana, Cherry]
        System.out.println("Copied List: " + copiedList);     // [Apple, Banana, Cherry]

        // Modifying the copied list doesn't affect the original for String elements
        copiedList.add("Date");
        System.out.println("Original List after modifying copied: " + originalList); // [Apple, Banana, Cherry]
        System.out.println("Copied List after modifying copied: " + copiedList);     // [Apple, Banana, Cherry, Date]

        // What happens with mutable objects (e.g., custom objects)
        List<MyObject> originalObjectList = new ArrayList<>();
        originalObjectList.add(new MyObject("Obj1"));
        originalObjectList.add(new MyObject("Obj2"));

        List<MyObject> copiedObjectList = new ArrayList<>(originalObjectList);

        System.out.println("Original Object List: " + originalObjectList.get(0).getName()); // Obj1
        System.out.println("Copied Object List: " + copiedObjectList.get(0).getName());     // Obj1

        // Modifying an object within the copied list will affect the original list
        copiedObjectList.get(0).setName("Modified Obj1");
        System.out.println("Original Object List after modifying copied object: " + originalObjectList.get(0).getName()); // Modified Obj1
        System.out.println("Copied Object List after modifying copied object: " + copiedObjectList.get(0).getName());     // Modified Obj1
    }
}

class MyObject {
    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

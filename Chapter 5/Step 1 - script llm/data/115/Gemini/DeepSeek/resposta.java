import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    private static final String ALICE = "Alice";
    
    public static void main(String[] args) {
        Map<String, Integer> studentAges = new HashMap<>();

        studentAges.put(ALICE, 20);
        studentAges.put("Bob", 22);
        studentAges.put("Charlie", 21);
        studentAges.put(ALICE, 21);

        System.out.println("HashMap after adding elements: " + studentAges);

        int aliceAge = studentAges.get(ALICE);
        System.out.println("Alice's age: " + aliceAge);

        Integer davidAge = studentAges.get("David");
        System.out.println("David's age: " + davidAge);

        boolean hasBob = studentAges.containsKey("Bob");
        System.out.println("Does HashMap contain Bob? " + hasBob);

        boolean hasAge20 = studentAges.containsValue(20);
        System.out.println("Does HashMap contain age 20? " + hasAge20);

        studentAges.remove("Bob");
        System.out.println("HashMap after removing Bob: " + studentAges);

        int size = studentAges.size();
        System.out.println("Size of HashMap: " + size);

        System.out.println("\nIterating through the HashMap:");
        for (Map.Entry<String, Integer> entry : studentAges.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Age: " + entry.getValue());
        }

        System.out.println("\nIterating through keys:");
        for (String name : studentAges.keySet()) {
            System.out.println("Student Name: " + name);
        }

        System.out.println("\nIterating through values:");
        for (Integer age : studentAges.values()) {
            System.out.println("Age: " + age);
        }

        studentAges.clear();
        System.out.println("HashMap after clearing: " + studentAges);

        boolean isEmpty = studentAges.isEmpty();
        System.out.println("Is HashMap empty? " + isEmpty);
    }
}
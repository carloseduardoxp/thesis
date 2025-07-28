import com.fasterxml.jackson.databind.ObjectMapper;

class Person {
    private String name;
    private int age;

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
}

public class Main {
    public static void main(String[] args) {
        String json = "{\"name\":\"Alice\", \"age\":30}";

        ObjectMapper mapper = new ObjectMapper();

        try {
            Person person = mapper.readValue(json, Person.class);
            System.out.println(person.getName()); // Output: Alice
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

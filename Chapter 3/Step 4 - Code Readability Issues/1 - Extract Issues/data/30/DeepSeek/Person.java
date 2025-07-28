import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Person {
    private String name;
    private int age;
    private List<String> hobbies;
    
    // Default constructor (required for Jackson)
    public Person() {}
    
    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    
    public List<String> getHobbies() { return hobbies; }
    public void setHobbies(List<String> hobbies) { this.hobbies = hobbies; }
}

class JsonDeserializer {
    public static void main(String[] args) {
        String json = "{\"name\":\"John\",\"age\":30,\"hobbies\":[\"reading\",\"hiking\"]}";
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        try {
            Person person = objectMapper.readValue(json, Person.class);
            System.out.println("Name: " + person.getName());
            System.out.println("Age: " + person.getAge());
            System.out.println("Hobbies: " + person.getHobbies());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

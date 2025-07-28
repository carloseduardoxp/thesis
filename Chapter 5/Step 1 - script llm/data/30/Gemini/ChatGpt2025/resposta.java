import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Person {
    private String name;
    private int age;
    private String city;

    // Default constructor (required by Jackson)
    public Person() {
        // This constructor is intentionally empty.
        // It is required by the Jackson library for deserialization.
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", city='" + city + '\'' +
               '}';
    }
}

class JsonDeserializationExample {
    public static void main(String[] args) {
        String jsonString = "{\"name\": \"Alice\", \"age\": 30, \"city\": \"New York\"}";

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            Person person = objectMapper.readValue(jsonString, Person.class);
            System.out.println("Deserialized Person object: " + person);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

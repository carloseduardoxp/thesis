class Person {
    // Fields will be used when deserializing JSON
    private String name;
    private int age;

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
}

public class Teste {
    public static void main(String[] args) throws Exception {
        String json = "{\"name\": \"John\", \"age\": 30}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(json, Person.class);
    }
}

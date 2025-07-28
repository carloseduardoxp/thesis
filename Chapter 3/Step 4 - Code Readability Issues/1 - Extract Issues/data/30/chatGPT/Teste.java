class Person {
    private String name;
    private int age;

    // getters and setters
}

public class Teste {

    public static void main(String[] args) {
        String json = "{\"name\": \"John\", \"age\": 30}";

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json, Person.class);

    }
}
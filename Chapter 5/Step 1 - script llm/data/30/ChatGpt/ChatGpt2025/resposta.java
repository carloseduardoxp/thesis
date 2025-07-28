public class Teste {

    public static void main(String[] args) {
        String json = "{\"name\": \"John\", \"age\": 30}";

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.readValue(json, Person.class);
    }
}

class Person {
    // No fields as they are unused
}
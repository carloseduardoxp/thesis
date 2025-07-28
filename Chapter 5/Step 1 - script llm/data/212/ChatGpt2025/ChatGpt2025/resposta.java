import java.lang.reflect.Field;

class Person {
}

public class Main {
    public static void main(String[] args) throws Exception {
        Person person = new Person();

        Field field = Person.class.getDeclaredField("name");
        field.setAccessible(true); // bypass private access
        String name = (String) field.get(person);

        System.out.println("Name: " + name);
    }
}
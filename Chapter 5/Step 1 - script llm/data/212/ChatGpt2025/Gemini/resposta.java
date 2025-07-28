class Person {
    private String name = "John";

    public String getName() {
        return this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        String name = person.getName();

        System.out.println("Name: " + name);
    }
}

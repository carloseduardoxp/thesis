class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Chat {
    public static void main(String[] args) {
        // Accessing:
        Person p = new Person();
        p.setName("Alice");
        System.out.println(p.getName());
    }
}



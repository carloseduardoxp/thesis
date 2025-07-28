import java.util.Arrays;
import java.util.Comparator;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class Main {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 28)
        };

        // Sort by age
        Arrays.sort(people, (p1, p2) -> Integer.compare(p1.age, p2.age));

        // Print sorted array
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
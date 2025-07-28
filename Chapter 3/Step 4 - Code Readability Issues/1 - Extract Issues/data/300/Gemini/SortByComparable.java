import java.util.Arrays;

class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person other) {
        // Sort by age in ascending order
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + '}';
    }
}

public class SortByComparable {
    public static void main(String[] args) {
        Person[] people = {
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35)
        };

        System.out.println("Before sorting:");
        for (Person p : people) {
            System.out.println(p);
        }

        // Sort the array using the natural ordering defined by compareTo
        Arrays.sort(people);

        System.out.println("\nAfter sorting by age (ascending):");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}

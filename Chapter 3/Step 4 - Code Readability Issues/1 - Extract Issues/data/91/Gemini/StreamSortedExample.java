import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    String name;
    int age;

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
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", age=" + age +
               '}';
    }
}

public class StreamSortedExample {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
            new Person("Alice", 30),
            new Person("Bob", 25),
            new Person("Charlie", 35),
            new Person("David", 25)
        );

        // Sort by age (ascending)
        List<Person> sortedByAge = people.stream()
            .sorted(Comparator.comparingInt(Person::getAge))
            .collect(Collectors.toList());
        System.out.println("Sorted by Age (Ascending):");
        sortedByAge.forEach(System.out::println);

        System.out.println();

        // Sort by age (descending)
        List<Person> sortedByAgeDesc = people.stream()
            .sorted(Comparator.comparingInt(Person::getAge).reversed())
            .collect(Collectors.toList());
        System.out.println("Sorted by Age (Descending):");
        sortedByAgeDesc.forEach(System.out::println);

        System.out.println();

        // Sort by name (alphabetical)
        List<Person> sortedByName = people.stream()
            .sorted(Comparator.comparing(Person::getName))
            .collect(Collectors.toList());
        System.out.println("Sorted by Name (Alphabetical):");
        sortedByName.forEach(System::out::println);

        System.out.println();

        // Sort by age, then by name for people with the same age
        List<Person> sortedByAgeThenName = people.stream()
            .sorted(Comparator.comparingInt(Person::getAge)
                              .thenComparing(Person::getName))
            .collect(Collectors.toList());
        System.out.println("Sorted by Age then Name:");
        sortedByAgeThenName.forEach(System.out::println);
    }
}

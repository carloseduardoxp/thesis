/**
 * Represents a basic Person with a name and age.
 * This class demonstrates fundamental Java class structure,
 * including fields (attributes), a constructor, and methods.
 */
public class Person {

    // Fields (attributes) of the Person class
    private String name;
    private int age;

    /**
     * Constructor for the Person class.
     * Initializes a new Person object with the given name and age.
     *
     * @param name The name of the person.
     * @param age The age of the person.
     */
    public Person(String name, int age) {
        this.name = name; // 'this' refers to the current instance's field
        this.age = age;
    }

    /**
     * Getter method to retrieve the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method to update the name of the person.
     *
     * @param name The new name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method to retrieve the age of the person.
     *
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method to update the age of the person.
     * Includes a basic validation to ensure age is not negative.
     *
     * @param age The new age to set.
     */
    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        } else {
            System.out.println("Age cannot be negative. Age remains unchanged.");
        }
    }

    /**
     * A method to make the person introduce themselves.
     */
    public void introduce() {
        System.out.println("Hi, my name is " + name + " and I am " + age + " years old.");
    }

    /**
     * Main method to demonstrate the usage of the Person class.
     * This is a standard entry point for Java applications.
     *
     * @param args Command line arguments (not used in this example).
     */
    public static void main(String[] args) {
        // Create an instance (object) of the Person class
        Person person1 = new Person("Alice", 30);

        // Call methods on the person1 object
        person1.introduce(); // Output: Hi, my name is Alice and I am 30 years old.

        // Update the age using the setter
        person1.setAge(31);
        person1.introduce(); // Output: Hi, my name is Alice and I am 31 years old.

        // Try setting an invalid age
        person1.setAge(-5); // Output: Age cannot be negative. Age remains unchanged.
        person1.introduce(); // Output: Hi, my name is Alice and I am 31 years old.

        // Create another instance
        Person person2 = new Person("Bob", 25);
        person2.introduce(); // Output: Hi, my name is Bob and I am 25 years old.
    }
}

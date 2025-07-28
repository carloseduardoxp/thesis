// Define a class. A class is a blueprint for creating objects.
class Dog {
    // Instance variables (attributes)
    String name;
    String breed;
    int age;

    // Constructor: A special method used to initialize objects.
    // It has the same name as the class and no return type.
    public Dog(String name, String breed, int age) {
        this.name = name;   // 'this' refers to the current object
        this.breed = breed;
        this.age = age;
    }

    // Method (behavior)
    public void bark() {
        System.out.println(name + " says Woof!");
    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", Breed: " + breed + ", Age: " + age);
    }
}

// Main class to demonstrate object creation
public class Main {
    public static void main(String[] args) {
        // 1. Declare a reference variable of the class type.
        // This variable will hold the memory address of the object.
        Dog myDog;

        // 2. Create an object (instance) of the Dog class using the 'new' keyword
        // and the constructor.
        // The 'new' keyword allocates memory for the new object, and the constructor
        // initializes that object.
        myDog = new Dog("Buddy", "Golden Retriever", 3);

        // You can also declare and create the object in a single line:
        Dog anotherDog = new Dog("Lucy", "Labrador", 5);

        // 3. Access object's attributes and methods using the dot (.) operator.
        System.out.println("My first dog's name is: " + myDog.name);
        myDog.bark();
        myDog.displayInfo();

        System.out.println("\nAnother dog's name is: " + anotherDog.name);
        anotherDog.bark();
        anotherDog.displayInfo();

        // You can also change the state of an object
        myDog.age = 4;
        System.out.println("\nBuddy's new age: " + myDog.age);
    }
}

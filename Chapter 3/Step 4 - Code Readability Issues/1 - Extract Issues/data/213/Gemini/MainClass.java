// Animal.java
class Animal {
    public void makeSound() {
        System.out.println("The animal makes a generic sound.");
    }

    public void eat() {
        System.out.println("The animal eats food.");
    }
}

// Dog.java
class Dog extends Animal {
    // This method overrides the makeSound() method from the Animal class
    @Override // This is a recommended annotation!
    public void makeSound() {
        System.out.println("The dog barks: Woof! Woof!");
    }

    // The eat() method is inherited as is, not overridden here.
    // We could override it if we wanted a specific dog eating behavior.

    public void fetch() {
        System.out.println("The dog fetches the ball.");
    }
}

// MainClass.java
public class MainClass {
    public static void main(String[] args) {
        Animal genericAnimal = new Animal();
        Dog myDog = new Dog();

        System.out.println("--- Calling methods on Animal object ---");
        genericAnimal.makeSound(); // Calls Animal's makeSound()
        genericAnimal.eat();       // Calls Animal's eat()

        System.out.println("\n--- Calling methods on Dog object ---");
        myDog.makeSound();    // Calls Dog's overridden makeSound()
        myDog.eat();          // Calls Animal's inherited eat()
        myDog.fetch();        // Calls Dog's specific fetch()

        System.out.println("\n--- Polymorphic behavior (Animal reference to Dog object) ---");
        Animal polymorphicAnimal = new Dog(); // Polymorphic reference
        polymorphicAnimal.makeSound(); // Calls Dog's overridden makeSound() at runtime
        polymorphicAnimal.eat();       // Calls Animal's inherited eat()
        // polymorphicAnimal.fetch(); // ERROR: Cannot call fetch() because 'polymorphicAnimal' is of type Animal
                                   // Even though the actual object is a Dog, the compiler only sees the Animal type.
    }
}
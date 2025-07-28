class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override // Annotation indicating method overriding
    void makeSound() {
        System.out.println("Dog barks: Woof woof!");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows: Meow!");
    }
}

public class PolymorphismDemo {
    public static void main(String[] args) {
        Animal myAnimal1 = new Dog(); // Animal reference, Dog object
        Animal myAnimal2 = new Cat(); // Animal reference, Cat object
        Animal myAnimal3 = new Animal(); // Animal reference, Animal object

        myAnimal1.makeSound(); // Calls Dog's makeSound()
        myAnimal2.makeSound(); // Calls Cat's makeSound()
        myAnimal3.makeSound(); // Calls Animal's makeSound()
    }
}
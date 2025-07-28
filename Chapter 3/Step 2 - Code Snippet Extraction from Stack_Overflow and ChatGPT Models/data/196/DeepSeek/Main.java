class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Dog barks");
    }
}

class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Cat meows");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();  // Animal object
        Animal myDog = new Dog();        // Dog object
        Animal myCat = new Cat();        // Cat object
        
        myAnimal.makeSound();  // Output: Animal makes a sound
        myDog.makeSound();     // Output: Dog barks
        myCat.makeSound();     // Output: Cat meows
    }
}
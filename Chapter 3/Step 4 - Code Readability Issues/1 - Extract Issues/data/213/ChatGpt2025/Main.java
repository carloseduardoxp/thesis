class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal();
        myAnimal.sound();  // Output: Animal makes a sound

        Dog myDog = new Dog();
        myDog.sound();     // Output: Dog barks

        Animal animalDog = new Dog();
        animalDog.sound(); // Output: Dog barks (polymorphism)
    }
}

abstract class Animal {
    public abstract void makeSound();
    public abstract int getLegCount();
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }
    
    @Override
    public int getLegCount() {
        return 4;
    }
}

public class Main {
    public static void main(String[] args) {
        Animal myDog = new Dog();
        myDog.makeSound(); // Outputs "Woof!"
        System.out.println("Legs: " + myDog.getLegCount()); // Outputs "Legs: 4"
    }
}

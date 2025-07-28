class Animal {
    // This class is no longer empty to serve as a proper base for inheritance.
    public void eat() {
        // Common eating behavior for all animals.
    }
}

class Dog extends Animal {
    // Dog class code
}

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        
        // Get the parent class name (superclass)
        Class<?> parentClass = dog.getClass().getSuperclass();
        System.out.println("Parent class name: " + parentClass.getName());
    }
}

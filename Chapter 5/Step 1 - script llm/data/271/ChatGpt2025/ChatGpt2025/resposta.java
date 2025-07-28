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
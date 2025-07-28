public class Teste {

    public static void main(String[] args) {
        final int x = 10; // declaring a final variable of primitive type
        final String message = "Hello"; // declaring a final variable of object type
        final MyClass obj = new MyClass(); // declaring a final reference variable   
    }
}

class BaseClass {
    public final void printMessage() {
        System.out.println("This is a final method.");
    }
}

class SubClass extends BaseClass {
    // Error: cannot override final method
    // public void printMessage() {
    //     System.out.println("This is a subclass method.");
    // }
}

final class BaseClass {
    // ...
}

// Error: cannot extend final class
// class SubClass extends BaseClass {
//     // ...
// }

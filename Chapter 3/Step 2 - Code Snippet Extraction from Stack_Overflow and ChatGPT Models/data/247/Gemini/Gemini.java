
import java.io.FileNotFoundException;
import java.io.IOException;

class SuperClass {
    void doSomething() throws IOException {
        System.out.println("SuperClass doing something.");
    }
}

class SubClass extends SuperClass {
    @Override
    void doSomething() throws FileNotFoundException { // OK: FileNotFoundException is a subclass of IOException
        System.out.println("SubClass doing something.");
        throw new FileNotFoundException("File not found in SubClass");
    }
}

class AnotherSubClass extends SuperClass {
    @Override
    void doSomething() { // OK: Can choose not to throw any checked exception
        System.out.println("AnotherSubClass doing something.");
    }
}

class InvalidSubClass extends SuperClass {
    // This would cause a compile-time error
    // @Override
    // void doSomething() throws Exception { // ERROR: Exception is broader than IOException
    //     System.out.println("InvalidSubClass doing something.");
    // }
}

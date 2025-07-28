import java.io.FileNotFoundException;
import java.io.IOException;

class SuperClass {
    void doSomething() {
        System.out.println("SuperClass doing something.");
    }
}

class SubClass extends SuperClass {
    @Override
    void doSomething() throws FileNotFoundException {
        System.out.println("SubClass doing something.");
        throw new FileNotFoundException("File not found in SubClass");
    }
}

class AnotherSubClass extends SuperClass {
    @Override
    void doSomething() {
        System.out.println("AnotherSubClass doing something.");
    }
}

class InvalidSubClass extends SuperClass {
    @Override
    void doSomething() {
        System.out.println("InvalidSubClass doing something.");
    }
}

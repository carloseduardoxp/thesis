import java.io.FileNotFoundException;

class SuperClass {
    void doSomething() {
        System.out.println("SuperClass doing something.");
    }
}

class SubClass extends SuperClass {
    @Override
    void doSomething() {
        System.out.println("SubClass doing something.");
        throw new RuntimeException(new FileNotFoundException("File not found in SubClass"));
    }
}

class AnotherSubClass extends SuperClass {
    @Override
    void doSomething() {
        System.out.println("AnotherSubClass doing something.");
    }
}

class InvalidSubClass extends SuperClass {
}

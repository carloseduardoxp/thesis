class Parent {
    void doSomething() {
        try {
            System.out.println("Parent doing something");
            // Some code that may throw exceptions
        } catch (Exception e) {
            System.out.println("Parent caught exception: " + e.getMessage());
        }
    }
}

class Child extends Parent {
    @Override
    void doSomething() {
        try {
            System.out.println("Child doing something");
            // Some code that may throw exceptions
        } catch (Exception e) {
            System.out.println("Child caught exception: " + e.getMessage());
        }
    }
}

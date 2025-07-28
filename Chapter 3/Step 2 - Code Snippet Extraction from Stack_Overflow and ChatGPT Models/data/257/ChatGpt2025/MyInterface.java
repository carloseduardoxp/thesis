public interface MyInterface {
    // Constant (implicitly public, static, and final)
    int MY_CONSTANT = 10;

    // Abstract method (implicitly public and abstract)
    void doSomething();

    // Default method (provides a body)
    default void defaultMethod() {
        System.out.println("This is a default method.");
    }

    // Static method
    static void staticMethod() {
        System.out.println("This is a static method.");
    }
}

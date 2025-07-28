public interface MyInterface {
    // Constant declarations (implicitly public, static, final)
    String CONSTANT_EXAMPLE = "Value";
    
    // Abstract method signatures (implicitly public and abstract)
    void method1();
    int method2(String param);
    
    // Default method (Java 8+)
    default void defaultMethod() {
        System.out.println("Default implementation");
    }
    
    // Static method (Java 8+)
    static void staticMethod() {
        System.out.println("Static method in interface");
    }
}

public class Singleton {
    public static final Singleton instance = new Singleton();
    private Singleton() {}
    public void foo() {
        // Intentionally left empty as this is a placeholder for future implementation
    }

    public static void main(String[] args) {
        Singleton.instance.foo();
    }
}

public class Singleton {
    public static final Singleton instance = new Singleton();
    private Singleton() {}
    public void foo() {
        // This method is intentionally empty.
    }

    public static void main(String[] args) {
        Singleton.instance.foo();
    }
}

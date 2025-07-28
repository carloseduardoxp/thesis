public class Singleton {
    public static final Singleton instance = new Singleton();
    private Singleton() {} // Constructor is intentionally empty to prevent external instantiation

    public void foo() {}

    public static void main(String[] args) {
        Singleton.instance.foo();
    }
}
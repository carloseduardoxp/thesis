enum Singleton {
    INSTANCE;
    
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

public class DeepSeek {
    public static void main(String[] args) {
        // Usage:
        Singleton.INSTANCE.doSomething();
    }
}


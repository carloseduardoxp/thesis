public class DeepSeek {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        // For a class with a no-arg constructor
        Class.forName("com.example.MyClass").newInstance(); // Deprecated in Java 9+
    }

}
public class DeepSeek {

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("com.example.MyClass");
        clazz.getDeclaredConstructor().newInstance();
    }

}

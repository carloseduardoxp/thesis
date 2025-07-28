public class Chat {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

        Class<?> clazz = Class.forName("com.example.MyClass");
        clazz.newInstance(); // Deprecated since Java 9

    }

}
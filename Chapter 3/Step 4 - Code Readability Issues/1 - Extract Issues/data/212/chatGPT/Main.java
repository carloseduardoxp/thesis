import java.lang.reflect.Field;

class MyClass {
    private int privateField;
}

public class Main {
    public static void main(String[] args) throws Exception {
        MyClass myObject = new MyClass();
        Field privateField = MyClass.class.getDeclaredField("privateField");
        privateField.setAccessible(true);
        privateField.setInt(myObject, 42);
        System.out.println(privateField.getInt(myObject)); // Output: 42
    }
}

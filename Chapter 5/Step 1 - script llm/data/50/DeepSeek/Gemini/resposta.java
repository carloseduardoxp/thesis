import java.lang.reflect.Field;

class MyClass {
    @SuppressWarnings("unused")
    private String secret = "Private Data";
}

public class Main {
    public static void main(String[] args) throws Exception {
        MyClass obj = new MyClass();

        // Get the Class object of MyClass
        Class<?> myClass = obj.getClass();

        // Get the private field "secret"
        Field privateField = myClass.getDeclaredField("secret");

        // Make the field accessible (bypass private modifier)
        privateField.setAccessible(true); // This is the key step!

        // Access the field's value
        String value = (String) privateField.get(obj);
        System.out.println(value); // Output: Private Data

        // Modify the private field
        privateField.set(obj, "Modified Data");
        System.out.println(privateField.get(obj)); // Output: Modified Data
    }
}

import java.lang.reflect.Field;

public class PrivateAccessExample {

    public static void main(String[] args) throws Exception {
        PrivateAccessExample obj = new PrivateAccessExample();
        Field privateField = PrivateAccessExample.class.getDeclaredField("privateField");
        privateField.setAccessible(true);
        int fieldValue = (int) privateField.get(obj);
        System.out.println("Private field value: " + fieldValue);
    }
}
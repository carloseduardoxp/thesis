import java.lang.reflect.Array;

public class Teste {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> dtoClass = Class.forName(p_fld.getType().getName());
        if (dtoClass.isArray()) {
            Object aObject = Array.newInstance(dtoClass.getComponentType(), 5); // 5 is length
            int length = Array.getLength(aObject); // will be 5
            for (int i = 0; i < length; i++) {
                Array.set(aObject, i, "someVal"); // set your val here
            }
        }
    }
}

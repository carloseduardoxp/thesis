import java.lang.reflect.Array;

public class Teste {

    public static void main(String[] args) throws ClassNotFoundException {   
        Class<?> dtoClass = Class.forName(p_fld.getType().getName());     
        if (dtoClass.isArray()) {
            Object arrayObject = Array.newInstance(dtoClass, 5); //5 is length
            int length = Array.getLength(arrayObject); // will be 5
            for (int i = 0; i < length; i++)
                Array.set(arrayObject, i, "someVal"); // set your val here
        }    
    }
}

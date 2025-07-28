
import java.lang.reflect.Array;

public class Teste {

    public static void main(String[] args) {   
        Class l_dto_class = Class.forName(p_fld.getType().getName());     
        if (l_dto_class.isArray()) {
            Object aObject = Array.newInstance(l_dto_class, 5); //5 is length
            int length = Array.getLength(aObject); // will be 5
            for (int i=0; i<length; i++)
                Array.set(aObject, i, "someVal"); // set your val here
        }    
    }
}
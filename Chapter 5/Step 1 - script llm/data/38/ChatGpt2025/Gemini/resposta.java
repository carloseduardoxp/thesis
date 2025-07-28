import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class GenericClass<T> {
    // This field is added to use the generic type 'T' and make the class non-empty.
    private T genericField;
}

class MyClass extends GenericClass<String> {
    // This class is intentionally left empty for the reflection demonstration.
}

public class Main {
    public static void main(String[] args) {
        Type type = MyClass.class.getGenericSuperclass();

        if (type instanceof ParameterizedType) {
            Type[] typeArguments = ((ParameterizedType) type).getActualTypeArguments();
            for (Type t : typeArguments) {
                System.out.println(t.getTypeName()); // prints: java.lang.String
            }
        }
    }
}

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class GenericClass<T> {}

class MyClass extends GenericClass<String> {}

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

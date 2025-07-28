import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

class StringList extends MyList<String> {}
class IntegerList implements MyInterface<Integer, String> {}

abstract class MyList<T> {
    // Add a field to use T and avoid empty class warning
    private T element;
}

interface MyInterface<T, U> {
    // Add a method to use T and U and avoid unused type parameter warning
    void process(T t, U u);
}

public class GenericTypeInfo {
    public static void main(String[] args) {
        // For StringList
        Type stringListSuperclass = StringList.class.getGenericSuperclass();
        if (stringListSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) stringListSuperclass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            System.out.println("StringList's generic type: " + typeArguments[0]); // Output: class java.lang.String
        }

        // For IntegerList
        Type[] integerListInterfaces = IntegerList.class.getGenericInterfaces();
        for (Type genericInterface : integerListInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                Type[] typeArguments = parameterizedType.getActualTypeArguments();
                System.out.println("IntegerList's first generic type: " + typeArguments[0]); // Output: class java.lang.Integer
                System.out.println("IntegerList's second generic type: " + typeArguments[1]); // Output: class java.lang.String
            }
        }
    }
}

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

class StringList extends MyList<String> {}
class IntegerList implements MyInterface<Integer, String> {}
class MyList<T> { /* Class with type parameter T */ }
interface MyInterface<T, U> { /* Interface with type parameters T and U */ }

public class GenericTypeInfo {
    public static void main(String[] args) {
        // For StringList
        Type stringListSuperclass = StringList.class.getGenericSuperclass();
        if (stringListSuperclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) stringListSuperclass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            System.out.println("StringList's generic type: " + typeArguments[0]);
        }

        // For IntegerList
        Type[] integerListInterfaces = IntegerList.class.getGenericInterfaces();
        for (Type genericInterface : integerListInterfaces) {
            if (genericInterface instanceof ParameterizedType) {
                ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
                Type[] typeArguments = parameterizedType.getActualTypeArguments();
                System.out.println("IntegerList's first generic type: " + typeArguments[0]);
                System.out.println("IntegerList's second generic type: " + typeArguments[1]);
            }
        }
    }
}

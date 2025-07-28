import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class GenericTypeExample {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        Type type = list.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) type;
        Type[] typeArguments = parameterizedType.getActualTypeArguments();

        System.out.println("Type of list elements: " + typeArguments[0]);
    }
}

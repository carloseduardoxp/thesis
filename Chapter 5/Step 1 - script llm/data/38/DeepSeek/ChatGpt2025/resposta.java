import java.lang.reflect.*;
import java.util.List;

public class GenericTypeExample {
    public static void main(String[] args) throws Exception {
        Field field = GenericTypeExample.class.getDeclaredField("stringList");
        Type genericFieldType = field.getGenericType();

        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) genericFieldType;
            Type[] actualTypeArgs = pType.getActualTypeArguments();
            for (Type type : actualTypeArgs) {
                System.out.println("Generic type argument: " + type);
            }
        }
    }

    // For demonstration purposes, keep the field as public and static so it can be accessed via reflection
    public static List<String> stringList;
}
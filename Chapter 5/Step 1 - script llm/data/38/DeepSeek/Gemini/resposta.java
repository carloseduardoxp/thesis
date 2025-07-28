import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class GenericTypeExample {
    @SuppressWarnings("unused") // Used by reflection in main
    private List<String> stringList;
    
    public static void main(String[] args) throws Exception {
        Field field = GenericTypeExample.class.getDeclaredField("stringList");
        Type genericFieldType = field.getGenericType();
        
        if (genericFieldType instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType)genericFieldType;
            Type[] actualTypeArgs = pType.getActualTypeArguments();
            for (Type type : actualTypeArgs) {
                System.out.println("Generic type argument: " + type);
                // Output: Generic type argument: class java.lang.String
            }
        }
    }
}

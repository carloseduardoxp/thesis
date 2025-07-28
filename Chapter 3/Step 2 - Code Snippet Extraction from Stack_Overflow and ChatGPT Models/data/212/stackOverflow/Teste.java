
import java.lang.reflect.Field;

public class Teste {

    private static Field getField(Class<?> clazz, String fieldName) {
        Class<?> tmpClass = clazz;
        do {
            for ( Field field : tmpClass.getDeclaredFields() ) {
                String candidateName = field.getName();
                if ( ! candidateName.equals(fieldName) ) {
                    continue;
                }
                field.setAccessible(true);
                return field;
            }
            tmpClass = tmpClass.getSuperclass();
        } while ( clazz != null );
        throw new RuntimeException("Field '" + fieldName +
            "' not found on class " + clazz);
    }
}
import java.lang.reflect.Field;

public class Teste {

    public static Field getField(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        Class<?> tmpClass = clazz;
        do {
            for (Field field : tmpClass.getDeclaredFields()) {
                String candidateName = field.getName();
                if (!candidateName.equals(fieldName)) {
                    continue;
                }
                field.setAccessible(true);
                return field;
            }
            tmpClass = tmpClass.getSuperclass();
        } while (tmpClass != null);
        throw new NoSuchFieldException("Field '" + fieldName +
            "' not found on class " + clazz);
    }
}

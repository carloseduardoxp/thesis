import java.lang.reflect.Field;

public class Teste {

    public static class FieldNotFoundException extends RuntimeException {
        public FieldNotFoundException(String message) {
            super(message);
        }
    }

    // Remove this method if it is truly unused.
    // If it is needed, consider making it public or package-private.
    // For demonstration, changing to package-private:
    static Field getField(Class<?> clazz, String fieldName) {
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
        throw new FieldNotFoundException("Field '" + fieldName +
            "' not found on class " + clazz);
    }
}
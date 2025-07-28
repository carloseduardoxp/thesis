import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    private static final String TAGS_PREFIX = "  Tags: ";
    private static final String COUNT_PREFIX = "  Count: ";
    private static final String ENABLED_PREFIX = "  Enabled: ";
    private static final String VALUE_PREFIX = "  Value: ";

    public static void main(String[] args) {
        // Process class annotation
        Class<MyAnnotatedClass> clazz = MyAnnotatedClass.class;
        if (clazz.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation classAnnotation = clazz.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Class Annotation: ");
            System.out.println(VALUE_PREFIX + classAnnotation.value());
            System.out.println(COUNT_PREFIX + classAnnotation.count());
            System.out.println(ENABLED_PREFIX + classAnnotation.enabled());
            System.out.println(TAGS_PREFIX + String.join(", ", classAnnotation.tags()));
        }

        // Process method annotation
        try {
            Method method = clazz.getMethod("myAnnotatedMethod");
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation methodAnnotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println("\nMethod Annotation (myAnnotatedMethod): ");
                System.out.println(VALUE_PREFIX + methodAnnotation.value());
                System.out.println(COUNT_PREFIX + methodAnnotation.count());
                System.out.println(ENABLED_PREFIX + methodAnnotation.enabled());
                System.out.println(TAGS_PREFIX + String.join(", ", methodAnnotation.tags()));
            }
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found: " + e.getMessage());
        }

        // Process field annotation
        try {
            Field field = clazz.getDeclaredField("myAnnotatedField");
            if (field.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation fieldAnnotation = field.getAnnotation(MyCustomAnnotation.class);
                System.out.println("\nField Annotation (myAnnotatedField): ");
                System.out.println(VALUE_PREFIX + fieldAnnotation.value());
                System.out.println(COUNT_PREFIX + fieldAnnotation.count());
                System.out.println(ENABLED_PREFIX + fieldAnnotation.enabled());
                System.out.println(TAGS_PREFIX + String.join(", ", fieldAnnotation.tags()));
            }
        } catch (NoSuchFieldException e) {
            System.err.println("Field not found: " + e.getMessage());
        }
    }
}

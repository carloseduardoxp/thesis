import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    private static final String VALUE_LABEL = "  Value: ";
    private static final String COUNT_LABEL = "  Count: ";
    private static final String ENABLED_LABEL = "  Enabled: ";
    private static final String TAGS_LABEL = "  Tags: ";

    public static void main(String[] args) {
        // Process class annotation
        Class<MyAnnotatedClass> clazz = MyAnnotatedClass.class;
        if (clazz.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation classAnnotation = clazz.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Class Annotation: ");
            System.out.println(VALUE_LABEL + classAnnotation.value());
            System.out.println(COUNT_LABEL + classAnnotation.count());
            System.out.println(ENABLED_LABEL + classAnnotation.enabled());
            System.out.println(TAGS_LABEL + String.join(", ", classAnnotation.tags()));
        }

        // Process method annotation
        try {
            Method method = clazz.getMethod("myAnnotatedMethod");
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation methodAnnotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println("\nMethod Annotation (myAnnotatedMethod): ");
                System.out.println(VALUE_LABEL + methodAnnotation.value());
                System.out.println(COUNT_LABEL + methodAnnotation.count());
                System.out.println(ENABLED_LABEL + methodAnnotation.enabled());
                System.out.println(TAGS_LABEL + String.join(", ", methodAnnotation.tags()));
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
                System.out.println(VALUE_LABEL + fieldAnnotation.value());
                System.out.println(COUNT_LABEL + fieldAnnotation.count());
                System.out.println(ENABLED_LABEL + fieldAnnotation.enabled());
                System.out.println(TAGS_LABEL + String.join(", ", fieldAnnotation.tags()));
            }
        } catch (NoSuchFieldException e) {
            System.err.println("Field not found: " + e.getMessage());
        }
    }
}

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationProcessor {

    public static void main(String[] args) {
        // Process class annotation
        Class<MyAnnotatedClass> clazz = MyAnnotatedClass.class;
        if (clazz.isAnnotationPresent(MyCustomAnnotation.class)) {
            MyCustomAnnotation classAnnotation = clazz.getAnnotation(MyCustomAnnotation.class);
            System.out.println("Class Annotation: ");
            System.out.println("  Value: " + classAnnotation.value());
            System.out.println("  Count: " + classAnnotation.count());
            System.out.println("  Enabled: " + classAnnotation.enabled());
            System.out.println("  Tags: " + String.join(", ", classAnnotation.tags()));
        }

        // Process method annotation
        try {
            Method method = clazz.getMethod("myAnnotatedMethod");
            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                MyCustomAnnotation methodAnnotation = method.getAnnotation(MyCustomAnnotation.class);
                System.out.println("\nMethod Annotation (myAnnotatedMethod): ");
                System.out.println("  Value: " + methodAnnotation.value());
                System.out.println("  Count: " + methodAnnotation.count());
                System.out.println("  Enabled: " + methodAnnotation.enabled());
                System.out.println("  Tags: " + String.join(", ", methodAnnotation.tags()));
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
                System.out.println("  Value: " + fieldAnnotation.value());
                System.out.println("  Count: " + fieldAnnotation.count());
                System.out.println("  Enabled: " + fieldAnnotation.enabled());
                System.out.println("  Tags: " + String.join(", ", fieldAnnotation.tags()));
            }
        } catch (NoSuchFieldException e) {
            System.err.println("Field not found: " + e.getMessage());
        }
    }
}

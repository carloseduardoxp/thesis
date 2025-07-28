
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DirtyCheck {
    String newValue();
    String oldValue();
}

final class DirtyChecker {

    public boolean process(Object instance) {
        Class<?> clazz = instance.getClass();
        for (Method m : clazz.getDeclaredMethods()) {
            if (m.isAnnotationPresent(DirtyCheck.class)) {
                DirtyCheck annotation = m.getAnnotation(DirtyCheck.class);
                String newVal = annotation.newValue();
                String oldVal = annotation.oldValue();
                return newVal.equals(oldVal);
            }
        }
        return false;
    }
}
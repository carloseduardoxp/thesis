import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

// Retain this annotation at runtime (available via reflection)
@Retention(RetentionPolicy.RUNTIME)

// Can be applied to methods only
@Target(ElementType.METHOD)
public @interface MyCustomAnnotation {
    String value() default "default value";  // An element with a default value
    int number() default 0;                  // Another element
}

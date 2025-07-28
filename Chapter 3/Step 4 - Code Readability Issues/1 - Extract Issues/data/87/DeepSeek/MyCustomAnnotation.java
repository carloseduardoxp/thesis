import java.lang.annotation.*;

// Meta-annotations define how your annotation can be used
@Retention(RetentionPolicy.RUNTIME) // Available at runtime
@Target(ElementType.METHOD)         // Can be applied to methods
public @interface MyCustomAnnotation {
    // Annotation elements (optional parameters)
    String value() default "default value";
    int count() default 1;
}

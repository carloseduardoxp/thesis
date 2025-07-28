import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String value();
}

class MyClass {
    @MyAnnotation("This is a method annotated with MyAnnotation")
    public void myMethod() {
        // Method body
    }

}

class Teste {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        Method method = obj.getClass().getMethod("myMethod");
        MyAnnotation annotation = method.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.value());

    }
}
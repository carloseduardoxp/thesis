// T is a type parameter
class Box<T> {
    private T content;

    public void setContent(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }
}

public class GenericClassExample {
    public static void main(String[] args) {
        // Create a Box for Integer
        Box<Integer> integerBox = new Box<>();
        integerBox.setContent(123);
        int intValue = integerBox.getContent(); // No cast needed
        System.out.println("Integer Box Content: " + intValue);

        // Create a Box for String
        Box<String> stringBox = new Box<>();
        stringBox.setContent("Hello Generics!");
        String stringValue = stringBox.getContent(); // No cast needed
        System.out.println("String Box Content: " + stringValue);

        // This would cause a compile-time error:
        // integerBox.setContent("abc"); // Incompatible types
    }
}

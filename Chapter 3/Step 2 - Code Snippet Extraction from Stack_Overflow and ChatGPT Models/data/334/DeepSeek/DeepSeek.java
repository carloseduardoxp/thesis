
// Custom checked exception (must be declared or caught)
public class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }
}

// Custom unchecked exception (extends RuntimeException)
public class MyUncheckedException extends RuntimeException {
    public MyUncheckedException(String message) {
        super(message);
    }
}

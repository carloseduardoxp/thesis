// MyCustomCheckedException.java
public class MyCustomCheckedException extends Exception {

    // Constructor with no arguments
    public MyCustomCheckedException() {
        this(null, 0);
    }

    // Constructor with a message
    public MyCustomCheckedException(String message) {
        this(message, 0);
    }

    // Constructor with a message and a cause
    public MyCustomCheckedException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = 0;
    }

    // Constructor with a cause
    public MyCustomCheckedException(Throwable cause) {
        super(cause);
        this.errorCode = 0;
    }

    // You can add custom fields or methods if needed
    private final int errorCode;

    public MyCustomCheckedException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

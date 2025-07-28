
// MyCustomCheckedException.java
public class MyCustomCheckedException extends Exception {

    // Constructor with no arguments
    public MyCustomCheckedException() {
        super();
    }

    // Constructor with a message
    public MyCustomCheckedException(String message) {
        super(message);
    }

    // Constructor with a message and a cause
    public MyCustomCheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor with a cause
    public MyCustomCheckedException(Throwable cause) {
        super(cause);
    }

    // You can add custom fields or methods if needed
    private int errorCode;

    public MyCustomCheckedException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
}

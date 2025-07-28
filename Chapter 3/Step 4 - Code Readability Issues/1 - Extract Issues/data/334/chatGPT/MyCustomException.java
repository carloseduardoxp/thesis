public class MyCustomException extends Exception {

  public MyCustomException(String message) {
      super(message);
  }

  public MyCustomException(String message, Throwable cause) {
      super(message, cause);
  }

  public static void main(String[] args) {
    if (someCondition) {
      throw new MyCustomException("Some error message");
    }
  }
}

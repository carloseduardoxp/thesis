public class MyClass {
    
  public void myMethod() throws MyException {
      // some code that may throw an exception
  }
  
  public void myExceptionHandler() {
      try {
          myMethod();
      } catch (MyException e) {
          // handle the exception here
      }
  }
  
  public static void main(String[] args) {
      MyClass myObject = new MyClass();
      myObject.myExceptionHandler();
  }
  
  private static class MyException extends Exception {
      // custom exception class
  }
}

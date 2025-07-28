public class MyStaticClass {
  public static void doSomethingWithApplicationContext(Context context) {
      // use the application context for a long-running operation
      // ...
  }

  public static void main(String[] args) {
    MyStaticClass.doSomethingWithApplicationContext(getApplicationContext());
  }
}
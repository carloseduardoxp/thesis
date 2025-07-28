@FunctionalInterface
public interface MySAM {
    public void doSomething();
}

class MyClass {
  public void printMessage() {
      System.out.println("Hello, SAM from MyClass!");
  }

  public static void main(String[] args) {
    MyClass myClass = new MyClass();
    MySAM mySam = myClass::printMessage;
    mySam.doSomething(); // Output: Hello, SAM from MyClass!
  }
}



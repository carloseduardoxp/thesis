class MyClass {
  private int value;

  public MyClass(int value) {
      this.value = value;
  }

  public MyClass plus(MyClass other) {
      return new MyClass(this.value + other.value);
  }

  public int getValue() {
      return value;
  }
}

public class Main {
  public static void main(String[] args) {
      MyClass a = new MyClass(2);
      MyClass b = new MyClass(3);
      MyClass c = a.plus(b);
      System.out.println(c.getValue()); // Output: 5
  }
}

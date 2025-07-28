public class MyClass {
  public void myMethod(int num) {
      System.out.println("Integer: " + num);
  }
  public void myMethod(String str) {
      System.out.println("String: " + str);
  }
}

class Animal {
  public void makeSound() {
      System.out.println("The animal makes a sound");
  }
}

class Dog extends Animal {
  @Override
  public void makeSound() {
      System.out.println("The dog barks");
  }
}

class Cat extends Animal {
  @Override
  public void makeSound() {
      System.out.println("The cat meows");
  }
}
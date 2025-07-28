abstract class Animal {
  public abstract void makeSound();
}

class Dog extends Animal {
  public void makeSound() {
      System.out.println("Bark");
  }
}

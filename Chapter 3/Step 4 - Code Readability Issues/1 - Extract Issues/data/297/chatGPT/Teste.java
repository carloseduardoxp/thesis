interface Animal {
  void makeSound();
}

class Dog implements Animal {
  @Override
  public void makeSound() {
      System.out.println("Woof!");
  }
}

class Cat implements Animal {
  @Override
  public void makeSound() {
      System.out.println("Meow!");
  }
}

class AnimalFactory {
  public Animal createAnimal(String type) {
      if (type.equalsIgnoreCase("dog")) {
          return new Dog();
      } else if (type.equalsIgnoreCase("cat")) {
          return new Cat();
      } else {
          throw new IllegalArgumentException("Invalid animal type: " + type);
      }
  }
}

public class Teste {
  public static void main(String[] args) {
    AnimalFactory animalFactory = new AnimalFactory();
    Animal dog = animalFactory.createAnimal("dog");
    dog.makeSound(); // Output: Woof!

    Animal cat = animalFactory.createAnimal("cat");
    cat.makeSound(); // Output: Meow!

  }
}
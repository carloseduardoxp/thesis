public class ParentClassExample {
  public static void main(String[] args) {
     // Get the parent class of a class
     Class<?> parentClass = ChildClass.class.getSuperclass();

     // Print the name of the parent class
     System.out.println("The parent class of ChildClass is: " + parentClass.getName());
  }
}

class ParentClass {
  // Add meaningful implementation or remove this class if not needed
}

class ChildClass extends ParentClass {
  // ...
}
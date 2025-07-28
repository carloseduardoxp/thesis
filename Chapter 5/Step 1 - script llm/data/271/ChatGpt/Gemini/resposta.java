public class ParentClassExample {
  public static void main(String[] args) {
     // Get the parent class of a class
     Class<?> parentClass = Integer.class.getSuperclass();

     // Print the name of the parent class
     System.out.println("The parent class of Integer is: " + parentClass.getName());
  }
}

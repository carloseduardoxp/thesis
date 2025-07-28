public class ChildClass extends ParentClass {
    public static void main(String[] args) {
        // Get the parent class of ChildClass
        Class<?> parentClass = ChildClass.class.getSuperclass();
        
        // Print the parent class name
        System.out.println("Parent class: " + parentClass.getName());
    }
}

class ParentClass {
}
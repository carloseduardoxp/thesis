class ParentClass {
    // Parent class
}

class ChildClass extends ParentClass {
    // Child class
}

public class Main {
    public static void main(String[] args) {
        ChildClass childObject = new ChildClass();

        // Get the Class object for the childObject
        Class<?> childClass = childObject.getClass();

        // Get the Class object for the superclass
        Class<?> superClass = childClass.getSuperclass();

        // Check if there is a superclass (Object.class has no superclass, returns null)
        if (superClass != null) {
            // Get the full qualified name of the superclass
            String superClassName = superClass.getName();
            System.out.println("Full qualified parent class name: " + superClassName);

            // Get the simple name of the superclass (without package)
            String simpleSuperClassName = superClass.getSimpleName();
            System.out.println("Simple parent class name: " + simpleSuperClassName);
        } else {
            System.out.println("No superclass found (likely java.lang.Object)");
        }

        // You can also get the superclass name directly from a Class literal:
        Class<?> directSuperClass = ChildClass.class.getSuperclass();
        if (directSuperClass != null) {
            System.out.println("Direct parent class name (from class literal): " + directSuperClass.getName());
        }
    }
}

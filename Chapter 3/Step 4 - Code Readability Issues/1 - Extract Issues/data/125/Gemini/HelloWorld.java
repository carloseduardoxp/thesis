// This is a simple Java program that prints "Hello, World!" to the console.

// Every Java application must have at least one class.
// The class name should ideally start with an uppercase letter and follow PascalCase.
public class HelloWorld {

    // The main method is the entry point for any Java application.
    // When you run a Java program, the Java Virtual Machine (JVM) looks for this method.
    // - 'public': This is an access modifier, meaning the method can be accessed from anywhere.
    // - 'static': This means the method belongs to the class itself, not to any specific object of the class.
    //             You can call it without creating an instance of the class.
    // - 'void': This indicates that the method does not return any value.
    // - 'main': This is the name of the method. It must be exactly 'main' for the JVM to recognize it.
    // - '(String[] args)': This defines the command-line arguments that can be passed to the program.
    //                      'args' is an array of String objects.
    public static void main(String[] args) {

        // System.out.println() is used to print output to the console.
        // - 'System': A final class in the java.lang package.
        // - 'out': A static member of the System class, which is an instance of PrintStream.
        // - 'println': A method of the PrintStream class that prints a string and then terminates the line.
        System.out.println("Hello, World!");
    }
}

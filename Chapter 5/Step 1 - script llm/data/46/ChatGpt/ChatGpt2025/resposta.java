class MyClass {
    private static int count = 0; // static member variable

    public MyClass() {
        count++; // increment count for each new instance of MyClass
    }

    public static void printCount() { // static method
        System.out.println("Number of instances created: " + count);
    }
}

public class Main {
    public static void main(String[] args) {
        new MyClass();
        new MyClass();
        new MyClass();

        MyClass.printCount(); // Access static method using class name
    }
}
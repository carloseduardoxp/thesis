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
        MyClass obj1 = new MyClass();
        MyClass obj2 = new MyClass();
        MyClass obj3 = new MyClass();

        MyClass.printCount(); // Access static method using class name
    }
}

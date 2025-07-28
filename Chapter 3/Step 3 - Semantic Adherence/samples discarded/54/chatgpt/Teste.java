public class MyClass {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        int result = myClass.add(3, 5);
        System.out.println(result); // prints 8

    }
}

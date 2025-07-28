public class Example {
    static int counter = 0;

    Example() {
        counter++;
    }

    public static void main(String[] args) {
        new Example();
        new Example();
        System.out.println(Example.counter); // Output: 2
    }
}

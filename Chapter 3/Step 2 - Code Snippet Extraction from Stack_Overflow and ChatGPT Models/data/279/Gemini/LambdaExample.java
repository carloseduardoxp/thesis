// A functional interface (single abstract method)
interface MyFunction {
    void doSomething(String message);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement MyFunction
        MyFunction printer = (msg) -> System.out.println("Message: " + msg);

        printer.doSomething("Hello, Lambda!");

        // Lambda with multiple statements in the body
        MyFunction calculator = (numStr) -> {
            int num = Integer.parseInt(numStr);
            int result = num * 2;
            System.out.println("Double of " + num + " is: " + result);
        };
        calculator.doSomething("10");
    }
}

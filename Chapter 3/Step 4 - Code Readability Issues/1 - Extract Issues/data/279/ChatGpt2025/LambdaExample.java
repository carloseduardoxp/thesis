public class LambdaExample {
    public static void main(String[] args) {
        // Lambda expression for adding two integers
        MathOperation add = (a, b) -> a + b;
        
        // Using the lambda expression
        System.out.println("Addition result: " + add.operation(5, 3));  // Outputs 8
    }
}

interface MathOperation {
    int operation(int a, int b);
}

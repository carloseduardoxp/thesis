import java.util.Scanner;

public class SimpleCalculator {
    private static final String RESULT_PREFIX = "Result: ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Simple Calculator");
        System.out.println("----------------");
        System.out.println("Operations available:");
        System.out.println("1. Addition (+)");
        System.out.println("2. Subtraction (-)");
        System.out.println("3. Multiplication (*)");
        System.out.println("4. Division (/)");
        
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        
        System.out.print("Choose operation (+, -, *, /): ");
        char operation = scanner.next().charAt(0);
        
        double result;
        
        switch(operation) {
            case '+':
                result = num1 + num2;
                System.out.println(RESULT_PREFIX + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println(RESULT_PREFIX + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println(RESULT_PREFIX + result);
                break;
            case '/':
                if(num2 != 0) {
                    result = num1 / num2;
                    System.out.println(RESULT_PREFIX + result);
                } else {
                    System.out.println("Error: Division by zero!");
                }
                break;
            default:
                System.out.println("Invalid operation!");
        }
        
        scanner.close();
    }
}

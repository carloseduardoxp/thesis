import java.util.Scanner;

public class Calculator {

    // Rule java:S115 - Renamed enum members to UPPER_SNAKE_CASE.
    // Also renamed enum type to PascalCase for convention.
    private enum Operation {
        POS, NEG, MULT, DIV
    }
    // Rule java:S1116 - Removed empty statement that was after the enum definition.

    // Rule java:S1068 - Removed unused private string fields: pos, neg, mult, div.

    // Rule java:S3010 - Moved Scanner initialization from constructor to declaration.
    // Also applied naming conventions (UPPER_SNAKE_CASE for static final) and made it private.
    private static final Scanner OPERATORS = new Scanner(System.in);

    private int x;
    private int y;

    // The constructor was only used for initializing fields that have been removed
    // or refactored, so it is no longer needed. A default constructor will be provided.

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int addition(int x, int y) {
        return x + y;
    }

    public int subtraction(int x, int y) {
        return x - y;
    }

    public int multiplication(int x, int y) {
        return x * y;
    }

    public int division(int x, int y) {
        // Simplified method by removing unnecessary 'solution' field.
        return x / y;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Insert 2 numbers");

        System.out.print("operand 1: ");
        calc.setX(Integer.parseInt(OPERATORS.next()));

        System.out.print("operand 2: ");
        calc.setY(Integer.parseInt(OPERATORS.next()));

        System.out.println("What operation? ('POS', 'NEG', 'MULT', 'DIV')");
        // Using the renamed enum type and a more descriptive variable name.
        // Making the input processing case-insensitive for better UX.
        Operation selectedOperation = Operation.valueOf(OPERATORS.next().toUpperCase());
        int output = 0;

        // Using the renamed enum constants in the switch
        switch (selectedOperation) {
            case POS:
                output = calc.addition(calc.getX(), calc.getY());
                break;
            case NEG:
                output = calc.subtraction(calc.getX(), calc.getY());
                break;
            case MULT:
                output = calc.multiplication(calc.getX(), calc.getY());
                break;
            case DIV:
                output = calc.division(calc.getX(), calc.getY());
                break;
        }
        System.out.println("output=" + output);
    }
}

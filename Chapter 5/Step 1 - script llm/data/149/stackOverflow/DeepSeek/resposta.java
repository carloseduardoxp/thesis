import java.util.Scanner;

public class Calculator {
    private enum Operation {
        ADDITION, SUBTRACTION, MULTIPLICATION, DIVISION
    }

    private int solution;
    private int x;
    private int y;
    private static Scanner operators;

    public Calculator() {
        solution = 0;
        operators = new Scanner(System.in);
    }

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
        solution = x / y;
        return solution;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Insert 2 numbers");
        System.out.println("operand 1: ");
        calc.setX(Integer.parseInt(operators.next()));

        System.out.println("operand 2: ");
        calc.setY(Integer.parseInt(operators.next()));

        System.out.println("What operation? ('ADDITION', 'SUBTRACTION', 'MULTIPLICATION', 'DIVISION')");
        Operation operation = Operation.valueOf(operators.next().toUpperCase());
        int output = 0;
        switch(operation) {
            case ADDITION:
                output = calc.addition(calc.getX(), calc.getY());
                break;
            case SUBTRACTION:
                output = calc.subtraction(calc.getX(), calc.getY());
                break;
            case MULTIPLICATION:
                output = calc.multiplication(calc.getX(), calc.getY());
                break;
            case DIVISION:
                output = calc.division(calc.getX(), calc.getY());
                break;
        }
        System.out.println("output = " + output);
    }
}

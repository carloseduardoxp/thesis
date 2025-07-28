import java.util.Scanner;

public class Calculator {

    private int solution;
    private int x;
    private int y;

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

    private enum Operation {
        POS, NEG, MULT, DIV
    }

    public Calculator() {
        solution = 0;
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
        Scanner operators = new Scanner(System.in);

        System.out.println("Insert 2 numbers");

        System.out.println("operand 1: ");
        calc.setX(Integer.parseInt(operators.next()));

        System.out.println("operand 2: ");
        calc.setY(Integer.parseInt(operators.next()));

        System.out.println("What operation? ('POS', 'NEG', 'MULT', 'DIV')");
        Operation ttt = Operation.valueOf(operators.next().toUpperCase());
        int output = 0;
        switch (ttt) {
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
        System.out.println("output =" + output);
        operators.close();
    }
}

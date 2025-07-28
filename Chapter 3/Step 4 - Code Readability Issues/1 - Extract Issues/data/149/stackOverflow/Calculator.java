
import java.util.Scanner;

public class Calculator {
    private static final String pos = "+";
    private static final String neg = "-";
    private static final String mult = "*";
    private static final String div = "/";

    private enum operation {
        pos, neg, mult, div
    };
    private int solution;
    private int x;
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

    private int y;



    static Scanner operators;

    public Calculator() {
        solution = 0;
        operators = new Scanner(System.in);

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

        System.out.println("What operation? ('pos', 'neg', 'mult', 'div')");
        operation ttt = operation.valueOf(operators.next());
        int output = 0 ;
        switch(ttt){
        case pos:
            output = calc.addition(calc.getX(), calc.getY());

            break;
          case neg:
              output = calc.subtraction(calc.getX(), calc.getY());

            break;
          case mult:
              output = calc.multiplication(calc.getX(), calc.getY());

            break;
          case div:
              output = calc.division(calc.getX(), calc.getY());

            break;
        }
        System.out.println("output ="+output);
    }
}
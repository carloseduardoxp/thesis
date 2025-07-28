import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        // Using a lambda expression to filter even numbers
        List<Integer> evenNumbers = numbers.stream()
                                            .filter(n -> n % 2 == 0)
                                            .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        // Using a lambda expression to square each number
        List<Integer> squaredNumbers = numbers.stream()
                                               .map(n -> n * n)
                                               .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers);

        // Using a lambda expression to compute the sum of all numbers
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum of all numbers: " + sum);
    }
}

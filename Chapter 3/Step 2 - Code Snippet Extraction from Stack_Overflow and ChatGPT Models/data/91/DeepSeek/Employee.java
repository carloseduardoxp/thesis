import java.util.*;
import java.util.stream.*;

public class Employee {
    private String name;
    private int age;
    private double salary;
    
    // Constructor, getters omitted for brevity
    
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John", 30, 50000),
            new Employee("Alice", 25, 60000),
            new Employee("Bob", 30, 45000)
        );
        
        // Sort by age ascending, then by salary descending
        List<Employee> sortedEmployees = employees.stream()
            .sorted(Comparator.comparingInt(Employee::getAge)
                   .thenComparing(Comparator.comparingDouble(Employee::getSalary).reversed()))
            .collect(Collectors.toList());
            
        sortedEmployees.forEach(e -> System.out.println(e.getName() + " - " + e.getAge() + " - $" + e.getSalary()));
    }
}

import java.util.Objects;

public class Employee {
    private final int id;
    private final String name;
    private final Department department;
    
    // Constructor
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
               Objects.equals(name, employee.name) &&
               Objects.equals(department, employee.department);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, department);
    }
}

class Department {
    // equals() and hashCode()
}

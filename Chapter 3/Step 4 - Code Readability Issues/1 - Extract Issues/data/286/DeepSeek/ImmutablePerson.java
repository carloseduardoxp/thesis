import java.util.Date;

public final class ImmutablePerson {
    // All fields private and final
    private final String name;
    private final int age;
    private final Date birthDate;  // Date is mutable
    
    // Constructor initializes all fields
    public ImmutablePerson(String name, int age, Date birthDate) {
        this.name = name;
        this.age = age;
        // Defensive copy for mutable field
        this.birthDate = new Date(birthDate.getTime());
    }
    
    // Only getters, no setters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public Date getBirthDate() {
        // Return defensive copy
        return new Date(birthDate.getTime());
    }
}

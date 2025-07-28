import java.util.Date;

public final class ImmutablePerson {
    private final String name;
    private final int age;
    private final Date birthDate; // mutable object

    public ImmutablePerson(String name, int age, Date birthDate) {
        this.name = name;
        this.age = age;
        // Defensive copy to prevent external mutation of birthDate
        this.birthDate = new Date(birthDate.getTime());
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Date getBirthDate() {
        // Return a defensive copy to avoid exposing the internal mutable object
        return new Date(birthDate.getTime());
    }
}

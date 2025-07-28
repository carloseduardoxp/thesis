import java.util.ArrayList;
import java.util.Collections;
import java.util.Date; // Date is a mutable class
import java.util.List;

public final class ImmutableStudent { // Rule 1: Class is final

    private final int id;             // Rule 2: All fields are private and final
    private final String name;        // Rule 2: All fields are private and final
    private final List<String> courses; // Rule 2: All fields are private and final
    private final Date enrollmentDate; // Rule 2: All fields are private and final

    // Rule 4: Initialize all fields via the constructor
    public ImmutableStudent(int id, String name, List<String> courses, Date enrollmentDate) {
        this.id = id;
        this.name = name;

        // Rule 5 (a): Deep copy for mutable List in constructor
        if (courses == null) {
            this.courses = Collections.emptyList(); // Or throw IllegalArgumentException
        } else {
            this.courses = new ArrayList<>(courses); // Create a new ArrayList from the passed one
        }

        // Rule 5 (a): Deep copy for mutable Date in constructor
        if (enrollmentDate == null) {
            this.enrollmentDate = null; // Or handle as an error if date is mandatory
        } else {
            this.enrollmentDate = new Date(enrollmentDate.getTime()); // Create a new Date object
        }
    }

    // Rule 3: No setter methods

    // Getter methods (return copies for mutable objects)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getCourses() {
        // Rule 5 (b): Deep copy for mutable List in getter
        return new ArrayList<>(courses); // Return a new ArrayList, not the internal reference
    }

    public Date getEnrollmentDate() {
        // Rule 5 (b): Deep copy for mutable Date in getter
        if (enrollmentDate == null) {
            return null;
        }
        return new Date(enrollmentDate.getTime()); // Return a new Date object
    }

    @Override
    public String toString() {
        return "ImmutableStudent{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", courses=" + courses +
               ", enrollmentDate=" + enrollmentDate +
               '}';
    }
}

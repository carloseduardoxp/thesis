public class StringConcatenationExample {
    public static void main(String[] args) {
        String firstName = "John";
        String lastName = "Doe";

        // Concatenating two strings
        String fullName = firstName + " " + lastName;
        System.out.println("Full Name: " + fullName); // Output: Full Name: John Doe

        // Concatenating strings with other data types
        int age = 30;
        String message = "My name is " + firstName + " and I am " + age + " years old.";
        System.out.println(message); // Output: My name is John and I am 30 years old.
    }
}

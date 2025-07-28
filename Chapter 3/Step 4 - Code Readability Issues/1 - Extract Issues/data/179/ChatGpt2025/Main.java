class Car {
    // Attributes (fields)
    String color;
    String model;

    // Constructor (optional but common)
    public Car(String color, String model) {
        this.color = color;
        this.model = model;
    }

    // Method (optional)
    public void display() {
        System.out.println("Car model: " + model + ", Color: " + color);
    }
}
public class Main {
    public static void main(String[] args) {
        // Create a new Car object
        Car myCar = new Car("Red", "Toyota");

        // Use the object
        myCar.display();  // Output: Car model: Toyota, Color: Red
    }
}

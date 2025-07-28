// 1. Abstract Class with an Abstract Method
public abstract class Shape {
    private String name;

    public Shape(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method - subclasses must implement this
    public abstract double calculateArea();

    public void displayMessage() {
        System.out.println("This is a shape.");
    }
}

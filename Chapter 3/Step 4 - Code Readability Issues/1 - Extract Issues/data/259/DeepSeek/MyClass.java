// Basic class syntax in Java
public class MyClass {
    // Fields (instance variables)
    private int myNumber;
    private String myString;
    
    // Constructor
    public MyClass(int number, String text) {
        this.myNumber = number;
        this.myString = text;
    }
    
    // Methods
    public void printDetails() {
        System.out.println("Number: " + myNumber);
        System.out.println("Text: " + myString);
    }
    
    // Getters and setters
    public int getMyNumber() {
        return myNumber;
    }
    
    public void setMyNumber(int myNumber) {
        this.myNumber = myNumber;
    }
    
    public String getMyString() {
        return myString;
    }
    
    public void setMyString(String myString) {
        this.myString = myString;
    }
    
    // Main method (optional - typically in a separate class)
    public static void main(String[] args) {
        MyClass myObject = new MyClass(42, "Hello World");
        myObject.printDetails();
    }
}

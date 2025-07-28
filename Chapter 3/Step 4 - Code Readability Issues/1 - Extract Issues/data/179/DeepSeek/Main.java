// 1. Define a class
class Car {
    String model;
    int year;
    
    void start() {
        System.out.println("Car started!");
    }
}

public class Main {
    public static void main(String[] args) {
        // 2. Create an object using the 'new' keyword
        Car myCar = new Car();
        
        // 3. Access object's fields and methods
        myCar.model = "Toyota";
        myCar.year = 2020;
        myCar.start();
    }
}

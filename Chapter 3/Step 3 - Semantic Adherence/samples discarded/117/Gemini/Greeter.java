public class Greeter {
    public void sayHello() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        Greeter myGreeter = new Greeter(); // Create an object of Greeter
        myGreeter.sayHello();             // Call the sayHello method
    }
}

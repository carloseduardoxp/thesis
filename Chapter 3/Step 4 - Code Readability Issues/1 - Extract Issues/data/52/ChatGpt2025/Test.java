class Parent {
    int num = 100;
    
    void display() {
        System.out.println("Parent display method");
    }
}

class Child extends Parent {
    int num = 200;
    
    void display() {
        System.out.println("Child display method");
    }
    
    void show() {
        display();             // calls child class method
        super.display();       // calls parent class method
        
        System.out.println(num);        // prints 200 (child variable)
        System.out.println(super.num);  // prints 100 (parent variable)
    }
}

public class Test {
    public static void main(String[] args) {
        Child c = new Child();
        c.show();
    }
}

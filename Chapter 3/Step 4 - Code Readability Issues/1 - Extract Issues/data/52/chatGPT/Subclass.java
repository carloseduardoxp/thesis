public class Subclass extends Superclass {
    public Subclass(int x, int y) {
        super(x, y); // calls the constructor of the superclass with two arguments
    }
}

class Subclass2 extends Superclass {
    public void doSomething() {
        super.doSomething(); // calls the doSomething method of the superclass
    }
}

class Subclass3 extends Superclass {
    public void printX() {
        System.out.println(super.x); // accesses the x variable of the superclass
    }
}

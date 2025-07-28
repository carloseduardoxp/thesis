
import java.io.FileNotFoundException;
import java.io.IOException;

class Parent {
    void doSomething() throws IOException {
        // parent implementation
    }
}

public class Child extends Parent {
    @Override
    void doSomething() throws FileNotFoundException { // FileNotFoundException is subclass of IOException
        // child implementation
    }
}

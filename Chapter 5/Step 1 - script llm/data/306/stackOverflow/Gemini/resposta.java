class A {

    //getter setter
}

class B {

    //getter setter
}

public class Teste {

    public static void main(String[] args) {
        // The stream operation was removed as it had no side effects and its result was unused.
        // This caused the fields 'b' and 'id' to be flagged as unused.
        // Applying the recommendation to remove the fields requires removing the code that uses them.
    }
}

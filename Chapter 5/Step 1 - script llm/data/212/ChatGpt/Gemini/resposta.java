class MyClass {
    private int privateField;

    public void setPrivateField(int value) {
        this.privateField = value;
    }

    public int getPrivateField() {
        return privateField;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass myObject = new MyClass();
        myObject.setPrivateField(42);
        System.out.println(myObject.getPrivateField()); // Output: 42
    }
}

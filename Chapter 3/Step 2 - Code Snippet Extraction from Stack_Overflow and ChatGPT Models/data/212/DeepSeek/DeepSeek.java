
class MyClass {

    private int privateField;

    public int getPrivateField() {
        return this.privateField;
    }
}

public class DeepSeek {

    public static void main(String[] args) {

        MyClass obj = new MyClass();
        int value = obj.getPrivateField();

    }

}

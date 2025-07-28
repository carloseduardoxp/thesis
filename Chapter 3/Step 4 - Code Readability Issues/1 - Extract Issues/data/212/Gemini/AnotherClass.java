class MyClass {
    private String privateField = "Hello";

    public String getPrivateField() {
        return privateField;
    }

    public void setPrivateField(String newValue) {
        // Optional: Add validation logic here
        this.privateField = newValue;
    }
}

public class AnotherClass {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        System.out.println(obj.getPrivateField()); // Accessing via getter

        obj.setPrivateField("World"); // Modifying via setter
        System.out.println(obj.getPrivateField());
    }
}

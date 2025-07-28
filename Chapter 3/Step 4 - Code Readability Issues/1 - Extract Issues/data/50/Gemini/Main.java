class MyClass {
    private String privateData = "secret";

    public String getPrivateData() {
        return privateData;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass();
        String data = obj.getPrivateData(); // Accessing through the public getter
        System.out.println(data); // Output: secret
    }
}

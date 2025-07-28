public class Teste<T> {
    private T value;

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        Teste<Integer> box1 = new Teste<>();
        box1.setValue(123);
        System.out.println(box1.getValue()); // Output: 123
    
        Teste<String> box2 = new Teste<>();
        box2.setValue("Hello, World!");
        System.out.println(box2.getValue()); // Output: Hello, World!
    
    }
}


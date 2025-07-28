public class Box<T> {
  private T item;

  public void setItem(T item) {
      this.item = item;
  }

  public T getItem() {
      return item;
  }
}

class Teste {
  public static void main(String[] args) {
    Box<String> stringBox = new Box<>();
    Box<Integer> intBox = new Box<>();

    stringBox.setItem("Hello, World!");
    System.out.println(stringBox.getItem());

    intBox.setItem(42);
    System.out.println(intBox.getItem());


  }
}
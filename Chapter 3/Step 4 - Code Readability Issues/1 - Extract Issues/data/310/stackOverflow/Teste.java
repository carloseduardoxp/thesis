
public class Teste {

    public static void main(String[] args) {
        RLinkedList ll = new RLinkedList();
        ll.add("Amy");
        ll.add("Bob");
        ll.add(0, "Al");
        ll.add(2, "Beth");
        ll.add(4, "Carol");

        System.out.println("SIZE");
        System.out.println(ll.size());
    }
}

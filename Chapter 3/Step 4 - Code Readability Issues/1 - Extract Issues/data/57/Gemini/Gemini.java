
class Node {

    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Gemini {

    public void removeFirst() {
        if (head != null) {
            head = head.next;
        }
        // If the list was empty, head remains null.
    }
}

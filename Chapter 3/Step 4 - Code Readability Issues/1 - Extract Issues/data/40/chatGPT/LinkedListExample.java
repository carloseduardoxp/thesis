class Node {
    int value;
    Node next;

    public Node(int value) {
        this.value = value;
    }
}

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        // Print the original list
        System.out.println("Original list:");
        printList(head);

        // Reverse the list
        Node prev = null;
        Node curr = head;
        Node next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;

        // Print the reversed list
        System.out.println("Reversed list:");
        printList(head);
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

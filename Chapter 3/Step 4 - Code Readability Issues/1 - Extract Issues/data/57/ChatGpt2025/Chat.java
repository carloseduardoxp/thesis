class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to remove the first occurrence of a node with given value
    public void remove(int value) {
        if (head == null) {
            return; // empty list
        }

        // If head node itself holds the value to be removed
        if (head.data == value) {
            head = head.next;
            return;
        }

        // Find the node to be deleted, keep track of the previous node
        Node current = head;
        Node prev = null;

        while (current != null && current.data != value) {
            prev = current;
            current = current.next;
        }

        // If value was not present in linked list
        if (current == null) {
            return;
        }

        // Unlink the node from linked list
        prev.next = current.next;
    }

    // Method to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Helper to add new node at the end
    public void append(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);

        System.out.println("Original list:");
        list.printList();

        list.remove(3);

        System.out.println("List after removing 3:");
        list.printList();
    }
}

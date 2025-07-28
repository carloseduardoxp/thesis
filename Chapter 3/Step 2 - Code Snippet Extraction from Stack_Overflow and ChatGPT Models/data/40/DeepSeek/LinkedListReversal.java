public class LinkedListReversal {
    static class Node {
        int data;
        Node next;
        
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    // Iterative reversal
    public static Node reverseIterative(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        
        return prev;
    }
    
    // Recursive reversal
    public static Node reverseRecursive(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;
        
        return newHead;
    }
    
    // Utility method to print the linked list
    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create a sample linked list: 1->2->3->4->5
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);
        
        System.out.println("Original list:");
        printList(head);
        
        // Reverse iteratively
        head = reverseIterative(head);
        System.out.println("After iterative reversal:");
        printList(head);
        
        // Reverse recursively
        head = reverseRecursive(head);
        System.out.println("After recursive reversal (back to original):");
        printList(head);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while (current != null) {
            ListNode nextNode = current.next; // Save next node
            current.next = prev;              // Reverse current node's pointer
            prev = current;                   // Move prev forward
            current = nextNode;               // Move current forward
        }

        return prev; // New head of the reversed list
    }

    // Optional: Helper method to print list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample linked list: 1 -> 2 -> 3 -> null
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        System.out.print("Original list: ");
        printList(head);

        head = reverseList(head);

        System.out.print("Reversed list: ");
        printList(head);
    }
}

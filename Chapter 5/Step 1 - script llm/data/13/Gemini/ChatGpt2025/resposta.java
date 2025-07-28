import java.util.LinkedList;

public class Gemini {

    public static void main(String[] args) {

        LinkedList<String> myLinkedList = new LinkedList<>(); // Creates a linked list to store Strings
        myLinkedList.add("Apple");
        myLinkedList.add("Banana");
        myLinkedList.add("Cherry");
        System.out.println(myLinkedList); // Output: [Apple, Banana, Cherry]
        myLinkedList.addFirst("Mango");
        System.out.println(myLinkedList); // Output: [Mango, Apple, Banana, Cherry]
        myLinkedList.addLast("Date");
        System.out.println(myLinkedList); // Output: [Mango, Apple, Banana, Cherry, Date]
        myLinkedList.add(2, "Grape");
        System.out.println(myLinkedList); // Output: [Mango, Apple, Grape, Banana, Cherry, Date]
        String fruit = myLinkedList.get(1);
        System.out.println(fruit); // Output: Apple
        String firstFruit = myLinkedList.getFirst();
        System.out.println(firstFruit); // Output: Mango
        String lastFruit = myLinkedList.getLast();
        System.out.println(lastFruit); // Output: Date

    }
}
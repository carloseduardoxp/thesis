
public class DeepSeek {

    public static void main(String[] args) {

        String str = "Hello, welcome to Java programming";
        String search = "Java";

// Find first occurrence
        int position = str.indexOf(search); // returns 18

        if (position != -1) {
            System.out.println("Found at position: " + position);
        } else {
            System.out.println("Not found");
        }

// Find occurrence starting from specific index
        int fromIndex = 10;
        position = str.indexOf(search, fromIndex); // searches from index 10 onward

    }

}

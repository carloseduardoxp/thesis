
public class DeepSeek {

    public static void main(String[] args) {

        switch (value) {
            case 1:
                System.out.println("One");
            // No break - falls through to case 2
            case 2:
                System.out.println("Two");
                break;
            case 3:
                System.out.println("Three");
                break;
            default:
                System.out.println("Other");
        }

    }

}

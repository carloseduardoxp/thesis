
public class Chat {

    public static void main(String[] args) {

        String str = "apple,banana,orange";
        String[] parts = str.split(",");  // Split by comma

        for (String part : parts) {
            System.out.println(part);
        }

    }

}

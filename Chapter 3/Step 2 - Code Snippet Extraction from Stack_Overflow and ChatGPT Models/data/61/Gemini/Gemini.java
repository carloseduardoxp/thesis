
public class Gemini {

    public static void main(String[] args) {

        String myString = "apple,banana,orange,grape";
        String[] parts = myString.split(","); // Split by the comma

        for (String part : parts) {
            System.out.println(part);
        }
// Output:
// apple
// banana
// orange
// grape
    }
}

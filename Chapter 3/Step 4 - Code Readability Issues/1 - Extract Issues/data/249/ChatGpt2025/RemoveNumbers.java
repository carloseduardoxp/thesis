public class RemoveNumbers {
    public static void main(String[] args) {
        String input = "Hello123World456!";
        String result = input.replaceAll("\\d+", ""); // \\d+ matches one or more digits
        System.out.println(result); // Output: HelloWorld!
    }
}

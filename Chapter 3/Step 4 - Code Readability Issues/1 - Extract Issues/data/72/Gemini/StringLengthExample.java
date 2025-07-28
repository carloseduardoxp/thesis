public class StringLengthExample {
    public static void main(String[] args) {
        String myString = "Hello, Java!";
        int length = myString.length();
        System.out.println("The length of the string is: " + length);

        String emptyString = "";
        int emptyLength = emptyString.length();
        System.out.println("The length of the empty string is: " + emptyLength);

        String anotherString = "Programming";
        System.out.println("The length of \"" + anotherString + "\" is: " + anotherString.length());
    }
}

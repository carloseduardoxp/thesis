public class Teste {

    public static void main(String[] args) {
        String line = "line";
        // Example: string to char
        char firstChar = line.charAt(0);
        char[] charArray = line.toCharArray();
        // Example: char array to string
        char[] anotherCharArray = {'a', 'b', 'c'};
        String anotherString = String.valueOf(anotherCharArray);
        // (or iterate the charArray and append each character to a StringBuilder)
    }

}

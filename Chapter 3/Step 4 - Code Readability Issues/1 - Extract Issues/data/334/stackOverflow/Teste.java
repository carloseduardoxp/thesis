
class WordContainsException extends Exception {
    // Parameterless Constructor

    public WordContainsException() {
    }

    // Constructor that accepts a message
    public WordContainsException(String message) {
        super(message);
    }
}

public class Teste {

    public static void main(String[] args) {
        String word=reader.readLine();
        try {
            if (word.contains(" ")) {
                throw new WordContainsException();
            }
        } catch (WordContainsException ex) {
            // Process message however you would like
        }
    }
}

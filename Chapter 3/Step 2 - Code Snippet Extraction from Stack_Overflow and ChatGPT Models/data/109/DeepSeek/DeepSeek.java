
public class DeepSeek {

    public static int countOccurrences(String text, String search) {
        if (text == null || text.isEmpty() || search == null || search.isEmpty()) {
            return 0;
        }
        return text.split(search, -1).length - 1;
    }

}
